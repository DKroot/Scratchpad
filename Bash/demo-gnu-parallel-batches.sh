#!/usr/bin/env bash
set -e
set -o pipefail

# Get a script directory, same as by $(dirname $0)
script_dir=${0%/*}
absolute_script_dir=$(cd "${script_dir}" && pwd)
cd "${absolute_script_dir}"
echo -e "\n## Running under ${USER}@${HOSTNAME} at ${PWD} ##\n"

echo -e "### GNU Parallel batching ###"

process_batch() {
  echo -e "\n== Starting batch #$1 processing =="

  while IFS= read -r line; do
    echo "$line"
  done

  echo "=== Batch #$1 is processed ==="
}

export -f process_batch
parallel --pipe --block 200 --halt soon,fail=1 --line-buffer --tagstring '|job#{#} s#{%}|' process_batch '{#}' <"$0" #12

exit 0

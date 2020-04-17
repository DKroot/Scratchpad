#!/usr/bin/env bash
set -e
set -o pipefail

# Get a script directory, same as by $(dirname $0)
script_dir=${0%/*}
absolute_script_dir=$(cd "${script_dir}" && pwd)
#work_dir=${1:-${absolute_script_dir}/build} # $1 with the default
#work_dir=${1:-${absolute_script_dir}/build} # $1 with the default
#if [[ ! -d "$work_dir" ]]; then
#  mkdir "$work_dir"
#  chmod g+w "$work_dir"
#fi
cd "${absolute_script_dir}"
echo -e "\n## Running under ${USER}@${HOSTNAME} at ${PWD} ##\n"

echo -e "### Script job ###"
find . -maxdepth 1 -type f -print0 | parallel -0 --halt soon,fail=1 --line-buffer --tagstring '|job#{#} s#{%}|' \
  "set -e
  echo 'Processing {} ...'
  zip -9 {.} {}
  rm -fv {.}.zip
  echo '{}: done.'"

echo -e "\n### Script job: fail on the first command failure ###"
find . -maxdepth 1 -type f -print0 | parallel -0 --halt soon,fail=1 --line-buffer --tagstring '|job#{#} s#{%}|' "set -e
  echo 'Processing {} ...'
  #foo
  echo '{}: done.'"

echo -e "\n### Script job argument: multi-line ###"
# Multi-line script arguments are interpreted as single-line pipelines:
# * Line continuations within double-quotes must be used
# * Explicit pipeline separators, e.g. ';' must be used
# * Comments can’t be used
parallel --halt soon,fail=1 --verbose --line-buffer --tagstring '|job#{#} s#{%}|' ::: "set -e; \
  wc ./*.sh" "set -e; \
  for f in *; do \
    echo \"Processing \${f}\"; \
  done"

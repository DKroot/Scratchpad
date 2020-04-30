#!/usr/bin/env bash
set -e
set -o pipefail

# Get a script directory, same as by $(dirname $0)
#script_dir=${0%/*}
#absolute_script_dir=$(cd "${script_dir}" && pwd)
echo -e "\n## Running under ${USER}@${HOSTNAME} in ${PWD} ##\n"

foo() {
  echo "Inside foo()"

  echo "Arg 1='$1'"
  echo "Arg 2='$2'"
  # Exits the script
  exit 1
}

foo "" "bar" "baz"
echo -e "\nDone."

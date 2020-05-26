#!/usr/bin/env bash
set -e
set -o pipefail

# Get a script directory, same as by $(dirname $0)
#script_dir=${0%/*}
#absolute_script_dir=$(cd "${script_dir}" && pwd)
echo -e "\n## Running under ${USER}@${HOSTNAME} in ${PWD} ##\n"
echo "Shell options: $-"

returning_fun() {
  echo -e "\nInside returning_fun()"
  echo "Shell options: $-"

  echo "Arg 1='$1'"
  echo "Arg 2='$2'"
  cat <<'HEREDOC'
Argument array: "%s\n" "$@"
-----
HEREDOC
  printf "%s\n" "$@"
  echo '-----'

  echo "Variable='$var'"

  mapfile -t $1 <<<"bar"
}

erroring_fun() {
  echo -e "\nInside erroring_fun()"
  echo "Shell options: $-"

  # This should error out and stop the script
  foo
}

var="foo"

echo "var='$var'"
returning_fun "var" "bar" "baz"
echo "var='$var'"

erroring_fun

echo -e "\nDone."

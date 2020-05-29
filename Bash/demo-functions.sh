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

  for param in "$@"; do
    echo "Arg='$param'"
  done

  cat <<'HEREDOC'
Argument array:
-----
HEREDOC
  printf "%s\n" "$@"
  echo '-----'

  echo "Param 1 with replacement='${1/a/A}'"

  echo "Variable='$var'"

  # shellcheck disable=SC2016
  echo 'Change `var` indirectly (`eval`-like)'
  mapfile -t "$1" <<<"bar"
}

erroring_fun() {
  echo -e "\nInside erroring_fun()"
  echo "Shell options: $-"

  # This should error out and stop the script
  foo
}

var="foo"

echo "var='$var'"
returning_fun "var" "foo bar baz"
echo "var='$var'"

erroring_fun

echo -e "\nDone."

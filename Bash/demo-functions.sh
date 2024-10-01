#!/usr/bin/env bash
set -e
set -o pipefail

# Get a script directory, same as by $(dirname $0)
#script_dir=${0%/*}
#absolute_script_dir=$(cd "${script_dir}" && pwd)
echo -e "\n## Running under ${USER}@${HOSTNAME} in ${PWD} ##\n"
echo "Shell options: $-"

global_var=foo
global_arr=(bar baz)

function f() {
  echo "Inside f()"

  echo "Global var=$global_var"
  echo "Global array var=${global_arr[*]}"

  # Update global vars inside the function
  global_var="bar"
  global_arr[1]="qux"

  echo "Number of parameters: \$# = $#"
  echo "\$0 = $0"
  echo "\$1 = $1"
  echo "\$2 = $2"
  echo "\$3 = $3"
  echo "\$4 = $4"
  cat <<'HEREDOC'
Argument array: "%s\n" "$@"
-----
HEREDOC
  printf "%s\n" "$@"
  echo '-----'
  IFS=';'
  echo "All arguments (double-quoted): IFS=';' \$* = $*"
  IFS=' '
}

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

echo
echo "Passing all arguments to a direct function call"
f "$@"

echo
echo "Passing hardcoded arguments with spaces to a direct function call"
f param1 "param 2 with a space" param3 --param="value 4 with a space"
pause

var="foo"

echo "var='$var'"
returning_fun "var" "foo bar baz"
echo "var='$var'"

erroring_fun

echo -e "\nDone."

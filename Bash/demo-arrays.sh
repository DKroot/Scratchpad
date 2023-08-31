#!/usr/bin/env bash
set -e
set -o pipefail

a=(foo 'bar baz' qux)

IFS=';' # IFS can't be passed on the fly to echo
echo "IFS-separated array interpolation ([*]): \`${a[*]}\`"
unset IFS

IFS=';'
echo "Expanded space-separated array ([@]). IFS has no effect:" "${a[@]}"
bash -c 'echo Passing args: 1=\`$1\`, 2=\`$2\`, 3=\`$3\`, 4=\`$4\`. Number of args=$#.' - "${a[@]}"
time (echo 'Expanded space-separated array in a subshell:'; echo "${a[@]}")
unset IFS

printf -v JOINED_ARR '%s;' "${a[@]}"
echo "Joined array: \`$JOINED_ARR\`"

printf -v JOINED_ARR -- "--file='%s' " "${a[@]}"
echo "Join + format each segment: \`$JOINED_ARR\`"

head_and_tail() {
  # Intermediate array is required in order to be indexed
  local -a args=("$@")
  local head tail all

  printf -v all '%s;' "$@"
  echo "All arguments = \`${all}\`"

  # The tail, i.e. the last item
  tail="${args[$#-1]}"
  echo "Tail = \`${tail}\`"

  head="${all%%${tail};}"
  echo "Head (all arguments except last) = \`${head}\`"

  echo "Loop through the head (all arguments except the last):"
  while (($# > 1)); do
    echo "$1"
    shift
  done
}

head_and_tail "${a[@]}"
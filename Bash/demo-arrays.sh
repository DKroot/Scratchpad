#!/usr/bin/env bash
set -e
set -o pipefail

declare -a arr=(foo 'bar baz' qux)

IFS=';'
echo "IFS-separated array interpolation: \`${arr[*]}\`"
unset IFS

bash -c 'echo Passing arg array: 1=\`$1\`, 2=\`$2\`, 3=\`$3\`, 4=\`$4\`, 5=\`$5\`. Number of args=$#.' - "${arr[@]}"

printf -v JOINED_ARR '%s;' "${arr[@]}"
echo "Joined array: \`$JOINED_ARR\`"

printf -v JOINED_ARR -- "--file='%s' " "${arr[@]}"
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

head_and_tail "${arr[@]}"
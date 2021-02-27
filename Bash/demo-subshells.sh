#!/usr/bin/env bash
set -e
set -o pipefail

readonly STR=foo
# Arrays can't be exported
declare -ra ARRAY=(foo bar baz)
declare -rx EXPORTED_STR=bar

fun() {
  echo "STR=$STR"
  echo "ARRAY=${ARRAY[*]}"
  echo "EXPORTED_STR=$EXPORTED_STR"
}

exported_fun() {
  echo "STR=$STR"
  echo "ARRAY=${ARRAY[*]}"
  echo "EXPORTED_STR=$EXPORTED_STR"
}
export -f exported_fun

echo -e "\n## Direct function call ##"
fun

echo -e "\n## Command substitution ##"
echo -e "Command substitution subshell\n$( fun )"

echo -e "\n## Commands grouped with parentheses ##"
( echo "Commands group subshell"; fun )

echo -e "\n## Async command ##"
fun &
wait

echo -e "\n## Pipe subshell ##"
echo "pipe subshell" | fun

echo -e "\n## Process substitution ##"
cat < <(echo "Process substitution subshell"; fun)

echo -e "\n## bash -c subshell function call ##"
bash -c 'echo "bash -c subshell"; exported_fun'

echo -e "\n## GNU Parallel subshell function call ##"
parallel --halt soon,fail=1 --line-buffer --tagstring '|job#{#} s#{%}|' ::: exported_fun

var="foo"
echo -e "\n### Variables and sub-processes ###"
echo "Variable change is not visible from a sub-shell introduced by piping"
while IFS= read -r line; do
  echo "$line"
  var="bar"
done <"$0"
echo "var=$var"

var="foo"
echo "Variable change is OK here (without piping)"
while IFS=: read -r user enc_passwd uid gid full_name home shell; do
  echo "User record: $user $enc_passwd $uid $gid $full_name $home $shell"
  var="bar"
done </etc/passwd
echo "var=$var"

var="foo"
echo "Variable change is OK to use here via Process Substitution"
while IFS=: read -r user uid home; do
  echo "User record: $user $uid $home"
  var="bar"
done < <(cat /etc/passwd | cut -d ':' -f 1,3,6)
echo "var=$var"
pause
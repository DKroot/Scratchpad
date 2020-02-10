#!/usr/bin/env bash

readonly VAR=foo
declare -rx EXPORTED_VAR=bar

fun() {
  echo "VAR=$VAR"
  echo "EXPORTED_VAR=$EXPORTED_VAR"
}

exported_fun() {
  echo "VAR=$VAR"
  echo "EXPORTED_VAR=$EXPORTED_VAR"
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
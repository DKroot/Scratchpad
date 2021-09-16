#!/usr/bin/env bash
if [[ $1 == "-h" ]]; then
  cat <<'HEREDOC'
NAME
  demo_sorted_args.sh -- demoes sorting of command line arguments

SYNOPSIS
  demo_sorted_args.sh [arg] ...
  demo_sorted_args.sh -h: display this help
HEREDOC
  exit 1
fi

set -e
set -o pipefail

echo -e "\n## Running under ${USER}@${HOSTNAME} in ${PWD} ##\n"

echo "All arguments: \$@ = $@"
echo "Number of arguments: \$# = $#"

arg_array=( "$@" )
echo "Argument array = ${arg_array[@]}"
echo -e "\nArguments:"
for arg in "${arg_array[@]}"; do
   echo "$arg"
done

# Courtesy of https://stackoverflow.com/questions/7442417/how-to-sort-an-array-in-bash
IFS=$'\n' sorted_args=($(sort <<<"${arg_array[*]}")); unset IFS

echo -e "\nArguments, sorted alphabetically:"
for arg in "${sorted_args[@]}"; do
  echo "$arg"
done

IFS=$'\n' sorted_args=($(sort --reverse <<<"${arg_array[*]}")); unset IFS

echo -e "\nArguments, sorted in the reverse alphabetical order:"
for arg in "${sorted_args[@]}"; do
  echo "$arg"
done













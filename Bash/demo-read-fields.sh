#!/usr/bin/env bash
set -e
#set -ex
set -o pipefail

echo -e "\n## Running under ${USER}@${HOSTNAME} in ${PWD} ##\n"

echo "Reading a whitespace-separated file..."

echo -e "\n------"

# Turn off xpg_echo (echo expands backslash-escape sequences by default) if set
shopt -u xpg_echo

while read -r field1 field2; do
  echo "field1=${field1}, field2=${field2}"
done <'fields.tsv'
echo "------"
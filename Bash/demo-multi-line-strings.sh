#!/usr/bin/env bash
set -e
set -o pipefail

echo -e "\n## Demo 1 ##"
echo "A multi-line string.
Line 2."

echo -e "\n## Demo 2 ##"
echo "\
Line 1.
Line 2."

echo -e "\n## Demo 3 ##"
echo "A multi-line string with embedded single quotes: 'quoted'.
Line 2."

echo -e "\n## Demo 4 ##"
echo "\
A multi-line string with embedded double quotes: \"quoted\".
Line 2."

echo -e "\n## Demo 5 ##"
foo='A quick brown fox jumps over the "lazy" dog.'

echo "A multi-line string with a variable expansion: ${foo}.
Line 2."

echo -e "\n## Demo 6 ##"
echo "A multi-line string with a variable expansion, double-quoted.
cmd \"${foo}\"
Line 3."

echo -e "\n## Demo 7 ##"
echo "A multi-line string with a variable expansion, single-quoted.
cmd '${foo}'
Line 3"

echo -e "\n## Demo 8 ##"
cat <<< "A multi-line here string.
Line 2."

echo -e "\n## Demo 9 ##"
cat <<< "\
A multi-line here string.
Line 2."

echo -e "\n## Demo 10 ##"
cat <<HEREDOC
A multi-line here doc.
Variable "foo"=$foo
Line 2.
HEREDOC

echo -e "\n## Demo 11 ##"
bash -ec 'echo "Job" &&
  for file in *; do
    echo "Processing ${file} ..."
  done'

echo -e "\n## Demo 12 ##"
bash -ec "echo 'Job' &&
  for file in *; do
    echo \"Processing \${file} ...\"
  done"

echo -e "\nDone."
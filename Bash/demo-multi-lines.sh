#!/usr/bin/env bash
set -e
set -o pipefail

echo -e "\n## Multi-line command ##"
echo Multi-line command:\
  Line 2 Arg

echo -e "\n## Multi-line command with backtick comments ##"
echo Multi-line command:\
  `# This is an expensive comment`\
  Line 2 Arg

echo -e "\n## Multi-line string ##"
echo "A multi-line string.
Line 2."

echo -e "\n## A single-line strings formatted into multiple lines with continuations ##"
echo "start\
-continuing on Line 1\
-continuing on Line 2."

echo -e "\n## Multi-line string with embedded single quotes ##"
echo "A multi-line string with embedded single quotes: 'quoted'.
Line 2."

echo -e "\n## Multi-line string with embedded double quotes ##"
echo "\
A multi-line string with embedded double quotes: \"quoted\".
Line 2."

echo -e "\n## Embedded multi-line scripts ##"
bash -ec 'echo "Job" &&
  for file in *; do
    echo "Processing ${file} ..."
  done'

echo -e "\nDone."
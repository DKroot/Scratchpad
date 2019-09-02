#!/usr/bin/env bash
if [[ $# -lt 1 ]]; then
  cat <<END
NAME
    demo_files -- expand masks and parse matching files

SYNOPSIS
    $0 'file_pattern' ...
    $0: display this help

DESCRIPTION
    Directories are skipped.
    Supports recursive wildcards, e.g. '**'.

EXAMPLES
    Expand all files recursively

        demo_files.sh '*' '.*'

    Expand all non-hidden files recursively

        demo_files.sh '**'
END
  exit 1
fi

#set -xe
set -e

while [[ $# -gt 0 ]]; do
  for file in $1; do
    echo "Processing '${file}' ..."
    if [[ -f ${file} ]]; then
      # Remove longest */ prefix
      name_with_ext=${file##*/}

      if [[ "${name_with_ext}" != *.* ]]; then
        name_with_ext=${name_with_ext}.
      fi
      # Remove longest *. prefix
      ext=${name_with_ext##*.}

      # Remove shortest .* suffix
      name=${name_with_ext%.*}

      if [[ "${file}" != */* ]]; then
        file=./${file}
      fi
      # Remove shortest /* suffix
      dir=${file%/*}
      echo "name with extension=${name_with_ext}, extension=${ext}, name=${name}, dir=${dir}/"
     fi
  done
  shift
done
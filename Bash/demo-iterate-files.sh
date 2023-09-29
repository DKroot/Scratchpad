#!/usr/bin/env bash

# File loop
for f in *.sh *.tsv; do
  # File exists and non-empty
  if [[ -s "$f" ]]; then
    echo "Processing $f ..."
  fi
done

# Dir loop
for d in * .*; do
  if [[ -d "$d" ]]; then
    echo "Processing $d/ directory ..."
    ls -a "${d}"
  fi
done

# Unmatched globs
for f in *.foo *.bar; do
  echo "Iterating: $f ..."
done
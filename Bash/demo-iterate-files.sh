#!/usr/bin/env bash

# File loop
for f in *.sh; do
  # File exists and non-empty
  if [[ -s "$f" ]]; then
    echo "Processing $f ..."
  fi
done

# Dir loop
for f in * .*; do
  if [[ -d "$f" ]]; then
    echo "Processing $f/ directory ..."
    ls -a "${f}"
    pause
  fi
done

#!/usr/bin/env bash
for f in *; do
  if [[ -d "$f" ]]; then
    echo "Processing $f ..."
    ls -a ${f}
    pause
  fi
done

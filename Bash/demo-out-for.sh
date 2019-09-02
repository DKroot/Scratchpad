#!/usr/bin/env bash
set -e
for ((i=1; i<=10; i++)); do
  echo "Iteration #$i."
  ((i == 5)) && foo
done
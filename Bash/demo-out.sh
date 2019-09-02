#!/usr/bin/env bash
set -e
#set -xe

if [[ "$1" == "-h" ]]; then
  cat <<END
SYNOPSIS
  $0 [{seconds_to_run}]
  $0 -h

DESCRIPTION
  Demonstrates stdout and stderr output. They could get out of order with the default OS buffering.
  Runs a loop for the specified seconds_to_run (60 by default).
  Times out (abnormally terminates) the run at 30 seconds.
END
  exit 1
fi

declare -i seconds_to_run=${1:-60}

out() {
 echo stdout $*
 echo stderr $* >&2
}

main() {
  declare -i elapsed=0 left
  while ((elapsed < seconds_to_run)); do
    ((left=seconds_to_run - elapsed))
    ((++elapsed))
    out "#${elapsed} ${left} second(s) left..."
    if ((left == 30)); then
      echo "Abnormal exit!"
      exit 42
    fi
    sleep 1
  done
}

main
#!/usr/bin/env bash
if (($# < 1)); then
  cat <<HEREDOC
SYNOPSIS
  $0 simple_class_name
  $0: display this help

DESCRIPTION
  Runs the specified class.
HEREDOC
  exit 1
fi
set
pause
java -cp build/classes/main org.houseofsoft.$1

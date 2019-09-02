#!/usr/bin/env bash

if (( $# < 1 )); then
  exec 1>&2
  cat << EOF
Run Liquibase Demo

Usage:
  $0 demo-directory

Examples:
  $0 BlockComment
EOF
  exit 127
fi

cd $1
gradle -b ../build.gradle
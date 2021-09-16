#!/usr/bin/env bash
declare -a arr=(foo bar baz)
printf -v JOINED_ARR -- '--file=%s ' "${arr[@]}"
echo "Joined array: \`$JOINED_ARR\`"

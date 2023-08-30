#!/usr/bin/env bash
set -e
set -o pipefail

time (echo foo; echo bar)

var1=$(echo foo; echo bar)
echo -e "\nvar1=\`$var1\`"

var2=$(time (echo foo; echo bar) )
echo -e "\nvar2=\`$var2\`"
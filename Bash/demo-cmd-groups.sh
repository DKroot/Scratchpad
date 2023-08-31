#!/usr/bin/env bash
set -e
set -o pipefail

var1=$(echo foo; echo bar)
echo -e "\nvar1=\`$var1\`"

echo
time { echo foo; printf "It took:" >&2; }

# Bash 5.1.16: success
# Bash 5.2.15: syntax error near unexpected token `}'
#var2=$(time { echo foo; echo bar; })
#echo -e "\nvar2=\`$var2\`"

echo
time (echo foo; printf "It took:" >&2)

# Bash 5.1.16: success
# Bash 5.2.15: syntax error near unexpected token `)'
#var3=$(time (echo foo; echo bar))
#echo -e "\nvar3=\`$var3\`"

time var4=$(echo foo; echo bar)
echo -e "\nvar4=\`$var4\`"

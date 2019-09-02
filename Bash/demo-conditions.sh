#!/usr/bin/env stdbuf -o L -e L bash
set -e
set -o pipefail
set -x

# Get a script directory, same as by $(dirname $0)
#script_dir=${0%/*}
#absolute_script_dir=$(cd "${script_dir}" && pwd)
echo -e "\n## Running under ${USER}@${HOSTNAME} in ${PWD} ##\n"

[[ 0 ]] && echo "0: true"
[[ 1 ]] && echo "1: true"
[[ -1 ]] && echo "-1: true"

# Random string is true.
echo -e "\nchecking [[ foo ]]"
if [[ foo ]]; then
  echo "Random string is true."
else
  echo "Random string is false."
fi

echo -e "\nchecking [[ \${foo} ]]"
# Uninitialized variable is false.
if [[ ${foo} ]]; then
  echo "Uninitialized variable is true."
else
  echo "Uninitialized variable is false."
fi

# Uninitialized variable is false.
echo -e "\nchecking [[ -n \"\$foo\" ]]"
if [[ -n "$foo" ]] # More pedantically correct.
then
  echo "Uninitialized variable is true."
else
  echo "Uninitialized variable is false."
fi

# Null variable is false.
# Initialized, but set to null value:
bar=
echo -e "\nchecking [[ -n \"\$bar\" ]]"
if [[ -n "$bar" ]]; then
  echo "Null variable is true."
else
  echo "Null variable is false."
fi

# "false" string
echo -e "\nchecking [[ \"false\" ]]"
if [[ "false" ]]; then
  echo "true"
else
  echo "false"
fi

echo -e "\nchecking false"
if false; then
  echo "false utility's exit code is true."
else
  echo "false utility's exit code is false."
fi

echo -e "\nchecking [[ : ]]"
if [[ : ]]; then
  echo "Null operator's result is true."
else
  echo "Null operator's result is false."
fi

declare -i i=1
printf "Arithmetic comparison: "
(( i+i == 2 )) && echo "true" || echo "false"

printf "Compound comparison: "
[[ ${i} -gt 1 || "foo" == "foo" ]] && echo "true" || echo "false"

printf "Compound comparison (arithmetic): "
[[ $(( i+i == 2 )) || "foo" == "bar" ]] && echo "true" || echo "false"

echo -e "\nassigning integer variable to zero: declare -i i=0"
declare -i i=0

#(( i=0 )) # Terminates (with set -e)

echo -e "\nassigning integer variable to zero: (( i=0 )) || :"
(( i=0 )) || :

echo -e "\nassigning integer variable to zero: (( i=0 )) || true"
(( i=0 )) || true

#let i=0 # Terminates (with set -e)

echo -e "\nassigning integer variable to zero: let i=0 || :"
let i=0 || :

echo -e "\nassigning integer variable to zero: let i=0 || true"
let i=0 || true

echo
var_label=foo
case foo in
  "$var_label")
    echo "Case foo"
    ;;
  *)
    echo "Case else"
esac

var_label=f
case foo in
  ${var_label}*)
    echo "Case fo*"
    ;;
  *)
    echo "Case else"
esac

echo -e "\nDone."
#!/usr/bin/env bash
set -e
set -o pipefail

# Examples:
#   Valid: $0 -v -f filename
#   Valid: $0 -ffilename -v
#   Valid: $0 -vf filename
#   Valid: $0 -vffilename
#   Valid: $0 -vffilename thing1 thing 2
#   Valid: $0 thing1 thing 2
#   Valid: $0 "param 1 with a space" --param="value 2 with a space"
#   Invalid: $0 -x

echo "PATH=$PATH"

echo -e "\n## Parameters ##"
echo "Number of parameters = $#"
echo "Script = $0"
echo "Parameter 1 = $1"
echo "Parameter 2 = $2"
echo "Parameter 3 = $3"

echo "Optional parameter 1 defaulting to 'default': = ${1:-default}"
echo "Optional parameter 1 with '--' prefix: = ${1+--$1}"
if [[ $1 ]]; then
  echo "Parameter 1 is present"
fi
echo "Optional parameter 1 with spaces replaced by underscores: ${1// /_}"

set -x
[[ $# -lt 1 || "$1" == "-h" ]] && echo "Usage requested: no params or the first parameter = '-h'"
set +x

echo "Optional parameter 2 defaulting to 'default: \${2:-default] = ${2:-default}"
echo "Optional parameter 2: \${2:--default} = ${2:--default}"
echo "Optional parameter 2 defaulting to parameter 1: \${2:-\$1} = ${2:-$1}"
if [[ ! $2 ]]; then
  echo "Parameter 2 is blank or undefined"
fi

args=("$@")
argc=${#args[@]}
echo "Array of parameters = ${args[@]}, length = $argc"
if ((argc > 0)); then
  echo "Last parameter = ${args[$argc - 1]}"
  echo "All parameters except last: \${*%%\$last} = ${*%%$last}"
fi
echo "All parameters: \$* = $*"
echo "All parameters: \$@ = $@"

echo "Directory of this script: \${0%/*} = ${0%/*}"
echo "Name of this script: \${0##*/} = ${0##*/}"

function f() {
  echo "Inside the function"
  echo "Number of parameters: \$# = $#"
  echo "\$0 = $0"
  echo "\$1 = $1"
  echo "\$2 = $2"
  echo "\$3 = $3"
  echo "\$4 = $4"
  echo "\$* = $*"
  echo "\$@ = $@"
}

echo
echo "Passing all parameters to a direct function call"
f "$@"

echo
echo "Passing hardcoded parameters with spaces to a direct function call"
f param1 "param 2 with a space" param3 --param="value 4 with a space"

echo -e "\n### Options Processing ###"
vflag=off
f=
while getopts vf: opt; do
  case "$opt" in
    v)
      vflag=on
      ;;
    f)
      f="$OPTARG"
      ;;
    \?) # unknown flag
      echo "Valid parameters: $0 [-v] [-f filename] [something ...]"
      exit 1
      ;;
  esac
done
shift $(expr $OPTIND - 1)

echo "\$vflag = $vflag"
echo "\$f = $f"
echo "Other parameters: \$* = $*"

var="foo"
echo -e "\n### Variables and sub-processes ###"
echo "Variable change is not visible from a sub-shell introduced by piping"
while IFS= read -r line; do
  var="bar"
done < "$0"
echo "var=$var"

var="foo"
echo "Variable change is OK here (without piping)"
while IFS=: read user enc_passwd uid gid full_name home shell; do
  var="bar"
done < /etc/passwd
echo "var=$var"

var="foo"
echo "Variable change is OK to use here via Process Substitution"
while IFS=: read user uid home; do
  var="bar"
done < <(cat /etc/passwd | cut -d ':' -f 1,3,6)
echo "var=$var"

pause

echo -e "\n## Environment ##"
set

echo -e "\n## Aliases ##"
alias

echo -e "\n## Shell flags ##"
echo $-

echo -e "\n## Shell options ##"
shopt

echo -e "\n## Internet Connectivity Check ##"
if ping -c 1 google.com; then
  echo "Connected."
else
  echo "Not connected."
fi

echo -e "\nDone."
pause

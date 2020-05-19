#!/usr/bin/env bash
set -e
set -o pipefail

# Examples:
#   Valid: $0 -v -f filename
#   Valid: $0 -f filename -v
#   Valid: $0 -vf filename
#   Valid: $0 -vf filename
#   Valid: $0 -vf filename thing1 thing 2
#   Valid: $0 thing1 thing 2
#   Valid: $0 "param 1 with a space" --param="value 2 with a space"
#   Invalid: $0 -x

echo "PATH=$PATH"

echo -e "\n## Arguments ##"
echo "Number of arguments = $#"

echo "Script = $0"
echo "Relative directory of this script: \${0%/*} = ${0%/*}"
echo "Name of this script: \${0##*/} = ${0##*/}"

echo "Argument 1 = $1"
echo "Argument 2 = $2"
echo "Argument 3 = $3"

echo "Optional argument 1 defaulting to 'default': = ${1:-default}"
echo "Optional argument 1 with '--' prefix: = ${1+--$1}"
if [[ $1 ]]; then
  echo "Argument 1 is present"
fi
echo "Optional argument 1 with spaces replaced by underscores: ${1// /_}"

if (($# < 1)) || [[ "$1" == "-h" ]]; then
  echo "Print usage: no params or the first argument = '-h'"
fi

echo "Optional argument 2 defaulting to 'default: \${2:-default] = ${2:-default}"
echo "Optional argument 2: \${2:--default} = ${2:--default}"
echo "Optional argument 2 defaulting to argument 1: \${2:-\$1} = ${2:-$1}"
if [[ ! $2 ]]; then
  echo "Argument 2 is blank or undefined"
fi

echo "All arguments (double-quoted): \$* = $*"
__IFS="$IFS"; IFS=';'
echo "All arguments (double-quoted): IFS=';' \$* = $*"
IFS="$__IFS"

cat <<'HEREDOC'
Argument array: "%s\n" "$@"
-----
HEREDOC
printf "%s\n" "$@"
echo '-----'

# Intermediate array is required in order to be indexed
args=("$@")
if (($# > 0)); then
  tail="${args[$#- 1]}"
  # shellcheck disable=SC2145
  echo "Tail (last argument) = $tail"
  echo "Head (all arguments except last): \${*%%\$tail} = ${*%%$tail}"
fi

function f() {
  echo "Inside the function"
  echo "Number of parameters: \$# = $#"
  echo "\$0 = $0"
  echo "\$1 = $1"
  echo "\$2 = $2"
  echo "\$3 = $3"
  echo "\$4 = $4"
  cat <<'HEREDOC'
Argument array: "%s\n" "$@"
-----
HEREDOC
  printf "%s\n" "$@"
  echo '-----'
  IFS=';'
  echo "All arguments (double-quoted): IFS=';' \$* = $*"
}

echo
echo "Passing all arguments to a direct function call"
f "$@"

echo
echo "Passing hardcoded arguments with spaces to a direct function call"
f param1 "param 2 with a space" param3 --param="value 4 with a space"
pause

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
shift $((OPTIND - 1))

echo "\$vflag = $vflag"
echo "\$f = $f"
echo "Other parameters: \$* = $*"

var="foo"
echo -e "\n### Variables and sub-processes ###"
echo "Variable change is not visible from a sub-shell introduced by piping"
while IFS= read -r line; do
  echo "$line"
  var="bar"
done <"$0"
echo "var=$var"

var="foo"
echo "Variable change is OK here (without piping)"
while IFS=: read -r user enc_passwd uid gid full_name home shell; do
  echo "User record: $user $enc_passwd $uid $gid $full_name $home $shell"
  var="bar"
done </etc/passwd
echo "var=$var"

var="foo"
echo "Variable change is OK to use here via Process Substitution"
while IFS=: read -r user uid home; do
  echo "User record: $user $uid $home"
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

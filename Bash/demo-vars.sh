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

echo -e "\n### Options Processing ###"
vflag=off
f=
while getopts vf:- opt; do
  case "$opt" in
    -) # Long option: an app CLI parameter
      ;;
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

#!/usr/bin/env bash

usage() {
  cat <<'HEREDOC'
NAME

    load.sh -- load Open Citations data to a local MarkLogic instance

SYNOPSIS

    load.sh {N-Triple file}
    load.sh -h: display this help

DESCRIPTION

    Load Open Citations data to MarkLogic


v0.1                                   March 2021                                   Created by Dmitriy "DK" Korobskiy
HEREDOC
  exit 1
}

set -e
set -o pipefail

# If a character is followed by a colon, the option is expected to have an argument
while getopts h OPT; do
  case "$OPT" in
    *) # -h or `?`: an unknown option
      usage
      ;;
  esac
done
shift $((OPTIND - 1))

# Process positional parameters
[[ $1 == "" ]] && usage
#declare -a files
#while (($# > 0)); do
#  files+=("$1")
#  shift
#done
file="$1"

if [[ "${file}" != */* ]]; then
  file=./${file}
fi
# Remove shortest /* suffix
dir=${file%/*}
# dir = '.' for files in the current directory

# Remove longest */ prefix
name_with_ext=${file##*/}

absolute_file_dir=$(cd "${dir}" && pwd)
absolute_file_path="${absolute_file_dir}/${name_with_ext}"

# `${USER:-${USERNAME:-${LOGNAME}}}` might be not available inside Docker containers
echo -e "\n# load.sh: running under $(whoami)@${HOSTNAME} in ${PWD} #\n"

echo "Loading data from $absolute_file_path to localhost:$MARK_LOGIC_DB_PORT"
mlcp.sh import -mode local -host localhost -port "$MARK_LOGIC_DB_PORT" -username "$MARK_LOGIC_USER" \
    -password "$MARK_LOGIC_PASSWORD" -input_file_path "$absolute_file_path" -input_file_type RDF -output_uri_prefix /oc/

exit 0

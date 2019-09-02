#!/usr/bin/env stdbuf -o L -e L bash
if [[ "$1" == "-h" ]]; then
  cat << 'HEREDOC'
NAME

    demo_parallel_sql.sh -- demo parallel Postgres psql queries

SYNOPSIS

    demo_parallel_sql.sh
    demo_parallel_sql.sh -h: display this help

DESCRIPTION

    Demonstrates parallel Postgres psql queries.

AUTHOR(S)

    Written by Dmitriy "DK" Korobskiy.
HEREDOC
  exit 1
fi

set -e
#set -x
set -o pipefail

# Get a script directory, same as by $(dirname $0)
script_dir=${0%/*}
absolute_script_dir=$(cd "${script_dir}" && pwd)
work_dir=${1:-${absolute_script_dir}/build} # $1 with the default
if [[ ! -d "${work_dir}" ]]; then
  mkdir "${work_dir}"
  chmod g+w "${work_dir}"
fi
cd "${work_dir}"
echo -e "\n## Running under ${USER}@${HOSTNAME} in ${PWD} ##\n"

# language=PostgresPLSQL
parallel --halt soon,fail=1 --verbose --line-buffer --tagstring '|job#{#} s#{%}|' \
  'psql -v ON_ERROR_STOP=on --echo-all <<HEREDOC
{}
HEREDOC' ::: 'SELECT (1, 2) = (1, 2);' 'SELECT (1, 2)
    = (1, 3);' 'SELECT (1, NULL) = (1, NULL);' 'SELECT
    ROW (1, NULL) = ROW (1, NULL);' 'SELECT (1, NULL) IS NOT DISTINCT FROM(1, NULL);' \
    'SELECT ROW (1, NULL) IS NOT DISTINCT FROM ROW (1, NULL);'

exit 0
#!/usr/bin/env bash
set -e
set -o pipefail

# Get a script directory, same as by $(dirname $0)
script_dir=${0%/*}
absolute_script_dir=$(cd "${script_dir}" && pwd)
#work_dir=${1:-${absolute_script_dir}/build} # $1 with the default
#work_dir=${1:-${absolute_script_dir}/build} # $1 with the default
#if [[ ! -d "$work_dir" ]]; then
#  mkdir "$work_dir"
#  chmod g+w "$work_dir"
#fi
cd "${absolute_script_dir}"
echo -e "\n## Running under ${USER}@${HOSTNAME} at ${PWD} ##\n"

echo -e "## Parallel runs with # of jobs = # of CPU cores using xargs using GNU parallel ##"
parallel_cores=$(parallel --number-of-cores)

echo -e "\n### Simple command scaled according to a number of cores ###"
# For certain jobs there is no need to continue if one of the jobs fails and has an exit code different from 0.
# GNU parallel will stop spawning new jobs with --halt soon,fail=1
# With --halt now,fail=1 the running jobs will be killed immediately
parallel --halt soon,fail=1 --verbose --line-buffer --tagstring '|job#{#} s#{%}|' \
              echo "Executing job {#} of {= \$_=total_jobs() =}" ::: $(seq -s ' ' "${parallel_cores}")

echo -e "\n### Simple command with quoted arguments ###"
# For certain jobs there is no need to continue if one of the jobs fails and has an exit code different from 0.
# GNU parallel will stop spawning new jobs with --halt soon,fail=1
# With --halt now,fail=1 the running jobs will be killed immediately
parallel --halt soon,fail=1 --verbose --line-buffer --tagstring '|job#{#} s#{%}|' echo "Processing '{}' ..." ::: \
  arg1 'arg(2)' arg3

echo -e "\n### A command with multi-line arguments ###"
parallel --null --halt soon,fail=1 --verbose --line-buffer --tagstring '|job#{#} s#{%}|' \
  echo "Processing {} ..." ::: '1: line1
1: line2' '2: line 1
2: line 2'

echo -e "\n### Processing multiple arguments at a time ###"
parallel --halt soon,fail=1 --verbose --line-buffer --tagstring '|job#{#} s#{%}|' "set -e;
  echo 'Processing group ({}): {1} + {2} + {3}'" ::: 1 4 7 10 :::+ 2 5 8 :::+ 3 6 9

echo -e "\n### A one-line script. WARNING: Failures are not processed! ###"
# shellcheck disable=SC2016
find . -maxdepth 1 -type f -print0 | parallel -0 --line-buffer -j 4 --tagstring '|job#{#}/{= $_=total_jobs() =} s#{%}|'\
              "echo 'Processing {} ...'; zip -9 {.} {} && rm -fv {.}.zip; echo '{}: done.'"
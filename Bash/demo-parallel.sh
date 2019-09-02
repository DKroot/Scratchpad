#!/usr/bin/env stdbuf -o L -e L bash
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

echo -e "\n## Timed sequential run ##"
time for file in *; do
  name_with_ext=${file##*/}
  echo "Processing ${file}"
  name=${name_with_ext%.*}
  zip -9 "${name}" "${file}"
  rm -fv "${name}.zip"
done

echo -e "\n## Parallel run with unlimited # of jobs using & ##"
for file in *; do
  {
    name_with_ext=${file##*/}
    echo "Processing ${file}"
    name=${name_with_ext%.*}
    zip -9 "${name}" "${file}"
    rm -fv "${name}.zip"
  } &
done
wait

echo -e "\n## Parallel run with # of jobs = # of virtual CPU cores using xargs ##"

cpu_cores=$(getconf _NPROCESSORS_ONLN)
# -L 1 switches xargs into line processing (one line at a time)
ls | xargs -L 1 -P ${cpu_cores} -I {} bash -c '\
  file=$1
  name_with_ext=${file##*/}
  echo "Processing ${file}"
  name=${name_with_ext%.*}
  zip -9 "${name}" "${file}"
  rm -fv "${name}".zip' demo_parallel_bash "{}"

echo -e "\n## Parallel runs with # of jobs = # of CPU cores using xargs using GNU parallel ##"
parallel_cores=$(parallel --number-of-cores)

echo -e "\n### Simple command scaled according to a number of cores ###"
# For certain jobs there is no need to continue if one of the jobs fails and has an exit code different from 0.
# GNU parallel will stop spawning new jobs with --halt soon,fail=1
# With --halt now,fail=1 the running jobs will be killed immediately
parallel --halt soon,fail=1 --verbose --line-buffer --tagstring '|job#{#} s#{%}|' \
              echo "Executing job {#} of {= \$_=total_jobs() =}" ::: $(seq -s ' ' ${parallel_cores})

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

echo -e "\n### Script on one line. WARNING: Failures are not processed! ###"
ls | parallel --line-buffer --tagstring '|job#{#} s#{%}|' \
              "echo 'Processing {} ...'; zip -9 {.} {} && rm -fv {.}.zip; echo '{}: done.'"

echo -e "\n### Script ###"
ls | parallel --halt soon,fail=1 --line-buffer --tagstring '|job#{#} s#{%}|' \
  "set -e
  echo 'Processing {} ...'
  zip -9 {.} {}
  rm -fv {.}.zip
  echo '{}: done.'"

echo -e "\n### Script: fail on the first command failure ###"
ls | parallel --halt soon,fail=1 --line-buffer --tagstring '|job#{#} s#{%}|' "set -e
  echo 'Processing {} ...'
  #foo
  echo '{}: done.'"

echo -e "\n### Script arguments (multi-line) ###"
# Script arguments are interpreted as single-line pipelines:
# * Line continuations within double-quotes must be used
# * Explicit pipeline separators, e.g. ';' must be used
# * Comments can’t be used
parallel --halt soon,fail=1 --verbose --line-buffer --tagstring '|job#{#} s#{%}|' ::: "set -e; \
  wc *.sh" "set -e; \
  for f in *; do \
    echo \"Processing \${f}\"; \
  done"

echo -e "\n### Function command arguments ###"
export message='Processing'

job1() {
  set -e
  echo 'Job #1'
  wc *.sh
  echo 'Job #1 is done.'
}

job2() {
  set -e
  echo 'Job #2'
  for f in *; do
    echo "${message} ${f}"
    #foo
  done
  echo 'Job #2 is done.'
}

export -f job1 job2
parallel --halt soon,fail=1 --verbose --line-buffer --tagstring '|job#{#} s#{%}|' ::: job1 job2
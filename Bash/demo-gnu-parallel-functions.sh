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

echo -e "### Two script job functions executed in parallel ###"
export message='Processing'

job_func1() {
  set -e
  echo 'Job #1'
  wc ./*.sh
  echo 'Job #1 is done.'
}

job_func2() {
  set -e
  echo 'Job #2'
  for f in *; do
    echo "${message} ${f}"
    #foo
  done
  echo 'Job #2 is done.'
}

export -f job_func1 job_func2
parallel --halt soon,fail=1 --verbose --line-buffer --tagstring '|job#{#} s#{%}|' ::: job_func1 job_func2

echo -e "\n### Script job function: returning totals ###"

job_func() {
  echo "Executing job() #$1"
  # Fail every third job
  if (( $1 % 3 == 0 )); then
     return 1
  fi
}
export -f job_func

set +e
set +o pipefail
# --halt never
# shellcheck disable=SC2016
find . -maxdepth 1 -type f -print0 | parallel -0 -j 4 --line-buffer \
    --tagstring '|job#{#} of {= $_=total_jobs() =} s#{%}|' "set -e
  echo 'Processing {} ...'
  job_func {#}
  echo '{}: done.'" | tee >(tail -1 | pcregrep -o1 'of (\d+)' >/tmp/demo-gnu-parallel.out)
  # head -1 would break the pipeline
parallel_exit_code=${PIPESTATUS[1]}
printf "\nTotal jobs: "
cat /tmp/demo-gnu-parallel.out
case $parallel_exit_code in
  0)
    echo "SUCCESS"
  ;;
  1)
    echo "1 job FAILED"
  ;;
  [2-9]|[1-9][0-9])
    echo "$parallel_exit_code jobs FAILED"
  ;;
  101)
    echo "More than 100 jobs FAILED"
  ;;
  *)
    echo "TOTAL FAILURE"
  ;;
esac
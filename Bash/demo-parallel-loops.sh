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
# shellcheck disable=SC1004
# shellcheck disable=SC2016
find . -maxdepth 1 -type f -print0 | xargs -0 -L 1 -P "${cpu_cores}" -I {} bash -c '\
  file=$1
  name_with_ext=${file##*/}
  echo "Processing ${file}"
  name=${name_with_ext%.*}
  zip -9 "${name}" "${file}"
  rm -fv "${name}".zip' demo_parallel_bash "{}"
#!/usr/bin/env stdbuf -o L -e L bash
set -e
set -o pipefail

# Get a script directory, same as by $(dirname $0)
script_dir=${0%/*}
absolute_script_dir=$(cd "${script_dir}" && pwd)
cd "${absolute_script_dir}"
echo -e "\n## Running under ${USER}@${HOSTNAME} at ${PWD} ##\n"

echo -e "## Bash command execution ##"
bash -c "set -e
  echo 'Job #1'
  for file in *.sh; do
    echo \"Processing \${file} ...\"
    # Fails early correctly on the first error
    #foo
  done"

echo -e "\n## Bash command pipeline execution ##"
bash -c "set -e &&
  echo 'Job #1' &&
  for file in *.sh; do
    echo \"Processing \${file} ...\" &&
    :
    # Fails early correctly on the first error
    #foo
  done"

echo -e "\n## Sub-shells ##"
# The error doesn't propagate in interpolated string
echo "A value from sub-shell='$(foo)'"

# The error propagates correctly here
#var=$(foo)

echo -e "\n## Abbreviated conditions don't fail the script ##"
[[ "${foo}" == "bar" ]] && echo "This should not be executed"

[[ -f /Applications/Thunderbird.app/Contents/MacOS/thunderbird-bin ]] && \
  alias tb=/Applications/Thunderbird.app/Contents/MacOS/thunderbird-bin

echo -e "\n## Executing external scripts ##"
echo "Executing a script with exit code 0"
"${absolute_script_dir}/demo_exit_code.sh"

echo "Sourcing a script with exit code 0"
. "${absolute_script_dir}/demo_exit_code.sh"

echo -e "\n## Wait loop ##"
# Failing command in a pipeline
bad_command | head -1 &
pid=$!

# Wait on a background job completion
declare -i elapsed=0
declare -i WAIT_MSG_INTERVAL=240 # Print every 4 minutes (should be < ClientAliveInterval in /etc/ssh/sshd_config)
# `ps -p ${pid}` works on macOS and CentOS. On both OSes `ps ${pid}` works as well.
while ps -p ${pid} >/dev/null; do
  sleep 1
  if ((++elapsed % WAIT_MSG_INTERVAL == 0)); then
    echo "Waiting for the completion of the main script. $((elapsed / 60))m and counting ..."
    echo -e "\nCurrently running queries in Postgres:"
    psql -v ON_ERROR_STOP=on -c 'SELECT * FROM running;'
  fi
done

# Return the exit code of the terminated background process. This works in Bash 4.4 despite what Bash docs say:
# "If neither jobspec nor pid specifies an active child process of the shell, the return status is 127."
wait ${pid}

echo 'After the failure: this should have not be seen!' >&2

echo -e "\n## Parallel run with two jobs using & ##"
{
  echo 'Job #1'
  wc *.sh
} &
{
  echo 'Job #2'
  for file in *.sh; do
    name_with_ext=${file##*/}
    echo "Processing '${file}' ..."
    name=${name_with_ext%.*}
    # Fails job #2, but not the script!
    foo
    zip -9 "${name}" "${file}"
    rm -fv "${name}.zip"
  done
} &
# If no arguments are given, all currently active child processes are waited for, and the return status is zero.
wait
echo 'After the failure: this should have not be seen!' >&2

echo -e "\n## GNU Parallel ##"
parallel --halt soon,fail=1 --line-buffer 'set -e
  #set -o pipefail
  echo "Job #{#}, slot #{%}"
  for file in *.sh; do
    echo "Processing ${file} ..."
    #foo
    #echo "This should not be seen!" >&2
  done' ::: 1 2 3
#echo "This should not be seen!" >&2

echo -e "\n## GNU Parallel: two job arguments (single-line) ##"
parallel --halt soon,fail=1 --line-buffer ::: "echo 'Job #1' && wc *.sh" \
  'echo "Job #2"; for file in *.sh; do echo "Processing $file ..."; done'

echo -e "\n## GNU Parallel: two job arguments##"
parallel --halt soon,fail=1 --line-buffer ::: "set -e; \
  echo 'Job #1'; \
  wc *.sh" "set -e; \
  echo 'Job #2'; \
  for f in *.sh; do \
    echo \"Processing \${f}\"; \
  done"
#echo "This should not be seen!" >&2

echo -e "\n### GNU Parallel: function command arguments ###"
job_foo() {
  set -e
  echo 'Job #1'
  wc *.sh
}

job_bar() {
  set -e
  echo 'Job #2'
  for f in *.sh; do
    echo "Processing ${f}"
    #foo
  done
}
export -f job_foo job_bar
parallel --halt soon,fail=1 --line-buffer ::: job_foo job_bar

echo -e "\n### GNU Parallel: function command arguments with --halt now ###"
job_baz() {
  set -e
  echo 'Job #1'
  foo
  wc *.sh
}

job_qux() {
  set -e
  echo 'Job #2'
  for f in *.sh; do
    echo "Processing ${f}"
    foo
  done
}
export -f job_baz job_qux
parallel --halt now,fail=1 --line-buffer ::: job_baz job_qux
#!/usr/bin/env bash
set -e
set -o pipefail

# Get a script directory, same as by $(dirname $0)
script_dir=${0%/*}
absolute_script_dir=$(cd "${script_dir}" && pwd)
cd "${absolute_script_dir}"
#echo -e "\n## Running under ${USER}@${HOSTNAME} at ${PWD} ##\n"

echo -e "\n## Sub-shells ##"

echo -e "### Bash sub-shell: a compound command ###"
bash -c "set -e
  echo 'Job #1'
  for file in *.sh; do
    echo \"Processing \${file} ...\"
    # STOP here
    #foo
  done"

echo -e "\n### Bash sub-shell: a compound pipeline ###"
bash -c "set -e &&
  echo 'Job #1' &&
  for file in *.sh; do
    echo \"Processing \${file} ...\" &&
    :
    # STOP here
    #foo
  done"

# WARNING. The error doesn't propagate from an interpolated string
echo -e "\n### A value from a sub-shell='$(foo)' ###"

# STOP here. The error propagates correctly here
#var=$(foo)

strings=$(ls)
echo -e "\n### Read loop: strings ###"
while read -r line; do
  echo "$line"
  var="foo"
done <<< "$strings"
echo "var=$var"

# WARNING. The error doesn't propagate in process substitution
echo -e "\n### Process substitution: pure ###"
cat < <(foo)

echo -e "\n### Process substitution with 'set -e' ###"
# WARNING. The error doesn't propagate in process substitution
cat < <(set -e; foo)

echo -e "\n## Co-processes ##"

echo -e "\n### Co-process for 'ls' ###"
coproc ls
# As of Bash 4, `COPROC_PID` has to be saved before it gets reset on process termination
_co_pid=$COPROC_PID
var="foo"
echo "Co-process stdout fd = ${COPROC[0]}"
while IFS= read -r line; do
  echo "Processing $line ..."
  var="bar"
done <& "${COPROC[0]}"
echo "var=$var"
wait "$_co_pid"

echo -e "\n### Co-process for a pipeline ###"
coproc { grep -E -v '^(#|root|sync|halt|shutdown)' /etc/passwd \
    | awk -F: '($7 != "/sbin/nologin" && $7 != "/bin/false") { print $1 " " $6 }'; }
# As of Bash 4, `COPROC_PID` has to be saved before it gets reset on process termination
_co_pid=$COPROC_PID
while read -r user dir; do
  echo "User: $user, home: $dir"
done <& "${COPROC[0]}"
wait "$_co_pid"

echo -e "\n### Co-process for an invalid command ###"
coproc { ls; }
# STOP on wait
#coproc { ls; foo; }
# STOP here
#coproc foo
_co_pid=$COPROC_PID
echo "Co-process stdout fd = ${COPROC[0]}"
while IFS= read -r line; do
  echo "Processing $line ..."
done <& "${COPROC[0]}"
wait "$_co_pid"

echo -e "\n## Abbreviated conditions ##"
# Does not fail the script
[[ ${foo} ]] && echo "This should not be executed"

# Does not fail the script
[[ -f /Applications/Thunderbird.app/Contents/MacOS/thunderbird-bin ]] && \
  alias tb=/Applications/Thunderbird.app/Contents/MacOS/thunderbird-bin

echo -e "foo\nbar\nbaz" | while IFS= read -r line; do
  echo "Read: $line"
  # Terminates the script after the while finishes if it's the last command in the loop
  [[ ${foo} ]] && echo "This should not be executed"
  #echo "Continuing..."
done
echo "</Abbreviated conditions>"
pause

echo -e "\n## Executing external scripts ##"
echo "Executing a script with exit code 0"
"${absolute_script_dir}/demo-exit-code.sh"

echo "Sourcing a script with exit code 0"
. "${absolute_script_dir}/demo-exit-code.sh"

#echo "Executing a script with exit code 1"
# This fails fast correctly
#"${absolute_script_dir}/demo-exit-code.sh" 1

echo -e "\n## Wait loop ##"
# STOP on `wait`. Failing command in a pipeline
#bash -c 'sleep 5; bad_command' | head -1 &
# shellcheck disable=SC2002
cat "$0" | head -1 &
pid=$!

# Wait on a background job completion
declare -i elapsed=0
declare -i WAIT_MSG_INTERVAL=2 # Print every 2 seconds
# `ps -p ${pid}` works on macOS and CentOS. On both OSes `ps ${pid}` works as well.
while ps -p ${pid} >/dev/null; do
  sleep 1
  if ((++elapsed % WAIT_MSG_INTERVAL == 0)); then
    echo "Waiting for the completion of the main script. $((elapsed / 60))m and counting ..."
#    echo -e "\nCurrently running queries in Postgres:"
#    psql -v ON_ERROR_STOP=on -c 'SELECT * FROM running;'
  fi
done

# Return the exit code of the terminated background process. This works in Bash 4.4 despite what Bash docs say:
# "If neither jobspec nor pid specifies an active child process of the shell, the return status is 127."
wait ${pid}
#echo 'ERROR After the failure: this should not be seen!' >&2

echo -e "\n## Parallel run with two jobs using & ##"
{
  echo 'Job #1'
  wc "*.sh"
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
# shellcheck disable=SC2016
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
# shellcheck disable=SC2016
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

#echo -e "\n### GNU Parallel: function command arguments with --halt now ###"
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
# This fails fast correctly
# parallel --halt now,fail=1 --line-buffer ::: job_baz job_qux

echo -e "\nThe end."

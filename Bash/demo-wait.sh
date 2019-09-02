#!/usr/bin/env bash
set -xe

script_dir=$(dirname "$0")

"${script_dir}/demo_out.sh" &
pid=$!

# Wait on a background job completion
declare -i elapsed=0
# Print every 10 seconds. This should be < ClientAliveInterval in /etc/ssh/sshd_config.
declare -i WAIT_MSG_INTERVAL=10
# `ps -p ${pid}` works on macOS and CentOS. On both OSes `ps ${pid}` works as well.
while ps -p ${pid} >/dev/null; do
  sleep 1
  if ((++elapsed % WAIT_MSG_INTERVAL == 0)); then
    echo "Waiting for the completion of the main script. $((elapsed / 60))m and counting ..."
  fi
done

# Return the exit code of the terminated background process. This works in Bash 4.4 despite what Bash docs say:
# "If neither jobspec nor pid specifies an active child process of the shell, the return status is 127."
wait ${pid}
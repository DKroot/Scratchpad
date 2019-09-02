#!/usr/bin/env bash
set -e
#set -xe

script_dir=$(dirname "$0")

declare -i seconds_to_run=10

out() {
 echo stdout $*
 echo stderr $* >&2
}

run() {
  declare -i i=0 left
  while ((i < seconds_to_run)); do
    ((left=seconds_to_run-i))
    out $((++i)) "exiting in $left second(s)..."
    sleep 1
  done
}

run

echo -e "\nScript output >> /tmp/demo_redir.log + /tmp/demo_redir-errors.log. Wait ${seconds_to_run} seconds..."
exec 3>&1 4>&2 1>>/tmp/demo_redir.log 2>>/tmp/demo_redir-errors.log
echo | tee -a /tmp/demo_redir-errors.log
date | tee -a /tmp/demo_redir-errors.log
run

exec 1>&3- 2>&4-
echo "Redirection cancelled"

echo -e "\nAnother script output >> /tmp/demo_redir.log + /tmp/demo_redir-errors.log. Wait ${seconds_to_run} seconds..."
exec 3>&1 4>&2 1>>/tmp/demo_redir.log 2>>/tmp/demo_redir-errors.log
echo | tee -a /tmp/demo_redir-errors.log
date | tee -a /tmp/demo_redir-errors.log
"${script_dir}/demo_out.sh" 10

exec 1>&3- 2>&4-
echo "Redirection cancelled"

echo -e "\nRedirecting time output"
{
  time ls
} 2>&1
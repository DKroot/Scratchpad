#!/usr/bin/env bash

# Implement filtering tee using a named pipe
# stdout and stderr messages are printed to the screen simultaneously with grepping into the log file

mkfifo /tmp/.demopipes.pipe
demo_out.sh 2>&1 | tee /tmp/.demopipes.pipe &
grep 'stderr' </tmp/.demopipes.pipe >/tmp/.demopipes.err
#rm -f /tmp/.demopipes.pipe

# Inter-process communication: persists until reboot
#mkfifo /tmp/.demopipes.2.pipe
echo "value:x" | tee /tmp/.demopipes.pipe & #will block until a reader is connected
echo "A separate process will now read this data"
bash -c 'cat </tmp/.demopipes.pipe'
rm -f /tmp/.demopipes.pipe
#!/usr/bin/env bash
# If called with no arguments a new start time is printed
# Otherwise, pass the start time to calculate elapsed time, printed as HH:MM:SSs
stopwatch() {
  if [[ $# -eq 0 ]]; then
    echo $(date '+%s')
  else
    local start=$1
    end=$(date '+%s')

    [[ -z "$start" ]] && start=${end}

    (( delta=end - start ))
    (( ds=delta % 60 ))
    (( dm=(delta / 60) % 60 ))
    (( dh=delta / 3600 ))
    printf '%d:%02d:%02ds' ${dh} ${dm} ${ds}
  fi
}

start_time=$(stopwatch)
read -p 'Enter when ready...'
echo "Elapsed time: $(stopwatch ${start_time})"
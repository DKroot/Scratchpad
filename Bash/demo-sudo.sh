#!/usr/bin/env bash
set -ex
set -o pipefail

LOGIN_GROUP="pardiusers"
if [[ $1 == '-s' ]]; then
  readonly SUPERUSER="true"
  readonly LOGIN_GROUP="pardicore"
  readonly ADDITIONAL_GROUPS="--groups wheel"
  shift
fi
readonly USERNAME="$1"
readonly PASSWORD="$2"

echo -e "\n## Running under ${USER}@${HOSTNAME} in ${PWD} ##\n"

exit 0

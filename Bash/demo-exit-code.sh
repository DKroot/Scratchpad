#!/usr/bin/env bash
[[ $1 ]] && exit $1

[[ -f /foo/bar ]] && echo "This should not be executed"

# Reset exit code to 0 (safe for sourcing) to suppress potential non-zero exit codes from abbreviated conditionals above
:
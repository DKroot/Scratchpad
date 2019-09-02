#!/usr/bin/env stdbuf -o L -e L bash
[[ -f /foo/bar ]] && echo "This should not be executed"

# Reset exit code to 0 (safe for sourcing) to suppress potential non-zero exit codes from abbreviated conditionals above
:
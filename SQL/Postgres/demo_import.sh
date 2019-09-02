#!/usr/bin/env bash
set -e
#set -ex
set -o pipefail

# Get a script directory, same as by $(dirname $0)
script_dir=${0%/*}
absolute_script_dir=$(cd "${script_dir}" && pwd)
cd "${script_dir}"
echo -e "\n## Running under ${USER}@${HOSTNAME} in ${PWD} ##\n"

psql -f demo_import_ddl.sql

echo -e "\n### Copying via stdin ###"
# Strip header via tail
# Split lines by `|` delimiter via awk
# Extract a substring via awk
tail -n +2 demo_import.txt | awk 'BEGIN{FS="|"} {print $1","$2","substr($2,9)}' | psql -f demo_import.sql

echo -e "\n### Copying via a client-side \copy ###"
# Extract a substring via the trigger
# language=PostgresPLSQL
psql -v ON_ERROR_STOP=on --echo-all <<'HEREDOC'
TRUNCATE tmp_demo_import;

\copy tmp_demo_import (wos_uid, pmid) from 'demo_import.txt' ( FORMAT CSV, DELIMITER '|', HEADER ON )
HEREDOC

echo -e "\n### Copying via server-side COPY with Bash variable expansion ###"
# Extract a substring via the trigger
# language=PostgresPLSQL
psql -v ON_ERROR_STOP=on --echo-all <<HEREDOC
TRUNCATE tmp_demo_import;

COPY tmp_demo_import (wos_uid, pmid) FROM '${absolute_script_dir}/demo_import.txt' ( FORMAT CSV, DELIMITER '|', HEADER ON );
HEREDOC

echo -e "\n### Copying via server-side COPY ###"
# Extract a substring via the trigger
# language=PostgresPLSQL
psql -v ON_ERROR_STOP=on --echo-all -v "csv_file=${absolute_script_dir}/demo_import.txt" <<'HEREDOC'
TRUNCATE tmp_demo_import;

COPY tmp_demo_import (wos_uid, pmid) FROM :'csv_file' ( FORMAT CSV, DELIMITER '|', HEADER ON );
HEREDOC

echo -e "\n### Copying via server-side COPY with string concatenation ###"
# Extract a substring via the trigger
# Concatenation operator is not supported, e.g. in `FROM :'dir' || '/demo_import.txt'`
# language=PostgresPLSQL
psql -v ON_ERROR_STOP=on --echo-all -v "dir=${absolute_script_dir}" <<'HEREDOC'
TRUNCATE tmp_demo_import;

COPY tmp_demo_import (wos_uid, pmid) FROM :'dir'
    '/demo_import.txt' ( FORMAT CSV, DELIMITER '|', HEADER ON );
HEREDOC
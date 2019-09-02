\set ON_ERROR_STOP on
\set ECHO all

TRUNCATE TABLE tmp_demo_import;

\copy tmp_demo_import (wos_uid, pmid, pmid_int) FROM pstdin (FORMAT csv, HEADER off)
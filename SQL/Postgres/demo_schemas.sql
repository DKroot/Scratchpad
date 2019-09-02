\set ON_ERROR_STOP on
\set ECHO all

\if :{?schema}
SET search_path = :schema;
\endif

-- JetBrains IDEs: start execution from here
SET TIMEZONE = 'US/Eastern';

SELECT current_setting('search_path');

-- Drops anywhere in the search path:: in the public schema if it doesn't exist in the current schema
DROP TABLE IF EXISTS user.tmp_demo_schemas;

-- Creates in the current schema (the first schema on the path)
CREATE TABLE tmp_demo_schemas (
  foo TEXT
);
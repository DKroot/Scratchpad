\set ON_ERROR_STOP on
\set ECHO all

\if :{?schema}
SET search_path = :schema;
\endif

-- JetBrains IDEs: start execution from here
SET TIMEZONE = 'US/Eastern';

SELECT make_date(2019, 7, 5);

SELECT isfinite(date '6-07-05');
-- Error
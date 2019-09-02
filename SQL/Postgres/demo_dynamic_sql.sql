\set ON_ERROR_STOP on
\set ECHO all

-- DataGrip: start execution from here
SET TIMEZONE = 'US/Eastern';

\echo 't =', :t

\set pk :t'_pk'
\echo 'pk =', :pk

DROP TABLE IF EXISTS tmp_demo:t;
CREATE TABLE tmp_demo:t(bar TEXT);

ALTER TABLE tmp_demo:t
  ADD CONSTRAINT tmp_demo:pk PRIMARY KEY (bar);
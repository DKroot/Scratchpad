\set ON_ERROR_STOP on
\set ECHO all

CREATE TABLE IF NOT EXISTS tmp_demo_create_like (
  col1      VARCHAR(100) NOT NULL,
  col2      VARCHAR(100) NOT NULL DEFAULT '',
  load_date DATE                  DEFAULT current_date,
  CONSTRAINT tmp_demo_create_like_pk PRIMARY KEY (col1, col2)
);

DROP TABLE IF EXISTS tmp_demo_create_like_copy;
CREATE TABLE tmp_demo_create_like_copy (LIKE tmp_demo_create_like); --

CREATE TABLE tmp_demo_create_like_copy (LIKE tmp_demo_create_like INCLUDING DEFAULTS); --

CREATE TEMP TABLE tmp_demo_create_like_copy (LIKE tmp_demo_create_like INCLUDING DEFAULTS); --

SELECT * FROM tmp_demo_create_like_copy;
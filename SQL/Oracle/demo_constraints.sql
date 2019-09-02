WHENEVER SQLERROR EXIT FAILURE
WHENEVER OSERROR EXIT FAILURE
SET SERVEROUTPUT ON
SET ECHO ON

CREATE TABLE tmp_demo_constraints (
  owner       VARCHAR2(128)       NOT NULL,
  table_name  VARCHAR2(128)       NOT NULL,
  column_name VARCHAR2(128)       NOT NULL,
  exclude     NUMBER(1) DEFAULT 0 NOT NULL CHECK (exclude IN (0, 1)), -- Boolean (1/0)
  null_percentage NUMBER(4, 2) DEFAULT 10 NOT NULL CHECK (null_percentage BETWEEN 0 AND 100),
  CONSTRAINT ned_masked_data_columns_pk PRIMARY KEY (owner, table_name, column_name)
);

EXIT
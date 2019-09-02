--liquibase formatted sql
--changeset DK:Liquibase-Demo-Batches-In-Sql-Changesets runAlways:true runOnChange:true endDelimiter:\n/\s*(\n|$)

CREATE OR REPLACE FUNCTION tmp_demo1
RETURN VARCHAR2
IS
BEGIN
  RETURN '';
END;
/

CREATE OR REPLACE FUNCTION tmp_demo2
RETURN VARCHAR2
IS
BEGIN
  RETURN '';
END;
/

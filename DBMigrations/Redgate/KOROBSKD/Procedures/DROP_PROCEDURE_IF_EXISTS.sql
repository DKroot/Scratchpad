CREATE OR REPLACE PROCEDURE korobskd.drop_procedure_if_exists(
    proc_name IN VARCHAR2)
---
--  Graceful dropping of a procedure
---
IS
  object_does_not_exist EXCEPTION;
  PRAGMA EXCEPTION_INIT(object_does_not_exist, -4043) ;
BEGIN
  EXECUTE immediate 'DROP PROCEDURE ' || proc_name;
EXCEPTION
WHEN object_does_not_exist THEN
  NULL;
END;
/
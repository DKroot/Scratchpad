CREATE OR REPLACE PROCEDURE korobskd.drop_function_if_exists(
    funcName IN VARCHAR2)
---
--  Graceful dropping of a function
---
IS
  object_does_not_exist EXCEPTION;
  PRAGMA EXCEPTION_INIT(object_does_not_exist, -4043) ;
BEGIN
  EXECUTE immediate 'DROP FUNCTION ' || funcName;
EXCEPTION
WHEN object_does_not_exist THEN
  NULL;
END;
/
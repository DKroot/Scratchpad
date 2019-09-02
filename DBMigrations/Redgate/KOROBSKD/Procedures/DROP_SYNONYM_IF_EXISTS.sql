CREATE OR REPLACE PROCEDURE korobskd.drop_synonym_if_exists(synonymName VARCHAR2)
---
--  Graceful dropping of a synonym
---
IS
  synonym_not_exists EXCEPTION;
  PRAGMA EXCEPTION_INIT(synonym_not_exists, -1434);
BEGIN
  EXECUTE IMMEDIATE 'DROP SYNONYM ' || synonymName;
EXCEPTION
  WHEN synonym_not_exists THEN
    NULL;
END;
/
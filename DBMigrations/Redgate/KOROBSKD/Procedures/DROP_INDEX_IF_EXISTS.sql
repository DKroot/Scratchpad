CREATE OR REPLACE PROCEDURE korobskd.drop_index_if_exists(
    index_name IN VARCHAR2)
---
--  Graceful dropping of an index
---
IS
  index_not_exists EXCEPTION;
  PRAGMA EXCEPTION_INIT(index_not_exists, -1418) ;
BEGIN
  EXECUTE IMMEDIATE 'DROP INDEX ' || index_name;
EXCEPTION
WHEN index_not_exists THEN
  NULL;
END;
/
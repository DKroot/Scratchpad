CREATE OR REPLACE PROCEDURE korobskd.drop_package_if_exists(
    package_name IN VARCHAR2)
---
--  Graceful dropping of a package
---
IS
  object_does_not_exist EXCEPTION;
  PRAGMA EXCEPTION_INIT(object_does_not_exist, -4043) ;
BEGIN
  EXECUTE immediate 'DROP PACKAGE ' || package_name;
EXCEPTION
WHEN object_does_not_exist THEN
  NULL;
END;
/
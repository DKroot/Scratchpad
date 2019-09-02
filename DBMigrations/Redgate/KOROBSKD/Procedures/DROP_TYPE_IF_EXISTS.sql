CREATE OR REPLACE PROCEDURE korobskd.drop_type_if_exists(objectName VARCHAR2)
---
--  Graceful dropping of a type.
--  Checks if the type exists before attempting to drop it.
---
IS
  v_count    BINARY_INTEGER;
BEGIN
  SELECT COUNT(*)
  INTO v_count
  FROM user_types
  WHERE UPPER(type_name) = UPPER(objectname);

  IF (v_count = 1) THEN
    EXECUTE IMMEDIATE 'DROP TYPE ' || objectName;
  END IF;
END;
/
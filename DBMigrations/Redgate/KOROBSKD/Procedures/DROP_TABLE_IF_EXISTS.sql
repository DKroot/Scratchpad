CREATE OR REPLACE PROCEDURE korobskd.drop_table_if_exists
(
  objectName    IN VARCHAR2
  --objectType    IN VARCHAR2 := ''
)
IS
v_count    BINARY_INTEGER;
--v_schema   VARCHAR2(50 BYTE)
BEGIN
  SELECT COUNT(*)
  INTO v_count
  FROM USER_OBJECTS
  WHERE UPPER(object_type) = UPPER('table')
  AND UPPER(object_name) = UPPER(objectName);

  IF (v_count = 1) THEN
    EXECUTE IMMEDIATE 'DROP TABLE ' || objectName;
  END IF;
END;
/
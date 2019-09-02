CREATE OR REPLACE PROCEDURE korobskd.drop_trigger_if_exists(objectName VARCHAR2)
IS
v_count    BINARY_INTEGER;
X    NUMBER;
BEGIN
      SELECT COUNT(*) INTO X FROM USER_TRIGGERS WHERE TRIGGER_NAME = UPPER(objectName);
      IF X > 0 THEN
          execute immediate  'DROP TRIGGER ' || objectName;
      END IF;
END;
/
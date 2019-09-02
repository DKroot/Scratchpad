CREATE OR REPLACE PROCEDURE korobskd.drop_domain_indexes(
  entityName IN VARCHAR2)
--
-- Drops all domain indexes of an entity
--
IS
  first_err_code_ NUMBER := NULL;
  first_err_msg_ VARCHAR2(32767) := NULl;
  err_msg_ VARCHAR2(32767) := NULl;
BEGIN
  -- Rebuild normal and domain indexes on all non-temporary tables
  FOR cur IN
  (SELECT index_name
  FROM user_indexes
  WHERE table_name = UPPER(entityName) AND index_type = 'DOMAIN'
  ORDER BY index_name
  )
  LOOP
    debug('Dropping index ' || cur.index_name || '...') ;
    BEGIN
      EXECUTE IMMEDIATE 'DROP INDEX ' || cur.index_name || ' FORCE';
    EXCEPTION WHEN OTHERS THEN
      -- Error processing: catch errors and proceed with other indexes
      err_msg_ := chr(10) || 'Error while dropping index ' || cur.index_name || chr(10) || SQLERRM;
      IF first_err_code_ IS NULL THEN
        first_err_code_ := SQLCODE;
        first_err_msg_ := err_msg_;
      END IF;

      DBMS_OUTPUT.PUT_LINE (err_msg_);
      DBMS_OUTPUT.PUT_LINE (DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);
    END;
  END LOOP;

  IF first_err_code_ IS NOT NULL THEN
    RAISE_APPLICATION_ERROR(-20000, first_err_msg_);
  END IF;
END;
/
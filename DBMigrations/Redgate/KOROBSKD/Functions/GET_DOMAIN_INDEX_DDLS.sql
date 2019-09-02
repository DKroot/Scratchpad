CREATE OR REPLACE FUNCTION korobskd.get_domain_index_ddls(
  entityName IN VARCHAR2) RETURN string_list
--
-- Returns a table of domain index DDLs
--
IS
  result string_list := string_list() ;
  i NUMBER := 1;
BEGIN
  FOR cur IN
  (
    SELECT index_name
    FROM user_indexes
    WHERE table_name = UPPER(entityName) AND index_type = 'DOMAIN'
    ORDER BY index_name
  )
  LOOP
    result.EXTEND;
    result(i) := RTRIM(dbms_metadata.get_ddl('INDEX', cur.index_name), ';');
    i := i+1;
  END LOOP;

  RETURN result;
END;
/
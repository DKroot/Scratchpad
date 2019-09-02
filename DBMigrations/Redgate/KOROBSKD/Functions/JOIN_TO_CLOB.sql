CREATE OR REPLACE FUNCTION korobskd.join_to_clob (list string_list, delimiter VARCHAR2 := ',') RETURN CLOB
IS
  result CLOB;
BEGIN
  IF list.COUNT > 0 THEN
    FOR i IN list.FIRST..list.LAST LOOP
      IF i != list.FIRST THEN
        result := result || delimiter;
      END IF;
      result := result || list(i);
    END LOOP;
  END IF;
  RETURN result;
END;
/
CREATE OR REPLACE FUNCTION korobskd.join(list string_list, delimiter VARCHAR2 := ',') RETURN VARCHAR2
IS
  result VARCHAR2(32767);
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
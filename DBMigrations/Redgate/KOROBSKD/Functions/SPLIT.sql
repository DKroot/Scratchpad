CREATE OR REPLACE FUNCTION korobskd.split(s VARCHAR2, delimiter VARCHAR2 := ',', trimItems BOOLEAN := TRUE) RETURN string_list
--
-- Splits delimited string into string_list TABLE
-- * Returns NULL if s is NULL (or '')
--
IS
  result string_list := string_list() ;
  currIndex BINARY_INTEGER := 1;
  nextIndex BINARY_INTEGER;
  i NUMBER := 1;
BEGIN
  IF s IS NULL THEN
    RETURN NULL;
  END IF;

  LOOP
    nextIndex := instr(s, delimiter, currIndex);
    result.extend;
    IF nextIndex > 0 THEN
      result(i) := substr(s, currIndex, nextIndex - currIndex);
    ELSE
      result(i) := substr(s, currIndex);
    END IF;
    IF trimItems THEN
      result(i) := trim(result(i));
    END IF;
    EXIT WHEN nextIndex = 0;
    i := i + 1;
    currIndex := nextIndex + 1;
  END LOOP;
  RETURN result;
END;
/
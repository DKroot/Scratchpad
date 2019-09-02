CREATE OR REPLACE PROCEDURE korobskd.debug(msg CLOB)
--
-- Outputs a time-stamped message. Supports CLOBs.
--
IS
  MaxLineLength CONSTANT BINARY_INTEGER := 32767;

  offset NUMBER := 1;
BEGIN
  LOOP
    IF offset = 1 THEN
      DBMS_OUTPUT.PUT(TO_CHAR(SYSTIMESTAMP, '[YYYY-MM-DD HH24:MI:SS.FF1 TZR] ')) ;
    END IF;

    IF msg IS NULL OR offset > DBMS_LOB.GETLENGTH(msg) THEN
      IF offset = 1 THEN
        DBMS_OUTPUT.PUT_LINE(''); -- PUT() has to be "closed" by PUT_LINE()
      END IF;
      EXIT;
    END IF;

    DBMS_OUTPUT.PUT_LINE(DBMS_LOB.SUBSTR(msg, MaxLineLength, offset));
    offset := offset + MaxLineLength;
  END LOOP;
END;
/
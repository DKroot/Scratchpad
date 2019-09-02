DECLARE
  s VARCHAR2(32767) := q'[ before'after ]';
BEGIN
  DBMS_OUTPUT.PUT_LINE(s);
END;
/

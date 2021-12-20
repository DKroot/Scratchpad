-- WARNING: doesn't work in DataGrip/IDEA. See https://youtrack.jetbrains.com/issue/DBE-3134,
DECLARE
  cur SYS_REFCURSOR;
BEGIN
  OPEN cur FOR SELECT 'OK' AS s FROM dual;

  dbms_sql.return_result(cur);
END;
/

-- region Repeated bind variables and bind variable expressions
-- Binding NULLs
DECLARE
  result VARCHAR2(128);
  cur SYS_REFCURSOR;
BEGIN
  OPEN cur FOR SELECT 'OK' AS s FROM dual;

  LOOP
    FETCH cur INTO result;
    EXIT WHEN cur%NOTFOUND;

    dbms_output.put_line(result);
  END LOOP;
  CLOSE cur;
END;
/

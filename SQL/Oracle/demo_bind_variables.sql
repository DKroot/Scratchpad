-- ### Repeated bind variables and Bind variable expressions ###

-- Binding NULLs
DECLARE
  q CONSTANT VARCHAR2(32767) := q'[
    SELECT 'OK' AS s
    FROM dual
    WHERE :p1 IS NULL
  ]'; 
  cur SYS_REFCURSOR;
  
  result VARCHAR2(128);
BEGIN
  debug('Binding NULLs');

  OPEN cur
  FOR q
  USING TO_CHAR(NULL);
  
  LOOP
    FETCH cur
    INTO result;
    EXIT WHEN cur%NOTFOUND;        

    DBMS_OUTPUT.PUT_LINE(result);
  END LOOP;
  CLOSE cur;
END;
/

-- If the dynamic SQL statement represents an anonymous PL/SQL block or a CALL statement, each *unique* placeholder name 
-- must have a corresponding bind variable in the USING clause.
-- If you repeat a placeholder name, you need not repeat its corresponding bind variable.
-- All references to that placeholder name correspond to one bind variable in the USING clause.
-- http://docs.oracle.com/database/121/LNPLS/dynamic.htm#LNPLS01108
DECLARE
  plsql_block VARCHAR2(100);
BEGIN
  plsql_block := 'BEGIN DBMS_OUTPUT.PUT_LINE(:x || :x || :y || :x); END;';
  EXECUTE IMMEDIATE plsql_block USING 0+1, 1+1;  -- Uses 1, 1, 2, 1
END;
/

CREATE OR REPLACE TYPE string_tab
AS 
TABLE OF VARCHAR2(32767);
/

-- Variables in INs
CREATE OR REPLACE TYPE string_tab
AS
TABLE OF VARCHAR2(32767);
/

DECLARE
  paramList string_tab := string_tab('foo', 'bar');
  result VARCHAR2(128);
  cur SYS_REFCURSOR;
BEGIN
  FOR cur IN (
    WITH cte AS (
      SELECT 'foo' as a
      FROM dual
    )
    SELECT 'It worked' AS result
    FROM cte
    WHERE a IN (SELECT * FROM TABLE(paramList))
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(cur.result);
  END LOOP;
END;
/

-- Bind variables in dynamic SQL INs
DECLARE
  param1 VARCHAR2(32767) := 'foo';

  --TYPE string_table IS TABLE OF varchar2(32767);
  param2 string_tab := string_tab('foo', 'bar');

  result VARCHAR2(128);
  cur SYS_REFCURSOR;
BEGIN
  OPEN cur
  FOR q'[
    SELECT '#1 worked'
    FROM DUAL
    WHERE :p1 IN ('foo', 'bar')
  ]'
  USING param1;

  LOOP
    FETCH cur
    INTO result;
    EXIT WHEN cur%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE(result);
  END LOOP;
  CLOSE cur;

  OPEN cur
  FOR q'[
    SELECT '#2 worked'
    FROM DUAL
    WHERE 'bar' IN (SELECT * FROM TABLE(:p1))
  ]'
  USING param2;

  LOOP
    FETCH cur
    INTO result;
    EXIT WHEN cur%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE(result);
  END LOOP;
  CLOSE cur;
END;
/


-- ### Quoting with bind variables ###

DECLARE
  result VARCHAR2(128);
  cur SYS_REFCURSOR;
  substring VARCHAR2(32767) := '%O''b%';
  q VARCHAR2(32767) := '
    WITH data AS
    (
    SELECT ''foo'' AS s
    FROM DUAL
    UNION
    SELECT ''bar'' AS s
    FROM DUAL
    UNION
    SELECT ''baz'' AS s
    FROM DUAL
    UNION
    SELECT ''O''''brian'' AS s
    FROM DUAL
    )
    SELECT *
    FROM data
    WHERE s LIKE :pattern
  ';
BEGIN
  debug('Regular bind variable');

  OPEN cur
  FOR q
  USING '%b%';
  
  LOOP
    FETCH cur
    INTO result;
    EXIT WHEN cur%NOTFOUND;        

    DBMS_OUTPUT.PUT_LINE(result);
  END LOOP;
  CLOSE cur;
  
  debug('Quotes in a bind value:');
  
  OPEN cur
  FOR q
  USING substring2;
  
  LOOP
    FETCH cur
    INTO result;
    EXIT WHEN cur%NOTFOUND;        

    DBMS_OUTPUT.PUT_LINE(result);
  END LOOP;
  CLOSE cur;
END;
/

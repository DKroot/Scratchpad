-- Print a simple result set
DECLARE
  rec VARCHAR2(128);
  cur SYS_REFCURSOR;
BEGIN
  OPEN cur FOR SELECT 'OK' AS s FROM dual;

  LOOP
    FETCH cur INTO rec;
    EXIT WHEN cur%NOTFOUND;

    dbms_output.put_line(rec);
  END LOOP;
  CLOSE cur;
END;
/

-- Print records from a result set
BEGIN
  FOR rec IN (--
    WITH cte(n, col1, col2) AS (
      SELECT 42, 'foo', 'bar'
      FROM dual --
      UNION ALL
      --
      SELECT 128, 'baz', 'qux'
      FROM dual
    )
    SELECT *
    FROM cte ) LOOP
    dbms_output.put_line(rec.n || ',' || rec.col1 || ',' || rec.col2);
  END LOOP;
END;
/

-- Print records from a result set with an explicit cursor
DECLARE
  CURSOR cur IS
    WITH cte(n, col1, col2) AS (
      SELECT 42, 'foo', 'bar'
      FROM dual --
      UNION ALL
      --
      SELECT 128, 'baz', 'qux'
      FROM dual
    )
    SELECT *
    FROM cte;
  rec cur%ROWTYPE;
BEGIN
  OPEN cur;
  LOOP
    FETCH cur INTO rec;
    EXIT WHEN cur%NOTFOUND;

    dbms_output.put_line(rec.n || ',' || rec.col1 || ',' || rec.col2);
  END LOOP;
  CLOSE cur;
END;
/

-- Print records from a result set with an explicit cursor
DECLARE --
  TYPE my_record_type IS RECORD (n NUMBER, col1 VARCHAR2(4000), col2 VARCHAR2(4000)); --
  TYPE my_cursor_type IS REF CURSOR RETURN my_record_type;

  cur my_cursor_type;
  rec my_record_type;
BEGIN
  OPEN cur FOR --
    WITH cte(n, col1, col2) AS (
      SELECT 42, 'foo', 'bar'
      FROM dual --
      UNION ALL
      --
      SELECT 128, 'baz', 'qux'
      FROM dual
    )
    SELECT *
    FROM cte;
  LOOP
    FETCH cur INTO rec;
    EXIT WHEN cur%NOTFOUND;

    dbms_output.put_line(rec.n || ',' || rec.col1 || ',' || rec.col2);
  END LOOP;
  CLOSE cur;
END;
/

-- Fetch a result set. WARNING: doesn't work in DataGrip/IDEA. See https://youtrack.jetbrains.com/issue/DBE-3134,
DECLARE
  cur SYS_REFCURSOR;
BEGIN
  OPEN cur FOR SELECT 'OK' AS s FROM dual;

  dbms_sql.return_result(cur);
END;
/
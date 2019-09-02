WITH
  data AS (
    SELECT 1 AS id, 'foo' AS account_type
    FROM dual
    UNION ALL
    SELECT 2 AS id, '' AS account_type
    FROM dual
    UNION ALL
    SELECT 3 AS id, NULL AS account_type
    FROM dual
  )
SELECT *
FROM data
WHERE account_type IS NULL;
-- 2 rows

WITH
  data AS (
    SELECT 1 AS id, 'foo' AS account_type
    FROM dual
    UNION ALL
    SELECT 2 AS id, '' AS account_type
    FROM dual
    UNION ALL
    SELECT 3 AS id, NULL AS account_type
    FROM dual
  )
SELECT *
FROM data
WHERE account_type = '';
-- 0 rows

DECLARE
  s VARCHAR2(1) := '';
  c CLOB := '';
BEGIN
  dbms_output.PUT('Empty VARCHAR2 string IS ');
  IF s IS NULL THEN
    dbms_output.PUT_LINE('NULL');
  ELSE
    dbms_output.PUT_LINE('NOT NULL');
  END IF;

  dbms_output.PUT('Empty CLOB string IS ');
  IF c IS NULL THEN
    dbms_output.PUT_LINE('NULL');
  ELSE
    dbms_output.PUT_LINE('NOT NULL');
  END IF;
END;
/

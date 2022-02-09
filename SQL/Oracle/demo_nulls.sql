-- COUNT(DISTINCT) with NULLs
WITH sample_data(account_type) AS (
  SELECT 'INT'
  FROM dual
  UNION ALL
  --
  SELECT 'EXT'
  FROM dual
  UNION ALL
  --
  SELECT NULL
  FROM dual
)
SELECT count(DISTINCT account_type) AS distinct_account_types
FROM sample_data;

-- NULLs in UNION ALL
WITH sample_data(account_type) AS (
  SELECT 'INT'
  FROM dual
  UNION ALL
  --
  SELECT 'EXT'
  FROM dual
  UNION ALL
  --
  SELECT NULL
  FROM dual
)
SELECT *
FROM sample_data
WHERE account_type = 'INT' OR account_type IS NULL;

-- Aggregating data with NULLs
WITH sample_data(v) AS (
  SELECT 1
  FROM dual
  UNION ALL
  --
  SELECT 2 AS v
  FROM dual
  UNION ALL
  --
  SELECT NULL AS v
  FROM dual
)
SELECT avg(v)
FROM sample_data;

-- CASE without ELSE returns NULL
SELECT CASE WHEN 1 = 2 THEN 'true' END
FROM dual;

/*
Although Oracle treats zero-length character strings as nulls, concatenating a zero-length
character string with another operand always results in the other operand, so null can result
only from the concatenation of two null strings. However, this may not continue to be true in
future versions of Oracle Database. To concatenate an expression that might be null, use the
NVL function to explicitly convert the expression to a zero-length string.
*/
SELECT 'foo' || NULL AS "|| with NULL", concat('bar', NULL) AS "concat() with NULL"
FROM dual;
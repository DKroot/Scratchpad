SELECT 9 / 10;
-- 0

SELECT cast(9 AS FLOAT) / 10;
-- 0.9

SELECT cast(9 AS NUMERIC) / 10;
-- 0.9

SELECT round(cast(9 AS NUMERIC) / 10);
-- 1

SELECT round(cast(1 AS NUMERIC) / 3, 2);
-- 1

SELECT (1, 2) = (1, 2);
-- true

SELECT (1, 2) = (1, 3);
-- false

SELECT (1, NULL) = (1, NULL);
-- NULL

-- Including an optional ROW keyword in the row constructor that builds a row value (also called a composite value)
--@formatter:off
SELECT ROW(1, NULL) = ROW(1, NULL);
-- NULL
--@formatter:on

SELECT (1, NULL) IS NOT DISTINCT FROM (1, NULL);
-- true

-- Including an optional ROW keyword in the row constructor that builds a row value (also called a composite value)
SELECT ROW (1, NULL) IS NOT DISTINCT FROM ROW (1, NULL);
-- true

-- Operation with a subquery value in SELECT
WITH cte AS (--
  SELECT 1, 'a', 'aa' --
  UNION ALL
  --
  SELECT 2, 'b', NULL --
  UNION ALL
  --
  SELECT 3, 'b', NULL)
SELECT 1 +
       (SELECT min(id)
        FROM cte t(id, foo, bar)
        WHERE foo = 'b') AS total;

-- Operation with a subquery value in WHERE
WITH employee AS ( --
  SELECT 1, 100000 --
  UNION ALL
  --
  SELECT 2, 80000 --
  UNION ALL
  --
  SELECT 3, 100000 --
)
SELECT *
FROM employee t(id, salary)
WHERE id =
      (WITH cte AS (--
        SELECT 1, 'a', 'aa' --
        UNION ALL
        --
        SELECT 2, 'b', NULL --
        UNION ALL
        --
        SELECT 3, 'b', NULL)
       SELECT min(id)
       FROM cte t(id, foo, bar)
       WHERE foo = 'b');
WITH cte AS (--
  SELECT 'foo' AS a, 'bar' AS b
  FROM dual
    UNION ALL --
    SELECT 'foo' AS a, 'baz' AS b
    FROM dual
    UNION ALL --
    SELECT 'bar' AS a, 'baz' AS b
    FROM dual
    UNION ALL --
    SELECT 'baz' AS a, 'qux' AS b
    FROM dual)
SELECT COUNT(1)
FROM cte
WHERE a = 'foo';
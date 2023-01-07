-- UNION: implicitly selecting DISTINCT values, including NULL. The column is named as in the first SELECT.
WITH cte(a, b) AS (
  VALUES
    ('foo', NULL),
    ('foo', 'baz'),
    ('foo', 'qux'),
    ('bar', 'baz'),
    ('baz', NULL)
)
SELECT a
FROM cte
UNION
SELECT b
FROM cte;

-- Ordered UNION (NULLs last by default). The column is named as in the first SELECT.
WITH cte(a, b) AS (
  VALUES
    ('foo', NULL),
    ('foo', 'baz'),
    ('foo', 'qux'),
    ('bar', 'baz'),
    ('baz', NULL)
)
SELECT a as column_a
FROM cte
UNION
SELECT b
FROM cte
ORDER BY 1;

-- UNION ALL: includes exactly 10 rows (5 from the first SELECT + 5 from the second SELECT)
WITH cte(a, b) AS (
  VALUES
    ('foo', NULL),
    ('foo', 'baz'),
    ('foo', 'qux'),
    ('bar', 'baz'),
    ('baz', NULL)
)
SELECT a as column_a
FROM cte
UNION ALL
SELECT b
FROM cte
ORDER BY 1;
-- Implicit GROUP = the entire result set
WITH cte(a, b) AS (
  VALUES
    ('foo', NULL),
    ('foo', 'baz'),
    ('foo', 'qux'),
    ('bar', 'baz'),
    ('baz', NULL)
)
SELECT count(a)
FROM cte;

-- GROUP BY and pick NOT NULLs
WITH cte(a, b) AS (
  VALUES
    ('foo', NULL),
    ('foo', 'baz'),
    ('foo', 'qux'),
    ('bar', 'baz'),
    ('baz', NULL)
)
SELECT a, max(b), min(b), string_agg(b, ', ')
FROM cte
GROUP BY a;

WITH cte(a, b) AS (
  VALUES
    ('foo', NULL),
    ('foo', 'baz'),
    ('foo', 'qux'),
    ('bar', 'baz'),
    ('baz', NULL)
)
SELECT 'True'
FROM cte
HAVING count(1) > 3;

-- Counting duplicates
SELECT COUNT(1)
FROM (
  VALUES
    ('foo', 'bar'),
    ('foo', 'baz'),
    ('bar', 'baz'),
    ('baz', 'qux')
) AS t(a, b)
WHERE a = 'foo';
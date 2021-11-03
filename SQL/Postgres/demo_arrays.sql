-- Unrolling an array in an int expression (a-la a lambda function)
WITH cte AS (
  SELECT ARRAY [1, 2, 42] AS a
)
SELECT unnest(a) + 1 AS expression
FROM cte;

-- Unrolling an array in a string expression (a-la a lambda function)
WITH cte AS (
  SELECT ARRAY [' f oo ', ' b ar,', 'baz'] AS a
)
SELECT translate(unnest(a), ' ,', '') AS expression
FROM cte;

-- Implicit GROUP = the entire result set
WITH cte(a, b) AS (
  VALUES
    ('foo', NULL),
    ('foo', 'baz'),
    ('foo', 'qux'),
    ('bar', 'baz'),
    ('baz', NULL)
)
SELECT array_agg(a) AS a_list, array_agg(b) AS b_list
FROM cte;

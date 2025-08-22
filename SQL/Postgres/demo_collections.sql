SELECT ARRAY [1, 2, 42] AS arr;

-- Unrolling an array in an int expression (a-la a lambda function)
-- In SELECT
SELECT unnest(ARRAY [1, 2, 42]) + 1 AS item_expr_values;
-- Use a row set as an entity in FROM
SELECT *
FROM unnest(ARRAY [1, 2, 42]) AS item_values(foo);

-- Unrolling an array in a string expression (a-la a lambda function)
SELECT translate(unnest(ARRAY [' f oo ', ' b ar,', 'baz']), ' ,', '') AS item_expr_values;

-- Implicit GROUP = the entire result set
SELECT array_agg(a) AS a_list, array_agg(b) AS b_list
FROM (
  VALUES ('foo', NULL),
    ('foo', 'baz'),
    ('foo', 'qux'),
    ('bar', 'baz'),
    ('baz', NULL)
) AS cte(a, b);

-- Split to array
SELECT string_to_array('foo;;bar;;baz', ';;');

-- Split with empty elements
SELECT string_to_array('foo;;bar;;baz', ';');

-- To the row set
SELECT string_to_table('foo;;bar;;baz', ';;') AS item_expr_values;
SELECT unnest(string_to_array('foo;;bar;;baz', ';;')) AS item_expr_values;

-- Use a row set as an entity in FROM
SELECT st.item
FROM string_to_table('foo;;bar;;baz', ';;') AS st(item);

-- Use a row set as a CTE
WITH cte(item) AS (
  SELECT string_to_table('foo;;bar;;baz', ';;')
)
SELECT item
FROM cte;

-- Use a row set as a subquery
SELECT sq.item_expr_values
FROM (
  SELECT string_to_table('foo;;bar;;baz', ';;') AS item_expr_values
) sq;

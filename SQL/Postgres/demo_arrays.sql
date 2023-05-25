-- Unrolling an array in an int expression (a-la a lambda function)
SELECT unnest(ARRAY [1, 2, 42]) + 1 AS expression;

-- Unrolling an array in a string expression (a-la a lambda function)
SELECT translate(unnest(ARRAY [' f oo ', ' b ar,', 'baz']), ' ,', '') AS expression;

-- Implicit GROUP = the entire result set
SELECT array_agg(a) AS a_list, array_agg(b) AS b_list
FROM (VALUES ('foo', NULL),
        ('foo', 'baz'),
        ('foo', 'qux'),
        ('bar', 'baz'),
        ('baz', NULL)) AS cte(a, b);

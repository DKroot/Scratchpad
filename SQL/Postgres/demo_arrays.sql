-- Unrolling an array in an expression (a-la a lambda function)
WITH cte AS (
  SELECT ARRAY[1, 2, 42] AS a
)
SELECT unnest(a) + 1 as expression
FROM cte;

-- Unrolling an array in an expression (a-la a lambda function)
-- noinspection SqlSignature
WITH cte AS (
  SELECT ARRAY[' f oo ', ' b ar,', 'baz'] AS a
)
SELECT translate(unnest(a), ' ,', '') as expression
FROM cte;
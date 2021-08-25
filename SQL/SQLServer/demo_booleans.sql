-- Select BIT data
WITH sample_data AS (
  SELECT 1 AS foo
)
SELECT cast(foo AS BIT) AS foo_bool
FROM sample_data;

-- Select a Boolean expression
WITH sample_data AS (
  SELECT 42 AS foo
)
SELECT cast(iif(foo IN (1, 2, 3), 1, 0) AS BIT) AS foo_bool, cast(iif(foo = 42, 1, 0) AS BIT) AS bar_bool
FROM sample_data;

-- Select a Boolean expression
WITH sample_data AS (
  SELECT 42 AS foo
)
SELECT cast(iif(foo IN (1, 2, 3), 1, 0) AS BIT) AS foo_bool, cast(iif(foo = 42, 'TRUE', 'FALSE') AS BIT) AS bar_bool
FROM sample_data;
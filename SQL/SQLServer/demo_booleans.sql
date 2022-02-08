-- Select BIT data
WITH sample_data(foo) AS (
  SELECT 1
)
SELECT cast(foo AS BIT) AS foo_bool
FROM sample_data;

-- Select a Boolean expression
WITH sample_data(foo) AS (
  SELECT 42
)
SELECT cast(iif(foo IN (1, 2, 3), 1, 0) AS BIT) AS foo_bool, cast(iif(foo = 42, 1, 0) AS BIT) AS bar_bool
FROM sample_data;

-- Select a Boolean expression
WITH sample_data(foo) AS (
  SELECT 42
)
SELECT cast(iif(foo IN (1, 2, 3), 1, 0) AS BIT) AS foo_bool, cast(iif(foo = 42, 'TRUE', 'FALSE') AS BIT) AS bar_bool
FROM sample_data;
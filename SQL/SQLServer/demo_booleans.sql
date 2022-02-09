-- Select BIT data
SELECT cast(foo AS BIT) AS foo_bool
FROM (
  VALUES --
    (1)
) AS sample_data(foo);

-- Select a Boolean expression
SELECT cast(iif(foo IN (1, 2, 3), 1, 0) AS BIT) AS foo_bool, cast(iif(foo = 42, 1, 0) AS BIT) AS bar_bool
FROM (
  VALUES --
    (42)
) AS sample_data(foo);

-- Select a Boolean expression
SELECT cast(iif(foo IN (1, 2, 3), 1, 0) AS BIT) AS foo_bool, cast(iif(foo = 42, 'TRUE', 'FALSE') AS BIT) AS bar_bool
FROM (
  VALUES --
    (42)
) AS sample_data(foo);
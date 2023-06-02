:ON ERROR EXIT

DECLARE @city VARCHAR(MAX), @bar VARCHAR(MAX);

SET @city = 'San Francisco';
PRINT concat('@city', @city);

SET @bar = 'bar';
PRINT concat_ws('; ', concat('@city=', @city), concat('@bar=', @bar));

-- Can't use multiple assignments
-- SET @foo = 'foo', @bar = 'bar'
SELECT @city = 'New Orleans', @bar = 'qux';
PRINT concat_ws('; ', concat('city=', @city), concat('@bar=', @bar));
GO

-- region Multiple-row query
DECLARE @city VARCHAR(MAX);

-- Assigns a value from the last result row to a variable
SELECT @city = city
FROM (
       VALUES --
              ('San Francisco'),
              ('Chicago'),
              ('New Orleans'),
              ('Washington'),
              ('New York'),
              ('Seattle')
     ) AS cities(city)
ORDER BY city DESC;

PRINT @city;
GO
-- endregion

-- region No-result query
DECLARE @city VARCHAR(MAX) = 'foo';
SELECT @city;

-- Variable is left unchanged on no result
SELECT @city = 'bar'
WHERE getdate() = '2000-01-01';

SELECT @city;

-- Variable is set to NULL on no result
SET @city = (SELECT 'bar'
             WHERE getdate() = '2000-01-01');
SELECT @city;
GO
-- endregion

-- region Variable could be added into SELECT to feed a fixed value into a column
DECLARE @city VARCHAR(MAX) = 'foo';

SELECT @city, city_name
FROM (
  VALUES --
    ('San Francisco'),
    ('Chicago'),
    ('New Orleans'),
    ('Washington'),
    ('New York'),
    ('Seattle')
) AS cities(city_name)
ORDER BY city_name DESC;

PRINT @city;
GO
-- endregion
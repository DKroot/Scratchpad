:ON ERROR EXIT
-- JetBrains IDEs: start execution from here

DECLARE @city VARCHAR(MAX), @bar VARCHAR(MAX);

SET @city = 'San Francisco';
PRINT concat('@city', @city);

SET @bar = 'bar';
PRINT concat_ws('; ', concat('@city=', @city), concat('@bar=', @bar));

-- Can't use multiple assignment in one line
-- SET @foo = 'foo', @bar = 'bar'
SELECT @city = 'New Orleans', @bar = 'qux';
PRINT concat_ws('; ', concat('city=', @city), concat('@bar=', @bar));

-- Sample data
SELECT TOP 1 @city = city
FROM (
       VALUES --
              ('San Francisco'),
              ('Chicago'),
              ('New Orleans'),
              ('Washington'),
              ('New York'),
              ('Seattle')
     ) AS cities(city)
ORDER BY city;

IF @city = 'Chicago'
  PRINT @city;
ELSE BEGIN
  PRINT 'ELSE';
END;

SELECT TOP 1 @city = city
FROM (
       VALUES --
              ('San Francisco'),
              ('Chicago'),
              ('New Orleans'),
              ('Washington'),
              ('New York'),
              ('Seattle')
     ) AS cities(city)
WHERE city = 'foo'
ORDER BY city DESC;
PRINT @city;
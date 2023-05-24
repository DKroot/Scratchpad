:ON ERROR EXIT
-- JetBrains IDEs: start execution from here

-- Sample data
SELECT *
FROM (
  VALUES --
    (1, 1, 2001, 'San Francisco'),
    (2, 1, 2009, 'Chicago'),
    (3, 1, 2009, 'New Orleans'),
    (4, 2, 2006, 'Washington'),
    (5, 2, 2007, 'New York'),
    (6, 3, 2008, 'Seattle')
) AS sample_data(tour_id, group_id, year, city);

DECLARE @foo VARCHAR(MAX), @bar VARCHAR(MAX);

SET @foo = 'foo';
PRINT concat('@foo=', @foo);

SET @bar = 'bar';
PRINT concat_ws('; ', concat('@foo=', @foo), concat('@bar=', @bar));

-- Can't use multiple assignment in one line
-- SET @foo = 'foo', @bar = 'bar'
SELECT @foo = 'baz', @bar = 'qux';
PRINT concat_ws('; ', concat('@foo=', @foo), concat('@bar=', @bar));

IF @foo = 'ba'
  PRINT @foo;
ELSE BEGIN
  PRINT 'ELSE';
END;
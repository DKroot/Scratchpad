-- Sample data
WITH sample_data(tour_id, group_id, year, city) AS (
  SELECT 1, 1, 2001, 'San Francisco'
  UNION ALL
  SELECT 2, 1, 2009, 'Chicago'
  UNION ALL
  SELECT 3, 1, 2009, 'New Orleans'
  UNION ALL
  SELECT 4, 2, 2006, 'Washington'
  UNION ALL
  SELECT 5, 2, 2007, 'New York'
  UNION ALL
  SELECT 6, 3, 2008, 'Seattle'
)
SELECT *
FROM sample_data

DECLARE @foo VARCHAR(MAX), @bar VARCHAR(MAX);

SET @foo = 'foo';
PRINT concat('@foo=', @foo);

SET @bar = 'bar';
PRINT concat_ws('; ', concat('@foo=', @foo), concat('@bar=', @bar));

-- Can't use multiple assignment in one line
-- SET @foo = 'foo', @bar = 'bar'
SELECT @foo = 'baz', @bar = 'qux';
PRINT concat_ws('; ', concat('@foo=', @foo), concat('@bar=', @bar));
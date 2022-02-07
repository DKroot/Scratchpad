/*
-- Sample data
WITH sample_data AS (
  SELECT 1 AS tour_id, 1 AS group_id, 2001 AS year, 'San Francisco' AS city
  UNION ALL
  SELECT 2 AS tour_id, 1 AS group_id, 2009 AS year, 'Chicago' AS city
  UNION ALL
  SELECT 3 AS tour_id, 1 AS group_id, 2009 AS year, 'New Orleans' AS city
  UNION ALL
  SELECT 4 AS tour_id, 2 AS group_id, 2006 AS year, 'Washington' AS city
  UNION ALL
  SELECT 5 AS tour_id, 2 AS group_id, 2007 AS year, 'New York' AS city
  UNION ALL
  SELECT 6 AS tour_id, 3 AS group_id, 2008 AS year, 'Seattle' AS city
)
SELECT *
INTO #demo_cursors -- new table created
FROM sample_data
*/

DECLARE @foo VARCHAR(MAX), @bar VARCHAR(MAX)

SET @foo = 'foo'
PRINT concat('@foo=', @foo)

SET @bar = 'bar'
PRINT concat_ws('; ', concat('@foo=', @foo), concat('@bar=', @bar))

-- Can't use multiple assignment in one line
-- SET @foo = 'foo', @bar = 'bar'
SELECT @foo = 'baz', @bar = 'qux'
PRINT concat_ws('; ', concat('@foo=', @foo), concat('@bar=', @bar))
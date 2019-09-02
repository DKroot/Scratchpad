-- COUNT of records with SELECT DISTINCT
WITH sample_data AS
(
  SELECT 1 AS group_id, 2001 AS year, 10001 as tour_id, 'San Francisco' AS city
  FROM dual
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9010 as tour_id, 'Chicago' AS city
  FROM dual
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9002 as tour_id, 'New Orleans' AS city
  FROM dual  
  UNION ALL
  SELECT 2 AS group_id, 2006 AS year, 6001 as tour_id, 'Washington' AS city
  FROM dual
  UNION ALL
  SELECT 2 AS group_id, 2007 AS year, 7001 as tour_id, 'New York' AS city
  FROM dual
  UNION ALL
  SELECT 3 AS group_id, 2008 AS year, 8001 as tour_id, 'Seattle' AS city
  FROM dual
)
SELECT DISTINCT
  year,
  COUNT(1) OVER () as TotalCount
FROM sample_data
ORDER BY year DESC
FETCH NEXT 3 ROWS ONLY;

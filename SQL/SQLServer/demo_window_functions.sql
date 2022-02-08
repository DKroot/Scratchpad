WITH sample_data AS (
  SELECT 1 AS group_id, 2001 AS year, 10001 AS tour_id, 'San Francisco' AS city
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9010 AS tour_id, 'Chicago' AS city
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9002 AS tour_id, 'New Orleans' AS city
  UNION ALL
  SELECT 2 AS group_id, 2006 AS year, 6001 AS tour_id, 'Washington' AS city
  UNION ALL
  SELECT 2 AS group_id, 2007 AS year, 7001 AS tour_id, 'New York' AS city
  UNION ALL
  SELECT 3 AS group_id, 2008 AS year, 8001 AS tour_id, 'Seattle' AS city
)
SELECT TOP (1) WITH TIES *
FROM sample_data
ORDER BY dense_rank() OVER (PARTITION BY group_id ORDER BY year DESC, tour_id DESC);

WITH sample_data AS (
  SELECT 1 AS group_id, 2001 AS year, 10001 AS tour_id, 'San Francisco' AS city
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9010 AS tour_id, 'Chicago' AS city
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9002 AS tour_id, 'New Orleans' AS city
  UNION ALL
  SELECT 2 AS group_id, 2006 AS year, 6001 AS tour_id, 'Washington' AS city
  UNION ALL
  SELECT 2 AS group_id, 2007 AS year, 7001 AS tour_id, 'New York' AS city
  UNION ALL
  SELECT 3 AS group_id, 2008 AS year, 8001 AS tour_id, 'Seattle' AS city
)
SELECT group_id, year, dense_rank() OVER (ORDER BY tour_id)
FROM sample_data
GROUP BY group_id, year
ORDER BY group_id, year DESC;

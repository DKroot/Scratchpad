-- MAX() + KEEP LAST
WITH sample_data AS (
  SELECT 1 AS group_id, 2001 AS year, 10001 AS tour_id, 'San Francisco' AS city
  FROM dual
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9010 AS tour_id, 'Chicago' AS city
  FROM dual
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9002 AS tour_id, 'New Orleans' AS city
  FROM dual
  UNION ALL
  SELECT 2 AS group_id, 2006 AS year, 6001 AS tour_id, 'Washington' AS city
  FROM dual
  UNION ALL
  SELECT 2 AS group_id, 2007 AS year, 7001 AS tour_id, 'New York' AS city
  FROM dual
  UNION ALL
  SELECT 3 AS group_id, 2008 AS year, 8001 AS tour_id, 'Seattle' AS city
  FROM dual
)
SELECT group_id, MAX(year) AS last_year, MAX(tour_id) KEEP (DENSE_RANK LAST ORDER BY year) AS last_year_last_tour,
  MAX(city) KEEP (DENSE_RANK LAST ORDER BY year, tour_id) AS last_year_last_tour_city
FROM sample_data
GROUP BY group_id;

-- DISTINCT + LAST_VALUE(): very weird result
WITH sample_data AS (
  SELECT 1 AS group_id, 2001 AS year, 10001 AS tour_id, 'San Francisco' AS city
  FROM dual
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9010 AS tour_id, 'Chicago' AS city
  FROM dual
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9002 AS tour_id, 'New Orleans' AS city
  FROM dual
  UNION ALL
  SELECT 2 AS group_id, 2006 AS year, 6001 AS tour_id, 'Washington' AS city
  FROM dual
  UNION ALL
  SELECT 2 AS group_id, 2007 AS year, 7001 AS tour_id, 'New York' AS city
  FROM dual
  UNION ALL
  SELECT 3 AS group_id, 2008 AS year, 8001 AS tour_id, 'Seattle' AS city
  FROM dual
)
SELECT DISTINCT group_id, LAST_VALUE(year) OVER (PARTITION BY group_id ORDER BY year, tour_id) AS last_year
FROM sample_data
ORDER BY group_id;

-- ROW_NUMBER OVER(): missing ORDER BY expression in the window specification
WITH sample_data AS (
  SELECT 1 AS group_id, 2001 AS year, 10001 AS tour_id, 'San Francisco' AS city
  FROM dual
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9010 AS tour_id, 'Chicago' AS city
  FROM dual
  UNION ALL
  SELECT 1 AS group_id, 2009 AS year, 9002 AS tour_id, 'New Orleans' AS city
  FROM dual
  UNION ALL
  SELECT 2 AS group_id, 2006 AS year, 6001 AS tour_id, 'Washington' AS city
  FROM dual
  UNION ALL
  SELECT 2 AS group_id, 2007 AS year, 7001 AS tour_id, 'New York' AS city
  FROM dual
  UNION ALL
  SELECT 3 AS group_id, 2008 AS year, 8001 AS tour_id, 'Seattle' AS city
  FROM dual
)
SELECT ROW_NUMBER() OVER() AS r, *
FROM sample_data
ORDER BY group_id;

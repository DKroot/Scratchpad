-- 3 latest years
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
SELECT DISTINCT TOP (3) year
FROM sample_data
ORDER BY year DESC;

-- 2nd latest year
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
SELECT TOP (1) year
FROM (
  SELECT DISTINCT TOP (2) year
  FROM sample_data
  ORDER BY year DESC
) top_2_years
ORDER BY year;

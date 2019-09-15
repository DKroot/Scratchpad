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
SELECT
  group_id,
  stuff((
          SELECT ', ' + t1.city
            FROM sample_data t1
           WHERE t1.group_id = sample_data.group_id
           ORDER BY t1.city
             FOR XML PATH (''), TYPE
        ).value('.', 'nvarchar(max)'), 1, datalength(', '), '') AS city_list
  FROM sample_data
 GROUP BY group_id
 ORDER BY group_id;

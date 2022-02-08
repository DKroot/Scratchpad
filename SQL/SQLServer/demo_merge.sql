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
INTO #demo_merge -- new table created
FROM sample_data;

-- INSERT if doesn't exist
WITH data AS (
  SELECT 7 AS tour_id, 4 AS group_id, 2021 AS year, 'San Francisco' AS city
)
INSERT
INTO #demo_merge(tour_id, group_id, year, city)
SELECT tour_id, group_id, year, city
FROM data
WHERE NOT exists(SELECT 1
                 FROM #demo_merge tdm
                   JOIN data ON tdm.tour_id = data.tour_id);

-- MERGE
MERGE
INTO #demo_merge AS tdm
USING (
  SELECT 7 AS tour_id, 4 AS group_id, 2021 AS year, 'San Francisco' AS city
) data
ON (tdm.tour_id = data.tour_id)
WHEN MATCHED THEN
  UPDATE
  SET tdm.group_id = data.group_id, tdm.year = data.year, tdm.city = data.city
WHEN NOT MATCHED THEN
  INSERT (tour_id, group_id, year, city)
  VALUES (data.tour_id, data.group_id, data.year, data.city);

DROP TABLE #demo_merge;
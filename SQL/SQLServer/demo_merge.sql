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
INTO tmp_demo_merge -- new table created
FROM sample_data;

-- INSERT if doesn't exist
WITH data AS (
  SELECT 7 AS tour_id, 4 AS group_id, 2021 AS year, 'San Francisco' AS city
)
INSERT
INTO tmp_demo_merge(tour_id, group_id, year, city)
SELECT tour_id, group_id, year, city
FROM data
WHERE NOT exists(SELECT 1
                 FROM tmp_demo_merge tdm
                   JOIN data ON tdm.tour_id = data.tour_id);

-- MERGE
MERGE INTO tmp_demo_merge AS tdm
USING (
  SELECT 7 AS tour_id, 4 AS group_id, 2021 AS year, 'San Francisco' AS city
) data
ON (tdm.tour_id = data.tour_id)
WHEN MATCHED THEN
  UPDATE
  SET tdm.group_id = data.group_id, tdm.year = data.year, tdm.city = data.city
WHEN NOT MATCHED THEN
  INSERT
    (tour_id, group_id, year, city)
  VALUES
    (data.tour_id, data.group_id, data.year, data.city);

DROP TABLE tmp_demo_merge;
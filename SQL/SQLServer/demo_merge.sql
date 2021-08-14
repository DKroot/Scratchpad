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
SELECT *
INTO tmp_demo_merge
FROM sample_data;

-- INSERT if doesn't exist
WITH data AS (
  SELECT 1 AS group_id, 2001 AS year, 10001 AS tour_id, 'San Francisco' AS city
)
INSERT
INTO tmp_demo_merge(group_id, year, tour_id, city)
SELECT group_id, year, tour_id, city
FROM data
WHERE NOT exists(SELECT 1
                 FROM
                   tmp_demo_merge tdm
                     JOIN data ON tdm.tour_id = data.tour_id);

-- MERGE
WITH data AS (
  SELECT 1 AS group_id, 2001 AS year, 10001 AS tour_id, 'San Francisco' AS city
) MERGE INTO tmp_demo_merge tdm
USING (
  SELECT *
  FROM data
) sq
ON (tdm. = sq.)
WHEN MATCHED THEN
  UPDATE
  SET tdm. = sq., tdm. = sq.
WHEN NOT MATCHED THEN
  INSERT
    (, )
  VALUES
    (sq., sq.);
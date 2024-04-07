-- Sample data
SELECT *
INTO #demo_merge -- new table created
FROM (
  VALUES --
    (1, 1, 2001, 'San Francisco'),
    (2, 1, 2009, 'Chicago'),
    (3, 1, 2009, 'New Orleans'),
    (4, 2, 2006, 'Washington'),
    (5, 2, 2007, 'New York'),
    (6, 3, 2008, 'Seattle')
) AS sample_data(tour_id, group_id, year, city);

-- INSERT if doesn't exist
WITH sample_data(tour_id, group_id, year, city) AS (
  SELECT 7, 4, 2021, 'San Francisco'
)
INSERT
INTO #demo_merge(tour_id, group_id, year, city)
SELECT tour_id, group_id, year, city
FROM sample_data
WHERE NOT exists(SELECT 1
                 FROM #demo_merge tdm
                   JOIN sample_data ON tdm.tour_id = sample_data.tour_id);

-- MERGE
MERGE
INTO #demo_merge AS tdm
USING (
  VALUES --
    (7, 4, 2021, 'San Francisco')
) AS sq(tour_id, group_id, year, city)
ON (tdm.tour_id = sq.tour_id)
WHEN MATCHED THEN
  UPDATE
  SET tdm.group_id = sq.group_id, tdm.year = sq.year, tdm.city = sq.city
WHEN NOT MATCHED THEN
  INSERT (tour_id, group_id, year, city)
  VALUES (
    sq.tour_id, sq.group_id, sq.year, sq.city);

-- DROP TABLE #demo_merge;
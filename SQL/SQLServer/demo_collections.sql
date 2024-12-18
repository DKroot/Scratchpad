DECLARE @list TABLE (
  tour_id INT,
  group_id INT,
  year INT,
  city VARCHAR(MAX)
);

-- Table population #1 with a simple inline values
INSERT INTO @list
SELECT *
-- INTO @list -- Error: this doesn't work for TABLE variables
FROM (
  VALUES --
    (1, 1, 2001, 'San Francisco'),
    (2, 1, 2009, 'Chicago'),
    (3, 1, 2009, 'New Orleans'),
    (4, 2, 2006, 'Washington'),
    (5, 2, 2007, 'New York'),
    (6, 3, 2008, 'Seattle')
) AS sample_data(tour_id, group_id, year, city);

PRINT 'Collection'
SELECT tour_id, group_id, year, city
FROM @list;

SELECT count(tour_id) AS count_no_recs
FROM @list
WHERE city = 'Odesa';
-- 0

SELECT sum(tour_id) AS sum_no_recs
FROM @list
WHERE city = 'Odesa';
-- NULL
GO

-- Generates tours per each group as a full join between 2 inline entities
PRINT 'Reprocessing collection'
SELECT tours.tour_id, groups.group_id, tours.year, tours.city
FROM (
  VALUES --
    (1),
    (2),
    (3)
) AS groups(group_id),
  (
    VALUES --
      (1, 2001, 'San Francisco'),
      (2, 2009, 'Chicago'),
      (3, 2009, 'New Orleans'),
      (4, 2006, 'Washington'),
      (5, 2007, 'New York'),
      (6, 2008, 'Seattle')
  ) AS tours(tour_id, year, city);

-- Generate a range of numbers
WITH range AS (
  SELECT 1 AS num
  UNION ALL
  SELECT num + 1
  FROM range
  WHERE num < 42 -- inclusive upper range boundary
)
SELECT num
FROM range;
--OPTION (MAXRECURSION 0); -- For upper boundaries > 100

-- SQL Server 2022+: `generate_series(1, 100)`
-- `sum()` yields NULL on no rows
SELECT sum(tour_budget) AS total_budget
FROM (
  VALUES
    (1000, 1, 2001, 'San Francisco'),
    (2000, 1, 2009, 'Chicago'),
    (3000, 1, 1999, NULL),
    (4000, 2, 2006, 'Washington'),
    (5000, 2, 1998, NULL),
    (6000, 3, 2008, 'Seattle')
) AS sample_data(tour_budget, group_id, year, city)
WHERE group_id = 0;


SELECT group_id, cast(iif(city IS NULL, 0, 1) AS BIT) known_cities, max(year) latest_year
FROM (
  VALUES
    (1, 1, 2001, 'San Francisco'),
    (2, 1, 2009, 'Chicago'),
    (3, 1, 1999, NULL),
    (4, 2, 2006, 'Washington'),
    (5, 2, 1998, NULL),
    (6, 3, 2008, 'Seattle')
) AS sample_data(tour_id, group_id, year, city)
GROUP BY group_id, iif(city IS NULL, 0, 1);

-- String aggregation prior to MS SQL 2017
WITH sample_data AS (
  SELECT *
  FROM (
    VALUES --
      (1, 1, 2001, 'San Francisco'),
      (2, 1, 2009, 'Chicago'),
      (3, 1, 2009, 'New Orleans'),
      (4, 2, 2006, 'Washington'),
      (5, 2, 2007, 'New York'),
      (6, 3, 2008, 'Seattle')
  ) AS t(tour_id, group_id, year, city)
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


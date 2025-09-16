-- 3 latest years
SELECT DISTINCT TOP 3 year
FROM (
  VALUES --
    (1, 1, 2001, 'San Francisco'),
    (2, 1, 2009, 'Chicago'),
    (3, 1, 2009, 'New Orleans'),
    (4, 2, 2006, 'Washington'),
    (5, 2, 2007, 'New York'),
    (6, 3, 2008, 'Seattle')
) AS sample_data(tour_id, group_id, year, city)
ORDER BY year DESC;

-- 2nd latest year
SELECT TOP 1 year
FROM (
  SELECT DISTINCT TOP 2 year
  FROM (
    VALUES --
      (1, 1, 2001, 'San Francisco'),
      (2, 1, 2009, 'Chicago'),
      (3, 1, 2009, 'New Orleans'),
      (4, 2, 2006, 'Washington'),
      (5, 2, 2007, 'New York'),
      (6, 3, 2008, 'Seattle')
  ) AS sample_data(tour_id, group_id, year, city)
  ORDER BY year DESC
) top_2_years
ORDER BY year;

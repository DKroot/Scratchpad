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

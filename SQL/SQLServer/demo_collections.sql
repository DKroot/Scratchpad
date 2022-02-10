DECLARE @list TABLE (
  tour_id INT,
  group_id INT,
  year INT,
  city VARCHAR(MAX)
)

INSERT INTO @list
SELECT *
FROM(
  VALUES --
    (1, 1, 2001, 'San Francisco'),
    (2, 1, 2009, 'Chicago'),
    (3, 1, 2009, 'New Orleans'),
    (4, 2, 2006, 'Washington'),
    (5, 2, 2007, 'New York'),
    (6, 3, 2008, 'Seattle')
) AS sample_data(tour_id, group_id, year, city);

PRINT 'Processing collection'
-- Processing collection
SELECT *
FROM @list;
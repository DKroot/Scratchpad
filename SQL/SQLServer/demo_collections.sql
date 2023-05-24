
DECLARE @list TABLE (
  tour_id INT,
  group_id INT,
  year INT,
  city VARCHAR(MAX)
)

-- Simple inline collection as an entity
INSERT INTO @list
SELECT *
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
SELECT *
FROM @list;

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
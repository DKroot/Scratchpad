:ON ERROR EXIT
-- JetBrains IDEs: start execution from here

SELECT *
INTO #demo_cursors
FROM (
  VALUES --
    (1, 1, 2001, 'San Francisco'),
    (2, 1, 2009, 'Chicago'),
    (3, 1, 2009, 'New Orleans'),
    (4, 2, 2006, 'Washington'),
    (5, 2, 2007, 'New York'),
    (6, 3, 2008, 'Seattle')
) AS sample_data(tour_id, group_id, year, city);

UPDATE #demo_cursors
SET year = 2022
WHERE group_id = 2;

UPDATE #demo_cursors
SET year = 2023
FROM #demo_cursors
WHERE group_id = 2;

SELECT *
FROM #demo_cursors dc;
:ON ERROR EXIT

/*
Last tour years per a city pivoted.
Rows are grouped by the `FOR` column, having values enumerated in the `IN ()` clause, and produce data columns.
3 data columns are produced here: a column for Seattle is skipped (not produced).
Note: Unused source columns will wreck the aggregation.
*/
SELECT 'Last Tour Year' AS legend, "San Francisco", "New York", "New Orleans"
INTO ##demo_pivot
FROM (
  -- A subquery is necessary here; otherwise, unused source columns will wreck the aggregation
  SELECT year, city
  FROM (
    VALUES--
      (1, 1, 2001, 'San Francisco'),
      (2, 1, 2008, 'New York'),
      (3, 1, 2009, 'New Orleans'),
      (4, 2, 2006, 'San Francisco'),
      (5, 2, 2007, 'New York'),
      (6, 3, 2008, 'Seattle')
  ) AS sample_data(tour_id, group_id, year, city)
) sq--
  PIVOT (max(year) FOR city IN ("San Francisco", "New York", "New Orleans")) AS t -- Alias is required
;

SELECT *
FROM ##demo_pivot;
/*
legend          San Francisco	New York  New Orleans
Last Tour Year	2006	        2008	    2009
*/

/*
Mixed pivot with the same # of rows without aggregation.
Aggregation is trivialized to one row by the presence of non-pivoted columns.
*/
SELECT tour_id /* non-pivoted */, group_id /* non-pivoted */, "San Francisco" AS year_in_san_francisco,
  "New York" AS year_in_new_york, "New Orleans" AS year_in_new_orleans, "Seattle" AS year_in_seattle
FROM (
  VALUES--
    (1, 1, 2001, 'San Francisco'),
    (2, 1, 2008, 'New York'),
    (3, 1, 2009, 'New Orleans'),
    (4, 2, 2006, 'San Francisco'),
    (5, 2, 2007, 'New York'),
    (6, 3, 2008, 'Seattle')
) AS sample_data(tour_id, group_id, year, city)--
  PIVOT (sum(year) -- Any aggregation function can be used for trivial (one-row) aggregation
  FOR city IN ("San Francisco", "New York", "New Orleans", "Seattle")) AS t;
/*
tour_id	group_id	year_in_san_francisco	year_in_new_york	year_in_new_orleans	year_in_seattle
1	      1	        2001
2	      1		                            2008
3	      1			                                            2009
4	      2	        2006
5	      2		                            2007
6	      3				                                                              2008
*/

/*
Unpivot.
Columns enumerated in the `IN ()` clause produce rows (2 rows are produced here) and values in the new (`FOR`) column.
A row for New Orleans is skipped (not produced).
*/
SELECT c AS city, y AS last_tour_year
FROM ##demo_pivot UNPIVOT ( y FOR c IN ("San Francisco", "New York") ) AS t -- Alias is required
;
/*
city          last_tour_year
San Francisco	2006
New York	    2008
*/

DROP TABLE ##demo_pivot;
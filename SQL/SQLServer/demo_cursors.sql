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
GO

/*
LOCAL: the scope of the cursor is local to the batch, SP or trigger. The cursor is implicitly deallocated when the
batch, SP, or trigger terminates, unless the cursor was passed back in an OUTPUT parameter, in which case the cursor is
deallocated with the last variable referencing it.
*/
DECLARE tmp_demo_cur1 CURSOR LOCAL STATIC FORWARD_ONLY READ_ONLY FOR --
  SELECT tour_id, group_id, year, city
  FROM #demo_cursors;
DECLARE @tour_id INT, @group_id INT, @year INT, @city NVARCHAR(255);
OPEN tmp_demo_cur1;
PRINT '## Resultset 1 ##';
WHILE 1 = 1 BEGIN
  FETCH NEXT FROM tmp_demo_cur1 INTO @tour_id, @group_id, @year, @city;
  IF @@fetch_status <> 0
    BREAK;
  PRINT concat_ws(', ', @tour_id, @group_id, @year, @city);
END
CLOSE tmp_demo_cur1;

DECLARE tmp_demo_cur2 CURSOR LOCAL STATIC FORWARD_ONLY READ_ONLY FOR --
  SELECT tour_id, group_id, year, city
  FROM #demo_cursors;
-- DECLARE @tour_id INT, @group_id INT, @year INT, @city NVARCHAR(255)
OPEN tmp_demo_cur2;
PRINT '## Resultset 2 ##';
WHILE 1 = 1 BEGIN
  FETCH NEXT FROM tmp_demo_cur2 INTO @tour_id, @group_id, @year, @city;
  IF @@fetch_status <> 0
    BREAK;
  PRINT concat_ws(', ', @tour_id, @group_id, @year, @city);
END
CLOSE tmp_demo_cur2;
-- DEALLOCATE tmp_demo_cur2

-- Reopening cursor
OPEN tmp_demo_cur2; -- Fails if deallocated
PRINT '## Resultset 3 ##';
WHILE 1 = 1 BEGIN
  FETCH NEXT FROM tmp_demo_cur2 INTO @tour_id, @group_id, @year, @city;
  IF @@fetch_status <> 0
    BREAK;
  PRINT concat_ws(', ', @tour_id, @group_id, @year, @city);
END
CLOSE tmp_demo_cur2;
DEALLOCATE tmp_demo_cur2;
GO
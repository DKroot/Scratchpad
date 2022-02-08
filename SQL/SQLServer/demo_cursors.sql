:ON ERROR EXIT
-- JetBrains IDEs: start execution from here

WITH sample_data AS (
  SELECT 1 AS tour_id, 1 AS group_id, 2001 AS year, 'San Francisco' AS city
  UNION ALL
  SELECT 2 AS tour_id, 1 AS group_id, 2009 AS year, 'Chicago' AS city
  UNION ALL
  SELECT 3 AS tour_id, 1 AS group_id, 2009 AS year, 'New Orleans' AS city
  UNION ALL
  SELECT 4 AS tour_id, 2 AS group_id, 2006 AS year, 'Washington' AS city
  UNION ALL
  SELECT 5 AS tour_id, 2 AS group_id, 2007 AS year, 'New York' AS city
  UNION ALL
  SELECT 6 AS tour_id, 3 AS group_id, 2008 AS year, 'Seattle' AS city
)
SELECT *
INTO #demo_cursors -- new table created
FROM sample_data
GO

/*
LOCAL: the scope of the cursor is local to the batch, SP or trigger. The cursor is implicitly deallocated when the
batch, SP, or trigger terminates, unless the cursor was passed back in an OUTPUT parameter, in which case the cursor is
deallocated with the last variable referencing it.
*/
DECLARE tmp_demo_cur1 CURSOR LOCAL STATIC FORWARD_ONLY READ_ONLY FOR --
  SELECT tour_id, group_id, year, city
  FROM #demo_cursors
DECLARE @tour_id INT, @group_id INT, @year INT, @city NVARCHAR(255)
OPEN tmp_demo_cur1
PRINT '## Resultset 1 ##'
WHILE 1 = 1 BEGIN
  FETCH NEXT FROM tmp_demo_cur1 INTO @tour_id, @group_id, @year, @city
  IF @@fetch_status <> 0
    BREAK
  PRINT concat_ws(', ', @tour_id, @group_id, @year, @city)
END
CLOSE tmp_demo_cur1

DECLARE tmp_demo_cur2 CURSOR LOCAL STATIC FORWARD_ONLY READ_ONLY FOR --
  SELECT tour_id, group_id, year, city
  FROM #demo_cursors
-- DECLARE @tour_id INT, @group_id INT, @year INT, @city NVARCHAR(255)
OPEN tmp_demo_cur2
PRINT '## Resultset 2 ##'
WHILE 1 = 1 BEGIN
  FETCH NEXT FROM tmp_demo_cur2 INTO @tour_id, @group_id, @year, @city
  IF @@fetch_status <> 0
    BREAK
  PRINT concat_ws(', ', @tour_id, @group_id, @year, @city)
END
CLOSE tmp_demo_cur2
-- DEALLOCATE tmp_demo_cur2

-- Reopening cursor
OPEN tmp_demo_cur2 -- Fails if deallocated
PRINT '## Resultset 3 ##'
WHILE 1 = 1 BEGIN
  FETCH NEXT FROM tmp_demo_cur2 INTO @tour_id, @group_id, @year, @city
  IF @@fetch_status <> 0
    BREAK
  PRINT concat_ws(', ', @tour_id, @group_id, @year, @city)
END
CLOSE tmp_demo_cur2
DEALLOCATE tmp_demo_cur2
GO
:ON ERROR EXIT

/*
Batch comment
*/

CREATE OR ALTER PROCEDURE tmp_error AS --
  SET XACT_ABORT, NOCOUNT ON;
BEGIN
  PRINT 'tmp_error';

  /*
  This errors out.
  * The line number gets reported in SSMS *correctly* if the entire batch is selected for execution.
  * The line number is not reported in JetBrains IDEs.
  */
  SELECT 1 / 0;
END;
GO

EXEC tmp_error;
GO

CREATE OR ALTER PROCEDURE tmp_error_lineno AS --
-- `LINENO` fixes line # error reporting for middle-of-file batches. Keep it matching the actual file line #.
-- noinspection SqlResolve
--@formatter:off
  LINENO 28;
--@formatter:on
  SET XACT_ABORT, NOCOUNT ON;
BEGIN
  DECLARE @foo INT;

  -- Generate a divide-by-zero error.
  SET @foo = 1 / 0;
  -- SSMS reports the line number correctly in the error
  -- IDEA as of 2023.1 doesn't reports line number in the error

  PRINT @foo;
END;
GO

EXEC tmp_error_lineno;
GO

DROP PROCEDURE IF EXISTS tmp_error_lineno;
GO

-- region tmp_demo_errors
CREATE OR ALTER PROCEDURE tmp_demo_errors AS --
--@formatter:off
-- `LINENO` fixes line # error reporting for middle-of-file batches. Keep it matching the actual file line #.
-- noinspection SqlResolve
  LINENO 54;
--@formatter:on
  SET XACT_ABORT, NOCOUNT ON;
BEGIN TRY
  SELECT 1 / 0;
END TRY BEGIN CATCH
  IF @@trancount > 0
    ROLLBACK TRANSACTION;

  DECLARE @err_msg NVARCHAR(4000) = error_message(), @err_state TINYINT = error_state(), @errno INT = error_number(),--
    @proc SYSNAME = error_procedure(), @lineno INT = error_line(),
    /* arbitrary error code >= 50000 */ @CUSTOM_ERROR INT = 63372;
  IF @err_msg NOT LIKE '**%'
    SET @err_msg =
        concat('** ERROR #', @errno, ' at ', coalesce(@proc + '()', '<dynamic SQL>'), ':', @lineno, ' ** ', @err_msg);
    --@formatter:off
    ;THROW @CUSTOM_ERROR, @err_msg, @err_state;
  --@formatter:on
END CATCH;
GO

EXEC tmp_demo_errors;
GO

DROP PROCEDURE IF EXISTS tmp_demo_errors;
GO
-- endregion

CREATE OR ALTER PROCEDURE tmp_plus1_in_out(
  @arg INT = 21, @result INT OUT
) AS --
--@formatter:off
-- `LINENO` fixes line # error reporting for middle-of-file batches. Keep it matching the actual file line #.
-- noinspection SqlResolve
  LINENO 88;
--@formatter:on
/**
Does something.
*/
  SET XACT_ABORT, NOCOUNT ON;
BEGIN TRY
  PRINT concat('tmp_plus1_in_out start: @result = ', coalesce(cast(@result AS VARCHAR), 'NULL'));
  -- NULL

  SET @result = iif(@arg = 42, @arg + 1, @arg - 1)
  PRINT concat('tmp_plus1_in_out end: @result = ', coalesce(cast(@result AS VARCHAR), 'NULL'));
END TRY BEGIN CATCH
  IF @@trancount > 0
    ROLLBACK TRANSACTION;

  DECLARE @err_msg NVARCHAR(4000) = error_message(), @err_state TINYINT = error_state(),--
    @err_num INT = error_number(), @proc SYSNAME = error_procedure(), @lineno INT = error_line(),
    /* arbitrary error code >= 50000 */ @custom_error_num INT = 63372;
  IF @err_msg NOT LIKE '**%'
    SET @err_msg =
        concat('**ERROR #', @err_num, ' at ', coalesce(@proc + '()', '<dynamic SQL>'), ':', @lineno, '** ', @err_msg);
    --@formatter:off
  ;THROW @custom_error_num, @err_msg, @err_state;
  --@formatter:on
END CATCH;
GO

DECLARE @res INT;
PRINT 'Executing...';

EXEC tmp_plus1_in_out 42, @res OUT;
PRINT concat('The result = ', coalesce(cast(@res AS VARCHAR), 'NULL'));

EXEC tmp_plus1_in_out @result = @res OUT;
PRINT concat('The result = ', coalesce(cast(@res AS VARCHAR), 'NULL'));

DROP PROCEDURE IF EXISTS tmp_plus1_in_out;
GO

/*
Attached doc comment: blank line separation doesn't matter. The entire batch DDL is stored.
*/

CREATE OR ALTER PROCEDURE tmp_plus2_in_out(
  @arg INT, @res INT OUT
) AS --
--@formatter:off
-- `LINENO` fixes line # error reporting for middle-of-file batches. Keep it matching the actual file line #.
-- noinspection SqlResolve
  LINENO 120;
--@formatter:on
  SET XACT_ABORT, NOCOUNT ON;

  SET @res = @arg + 1;
  SET @res = @res + 1;
GO

DROP PROCEDURE IF EXISTS tmp_plus2_in_out;
GO

CREATE OR ALTER PROCEDURE tmp_demo(
  @arg INT
) AS --
--@formatter:off
-- `LINENO` fixes line # error reporting for middle-of-file batches. Keep it matching the actual file line #.
-- noinspection SqlResolve
  LINENO 137;
--@formatter:on
  SET XACT_ABORT, NOCOUNT ON;
BEGIN
  SELECT 'Demo' AS a_string, @arg + 1 AS an_int, cast(1 AS BIT) AS a_boolean,
    cast('2007-05-08 12:35:29.123' AS DATETIME) AS a_date_time;
END
GO

EXEC tmp_demo 42;
GO

DROP PROCEDURE IF EXISTS tmp_demo;
GO

--@formatter:off
CREATE OR ALTER PROCEDURE tmp_demo_args(
  @aString VARCHAR(100) = 'Demo', -- Returns doubled argument
  @anInt INT = 42, -- Returns argument + 1
  @aBooleanBit BIT = 1, -- Returns NOT argument
  @aBooleanInt INT = 1, -- Returns NOT argument
  @aBooleanChar CHAR = 'Y', -- Returns argument
  @aBooleanVarchar VARCHAR(100) = '1', -- Returns argument. VARCHAR(MAX) does not work here.
  @aDateTime DATETIME = '2007-05-08 12:35:29.123' -- Returns argument
) AS --
--@formatter:off
-- `LINENO` fixes line # error reporting for middle-of-file batches. Keep it matching the actual file line #.
-- noinspection SqlResolve
  LINENO 165;
--@formatter:on
  SET XACT_ABORT, NOCOUNT ON;
BEGIN
  SELECT
    'tmp_demo_args' AS logger, @aString + ',' + @aString AS db_string, @anInt + 1 AS db_int,
    ~@aBooleanBit AS boolean_db_bit, -- 1 = true, 0 = false
    @aBooleanInt - 1 AS boolean_db_int, -- <> 0 = true, 0 = false
    @aBooleanChar AS boolean_db_char, -- 'Y'/'y' = true, else = false
    @aBooleanVarchar AS boolean_db_varchar, -- '1' = true, else = false
    @aDateTime AS db_date_time;
END;
--@formatter:on
GO

EXEC tmp_demo_args;
GO

DROP PROCEDURE IF EXISTS tmp_demo_args;
GO

--region demo_table_args: execute from here
CREATE TYPE TMP_SAMPLE_DATA_TYPE AS TABLE (
  tour_id INT,
  group_id INT,
  year INT,
  city VARCHAR(MAX)
);
GO

/*
Table-valued parameters must be passed as input READONLY parameters to Transact-SQL routines. You cannot perform DML
operations such as UPDATE, DELETE, or INSERT on a table-valued parameter in the body of a routine.

You cannot use a table-valued parameter as target of a SELECT INTO or INSERT EXEC statement. A table-valued parameter
can be in the FROM clause of SELECT INTO or in the INSERT EXEC string or stored procedure.
*/
CREATE OR ALTER PROCEDURE tmp_demo_table_args(
  @foo TMP_SAMPLE_DATA_TYPE READONLY
) AS --
--@formatter:off
-- `LINENO` fixes line # error reporting for middle-of-file batches. Keep it matching the actual file line #.
-- noinspection SqlResolve
  LINENO 208;
--@formatter:on
  SET XACT_ABORT, NOCOUNT ON;
BEGIN
  SELECT 'All records' AS "See next =>";
  SELECT *
  FROM @foo;

  SELECT 'Grouped by group_id' AS "See next =>";
  SELECT group_id, max(tour_id) AS last_tour, max(year) AS last_year
  FROM @foo
  GROUP BY group_id;
END;
GO

DECLARE @t TMP_SAMPLE_DATA_TYPE;

INSERT INTO @t(tour_id, group_id, year, city)
SELECT tour_id, group_id, year, city
FROM (
  VALUES --
    (1, 1, 2001, 'San Francisco'),
    (2, 1, 2009, 'Chicago'),
    (3, 1, 2009, 'New Orleans'),
    (4, 2, 2006, 'Washington'),
    (5, 2, 2007, 'New York'),
    (6, 3, 2008, 'Seattle')
) AS sample_data(tour_id, group_id, year, city);

EXEC tmp_demo_table_args @t;
GO

DROP PROCEDURE IF EXISTS tmp_demo_table_args;
DROP TYPE IF EXISTS TMP_SAMPLE_DATA_TYPE;
GO
--endregion
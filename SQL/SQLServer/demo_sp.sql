CREATE OR ALTER PROCEDURE tmp_plus1_in_out(
  @arg INT, @res INT OUT
) AS
BEGIN
  SET @res = @arg + 1;
END;
GO

DECLARE @res INT;
PRINT 'Executing...';;
EXEC tmp_plus1_in_out 42, @res OUT;
PRINT concat('The result = ', @res);
GO

DROP PROCEDURE tmp_plus1_in_out;
GO

CREATE OR ALTER PROCEDURE tmp_plus2_in_out(
  @arg INT, @res INT OUT
) AS
  SET @res = @arg + 1;
  SET @res = @res + 1;
GO

DROP PROCEDURE tmp_plus2_in_out;
GO

CREATE OR ALTER PROCEDURE tmp_demo(
  @arg INT
) AS
BEGIN
  SELECT
    'Demo' AS a_string, @arg + 1 AS an_int, cast(1 AS BIT) AS a_boolean,
    cast('2007-05-08 12:35:29.123' AS DATETIME) AS a_date_time;
END
GO

EXEC tmp_demo 42;
GO

DROP PROCEDURE tmp_demo;
GO

CREATE OR ALTER PROCEDURE tmp_demo_args
  @astring VARCHAR(100) = 'Demo', -- Returns doubled argument
  @anint INT = 42, -- Returns argument + 1
  @abooleanbit BIT = 1, -- Returns NOT argument
  @abooleanint INT = 1, -- Returns NOT argument
  @abooleanchar CHAR = 'Y', -- Returns argument
  @abooleanvarchar VARCHAR(100) = '1', -- Returns argument. VARCHAR(MAX) does not work here.
  @adatetime DATETIME = '2007-05-08 12:35:29.123' -- Returns argument
AS
BEGIN
  SELECT
    @astring + ',' + @astring AS db_string, @anint + 1 AS db_int,
    ~@abooleanbit AS boolean_db_bit, -- 1 = true, 0 = false
    @abooleanint - 1 AS boolean_db_int, -- <> 0 = true, 0 = false
    @abooleanchar AS boolean_db_char, -- 'Y'/'y' = true, else = false
    @abooleanvarchar AS boolean_db_varchar, -- '1' = true, else = false
    @adatetime AS db_date_time;
--     DATEADD(d, -1, @aDateTime) AS db_date_time;
END;
GO

EXEC tmp_demo_args;
GO

DROP PROCEDURE tmp_demo_args;
GO

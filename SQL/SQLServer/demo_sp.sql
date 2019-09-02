IF OBJECT_ID ( 'tmp_plus1inout', 'P' ) IS NOT NULL
  DROP PROCEDURE tmp_plus1inout;
GO

CREATE PROCEDURE tmp_plus1inout
  @arg INT,
  @res INT OUT
AS
BEGIN
  SELECT @res = @arg + 1;
END;
GO

DECLARE @res INT;
PRINT 'Executing...';
EXEC tmp_plus1inout 42, @res OUT;
PRINT CONCAT('The result = ', @res);
GO

IF OBJECT_ID ( 'tmp_demo', 'P' ) IS NOT NULL
  DROP PROCEDURE tmp_demo;
GO

CREATE PROCEDURE tmp_demo (@arg INT)
AS
BEGIN
  SELECT 'Demo' AS a_string, @arg + 1 AS an_int, CAST(1 AS BIT) AS a_boolean,
    CAST('2007-05-08 12:35:29.123' AS DATETIME) AS a_date_time;
END;
GO

EXEC tmp_demo 42;
GO

IF OBJECT_ID ( 'tmp_demo_args', 'P' ) IS NOT NULL
  DROP PROCEDURE tmp_demo_args;
GO

CREATE PROCEDURE tmp_demo_args
  @aString VARCHAR(100) = 'Demo', -- Returns doubled argument
  @anInt INT = 42, -- Returns argument + 1
  @aBooleanBit BIT = 1, -- Returns NOT argument
  @aBooleanInt INT = 1, -- Returns NOT argument
  @aBooleanChar CHAR = 'Y', -- Returns argument
  @aBooleanVarchar VARCHAR(100) = '1', -- Returns argument. VARCHAR(MAX) does not work here.
  @aDateTime DATETIME = '2007-05-08 12:35:29.123' -- Returns argument
AS
BEGIN
  SELECT 
    @aString + ',' + @aString AS db_string,
    @anInt + 1 AS db_int,
    ~@aBooleanBit AS boolean_db_bit, -- 1 = true, 0 = false
    @aBooleanInt - 1 AS boolean_db_int, -- <> 0 = true, 0 = false
    @aBooleanChar AS boolean_db_char, -- 'Y'/'y' = true, else = false
    @aBooleanVarchar AS boolean_db_varchar, -- '1' = true, else = false
    @aDateTime AS db_date_time;
--     DATEADD(d, -1, @aDateTime) AS db_date_time;
END;
GO

EXEC tmp_demo_args;
GO

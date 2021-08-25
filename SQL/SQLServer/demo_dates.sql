-- Now
SELECT current_timestamp;

-- Now
SELECT getdate();

-- Truncate to current date
SELECT cast(getdate() AS DATE);

-- Yesterday date/time
SELECT getdate() - 1;

-- Yesterday date
-- Operand type clash: date is incompatible with int
-- SELECT cast(getdate() AS DATE) - 1;

-- Tomorrow
SELECT getdate() + 1;

-- BETWEEN
SELECT 1 AS bit
WHERE getdate() BETWEEN getdate() - 1 AND getdate() + 1;

-- Literals
DECLARE @foo DATE = '2021-08-01', @bar DATETIME = '2021-08-01', @baz DATETIME = '2021-08-01T21:15:42';
SELECT @foo, @bar, @baz;
GO
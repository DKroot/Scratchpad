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
SELECT cast('1969-07-09' AS DATE);
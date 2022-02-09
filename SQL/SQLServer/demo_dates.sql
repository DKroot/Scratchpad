-- Now
PRINT current_timestamp;

-- Now
PRINT getdate();

-- Truncate to current date
PRINT cast(getdate() AS DATE);

-- Yesterday (date/time)
PRINT getdate() - 1;

-- Tomorrow
PRINT getdate() + 1;

-- Yesterday (date)
PRINT cast(getdate() - 1 AS DATE);
-- Can only subtract from DATETIME
-- SELECT cast(getdate() AS DATE) - 1;

-- BETWEEN
SELECT 1 AS bit
WHERE getdate() BETWEEN getdate() - 1 AND getdate() + 1;

-- Literals and difference
DECLARE @foo DATE = '2021-08-01', @bar DATETIME = '2021-08-02T21:00:42', @baz DATETIME = '2021-08-02T21:15:42';
PRINT concat_ws(', ', @foo, @bar, @baz);
PRINT concat_ws(' ', 'DATETIME - DATE =', datediff(DAY, @foo, @bar), 'day');
GO

-- Format seconds as hh:mm:ss
PRINT '90 seconds = ' + convert(varchar(10), dateadd(second, 90, 0), 108) + ' hh:mm:ss';
PRINT '3600 seconds = ' + convert(varchar(10), dateadd(second, 3600, 0), 108) + ' hh:mm:ss';
PRINT '12 hours + 1 second = ' + convert(varchar(10), dateadd(second, 12*3600 + 1, 0), 108) + ' hh:mm:ss';
-- Overflows on 24 hours
PRINT '24 hours = ' + convert(varchar(10), dateadd(second, 24*3600, 0), 108) + ' hh:mm:ss';
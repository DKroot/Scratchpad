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

-- Date/time in the last 24 hours?
SELECT cast(1 AS BIT) AS last_day
WHERE getdate() > getdate() - 1;

-- Date/time is in +/- 24 hours?
SELECT cast(1 AS BIT) AS plus_minus_day
WHERE getdate() BETWEEN getdate() - 1 AND getdate() + 1;

-- noinspection SqlRedundantCodeInCoalesce
SELECT cast(1 AS BIT) AS plus_minus_day
WHERE getdate() BETWEEN getdate() - 1 AND coalesce(NULL, getdate() + 1);

-- Literals and difference
DECLARE @foo DATE = '2021-08-01', @bar DATETIME = '2021-08-02T21:00:42', @baz DATETIME = '2021-08-02T21:15:42';
PRINT concat_ws(', ', @foo, @bar, @baz);
PRINT concat_ws(' ', 'DATETIME - DATE =', datediff(DAY, @foo, @bar), 'day');
GO

-- Format seconds as hh:mm:ss
PRINT '90 seconds = ' + convert(CHAR(8), dateadd(SECOND, 90, 0), 108) + ' hh:mm:ss';
PRINT '3600 seconds = ' + convert(CHAR(8), dateadd(SECOND, 3600, 0), 108) + ' hh:mm:ss';
PRINT '23 hours + 1 second = ' + convert(CHAR(8), dateadd(SECOND, 23 * 3600 + 1, 0), 108) + ' hh:mm:ss';

-- WARNING Overflows on 24 hours!
PRINT 'WARNING Overflows on 24 hours! 24 hours = ' + convert(VARCHAR(10), dateadd(SECOND, 24 * 3600, 0), 108)
    + ' hh:mm:ss';
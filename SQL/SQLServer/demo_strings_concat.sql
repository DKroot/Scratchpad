DECLARE @s VARCHAR(100);
PRINT 'CONCAT_NULL_YIELDS_NULL=' + iif(((4096 & @@options) = 4096), 'on', 'off');

SET CONCAT_NULL_YIELDS_NULL ON;
PRINT 'CONCAT_NULL_YIELDS_NULL=' + iif(((4096 & @@options) = 4096), 'on', 'off');
PRINT '---';
PRINT 'Concatenation (+) eaten by a NULL?' + @s; -- Produces warning
PRINT 'String:';
PRINT @s;
PRINT '---';

SET CONCAT_NULL_YIELDS_NULL OFF;
PRINT 'CONCAT_NULL_YIELDS_NULL=' + iif(((4096 & @@options) = 4096), 'on', 'off');
PRINT '---';
PRINT 'Eaten: NULL concatenates to NULL' + @s; -- Produces warning
PRINT 'String:';
PRINT @s;
PRINT '---';
GO

DECLARE @result VARCHAR(50);

PRINT 'Result=' + coalesce(@result, 'NULL'); -- Produces warning
GO

DECLARE @result VARCHAR(50);
SET CONCAT_NULL_YIELDS_NULL ON;
PRINT 'CONCAT_NULL_YIELDS_NULL=' + iif(((4096 & @@options) = 4096), 'on', 'off');
PRINT concat('concat() result=', @result);

SET CONCAT_NULL_YIELDS_NULL OFF;
PRINT 'CONCAT_NULL_YIELDS_NULL=' + iif(((4096 & @@options) = 4096), 'on', 'off');
PRINT concat('concat() result=', @result);
GO

PRINT concat('concat() skips NULLs safely', ':', NULL, 42);

PRINT concat_ws(', ', NULL, 'item1', 'item2');
-- `item1, item2`

PRINT concat_ws(', ', '', 'item1', 'item2');
-- `, item1, item2`

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
PRINT concat('concat() with NULL=`', @result, '`');

SET CONCAT_NULL_YIELDS_NULL OFF;
PRINT 'CONCAT_NULL_YIELDS_NULL=' + iif(((4096 & @@options) = 4096), 'on', 'off');
PRINT concat('concat() with NULL=`', @result, '`');
GO

DECLARE @int INT = 42;
-- ERROR: concat() or a cast is required
-- PRINT 'Concatenating with an int: ' + @int;
PRINT concat('Concatenating with an int: ', @int);

DECLARE @float FLOAT = 1.5;
-- ERROR: concat() or a cast is required
--PRINT 'Concatenating with a float: ' + @float;
PRINT concat('Concatenating with a float: ', @float);
PRINT 'Concatenating with a float: ' + cast(@float AS VARCHAR);
PRINT 'Concatenating with a float: ' + convert(VARCHAR(15), @float);
GO
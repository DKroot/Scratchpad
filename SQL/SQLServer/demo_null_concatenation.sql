DECLARE @s varchar(100);
PRINT '1';
PRINT '2';
PRINT '3';
GO

DECLARE @s varchar(100);
PRINT 'Eaten: NULL concatenates to NULL' + @s; -- Produces warning
PRINT 'String:';
PRINT @s;
GO

DECLARE @result varchar(50);
PRINT 'Result=' + COALESCE(@result, 'NULL'); -- Produces warning
GO

DECLARE @result varchar(50);
PRINT CONCAT('Result=', @result);
GO

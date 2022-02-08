DECLARE @s VARCHAR(100)
PRINT '1'
PRINT '2'
PRINT '3'
GO

DECLARE @s VARCHAR(100)
PRINT 'Eaten: NULL concatenates to NULL' + @s -- Produces warning
PRINT 'String:'
PRINT @s
GO

DECLARE @result VARCHAR(50)

PRINT 'Result=' + coalesce(@result, 'NULL') -- Produces warning
GO

DECLARE @result VARCHAR(50)
PRINT concat('Result=', @result)
GO

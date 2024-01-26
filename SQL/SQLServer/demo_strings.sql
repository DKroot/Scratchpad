DECLARE @foo CHAR(4) = 'F ';
PRINT '@foo=`' + @foo + '`';
PRINT 'CHAR() comparisons disregard trailing spaces? ' + iif(@foo = 'F', 'true', 'false');
GO

--region Collations
DECLARE @foo VARCHAR(MAX) = 'QW', @db_coll NVARCHAR(MAX) = cast(databasepropertyex(db_name(), 'collation') AS NVARCHAR);

-- Literal comparison with DB default collation
PRINT '1. Case-' + iif('QW' = 'qw', 'IN', '') + 'sensitive literal comparison';

PRINT '2. Case-' + iif(@foo = 'qw', 'IN', '') + 'sensitive literal comparison with the DB default ' + @db_coll;

PRINT '3. Case-' + iif(@foo = 'qw' COLLATE sql_latin1_general_cp1_cs_as, 'IN', '') +
      'sensitive literal comparison with the specified sql_latin1_general_cp1_cs_as';
GO

DECLARE @pay_plan CHAR(2);

SELECT @pay_plan = pay_plan_code
FROM dev.indv_info
WHERE indv_ssn_id = '100058314';

-- 'EI'
PRINT 'Case-' + iif(@pay_plan = 'ei', 'IN', '') + 'sensitive data comparison ';
PRINT 'Case-' +
      iif(@pay_plan COLLATE sql_latin1_general_cp1_ci_as = 'ei' COLLATE sql_latin1_general_cp1_ci_as, 'IN', '') +
      'sensitive data comparison with SQL_Latin1_General_CP1_CI_AS';
PRINT 'Case-' +
      iif(@pay_plan COLLATE sql_latin1_general_cp1_cs_as = 'ei' COLLATE sql_latin1_general_cp1_cs_as, 'IN', '') +
      'sensitive data comparison with SQL_Latin1_General_CP1_CS_AS';
GO

-- Case-sensitive LIKE pattern
SELECT s AS acronym
FROM (VALUES --
        ('FOO'),
        ('foo'),
        ('BAR'),
        ('bar')) AS t(s)
WHERE s LIKE '%[ABCDEFGHIJKLMNOPQRSTUVWXYZ]%' COLLATE sql_latin1_general_cp1_cs_as;

-- LIKE pattern ranges are always case-insensitive
SELECT s AS acronym
FROM (VALUES --
        ('FOO'),
        ('foo'),
        ('BAR'),
        ('bar')) AS t(s)
WHERE s LIKE '[A-Z][A-Z][A-Z]' COLLATE sql_latin1_general_cp1_cs_as;
--endregion

-- noinspection SqlRedundantCodeInCoalesce
PRINT coalesce(NULL, '.');
-- `.`

PRINT coalesce('', '.');
-- ``

DECLARE @i INT = NULL;
PRINT coalesce(cast(@i AS VARCHAR), 'NULL');
-- noinspection SqlCaseVsIf
SELECT CASE WHEN @i IS NULL THEN 'NULL' ELSE cast(@i AS VARCHAR) END;
-- noinspection SqlCaseVsIf
--PRINT coalesce(@i, 'NULL');
-- Error
-- PRINT isnull(@i, 'NULL');
-- Error
--SELECT CASE WHEN @i IS NULL THEN 'NULL' ELSE @i END;

PRINT 'foo=' + NULL;
-- ``

--PRINT 'foo' + ':' + 42;
-- Error

PRINT concat('foo', '=', NULL, 42);
-- `foo=42`

PRINT concat_ws('.', NULL, NULL);
-- ``

PRINT concat_ws('.', NULL, '');
-- ``

--region String aggregation: custom functions for SQL Server 2017+
SELECT string_agg(left(value, 1), '')
FROM string_split('BHW Management Information System Solution', ' ');

SELECT string_agg(left(value, 1), '')
FROM string_split(translate('OPAIS/340B Pricing System', '/', ' '), ' ');

SELECT iif(cte.name LIKE '%(%)%',
           substring(cte.name, charindex('(', cte.name) + 1, charindex(')', cte.name) - charindex('(', cte.name) - 1),
           (SELECT string_agg(left(value, 1), '')
            FROM string_split(cte.name, ' '))) AS code
FROM (VALUES --
        ('Electronic Handbooks (EHBs)')) AS cte(name);

SELECT (SELECT string_agg(left(value, 1), '')
        FROM string_split(cte.name, ' ')) AS code
FROM (VALUES --
        ('BHW Management Information System Solution')) AS cte(name);
--endregion
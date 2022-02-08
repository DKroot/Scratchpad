--region Collations

-- DB collation
SELECT databasepropertyex(db_name(), 'collation');
-- `SQL_Latin1_General_CP1_CI_AS`

DECLARE @foo VARCHAR = 'FOO', @pay_plan CHAR(2), --
  @db_collation NVARCHAR(128) = cast(databasepropertyex(db_name(), 'collation') AS NVARCHAR(128));
SELECT 'Case-' + iif(@foo = 'foo', 'IN', '') + 'sensitive literal comparison with ' + @db_collation AS resul1;
SELECT @pay_plan = pay_plan_code
FROM dev.indv_info
WHERE indv_ssn_id = '100058314';
-- 'EI'
SELECT 'Case-' + iif(@pay_plan = 'ei', 'IN', '') + 'sensitive data comparison with ' + @db_collation AS resul2;
SELECT
  'Case-' + iif(@pay_plan COLLATE sql_latin1_general_cp1_ci_as = 'ei', 'IN', '')
      + 'sensitive data comparison with SQL_Latin1_General_CP1_CI_AS' AS resul3;
SELECT
  'Case-' + iif(@pay_plan COLLATE sql_latin1_general_cp1_cs_as = 'ei', 'IN', '')
      + 'sensitive data comparison with SQL_Latin1_General_CP1_CS_AS' AS resul4;
GO

-- LIKE pattern ranges are always case-insensitive
WITH cte AS (
  SELECT *
  FROM (
    VALUES ('FOO'),
      ('foo'),
      ('BAR'),
      ('bar')
  ) AS t(s)
)
SELECT s AS acronym
FROM cte
WHERE s COLLATE sql_latin1_general_cp1_cs_as LIKE '[A-Z][A-Z][A-Z]' COLLATE sql_latin1_general_cp1_cs_as;

-- Case-sensitive LIKE pattern
WITH cte AS (
  SELECT *
  FROM (
    VALUES ('FOO'),
      ('foo'),
      ('BAR'),
      ('bar')
  ) AS t(s)
)
SELECT s AS acronym
FROM cte
WHERE s COLLATE sql_latin1_general_cp1_cs_as LIKE '%[ABCDEFGHIJKLMNOPQRSTUVWXYZ]%';
--endregion

SELECT concat_ws('.', NULL, NULL);
-- ''

SELECT concat_ws('.', NULL, '');
-- ''

--region String aggregation: SQL Server 2017+
SELECT string_agg(left(value, 1), '')
FROM string_split('BHW Management Information System Solution', ' ');

SELECT string_agg(left(value, 1), '')
FROM string_split(translate('OPAIS/340B Pricing System', '/', ' '), ' ');

WITH cte AS (
  SELECT 'Electronic Handbooks (EHBs)' AS name
)
SELECT
  iif(cte.name LIKE '%(%)%',
      substring(cte.name, charindex('(', cte.name) + 1, charindex(')', cte.name) - charindex('(', cte.name) - 1), (
        SELECT string_agg(left(value, 1), '')
        FROM string_split(cte.name, ' ')
      )) AS code
FROM cte;

WITH cte AS (
  SELECT 'BHW Management Information System Solution' AS name
)
SELECT (
  SELECT string_agg(left(value, 1), '')
  FROM string_split(cte.name, ' ')
) AS code
FROM cte;
--endregion
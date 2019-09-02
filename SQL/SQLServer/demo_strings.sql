-- Check that the string is an acronym
  WITH cte AS (
    SELECT *
      FROM
        (
          VALUES
            ('FOO'),
            ('foo'),
            ('BAR'),
            ('bar')
        ) AS t(s)
  )
SELECT s AS acronym
  FROM cte
 WHERE s COLLATE sql_latin1_general_cp1_cs_as NOT LIKE '%[^ABCDEFGHIJKLMNOPQRSTUVWXYZ]%';

SELECT concat_ws('.', NULL, NULL);
-- ''

SELECT concat_ws('.', NULL, '');
-- ''

SELECT string_agg(left(value, 1), '')
  FROM string_split('BHW Management Information System Solution', ' ');

SELECT string_agg(left(value, 1), '')
  FROM string_split(translate('OPAIS/340B Pricing System', '/', ' '), ' ');

  WITH cte AS ( SELECT 'Electronic Handbooks (EHBs)' AS name )
SELECT CASE
         WHEN cte.name LIKE '%(%)%'
           THEN substring(cte.name, charindex('(', cte.name) + 1,
                          charindex(')', cte.name) - charindex('(', cte.name) - 1)
         ELSE ( SELECT string_agg(left(value, 1), '') FROM string_split(cte.name, ' ') )
       END AS code
  FROM cte;

  WITH cte AS ( SELECT 'BHW Management Information System Solution' AS name )
SELECT ( SELECT string_agg(left(value, 1), '') FROM string_split(cte.name, ' ') ) AS code
  FROM cte;
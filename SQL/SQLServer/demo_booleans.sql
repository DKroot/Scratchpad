-- Numeric to BIT: true when <> 0
SELECT cast(one AS BIT) AS "1", cast(zero AS BIT) AS "0", cast(two AS BIT) AS "2", cast(true_upper AS BIT) AS ['TRUE'],
  cast(false_upper AS BIT) AS ['FALSE'], cast(true_lower AS BIT) AS ['true'], cast(true_lower AS BIT) AS ['false']
FROM (VALUES (1, 0, 2, 'TRUE', 'FALSE', 'true', 'false')) AS --
  sample_data(one, zero, two, true_upper, false_upper, true_lower, false_lower)

IF (SELECT 'foo') = 'foo'
  BEGIN
    PRINT 'SELECT ''foo'' = ''foo'''
    PRINT 'true'
  END
ELSE
  PRINT 'false'

IF (SELECT 'foo'
    WHERE 1 = 0) IS NULL
  PRINT 'true'
ELSE
  PRINT 'false'

IF (SELECT 'foo'
    WHERE 1 = 0) IS NULL
  PRINT 'true'
ELSE
  PRINT 'false'

IF exists (SELECT 1
           FROM (VALUES (1, 0, 2)) AS sample_data(one, zero, two)
           WHERE one <> 1)
  PRINT 'true'
ELSE
  PRINT 'false'
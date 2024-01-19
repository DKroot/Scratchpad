-- Numeric to BIT: true when <> 0
SELECT cast(1 AS BIT) AS "1_true", cast(0 AS BIT) AS "0_false", cast(2 AS BIT) AS "2_true";

-- Character to BIT: true when 'TRUE', false when 'false' (case-insensitive); error otherwise
SELECT
  cast('TRUE' AS BIT) AS ['TRUE'_true], cast('FALSE' AS BIT) AS ['FALSE'_false], --
  cast('true' AS BIT) AS ['true'_true], cast('false' AS BIT) AS ['false'_false],
  cast('True' AS BIT) AS ['True'_true];
  -- cast('Y' AS BIT) -- ERROR

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
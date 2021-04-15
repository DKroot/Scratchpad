\set ON_ERROR_STOP on
\set ECHO all

\if :{?schema}
SET search_path = :schema;
\endif

-- JetBrains IDEs: start execution from here
SET TIMEZONE = 'US/Eastern';

SELECT DATE '2014-08-30';

SELECT isfinite(DATE '6-07-05');

-- Interval conversion
SELECT cast('P1Y2M3D' AS INTERVAL);

-- Negative interval conversion
SELECT -cast('P1Y2M3D' AS INTERVAL);
-- Error
-- SELECT CAST('-P1Y2M3D' AS INTERVAL);

SELECT DATE '2014-08-30';
-- Error
-- SELECT DATE '2021-04';

SELECT DATE '2014-08-30' - cast('P3Y' AS INTERVAL);
SELECT DATE '2014-08-30' - cast('P3Y7M' AS INTERVAL);
SELECT DATE '2014-08-30' - cast('P3Y8M10D' AS INTERVAL);

SELECT extract(YEAR FROM DATE '2021-04-01');
SELECT extract(YEAR FROM DATE '2021-04');

SELECT to_number('15', '9999');
SELECT to_number('15', '99');
-- Error
-- SELECT to_number('', '9999');

SELECT make_date(2021, 4, 1);
SELECT
  make_date(cast(left('2021-04-01', 4) AS INT), cast(substr('2021-04-01', 6, 2) AS INT),
            cast(substr('2021-04-01', 9) AS INT));
SELECT
  make_date(cast(left('2021-04', 4) AS INT), cast(substr('2021-04', 6, 2) AS INT),
            cast(coalesce(nullif(substr('2021-04', 9), ''), '15') AS INT));

SELECT
  make_date(cast(left('2021', 4) AS INT), cast(coalesce(nullif(substr('2021', 6, 2), ''), '6') AS INT),
            cast(coalesce(nullif(substr('2021', 9), ''), '15') AS INT));

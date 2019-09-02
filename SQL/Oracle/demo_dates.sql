-- region Date/time (up to seconds) and DB time zone
SELECT sysdate, dbtimezone
FROM dual;

-- region Formatting
-- ISO formatted date/time
SELECT to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS')
FROM dual;

/*
-- Error
SELECT TO_CHAR(SYSDATE, 'pie_YYYY_MM_DD_HH24')
FROM DUAL;
*/

SELECT 'pie_' || to_char(sysdate, 'YYYY_MM_DD_HH24')
FROM dual;

SELECT to_char(sysdate, 'DDHH24')
FROM dual;

SELECT to_char(sysdate, 'DD-MON-YYYY')
FROM dual;

SELECT CAST('01-FEB-2018' AS DATE)
FROM dual;

SELECT to_date(20180201, 'YYYYMMDD')
FROM dual;

SELECT to_date(2018, 'YYYY')
FROM dual;
-- 2018-09-01
-- endregion

-- region Date parts
SELECT extract(DAY FROM sysdate)
FROM dual;

BEGIN
  --
  debug(extract(DAY FROM sysdate));
END;
/
-- endregion

-- region Date arithmetic
WITH
  cte AS (--
    SELECT to_date('1986-01-01', 'YYYY-MM-DD') AS start_date, to_date('1986-01-02', 'YYYY-MM-DD') AS end_date
    FROM dual
  )
SELECT start_date, end_date, end_date - start_date, start_date + 2
FROM cte;
-- endregion

-- region Timestamps
SELECT DBTIMEZONE
FROM dual;

SELECT *
FROM v$timezone_names
WHERE TZABBREV = 'EST';

SELECT *
FROM v$nls_parameters;

-- TIMESTAMP WITH TIME ZONE: Date/time with fractional seconds (precision = 6)
SELECT systimestamp
FROM dual;

-- Timestamp with a time zone shift
SELECT systimestamp AT TIME ZONE 'America/Los_Angeles'
FROM dual;

-- Custom-formatted Timestamp
SELECT to_char(systimestamp AT TIME ZONE 'America/Los_Angeles', 'YYYY-MM-DD HH24:MI:SS.FF1 TZD')
FROM dual;

-- Timezone offset is available, but abbreviation/region are unknown
SELECT
  extract(timezone_offset FROM systimestamp) AS timezone_offset,
  extract(TIMEZONE_ABBR FROM systimestamp) AS timezone_abbr,
  extract(TIMEZONE_REGION FROM systimestamp) AS timezone_region
FROM dual;

-- (IRDBPRD) actual_start_date is rendered with the time zone
-- (IRDBTST) actual_start_date is rendered without the time zone in UTC
SELECT log_id, job_name, actual_start_date, run_duration, log_date
FROM user_scheduler_job_run_details;

-- (IRDBPRD) TIMESTAMP WITH TIME ZONE columns are rendered with the time zone
-- (IRDBTST) TIMESTAMP WITH TIME ZONE columns are rendered without the time zone
SELECT
  job_name,
  status,
  errors,
  actual_start_date + run_duration AS actual_finish,
  actual_start_date AS actual_start,
  req_start_date AS requested_start,
  run_duration,
  binary_output AS serveroutput
FROM user_scheduler_job_run_details
WHERE CURRENT_DATE - actual_start_date < INTERVAL '14' DAY
ORDER BY actual_finish DESC;
-- endregion
SHOW TIMEZONE;

DROP TABLE IF EXISTS tmp_demo_times;

CREATE TABLE IF NOT EXISTS tmp_demo_times (
  record_id SERIAL PRIMARY KEY,
  col VARCHAR,
  record_date TIMESTAMP WITH TIME ZONE DEFAULT now()
);

INSERT INTO tmp_demo_times(col)
VALUES ('foo');

-- Timestamps without timezones are in UTC
INSERT INTO tmp_demo_times(col, record_date)
VALUES('bar', TIMESTAMP '2018-10-17 18:59');

-- Timestamp with time zone specified
INSERT INTO tmp_demo_times(col, record_date)
VALUES('baz', TIMESTAMP WITH TIME ZONE '2018-10-17 19:02 US/Eastern');

-- Timestamp with time zone specified
INSERT INTO tmp_demo_times(col, record_date)
VALUES('baz', '2018-10-17 19:02 US/Eastern');

SET TIMEZONE = 'US/Eastern';
SET TIMEZONE = 'UTC';

SELECT *
FROM tmp_demo_times;

SELECT pg_sleep_for('100 milliseconds');
SELECT pg_sleep_for('1 second');
SELECT pg_sleep_for('5 seconds');
-- Invalid
SELECT pg_sleep_for('foo');
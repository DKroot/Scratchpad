CREATE TABLE tmp_demo_defaults (
  foo VARCHAR(100),
  bar VARCHAR(100)
);

INSERT INTO tmp_demo_defaults
SELECT 'a', 'aa'
UNION ALL
SELECT 'b', 'bb'
UNION ALL
SELECT 'c', 'cc';

-- Add column with DEFAULT will populate it
ALTER TABLE tmp_demo_defaults
  ADD last_updated_time TIMESTAMP DEFAULT current_timestamp;

ALTER TABLE tmp_demo_defaults
  ADD last_updated_time TIMESTAMP;

-- Setting DEFAULT doesn't populate it
ALTER TABLE tmp_demo_defaults
  ALTER last_updated_time SET DEFAULT current_timestamp;
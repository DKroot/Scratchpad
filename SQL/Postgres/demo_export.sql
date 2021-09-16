\set ON_ERROR_STOP on
\set ECHO all

CREATE TABLE IF NOT EXISTS tmp_demo_export (
  id   INT          NOT NULL PRIMARY KEY,
  col1 VARCHAR(100) NOT NULL,
  col2 VARCHAR(100),
  load_date DATE DEFAULT current_date
);

-- TRUNCATE tmp_demo_export;

INSERT INTO tmp_demo_export(id, col1, col2) --
VALUES (1, 'foo', 'bar')
ON CONFLICT DO NOTHING;

\copy tmp_demo_export TO 'demo_export.csv' ( FORMAT CSV, HEADER ON )

COPY tmp_demo_export TO STDOUT ( FORMAT CSV, HEADER ON )
\g 'demo_export.csv'
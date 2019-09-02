DROP TABLE IF EXISTS tmp_demo_blanks;
CREATE TABLE tmp_demo_blanks (
  id        INT          NOT NULL PRIMARY KEY,
  col1      VARCHAR(100),
  col2      VARCHAR(100),
  load_date DATE DEFAULT current_date
);

COPY tmp_demo_blanks(id, col1, col2) FROM '/tmp/demo_blanks.csv' (
FORMAT CSV, HEADER ON );

TRUNCATE tmp_demo_blanks;

COPY tmp_demo_blanks(id, col1, col2) FROM '/tmp/demo_blanks.csv' (
FORMAT CSV, HEADER ON, NULL 'null' );

COPY tmp_demo_blanks(id, col1, col2) FROM '/tmp/demo_blanks.csv' (
FORMAT CSV, HEADER ON, FORCE_NOT_NULL (col1) );

COPY tmp_demo_blanks(id, col1, col2) FROM '/tmp/demo_blanks.csv' (
FORMAT CSV, HEADER ON, FORCE_NOT_NULL (col2) );
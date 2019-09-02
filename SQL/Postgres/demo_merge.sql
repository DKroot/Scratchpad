CREATE TABLE IF NOT EXISTS tmp_merge (
  id INT NOT NULL PRIMARY KEY,
  col1 VARCHAR(100),
  col2 INT DEFAULT 42
);

INSERT INTO tmp_merge
  (id, col1)
VALUES
  (1, 'A');

INSERT INTO tmp_merge
  (id, col1)
VALUES
  (2, $$line1
line2$$);

INSERT INTO tmp_merge
  (id, col1)
VALUES
  (3, 'C');

INSERT INTO tmp_merge
  (id, col1, col2)
VALUES
  (3, 'foo', 33)
    ON CONFLICT (id) DO UPDATE SET (col1, col2) = (excluded.col1, excluded.col2);

INSERT INTO tmp_merge
  (id, col1, col2)
VALUES
  (3, 'foo', 33)
    ON CONFLICT ON CONSTRAINT tmp_merge_pkey DO UPDATE SET (col1, col2) = (excluded.col1, excluded.col2);

INSERT INTO tmp_merge
  (id, col1, col2)
VALUES
  (3, 'foo', 33)
    ON CONFLICT (id) DO UPDATE SET (id, col1, col2) = (excluded.id, excluded.col1, excluded.col2);

INSERT INTO tmp_merge
  (id, col1) --
SELECT 4, 'D'
 UNION ALL
    --
SELECT 3, 'foo'
    ON CONFLICT (id) DO UPDATE SET col1 = excluded.col1;

INSERT INTO tmp_merge
  (id, col1) --
SELECT 3, 'foo'
 UNION ALL
    --
SELECT 3, 'bar'
    ON CONFLICT (id) DO UPDATE SET col1 = excluded.col1;
-- [21000] ERROR: ON CONFLICT DO UPDATE command cannot affect row a second time

-- Server-side export
-- Overwrites the old file if any
-- Produces RFC standard format except for producing LFs as EOLs
COPY tmp_merge TO '/tmp/tmp_merge.csv' (FORMAT CSV, HEADER ON);

TRUNCATE tmp_merge;

-- Server-side import
-- Imports new/added data
-- Fails on dupes
COPY tmp_merge FROM '/tmp/tmp_merge.csv' (FORMAT CSV, HEADER ON);

-- Server-side import
-- Imports new/added data from RFC standard format with CR+LFs. Multi-line field value would contain a CR+LF.
COPY tmp_merge FROM '/tmp/tmp_merge_cr_lf.csv' (FORMAT CSV, HEADER ON);

DROP TABLE IF EXISTS tmp_merge;
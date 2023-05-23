\set ON_ERROR_STOP on
\set ECHO all

\if :{?schema}
SET search_path = :schema;
\endif

-- JetBrains IDEs: start execution from here
SET TIMEZONE = 'US/Eastern';

DROP TABLE IF EXISTS tmp_demo;
CREATE TABLE tmp_demo
(
  id  INT PRIMARY KEY,
  foo VARCHAR(100)
);

--@formatter:off
DO $block$
DECLARE
  affected_rows integer;
BEGIN --
  INSERT INTO tmp_demo(id, foo) VALUES(42, 'foo');
  GET DIAGNOSTICS affected_rows = ROW_COUNT;
  RAISE NOTICE 'After INSERT: affected rows=%, FOUND=%', affected_rows, FOUND;

  INSERT INTO tmp_demo(id, foo) VALUES(42, 'bar')
  ON CONFLICT(id) DO NOTHING;
  GET DIAGNOSTICS affected_rows = ROW_COUNT;
  RAISE NOTICE 'After INSERT of a duplicate with DO NOTHING: affected rows=%, FOUND=%', affected_rows, FOUND;

  INSERT INTO tmp_demo(id, foo) VALUES(42, 'bar')
  ON CONFLICT(id)
  DO UPDATE SET foo = excluded.foo;
  GET DIAGNOSTICS affected_rows = ROW_COUNT;
  RAISE NOTICE 'After Upsert of a duplicate: affected rows=%, FOUND=%', affected_rows, FOUND;
END $block$;
--@formatter:on
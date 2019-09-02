\set ON_ERROR_STOP on
\set ECHO all

\if :{?schema}
SET search_path = :schema;
\endif

-- JetBrains IDEs: start execution from here
SET TIMEZONE = 'US/Eastern';

DROP TABLE IF EXISTS tmp_demo_returning;
CREATE TABLE tmp_demo_returning (
  id SERIAL PRIMARY KEY,
  foo VARCHAR(100)
);

--@formatter:off
DO $block$
DECLARE
  inserted_id integer;
BEGIN --
  INSERT INTO tmp_demo_blanks(foo) VALUES('1a');

  INSERT INTO tmp_demo_blanks(foo) VALUES('2b') RETURNING id INTO inserted_id;
  RAISE NOTICE 'Inserted id=%', inserted_id;

  INSERT INTO tmp_demo_blanks(foo)
  SELECT a
  FROM (
           VALUES ('3c'),
                  ('4d'),
                  ('5e')
       ) AS t(a)
  RETURNING id INTO inserted_id;
  RAISE NOTICE 'Inserted id=%', inserted_id;
END $block$;
--@formatter:on
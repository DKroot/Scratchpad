CREATE TABLE IF NOT EXISTS tmp_demo_uniques (
  foo VARCHAR(20) NOT NULL,
  bar VARCHAR(20) NOT NULL,
  baz VARCHAR(20)
);

-- ALTER TABLE tmp_demo_uniques DISABLE TRIGGER ALL;

CREATE UNIQUE INDEX tmp_demo_uniques_uk ON tmp_demo_uniques(foo, bar, baz);

-- Rejects duplicates
INSERT INTO tmp_demo_uniques
VALUES
  ('1', '2', '3');

-- Allows duplicates
INSERT INTO tmp_demo_uniques
VALUES
  ('1', '2', NULL);

-- Rejects duplicates
INSERT INTO tmp_demo_uniques
VALUES
  ('1', '2', '');

ALTER TABLE tmp_demo_uniques
  ALTER COLUMN baz DROP NOT NULL;

DROP INDEX tmp_demo_uniques_pk;

-- Works
INSERT INTO tmp_demo_uniques
VALUES
  ('1', '2', '3')
    ON CONFLICT (foo, bar, baz) DO UPDATE --
      SET foo = excluded.foo, bar = excluded.bar, baz = excluded.baz;

INSERT INTO tmp_demo_uniques
VALUES
  ('1', '2', NULL)
    ON CONFLICT (foo, bar, baz) DO UPDATE SET foo = excluded.foo, bar = excluded.bar, baz = excluded.baz;

INSERT INTO tmp_demo_uniques
VALUES
  ('1', '2', '')
    ON CONFLICT (foo, bar, baz) DO UPDATE SET foo = excluded.foo, bar = excluded.bar, baz = excluded.baz;

ALTER TABLE tmp_demo_uniques
  ADD CONSTRAINT tmp_demo_uniques_uc UNIQUE (foo, bar, baz);

INSERT INTO tmp_demo_uniques
VALUES
  ('1', '2', '3')
    ON CONFLICT ON CONSTRAINT tmp_demo_uniques_uc DO UPDATE SET foo = excluded.foo, bar = excluded.bar, baz = excluded.baz;

INSERT INTO tmp_demo_uniques
VALUES
  ('1', '2', NULL)
    ON CONFLICT ON CONSTRAINT tmp_demo_uniques_uc DO UPDATE SET foo = excluded.foo, bar = excluded.bar, baz = excluded.baz;

ALTER TABLE tmp_demo_uniques
  DROP CONSTRAINT tmp_demo_uniques_uc;

-- Adding PK sets baz to NOT NULL
ALTER TABLE tmp_demo_uniques
  ADD CONSTRAINT tmp_demo_uniques_pk PRIMARY KEY (foo, bar, baz);

ALTER TABLE tmp_demo_uniques
  DROP CONSTRAINT tmp_demo_uniques_pk;

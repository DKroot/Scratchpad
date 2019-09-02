\set ON_ERROR_STOP on
\set ECHO all

CREATE TABLE tmp_dfk_parents (
  parent VARCHAR(100) CONSTRAINT tmp_dfk_parents_pk PRIMARY KEY
);

INSERT INTO tmp_dfk_parents (parent) --
  SELECT 'foo' AS parent
  UNION ALL --
  SELECT 'bar' AS parent
  UNION ALL --
  SELECT 'baz' AS parent;

CREATE TABLE tmp_dfk_children (
  child VARCHAR(100) CONSTRAINT tmp_dfk_children_pk PRIMARY KEY,
  parent VARCHAR(100) CONSTRAINT tdc_parent_fk REFERENCES tmp_dfk_parents
);


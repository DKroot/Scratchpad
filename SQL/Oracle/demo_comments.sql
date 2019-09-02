WHENEVER SQLERROR EXIT FAILURE
WHENEVER OSERROR EXIT FAILURE
SET SERVEROUTPUT ON
SET ECHO ON

--@formatter:off
CALL drop_table_if_exists('tmp_demo_comments');

CREATE TABLE tmp_demo_comments (
  foo NUMBER,
  bar NUMBER,
  baz NUMBER,
  qux NUMBER
);

COMMENT ON TABLE tmp_demo_comments IS 'Same-line DDL';

COMMENT ON COLUMN tmp_demo_comments.foo
  IS 'Wrapped DDL';

COMMENT ON COLUMN tmp_demo_comments.bar IS q'[Multi-line
DDL]';

/*
-- ORA-00905: missing keyword
COMMENT ON COLUMN demo_alternative_quoting.baz --
  IS 'Wrapped DDL with trailing line pseudo-comment';
*/

COMMENT ON COLUMN tmp_demo_comments.baz -- Comment
  IS 'Wrapped DDL with trailing line comment';

/*
-- ORA-00905: missing keyword
COMMENT ON COLUMN demo_alternative_quoting.qux ---
  IS 'Wrapped DDL with trailing line longer pseudo-comment';
*/

COMMENT ON COLUMN tmp_demo_comments.qux --*
  IS 'Wrapped DDL with trailing line longer pseudo-comment';
--@formatter:on

EXIT

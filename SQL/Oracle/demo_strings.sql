WHENEVER SQLERROR EXIT FAILURE
WHENEVER OSERROR EXIT FAILURE
SET SERVEROUTPUT ON
SET ECHO ON

-- Types in CREATE TABLE AS
DROP TABLE tmp_demo_strings;

CREATE TABLE tmp_demo_strings AS
SELECT '123456' AS s, '1' AS c, ' 123456 ' AS padded_s
FROM dual
UNION ALL
SELECT '1234' AS s, '1' AS c, '123456' AS padded_s
FROM dual;
-- VARCHAR(6), CHAR(1), VARCHAR(8)

-- NULLs don't "eat" concatenated strings
SELECT 'HINT: ' || NULL AS message
FROM dual;

-- NUMBERS are eaten during formatting
BEGIN
  debug(utl_lms.format_message('Row filter %d %s%s, %s', CAST(1 AS NUMBER), 'foo', 'bar', 'baz'));
END;
/

BEGIN
  debug(utl_lms.format_message('Row filter %s %s%s, %s', to_char(CAST(1 AS NUMBER)), 'foo', 'bar', 'baz'));
END;
/

-- Removing a substring
SELECT replace('foo', 'o'), replace('foo', NULL)
FROM dual;

EXIT

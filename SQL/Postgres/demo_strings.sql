SELECT E'a\nb' AS foo;

-- region Types in CREATE TABLE AS
DROP TABLE IF EXISTS tmp_demo_strings;

CREATE TABLE tmp_demo_strings AS
SELECT *
FROM (
  VALUES ('123456', '1', ' 123456 '),
         ('1234', '1', '123456')
) AS t(s, c, padded_s);
-- TEXT, TEXT, TEXT

DROP TABLE IF EXISTS tmp_demo_strings;

CREATE TABLE tmp_demo_strings AS
SELECT '123456' AS c1, '1' AS c2, ' 123456 ' AS c3;
-- Postgres 10: TEXT, TEXT, TEXT
-- Postgres 9: Unknown, Unknown, Unknown

CREATE TABLE tmp_demo_strings_2 AS
SELECT c1, c2, c3, 'issn' AS c4
FROM tmp_demo_strings tds;
-- Postgres 10: TEXT, TEXT, TEXT, TEXT
-- endregion

-- Comparison with numbers
SELECT *
FROM (
  VALUES ('1986'),
         ('2001')
) AS t(year)
WHERE year <= '1991';

-- Trimming
SELECT 'Result=<' || trim($$ 'bla' $$, $$ ' $$) || '>';

-- Regular expression search and replacement
-- regexp_replace replaces the first matching substring by default
SELECT term, regexp_replace(term, '(.*?)[,.@!]+$', '\1') AS after_stripping_trailing_junk
FROM (
  VALUES ('CPU,'),
         (','),
         ('VINYL!,'),
         ('A=D-ANALOGUE/DIGITAL.'),
         ('POLYTHIOETHER!'),
         ('POLYETHYLENE@')
) AS t(term)
WHERE term ~ '[,.@!]';

WITH
  cte AS (
    SELECT 'foo' AS a, 'bar' AS b
    UNION ALL
    SELECT 'bar' AS a, 'baz' AS b
    UNION ALL
    SELECT 'baz' AS a, 'qux' AS b
  )
SELECT a, b, a < b AS a_less_than_b
FROM cte;

SELECT regexp_replace('VINYL!,', '(.*)[,.@!]+', '\1');
-- VINYL!

-- TODO Weird result: does not work like in other flavors. Report.
SELECT regexp_replace('VINYL!,', '(.*?)[,.@!]+', '\1');
-- VINYL,

-- regexp_replace replaces the first matching substring by default
SELECT regexp_replace('foobarbaz', 'b..', 'X');

-- NULLs 'eat' concatenated strings
SELECT $$ HINT: $$ || NULL AS message;

-- NULLs are expanded to empty strings in format()
SELECT format($$ HINT: %s $$, NULL);

-- NULLs are expanded to <NULL> in RAISE formats
DO $block$
  BEGIN
    --
    RAISE WARNING USING MESSAGE = format('%s%s%s', 'ERROR ' || '#12345', E'\nDetail: ' || 'foo',
                                         E'\nHint: ' || NULL); --
    --   RAISE NOTICE E'ERROR: %\nDETAIL: %\n%', 'Error #12345', NULL, 'HINT: ' || NULL; --
    --   RAISE USING MESSAGE = 'Error #12345', DETAIL = '', HINT = '';
  END $block$;

-- Concatenation with newlines
--@formatter:off
SELECT 'Hello,'
  ' newline concatenation!' AS message;
--@formatter:on

-- Newline concatenation is not supported for dollar-quoted strings
/*
SELECT $$Hello,$$
       ' newline concatenation!' AS message;
-- Syntax error

SELECT $$Hello,$$
       $$ newline concatenation!$$ AS message;
-- Syntax error

SELECT 'Hello,'
       $$ newline concatenation!$$ AS message;
-- Syntax error
*/

-- DataGrip: Enter the bind variable in single quotes when prompted
--@formatter:off
SELECT :'prefix'
  ' newline concatenation!' AS message;
--@formatter:on

TRUNCATE TABLE tmp_demo_copy;

COPY tmp_demo_copy(wos_uid, pmid) FROM '/demo_import.txt' ( FORMAT CSV, DELIMITER '|', HEADER ON );

-- Valid syntax, but erroneously flagged by DataGrip
COPY tmp_demo_copy(wos_uid, pmid) FROM :'dir' '/demo_import.txt' ( FORMAT CSV, DELIMITER '|', HEADER ON );
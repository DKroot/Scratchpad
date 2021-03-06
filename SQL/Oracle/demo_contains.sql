DROP TABLE tmp_demo_contains;

CREATE TABLE tmp_demo_contains 
(
  id      NUMBER(10) GENERATED BY DEFAULT ON NULL AS IDENTITY,
  title   VARCHAR2(4000 CHAR)
);

TRUNCATE TABLE tmp_demo_contains;

INSERT ALL
INTO tmp_demo_contains
  (title)
VALUES
  ('2015 Mar 17')
INTO tmp_demo_contains
  (title)
VALUES
  ('A quick brown fox:jumps over the lazy-dog')
INTO tmp_demo_contains
  (title)
VALUES
  ('TRUSTS ACT 1973')
INTO tmp_demo_contains
  (title)
VALUES
  ('TRUST ACCOUNTS ACT 1973')
INTO tmp_demo_contains
  (title)
VALUES
  ('sunk the sea within the earth')
INTO tmp_demo_contains
  (title)
VALUES
  ('Abraços ao meu avô')
INTO tmp_demo_contains
  (title)
VALUES
  ('Nascimento, Edson Arantes do')
SELECT *
FROM dual;

-- Domain index info
SELECT ctx_report.describe_index('tdc_title_ci')
FROM dual;

CALL drop_index_if_exists('tdc_title_ci');

-- Using:
-- * default LEXER ctxsys.default_lexer
-- * STOPLIST ctxsys.empty_stoplist
CREATE INDEX tdc_title_ci ON tmp_demo_contains(title)
INDEXTYPE IS ctxsys.context
PARAMETERS('STOPLIST ctxsys.empty_stoplist');

/*
-- Using:
-- * default LEXER ctxsys.default_lexer = ctxsys.basic_lexer with the index_themes attribute disabled
-- * default STOPLIST ctxsys.default_stoplist
CREATE INDEX tdc_title_ci ON tmp_demo_contains(title)
INDEXTYPE IS ctxsys.context;
-- PARAMETERS('STOPLIST ctxsys.default_stoplist'); -- Could be omitted
*/
        
-- Phrase search
SELECT *
FROM tmp_demo_contains
WHERE CONTAINS(title, '2015 Mar 17') > 0;

DECLARE
  query VARCHAR2(4000) := '2015 Mar 17';
  hitlist SYS_REFCURSOR;
BEGIN
  OPEN hitlist
  FOR
  SELECT *
  FROM tmp_demo_contains
  WHERE CONTAINS(title, query) > 0;  
 
  DBMS_SQL.RETURN_RESULT(hitlist);
END;
/

-- Case-insensitive
SELECT *
FROM tmp_demo_contains
WHERE CONTAINS(title, '2015 mar 17') > 0;

-- No results: not a phrase
SELECT *
FROM tmp_demo_contains
WHERE CONTAINS(title, '2015 17') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, 'Edson Nascimento') > 0;

-- Empty STOPLIST: stop words work like any other words. They have to match hence no results here.
SELECT *
FROM tmp_demo_contains
WHERE CONTAINS(title, 'The quick brown') > 0;

-- Default STOPLIST: when you include a stopword within your query phrase, the stopword matches any word.
-- (https://docs.oracle.com/cd/B28359_01/text.111/b28303/query.htm#i1006398)
SELECT *
FROM tmp_demo_contains
WHERE CONTAINS(title, '2015 the 17') > 0;

-- Non-alphabetic characters are treated as whitespace and ignored in indexed text
-- (http://docs.oracle.com/database/121/CCREF/cqspcl.htm#CCREF2091)
SELECT *
FROM tmp_demo_contains
WHERE CONTAINS(title, 'fox jumps') > 0;

-- Non-alphabetic characters are treated as whitespace in queries
SELECT *
FROM tmp_demo_contains
WHERE CONTAINS(title, 'fox:jumps') > 0;

SELECT *
FROM tmp_demo_contains
WHERE CONTAINS(title, 'fox@jumps') > 0;

SELECT *
FROM tmp_demo_contains
WHERE CONTAINS(title, 'lazy dog') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%\N\a\s\c\i\m\e\n\t\o\@\ \E\d\s%') > 0;

-- Phrase search: need to match exactly
SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '{TRUSTS} {ACT} {1973}') > 0;

-- ACCUM search with a query template
SELECT tdc.*, score(1)
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '
<query> 
  <textquery lang="ENGLISH" grammar="CONTEXT">
      <progression>
          <seq>{TRUSTS} ACCUM {ACT} ACCUM {1973}</seq>
      </progression>
  </textquery>
  <score datatype="INTEGER" algorithm="COUNT"/>
</query>', 1) > 0
ORDER BY score(1) DESC;

-- Substring search
SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%ox jump%') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%o%') > 0;

-- Trivial search does not return anything
SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%%') > 0;

-- Special characters are ignored
SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%az%') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%a & z%') > 0;

-- {} escaping can't be used with wildcards
SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%within jump%') > 0;

-- Substring search with escaping
SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%\w\i\t\h\i\n\ \t\h\e\ e\a%') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%\w\i\t\h\i\n\@\t\h\e\#\e\a%') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%\e\a\ \w\i\t\h\i\n\ \t\h\e\ \e\a\r%') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%A {quick} {brown} fox%') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%ea {within} {the} ear%') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%within {the} ea%') > 0;

-- Non-ASCII characters
SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, 'meu') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, 'Abraços') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '\A\b\r\a\ç\o\s') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, 'Abra:os') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, 'abraço%') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, 'avô') > 0;

-- OR Search
SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '%\N\a\s\c\i\m\e\n\t\o | \E\d\s%') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '\N\a\s\c\i\m\e\n\t\o\, | \E\d\s') > 0;

SELECT *
FROM tmp_demo_contains tdc
WHERE CONTAINS(title, '\E\d\s\o\n | \N\a\s\c\i\m\e\n\t\o') > 0;

-- AND search
SELECT *
FROM tmp_demo_contains
WHERE CONTAINS(title, 'Mar & 17 & 2015') > 0;

SELECT *
FROM tmp_demo_contains
WHERE CONTAINS(title, 'Mar & 17 & 2015') > 0;

-- region ts_rank()
SELECT
  ts_rank(to_tsvector('english', 'one two three'),
          plainto_tsquery('english', 'one two three'));
-- 0.268

SELECT
  ts_rank(to_tsvector('english', 'one two three four five six seven eight nine ten'),
          plainto_tsquery('english', 'one two three four five six seven eight nine ten'));
-- 0.987

SELECT
  ts_rank(to_tsvector('english', 'one two three four five six seven eight nine ten eleven'),
          plainto_tsquery('english', 'one two three four five six seven eight nine ten eleven'));
-- 0.994

SELECT
  ts_rank(to_tsvector('english', 'one two three four five six seven eight nine ten eleven twelve'),
          plainto_tsquery('english', 'one two three four five six seven eight nine ten eleven'));
-- 0.994

SELECT
  ts_rank(to_tsvector('english', 'one two three four five six seven eight nine ten eleven'),
          plainto_tsquery('english', 'one two three four five six seven eight nine ten eleven twelve'));
-- 0.994

SELECT
  ts_rank(to_tsvector('english', 'one two three four five six seven eight nine ten eleven twelve'),
          plainto_tsquery('english', 'one two three four five six seven eight nine ten eleven twelve'));
-- 0.997

SELECT
  ts_rank(to_tsvector('english', 'one two three four five six seven eight nine ten eleven twelve thirteen'),
          plainto_tsquery('english', 'one two three four five six seven eight nine ten eleven twelve thirteen'));
-- 0.999

SELECT
  ts_rank(to_tsvector('english', 'one two three'),
          plainto_tsquery('english', 'one two three'), 32);
-- 0.21

SELECT
  ts_rank(to_tsvector('english', 'one two three'),
          plainto_tsquery('english', 'one two three'), 8);
-- 0.09
-- endregion

-- 1:1 query conversion
SELECT 'Under & pressure'::TSQUERY;

SELECT to_tsquery('english', 'The & Fat & Cats');

-- Normalize words and convert to tsquery
SELECT to_tsquery('english', 'Under & pressure');

-- Produce AND-tsquery ignoring punctuation
SELECT plainto_tsquery('english', 'Something was under some sort of pressure.');

-- Produce AND-tsquery ignoring punctuation
SELECT websearch_to_tsquery('english', 'Something was under some sort of pressure.');

-- Produce OR-tsquery
SELECT
  array_to_string(tsvector_to_array(to_tsvector('english', 'Something was under some sort of pressure.')), ' | ');

SELECT title, ts_rank(to_tsvector('english', title), plainto_tsquery('english', 'tsquery tsvector')) AS rank
  FROM
    (
      VALUES
        ('The tsvector type represents a document in a form optimized for text search; the tsquery type similarly represents a
text query.'),
        ('A tsvector value is a sorted list of distinct lexemes, which are words that have been normalized to merge different
variants of the same word.'),
        ('Full text searching in PostgreSQL is based on the match operator @@, which returns true if a tsvector (document) matches
a tsquery (query).'),
        ('The @@ operator also supports text input, allowing explicit conversion of a text string to tsvector or tsquery to be skipped in simple cases.')
    ) AS t(title)
 WHERE to_tsvector('english', title) @@ plainto_tsquery('english', 'tsquery tsvector');

/*
The tsvector type represents a document in a form optimized for text search; the tsquery type similarly represents a
text query.

A tsvector value is a sorted list of distinct lexemes, which are words that have been normalized to merge different
variants of the same word.

Full text searching in PostgreSQL is based on the match operator @@, which returns true if a tsvector (document) matches
a tsquery (query).

The @@ operator also supports text input, allowing explicit conversion of a text string to tsvector or tsquery to be skipped in simple cases.
*/
SELECT phraseto_tsquery('Under pressure') @@ to_tsvector('Something was under some sort of pressure');
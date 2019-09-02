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
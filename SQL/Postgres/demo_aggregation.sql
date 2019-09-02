-- GROUP BY and pick NOT NULLs
SELECT a, max(b), min(b), string_agg(b, ', ')
FROM (
         VALUES ('foo', NULL),
                ('foo', 'baz'),
                ('foo', 'qux'),
                ('bar', 'baz'),
                ('baz', NULL)
     ) AS t(a, b)
GROUP BY a;

-- Counting duplicates
SELECT COUNT(1)
FROM (
         VALUES ('foo', 'bar'),
                ('foo', 'baz'),
                ('bar', 'baz'),
                ('baz', 'qux')
     ) AS t(a, b)
WHERE a = 'foo';
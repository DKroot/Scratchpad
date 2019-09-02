-- Select records for n random ids
WITH
  cte AS (
    SELECT *
    FROM (
      VALUES (1, 'foo'),
             (2, 'foo'),
             (3, 'foo'),
             (4, 'foo'),
             (5, 'foo'),
             (1, 'bar'),
             (2, 'bar'),
             (3, 'bar'),
             (4, 'bar'),
             (5, 'bar')
    ) AS t(id, a)
  )
SELECT *
FROM cte
WHERE id IN (
  SELECT id
  FROM cte
  GROUP BY id
  ORDER BY random()
  LIMIT 2 -- n = 2
);
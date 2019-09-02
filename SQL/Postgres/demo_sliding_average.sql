-- Sliding average of the last 2 records
WITH cte AS (
  SELECT 42 AS v, 1 AS id
  UNION ALL
  SELECT 142 AS v, 2 AS id
  UNION ALL
  SELECT 242 AS v, 3 AS id
)
SELECT avg(sq.v) AS AVERAGE
FROM (
  SELECT v
  FROM cte
  ORDER BY id DESC
  LIMIT 2
) sq;
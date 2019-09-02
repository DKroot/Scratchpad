SELECT max(salary) AS "42nd_highest_salary"
FROM
  (
    WITH cte AS (
      SELECT id, round(id * 0.5) * 1000 AS salary
      FROM generate_series(1, 100) AS id(id)
    )
    SELECT salary, dense_rank() OVER (ORDER BY salary DESC) AS rank
    FROM cte
  ) sq
WHERE rank = 42;


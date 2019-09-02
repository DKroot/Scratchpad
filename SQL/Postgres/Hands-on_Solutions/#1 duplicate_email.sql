WITH cte AS (
  SELECT *
  FROM
    (
      VALUES
        (1, 'foo@example.com'),
        (2, 'bar@example.com'),
        (3, 'foo@example.com')
    ) AS t(person_id, email)
)
SELECT email
FROM cte
GROUP BY email
HAVING COUNT(1) > 1;


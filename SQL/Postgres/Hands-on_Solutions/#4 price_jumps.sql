SELECT id, price
FROM
  (
    WITH cte AS (
      SELECT *
      FROM
        (
          VALUES
            (1, 3.50),
            (2, 3.65),
            (3, 4.00),
            (4, 3.85),
            (5, 5.00),
            (6, 3.65)
        ) AS t(id, price)
    )
    SELECT *, price / lag(price) OVER (ORDER BY id) AS delta_ratio
    FROM cte
  ) sq
WHERE delta_ratio >= 1.05 OR delta_ratio <= 0.95;
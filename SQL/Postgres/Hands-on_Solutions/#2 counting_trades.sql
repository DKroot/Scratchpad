WITH cte AS (
  SELECT CURRENT_TIMESTAMP - INTERVAL '1 day' AS trade_time, *
  FROM
    (
      VALUES
        (1, 100),
        (2, 10),
        (3, 20000),
        (4, 200),
        (5, 300)
    ) AS t(trade_id, num_stocks_traded)
)
SELECT CASE
         WHEN num_stocks_traded BETWEEN 1 AND 100
           THEN 'Low volume'
         WHEN num_stocks_traded BETWEEN 100 AND 10000
           THEN 'Medium volume'
         ELSE 'High volume'
       END AS volume, count(1) AS trade_count
FROM cte
WHERE date_trunc('day', trade_time) = CURRENT_DATE - INTERVAL '1 day'
GROUP BY volume;


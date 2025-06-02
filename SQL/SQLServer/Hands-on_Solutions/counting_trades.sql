WITH cte AS (
    SELECT current_timestamp AS trade_time, *
    FROM (
      VALUES (1, 100),
        (2, 10),
        (3, 20000),
        (4, 200),
        (5, 300)
    ) AS t(trade_id, num_stocks_traded)
  )
SELECT volume, count(1) as count
FROM (
  SELECT CASE
           WHEN num_stocks_traded BETWEEN 1 AND 100
             THEN 'Low volume'
           WHEN num_stocks_traded BETWEEN 100 AND 10000
             THEN 'Medium volume'
           ELSE 'High volume'
         END AS volume
  FROM cte
  WHERE trade_time > 0 -- faking yesterday
) trade_volumes
GROUP BY volume;


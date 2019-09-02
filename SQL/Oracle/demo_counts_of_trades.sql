SELECT volume, COUNT(1) AS trade_count
FROM
  (
    WITH sample_data AS (
      SELECT 'AAPL' AS symbol, 100.12 AS price, 5 AS num_stocks_traded
      FROM dual
      UNION ALL
      SELECT 'AAPL' AS symbol, 99.99 AS price, 42 AS num_stocks_traded
      FROM dual
      UNION ALL
      SELECT 'AAPL' AS symbol, 100.00 AS price, 1 AS num_stocks_traded
      FROM dual
      UNION ALL
      SELECT 'AAPL' AS symbol, 101.12 AS price, 101 AS num_stocks_traded
      FROM dual
    )
    SELECT CASE
             WHEN num_stocks_traded BETWEEN 1 AND 100
               THEN 'Low volume'
             WHEN num_stocks_traded BETWEEN 100 AND 10000
               THEN 'Medium volume'
             ELSE 'High volume'
           END AS volume
    FROM sample_data
  )
GROUP BY volume;

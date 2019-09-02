SELECT format($$COPY %s FROM %L (FORMAT CSV, HEADER %s)$$, 'a_table', '/tmp/some.csv', --
              CASE FALSE WHEN TRUE THEN 'ON' ELSE 'OFF' END);

SELECT format($$COPY %s FROM %L (FORMAT CSV, HEADER %s, DELIMITER %L)$$, 'a_table', '/tmp/some.csv', --
                 CASE TRUE WHEN TRUE THEN 'ON' ELSE 'OFF' END, ',');
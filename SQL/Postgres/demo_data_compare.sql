CREATE TABLE tmp_demo_data_compare_1 (
  foo VARCHAR
);

CREATE TABLE tmp_demo_data_compare_2 (LIKE tmp_demo_data_compare_1);

-- foo #1..#1000
INSERT INTO tmp_demo_data_compare_1(foo)
SELECT 'foo #' || s.num
FROM generate_series(1, 1000) AS s(num);

-- foo #1..500 + #502..1002
INSERT INTO tmp_demo_data_compare_2(foo)
SELECT 'foo #' || s.num
FROM generate_series(1, 500) AS s(num)
UNION ALL
SELECT 'foo #' || s.num
FROM generate_series(502, 1002) AS s(num);

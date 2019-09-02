-- Employees' largest sales months: option 1 (ORDER BY + LIMIT)
SELECT employees.employee AS employee, employees.employee_id, (
  SELECT sales.month
  FROM
    (
      VALUES
        (1, '201801', 100),
        (1, '201802', 200),
        (2, '201801', 80),
        (3, '201801', 100)
    ) AS sales(employee_id, month, monthly_sales)
  WHERE sales.employee_id = employees.employee_id
  ORDER BY sales.monthly_sales DESC
  LIMIT 1
) AS largest_sales_month
FROM
  (
    VALUES
      ('John Doe', 1),
      ('Jack Sparrow', 2),
      ('Jane Doe', 3)
  ) AS employees(employee, employee_id);

-- Employees' largest sales months: option 2 (row_number() + subquery)
SELECT employee, employee_id, month AS largest_sales_month
FROM
  (
    SELECT employees.employee AS employee, employees.employee_id, sales.month,
          row_number() OVER (PARTITION BY sales.employee_id ORDER BY sales.monthly_sales DESC) AS r
    FROM
      (
        VALUES
          ('John Doe', 1),
          ('Jack Sparrow', 2),
          ('Jane Doe', 3)
      ) AS employees(employee, employee_id)
        JOIN (
        VALUES
          (1, '201801', 100),
          (1, '201802', 200),
          (2, '201801', 80),
          (3, '201801', 100)
      ) AS sales(employee_id, month, monthly_sales) ON sales.employee_id = employees.employee_id
  ) sq
WHERE r = 1;

-- Ranked by salary
SELECT employee, salary, dense_rank() OVER (ORDER BY salary DESC) AS rank
FROM
  (
    VALUES
      ('John Doe', 100000),
      ('Jack Sparrow', 80000),
      ('Jane Doe', 100000)
  ) AS t(employee, salary)
ORDER BY rank, employee;

-- row_number() OVER(): the window frame is the same as the partition, which for lack of PARTITION BY is the whole table
SELECT employee, salary, row_number() OVER () AS rank
FROM
  (
    VALUES
      ('John Doe', 100000),
      ('Jack Sparrow', 80000),
      ('Jane Doe', 100000)
  ) AS t(employee, salary)
ORDER BY employee;

--DROP TABLE DEPT;
CREATE TABLE dept (
  deptno NUMBER(2)
    CONSTRAINT pk_dept PRIMARY KEY,
  dname VARCHAR2(14),
  loc VARCHAR2(13)
);

--DROP TABLE EMP;
CREATE TABLE emp (
  empno NUMBER(4)
    CONSTRAINT pk_emp PRIMARY KEY,
  ename VARCHAR2(10),
  job VARCHAR2(9),
  mgr NUMBER(4),
  hiredate DATE,
  sal NUMBER(7, 2),
  comm NUMBER(7, 2),
  deptno NUMBER(2)
    CONSTRAINT fk_deptno REFERENCES dept
);

INSERT INTO dept
VALUES
  (10, 'ACCOUNTING', 'NEW YORK');

INSERT INTO dept
VALUES
  (20, 'RESEARCH', 'DALLAS');

INSERT INTO dept
VALUES
  (30, 'SALES', 'CHICAGO');

INSERT INTO dept
VALUES
  (40, 'OPERATIONS', 'BOSTON');

INSERT INTO emp
VALUES
  (7369, 'SMITH', 'CLERK', 7902, to_date('17-12-1980', 'dd-mm-yyyy'),
   800, NULL, 20);

INSERT INTO emp
VALUES
  (7499, 'ALLEN', 'SALESMAN', 7698, to_date('20-2-1981', 'dd-mm-yyyy'),
   1600, 300, 30);

INSERT INTO emp
VALUES
  (7521, 'WARD', 'SALESMAN', 7698, to_date('22-2-1981', 'dd-mm-yyyy'),
   1250, 500, 30);

INSERT INTO emp
VALUES
  (7566, 'JONES', 'MANAGER', 7839, to_date('2-4-1981', 'dd-mm-yyyy'),
   2975, NULL, 20);

INSERT INTO emp
VALUES
  (7654, 'MARTIN', 'SALESMAN', 7698, to_date('28-9-1981', 'dd-mm-yyyy'),
   1250, 1400, 30);

INSERT INTO emp
VALUES
  (7698, 'BLAKE', 'MANAGER', 7839, to_date('1-5-1981', 'dd-mm-yyyy'),
   2850, NULL, 30);

INSERT INTO emp
VALUES
  (7782, 'CLARK', 'MANAGER', 7839, to_date('9-6-1981', 'dd-mm-yyyy'),
   2450, NULL, 10);

INSERT INTO emp
VALUES
  (7788, 'SCOTT', 'ANALYST', 7566, to_date('13-JUL-87') - 85,
   3000, NULL, 20);

INSERT INTO emp
VALUES
  (7839, 'KING', 'PRESIDENT', NULL, to_date('17-11-1981', 'dd-mm-yyyy'),
   5000, NULL, 10);

INSERT INTO emp
VALUES
  (7844, 'TURNER', 'SALESMAN', 7698, to_date('8-9-1981', 'dd-mm-yyyy'),
   1500, 0, 30);

INSERT INTO emp
VALUES
  (7876, 'ADAMS', 'CLERK', 7788, to_date('13-JUL-87') - 51,
   1100, NULL, 20);

INSERT INTO emp
VALUES
  (7900, 'JAMES', 'CLERK', 7698, to_date('3-12-1981', 'dd-mm-yyyy'),
   950, NULL, 30);

INSERT INTO emp
VALUES
  (7902, 'FORD', 'ANALYST', 7566, to_date('3-12-1981', 'dd-mm-yyyy'),
   3000, NULL, 20);

INSERT INTO emp
VALUES
  (7934, 'MILLER', 'CLERK', 7782, to_date('23-1-1982', 'dd-mm-yyyy'),
   1300, NULL, 10);

--col ename format a60
--col level format 999999

-- Recursive CTE (no `RECURSIVE` keyword)
WITH cte(emp_level, employee, empno, mgr) AS (
  SELECT 1, ename, empno, mgr
  FROM emp
  WHERE mgr IS NULL
  UNION ALL
  SELECT cte.emp_level + 1, lpad(' ', 2 * cte.emp_level) || emp.ename, emp.empno, emp.mgr
  FROM cte
    JOIN emp ON emp.mgr = cte.empno
)
SELECT emp_level, employee, empno, mgr
FROM cte
ORDER BY mgr NULLS FIRST;

-- Proprietary CONNECT BY syntax
SELECT level, lpad(' ', 2 * (level - 1)) || ename AS employee
FROM emp
CONNECT BY PRIOR empno = mgr
START WITH mgr IS NULL;

WHENEVER SQLERROR EXIT FAILURE
WHENEVER OSERROR EXIT FAILURE
SET SERVEROUTPUT ON
SET ECHO ON

CREATE TABLE tmp_demo_numbers (
  appl_id_number NUMBER(5) NOT NULL,
  rank_number NUMBER(6, 5),
  foo_number NUMBER,
  appl_id_dec DECIMAL(5) NOT NULL,
  rank_dec DECIMAL(6, 5),
  foo_dec DECIMAL,
  appl_id_numeric NUMERIC(5) NOT NULL,
  rank_numeric NUMERIC(6, 5),
  foo_numeric NUMERIC
);

SELECT dbms_random.value(1, 2)
FROM dual;

SELECT trunc(dbms_random.value(1, 3))
FROM dual;

EXIT


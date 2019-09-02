/*
CREATE TABLE Q (
    T TIMESTAMP NOT NULL ENABLE,
    P NUMBER NOT NULL ENABLE,
    CONSTRAINT "Q_PK" PRIMARY KEY ("T") ENABLE
);

insert into Q(T,P) values (to_timestamp('01-JAN-10','DD-MON-RR'), 10.2);
insert into Q(T,P) values (to_timestamp('02-JAN-10','DD-MON-RR'), 8.98);
insert into Q(T,P) values (to_timestamp('03-JAN-10','DD-MON-RR'), 12.24);
insert into Q(T,P) values (to_timestamp('01-FEB-10','DD-MON-RR'), 20.56);
commit; 
*/

WITH q AS
(
  SELECT TO_TIMESTAMP('01-JAN-10','DD-MON-RR') AS t, 10.2 AS p
  FROM dual
  UNION ALL
  SELECT TO_TIMESTAMP('02-JAN-10','DD-MON-RR') AS t, 8.98 AS p
  FROM dual
  UNION ALL
  SELECT TO_TIMESTAMP('03-JAN-10','DD-MON-RR') AS t, 12.24 AS p
  FROM dual
  UNION ALL
  SELECT TO_TIMESTAMP('01-FEB-10','DD-MON-RR') AS t, 20.56 AS p
  FROM dual
)
/* Solution that uses an analytic function */ 
SELECT TO_CHAR(t,'YYYY-MM-DD') AS t, p - LAG(p,1,NULL) OVER (ORDER BY t) AS delta
FROM q
ORDER BY t;

/* 
Output:
T          DELTA                  
---------- ---------------------- 
2010-01-01                        
2010-01-02 -1.22                  
2010-01-03 3.26                   
2010-02-01 8.32                   
*/

WITH q AS
(
  SELECT TO_TIMESTAMP('01-JAN-10','DD-MON-RR') AS t, 10.2 AS p
  FROM dual
  UNION ALL
  SELECT TO_TIMESTAMP('02-JAN-10','DD-MON-RR') AS t, 8.98 AS p
  FROM dual
  UNION ALL
  SELECT TO_TIMESTAMP('03-JAN-10','DD-MON-RR') AS t, 12.24 AS p
  FROM dual
  UNION ALL
  SELECT TO_TIMESTAMP('01-FEB-10','DD-MON-RR') AS t, 20.56 AS p
  FROM dual
)
/* Solution that does not use an analytic function */
SELECT TO_CHAR(q2.t,'YYYY-MM-DD') AS t, q2.p - q1.p AS delta
FROM q q1,
     q q2
WHERE q2.t = (SELECT MIN(t)
              FROM q q3
              WHERE q3.t > q1.t)
UNION
-- The first record:
SELECT TO_CHAR(q1.t,'YYYY-MM-DD') AS t, NULL AS delta
FROM q q1
WHERE q1.t = (SELECT MIN(t)
              FROM q q3)
ORDER BY t;

/*
Output:
T          DELTA                  
---------- ---------------------- 
2010-01-01                        
2010-01-02 -1.22                  
2010-01-03 3.26                   
2010-02-01 8.32
*/

CREATE TABLE tmp_demo
(
  a   VARCHAR2(4000)
);


INSERT INTO tmp_demo(a)
VALUES ('Multi-line 1' || chr(13) || chr(10) || 'Multi-line 2');

INSERT INTO tmp_demo(a)
VALUES ('Line with "inner quotes"');

INSERT INTO tmp_demo(a)
VALUES ('Regular line');

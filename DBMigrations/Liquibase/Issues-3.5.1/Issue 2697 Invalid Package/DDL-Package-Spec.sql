CREATE OR REPLACE PACKAGE tmp_lq_demo
AS
  PROCEDURE demo (
     loginId          IN VARCHAR2 := NULL
  );
END tmp_lq_demo;
/
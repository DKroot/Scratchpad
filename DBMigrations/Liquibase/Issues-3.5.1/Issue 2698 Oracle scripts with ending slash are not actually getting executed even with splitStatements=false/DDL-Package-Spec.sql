CREATE OR REPLACE PACKAGE tmp_lq_demo
AS      
  PROCEDURE demo1 (
     loginId          IN VARCHAR2 := NULL
  );
  
  PROCEDURE demo2 (
     loginId          IN VARCHAR2 := NULL
  );
END tmp_lq_demo;
/

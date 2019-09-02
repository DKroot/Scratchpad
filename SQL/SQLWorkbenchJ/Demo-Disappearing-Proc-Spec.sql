CREATE OR REPLACE PACKAGE tmp_demo
AS
  PROCEDURE d_appl_people(
      custom_query BOOLEAN := FALSE) ;

  PROCEDURE d_all;
END;
/

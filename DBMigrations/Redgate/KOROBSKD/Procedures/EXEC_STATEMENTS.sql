CREATE OR REPLACE PROCEDURE korobskd.exec_statements(statements string_list)
AS
BEGIN
  IF statements IS NOT EMPTY THEN
    FOR i IN statements.FIRST..statements.LAST LOOP
      debug(statements(i) || ' ...');

      EXECUTE IMMEDIATE statements(i);
    END LOOP;
  END IF;
END;
/
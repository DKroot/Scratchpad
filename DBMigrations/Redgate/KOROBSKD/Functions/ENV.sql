CREATE OR REPLACE FUNCTION korobskd.env RETURN VARCHAR2
--
-- Environment detection
--
IS
  dbGlobalName VARCHAR2(4000);
BEGIN
  SELECT global_name
  INTO dbGlobalName
  FROM global_name;

  debug('Running at ' || dbGlobalName);

  RETURN
    CASE
      WHEN dbGlobalName LIKE '%PRD%' OR dbGlobalName LIKE '%PROD%' THEN 'PROD'
      WHEN dbGlobalName LIKE '%TST%' OR dbGlobalName LIKE '%TEST%' THEN 'TEST'
      WHEN dbGlobalName LIKE '%DEV%' OR dbGlobalName LIKE '%STG%' THEN 'DEV'
      ELSE 'Unknown'
    END;
END;
/
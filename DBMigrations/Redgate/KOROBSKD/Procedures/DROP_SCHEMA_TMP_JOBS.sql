CREATE OR REPLACE PROCEDURE korobskd.drop_schema_tmp_jobs
--
-- Drops all %TMP% and %TEMP% jobs in the schema
--
IS
BEGIN
  FOR cur IN (
    SELECT job_name
    FROM user_scheduler_jobs
    WHERE job_name LIKE '%TMP%' OR job_name LIKE '%TEMP%'
    ORDER BY job_name
  ) LOOP
    debug('Dropping ' || cur.job_name || ' ...') ;
    dbms_scheduler.drop_job(cur.job_name) ;
  END LOOP;
END;
/
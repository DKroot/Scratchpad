CREATE OR REPLACE PROCEDURE korobskd.drop_job_if_exists(
    job_name IN VARCHAR2)
---
--  Graceful dropping of a job
---
IS
  job_doesnt_exist EXCEPTION;
  PRAGMA EXCEPTION_INIT(job_doesnt_exist, -27475) ;
BEGIN
  dbms_scheduler.drop_job(job_name) ;
EXCEPTION
WHEN job_doesnt_exist THEN
  NULL;
END;
/
CREATE OR REPLACE PROCEDURE korobskd.create_or_replace_download_job(
  mv VARCHAR2, -- downloadable MV
  jobName VARCHAR2 := NULL -- job name: defaults to the naming convention
)
--
-- Create or replace a job to refresh downloadable MV
--
IS
  job VARCHAR2(30) := COALESCE(jobName, 'np_j_r_' || mv);
BEGIN
  drop_job_if_exists (job);

  debug('Creating download job: ' || job || ' ...');

  dbms_scheduler.create_job (
    job_name => job,
    job_type => 'PLSQL_BLOCK',
    job_action => q'[
BEGIN
  r_mv_in_place (']' || mv || q'[');
END;
    ]',
    repeat_interval => 'FREQ=DAILY;BYDAY=TUE,WED,THU,FRI,SAT;BYHOUR=3;BYMINUTE=45',
    enabled => TRUE,
    comments => 'Downloads ' || mv);

  -- Configure a newly created job, including environment-specific email notifications
  setup_job(job);
END;
/
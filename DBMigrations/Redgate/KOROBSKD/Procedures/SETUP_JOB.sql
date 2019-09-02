CREATE OR REPLACE PROCEDURE korobskd.setup_job(
  job VARCHAR2,
  onEvents VARCHAR2 := 'JOB_FAILED,JOB_BROKEN,JOB_SCH_LIM_REACHED,JOB_CHAIN_STALLED,JOB_OVER_MAX_DUR',
  environment VARCHAR2 := NULL, -- The default is to derive enviroment name from IRDB DB global names (from global_name),
  recipients VARCHAR2 := 'a5o9d2a6a6k4i9x2@neteteam.slack.com' -- #pardi-notifications  
)
--
-- Sets up a newly created job:
-- * Sets logging_level=dbms_scheduler.logging_full
-- * Adds an enviroment-specific email notification
-- If a job has been already set up you should call dbms_scheduler.remove_job_email_notification(job) first
--
IS
  subject VARCHAR2(128);
BEGIN
  dbms_scheduler.set_attribute (job, 'logging_level', dbms_scheduler.logging_full);

  -- Email notifications
  -- COALESCE() is smart enough to short-circuit evaluation here
  subject := '(' || COALESCE(environment, env()) || ') Oracle job %job_name%: %event_type%';
  debug('Setting up email notification for ' || job || ' to go to ' || recipients || ' (Subj: ' || subject || ') ...') ;
  dbms_scheduler.add_job_email_notification (job, events => onEvents, recipients => recipients, subject => subject);
END;
/
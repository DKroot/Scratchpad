CREATE OR REPLACE PROCEDURE korobskd.drop_mv_if_exists(
    mv_name IN VARCHAR2)
---
--  Graceful dropping of a materialized view.
--  Retries up to 5 minutes on ORA-04021: "timeout occurred while waiting to lock object"
---
IS
  mv_does_not_exist EXCEPTION;
  PRAGMA EXCEPTION_INIT(mv_does_not_exist, -12003) ;
  lock_timeout EXCEPTION;
  PRAGMA EXCEPTION_INIT(lock_timeout, -4021) ;
  start_time TIMESTAMP; -- DATE would work incorrectly for the comparison with an INTERVAL
BEGIN
  start_time := CURRENT_TIMESTAMP;
  LOOP
    BEGIN
      EXECUTE IMMEDIATE 'DROP MATERIALIZED VIEW ' || mv_name;
      EXIT;
    EXCEPTION
      WHEN mv_does_not_exist THEN
        debug('MV `' || mv_name || '` does not exist');
        EXIT;
      WHEN lock_timeout THEN
        debug('Lock timeout');
        IF CURRENT_TIMESTAMP - start_time > INTERVAL '5' MINUTE THEN
          debug('Gave up after 5 minutes of trying');
          RAISE;
        END IF;
      WHEN OTHERS THEN
        RAISE;
    END;
  END LOOP;
END;
/
\set ON_ERROR_STOP on
\set ECHO all

--@formatter:off
DO $block$
DECLARE
  MAX_ATTEMPTS CONSTANT integer = 3;
BEGIN --
  FOR attempt IN 1..MAX_ATTEMPTS LOOP
    BEGIN
--       RAISE 'Test exception';
      UPDATE foreign_irdb.stg_pie_appls
      SET admin_phs_org_code = 'DK'
      WHERE appl_id = 123;
      RETURN;
    EXCEPTION
      WHEN OTHERS THEN
        RAISE WARNING E'Attempt #%. ERROR #%: %', attempt, SQLSTATE, SQLERRM;
    END;
  END LOOP;
  RAISE 'Exceeded the maximum number of attempts';
END $block$;
--@formatter:on
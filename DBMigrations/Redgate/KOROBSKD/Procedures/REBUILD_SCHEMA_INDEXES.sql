CREATE OR REPLACE PROCEDURE korobskd.rebuild_schema_indexes(stop_on_error IN BOOLEAN := FALSE)
/*
* For tables (excluding temporary tables): rebuilds *all* indexes in the current schema OFFLINE.
* (ONLINE rebuild requires extra privileges and an Enterprise Edition)
*
* For MVs: rebuild *unusable* indexes OFFLINE
* (Other MV indexes get rebuilt, re-created or automatically updated during MV refreshes)
*/
IS
  first_err_code_ NUMBER := NULL;
  first_err_msg_ VARCHAR2(32767) := NULl;
  err_msg_ VARCHAR2(32767) := NULl;
BEGIN
  -- Rebuild normal and domain indexes on all non-temporary tables
  FOR cur IN
  (SELECT ui.index_name, ui.status,
    MIN(uo.object_type) AS entity_type -- 'MATERIALIZED VIEW' if MV or 'TABLE`
  FROM user_indexes ui
  JOIN user_objects uo
  ON ui.table_name = uo.object_name
  WHERE ui.index_type IN ('NORMAL', 'DOMAIN')
  AND ui.index_name NOT LIKE 'DR$%' AND ui.index_name NOT LIKE 'DRC$%'
  AND ui.temporary = 'N'
  GROUP BY ui.index_name, ui.status
  ORDER BY ui.index_name
  )
  LOOP
    IF cur.entity_type = 'TABLE' OR cur.status <> 'VALID' THEN
      debug('Rebuilding ' || cur.status || ' index ' || cur.index_name || ' of a ' || cur.entity_type || '...') ;
      BEGIN
        EXECUTE IMMEDIATE 'ALTER INDEX ' || cur.index_name || ' REBUILD';
      EXCEPTION WHEN OTHERS THEN
        -- Error processing: catch errors and proceed with other indexes
        err_msg_ := chr(10) || 'Error while rebuilding index ' || cur.index_name || chr(10) || SQLERRM;
        IF first_err_code_ IS NULL THEN
          first_err_code_ := SQLCODE;
          first_err_msg_ := err_msg_;
        END IF;

        DBMS_OUTPUT.PUT_LINE (err_msg_);
        DBMS_OUTPUT.PUT_LINE (DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);

        IF stop_on_error THEN
          RAISE;
        END IF;
      END;
    ELSE
      debug('Skipping ' || cur.status || ' index ' || cur.index_name || ' of a ' || cur.entity_type || '...') ;
    END IF;
  END LOOP;

  IF first_err_code_ IS NOT NULL THEN
    RAISE_APPLICATION_ERROR(-20000, first_err_msg_);
  END IF;
END;
/
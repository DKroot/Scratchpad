CREATE OR REPLACE PROCEDURE korobskd.rebuild_unusable_indexes(
    entityName IN VARCHAR2)
/*
Rebuilds *unusable* indexes of one entity OFFLINE.
Doing this ONLINE requires extra privileges and Enterprise Edition.
To rebuild *all* (non-unique) indexes execure disable_indexes() first.
*/
IS
BEGIN
  FOR cur IN
  (SELECT index_name
  FROM user_indexes
  WHERE status = 'UNUSABLE'
  AND table_name = UPPER(entityName)
  ORDER BY index_name
  )
  LOOP
    debug('Rebuilding index ' || cur.index_name || '...') ;
    EXECUTE IMMEDIATE 'ALTER INDEX ' || cur.index_name || ' REBUILD';
  END LOOP;
END;
/
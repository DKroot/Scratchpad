CREATE OR REPLACE PROCEDURE korobskd.drop_schema_tmp_mvs
/*
* Drops all TMP% and TEMP% MVs in the schema
*/
IS
BEGIN
  FOR cur IN
  (
  SELECT object_name, status
  FROM user_objects
  WHERE object_type = 'MATERIALIZED VIEW'
  AND (object_name LIKE '%TMP%' OR object_name LIKE '%TEMP%')
  ORDER BY object_name
  )
  LOOP
    debug('Dropping ' || cur.object_name || ' MV ...') ;
    EXECUTE IMMEDIATE 'DROP MATERIALIZED VIEW ' || cur.object_name;
  END LOOP;
END;
/
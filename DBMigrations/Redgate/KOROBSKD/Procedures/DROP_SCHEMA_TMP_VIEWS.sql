CREATE OR REPLACE PROCEDURE korobskd.drop_schema_tmp_views
/*
* Drops all TMP% and TEMP% Views in the schema
*/
IS
BEGIN
  FOR cur IN
  (
  SELECT object_name, status
  FROM user_objects
  WHERE object_type = 'VIEW'
  AND (object_name LIKE '%TMP%' OR object_name LIKE '%TEMP%')
  ORDER BY object_name
  )
  LOOP
    debug('Dropping ' || cur.object_name || ' view ...') ;
    EXECUTE IMMEDIATE 'DROP VIEW ' || cur.object_name;
  END LOOP;
END;
/
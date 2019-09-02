CREATE OR REPLACE PROCEDURE korobskd.disable_indexes(
    a_table IN VARCHAR2,
    skip_index IN VARCHAR2 := '*NONE*')
--
-- Disable (make unusable) all non-unique indexes of a table or MV
--
IS
BEGIN
  FOR cur IN
  (SELECT index_name
   FROM user_indexes
   WHERE status = 'VALID'
     -- DML statements terminate with an error if there are any unusable indexes for UNIQUE constraints
     AND uniqueness = 'NONUNIQUE'
     AND table_name = UPPER(a_table)
     AND index_name <> UPPER(skip_index)
   ORDER BY table_name, index_name
  )
  LOOP
    debug('Disabling index ' || cur.index_name || ' ...') ;
    EXECUTE IMMEDIATE 'ALTER INDEX ' || cur.index_name || ' UNUSABLE';
  END LOOP;
END;
/
CREATE OR REPLACE PROCEDURE korobskd.copy_privileges(
  from_user IN VARCHAR2,
  to_user IN VARCHAR2)
--
-- Grants the same privileges to to_user as from_user has
--
AS
  q VARCHAR2(32767);
BEGIN
  FOR cur IN
  (SELECT table_name, privilege
   FROM all_tab_privs
   WHERE grantee = UPPER(from_user)
   ORDER BY table_name
  )
  LOOP
    q := 'GRANT ' || cur.privilege || ' ON ' || cur.table_name || ' TO ' || to_user;
    debug('Executing ' || q);
    EXECUTE IMMEDIATE q;
  END LOOP;
END;
/
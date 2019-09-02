CREATE OR REPLACE PROCEDURE korobskd.drop_constraint_if_exists(
    tableName IN VARCHAR2, constraintName IN VARCHAR2 := NULL)
---
--  Graceful dropping of a constraint with CASCADE. Defaults to a table_name || '_PK'.
---
IS
  nonexistent_constraint EXCEPTION;
  droppedConstraint VARCHAR2(30) := coalesce(constraintName, tableName || '_PK');
  ddl VARCHAR2(100) := 'ALTER TABLE ' || tableName || ' DROP CONSTRAINT ' || droppedConstraint || ' CASCADE';
PRAGMA EXCEPTION_INIT(nonexistent_constraint, -2443);
BEGIN
  debug('Attempting `' || ddl || ';`');
  EXECUTE IMMEDIATE ddl;
  debug('Completed');
EXCEPTION WHEN nonexistent_constraint THEN
    NULL;
END;
/
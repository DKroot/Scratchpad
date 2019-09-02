CREATE OR REPLACE PROCEDURE korobskd.create_domain_indexes(
  entityName IN VARCHAR2,
  columnList IN VARCHAR2)
--
-- Creates domain indexes with a custom preference for each column separately.
-- Indexes are created using {table abbreviation}_{column}_ctx naming convention.
--
IS
  MaxIndexNameLength CONSTANT BINARY_INTEGER := 25;

  entityNameComponents string_list := SPLIT(entityName, '_');
  entityAbbreviation VARCHAR2(30) := '';
  indexedColumns string_list;
  indexName VARCHAR2(30);
  indexClause VARCHAR2(32767);
  firstErrCode NUMBER := NULL;
  firstErrMsg VARCHAR2(32767) := NULL;
  errMsg VARCHAR2(32767) := NULL;
BEGIN
  FOR i IN entityNameComponents.FIRST..entityNameComponents.LAST LOOP
    entityAbbreviation := entityAbbreviation || SUBSTR(entityNameComponents(i), 1, 1);
  END LOOP;

  indexedColumns := SPLIT(columnList, ',');
  FOR i IN indexedColumns.FIRST..indexedColumns.LAST LOOP
    -- Temporary workaround for index dictionary corruption problem: vary index name by created date
    indexName := SUBSTR(entityAbbreviation || '_' || indexedColumns(i) || '_' || TO_CHAR(SYSDATE, 'DDHH24') || '_ci', 1, MaxIndexNameLength);
    indexClause := indexName || ' ON ' || entityName || '(' || indexedColumns(i) || ')';
    debug('Creating domain index ' || indexClause || ' ...');
    BEGIN
      EXECUTE IMMEDIATE 'CREATE INDEX ' || indexClause || q'[
        INDEXTYPE IS ctxsys.context
        PARAMETERS('FILTER ctxsys.null_filter WORDLIST wildcard_pref')
      ]';
      /*
      TODO This needs to be done in conjunction with minimum term length limit (2-3 at least).

      EXECUTE IMMEDIATE 'CREATE INDEX ' || indexClause || q'[
        INDEXTYPE IS ctxsys.context
        PARAMETERS('FILTER ctxsys.null_filter WORDLIST ireport_wordlist STOPLIST ctxsys.empty_stoplist')
      ]';
      */
    EXCEPTION WHEN OTHERS THEN
      -- Error processing: catch errors and proceed with other indexes
      errMsg := chr(10) || SQLERRM;
      IF firstErrCode IS NULL THEN
        firstErrCode := SQLCODE;
        firstErrMsg := errMsg;
      END IF;

      DBMS_OUTPUT.PUT_LINE (errMsg);
      DBMS_OUTPUT.PUT_LINE (DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);
    END;
  END LOOP;

  IF firstErrCode IS NOT NULL THEN
    RAISE_APPLICATION_ERROR(-20000, firstErrMsg);
  END IF;
END;
/
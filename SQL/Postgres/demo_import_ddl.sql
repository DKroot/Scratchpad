\set ON_ERROR_STOP on
\set ECHO all

CREATE TABLE IF NOT EXISTS tmp_demo_import (
  wos_uid  VARCHAR(30) NOT NULL PRIMARY KEY,
  pmid     VARCHAR(30),
  pmid_int INTEGER
);

CREATE OR REPLACE FUNCTION trg_extract_pmid_int()
  RETURNS TRIGGER AS $block$
--@formatter:off
BEGIN
  NEW.pmid_int := cast(substring(NEW.pmid from 'MEDLINE:(.*)') AS INTEGER);
  RETURN NEW;
END; $block$ LANGUAGE plpgsql;
--@formatter:on

DROP TRIGGER IF EXISTS trg_tmp_demo_copy_upsert
ON tmp_demo_import;

CREATE TRIGGER trg_tmp_demo_copy_upsert
  BEFORE INSERT OR UPDATE OF pmid
  ON tmp_demo_import
  FOR EACH ROW EXECUTE PROCEDURE trg_extract_pmid_int();
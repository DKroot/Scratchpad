CREATE TABLE korobskd.ned_masked_data (
  "OWNER" VARCHAR2(128 BYTE) NOT NULL,
  table_name VARCHAR2(128 BYTE) NOT NULL,
  column_name VARCHAR2(128 BYTE) NOT NULL,
  row_filter_sql VARCHAR2(4000 BYTE),
  format_name VARCHAR2(128 BYTE),
  null_percentage NUMBER(4,1) DEFAULT 10 NOT NULL CHECK (null_percentage BETWEEN 0 AND 100),
  row_set_num NUMBER(5) DEFAULT 1 NOT NULL,
  CONSTRAINT nmd_format_name_fk FOREIGN KEY (format_name) REFERENCES korobskd.ned_masked_data_formats (format_name) DEFERRABLE INITIALLY DEFERRED
);
COMMENT ON TABLE korobskd.ned_masked_data IS 'Data to be masked. Encrypted columns are masked by default if not present in this data.';
COMMENT ON COLUMN korobskd.ned_masked_data."OWNER" IS 'Entity owner schema';
COMMENT ON COLUMN korobskd.ned_masked_data.table_name IS 'Updatable entity';
COMMENT ON COLUMN korobskd.ned_masked_data.column_name IS 'Masked column in an updatable entity';
COMMENT ON COLUMN korobskd.ned_masked_data.row_filter_sql IS 'Row set filter condition, usable in a SQL WHERE clause of an UPDATE {table_name} masking query';
COMMENT ON COLUMN korobskd.ned_masked_data.null_percentage IS 'Percentage of values randomly set to NULL. Ignored for NOT NULL columns.';
COMMENT ON COLUMN korobskd.ned_masked_data.row_set_num IS 'Row set sequential number per a column: 1..n';
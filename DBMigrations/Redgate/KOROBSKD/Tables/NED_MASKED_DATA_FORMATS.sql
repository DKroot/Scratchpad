CREATE TABLE korobskd.ned_masked_data_formats (
  format_name VARCHAR2(128 BYTE) NOT NULL,
  "PATTERN" VARCHAR2(4000 BYTE),
  description VARCHAR2(4000 BYTE),
  CONSTRAINT ned_masked_data_formats_pk PRIMARY KEY (format_name)
);
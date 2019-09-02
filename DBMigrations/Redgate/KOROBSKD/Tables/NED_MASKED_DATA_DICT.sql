CREATE TABLE korobskd.ned_masked_data_dict (
  domain_name VARCHAR2(128 BYTE) DEFAULT 'US_CITY' NOT NULL,
  "VALUE" VARCHAR2(4000 BYTE) NOT NULL,
  CONSTRAINT ned_masked_data_dict_pk PRIMARY KEY (domain_name,"VALUE")
);
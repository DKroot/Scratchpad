CREATE TABLE korobskd.ned_identity (
  identity_id NUMBER NOT NULL,
  id_type_cd VARCHAR2(10 BYTE) NOT NULL,
  id_value VARCHAR2(100 BYTE),
  effective_start_date DATE NOT NULL,
  effective_end_date DATE,
  last_update_date DATE NOT NULL,
  last_update_user NUMBER NOT NULL
);
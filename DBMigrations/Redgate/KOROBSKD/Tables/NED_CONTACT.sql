CREATE TABLE korobskd.ned_contact (
  contact_id NUMBER NOT NULL,
  contact_type_cd VARCHAR2(20 BYTE) NOT NULL,
  contact_value VARCHAR2(500 BYTE),
  effective_start_date DATE NOT NULL,
  effective_end_date DATE,
  last_update_date DATE NOT NULL,
  last_update_user NUMBER NOT NULL
);
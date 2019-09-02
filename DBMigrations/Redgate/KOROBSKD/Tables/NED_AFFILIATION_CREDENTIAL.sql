CREATE TABLE korobskd.ned_affiliation_credential (
  credential_id NUMBER NOT NULL,
  credential_type_cd VARCHAR2(3 BYTE) NOT NULL,
  affiliation_id NUMBER NOT NULL,
  credential_status_cd VARCHAR2(10 BYTE) NOT NULL,
  badge_num NVARCHAR2(30),
  credential_physical_loc VARCHAR2(50 BYTE),
  badge_title_id NUMBER,
  effective_start_date DATE NOT NULL,
  effective_end_date DATE,
  last_update_user NUMBER NOT NULL,
  last_update_date DATE NOT NULL
);
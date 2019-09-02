CREATE TABLE korobskd.ned_person_name (
  person_name_id NUMBER NOT NULL,
  person_id NUMBER NOT NULL,
  name_type_cd VARCHAR2(10 BYTE) NOT NULL,
  surname VARCHAR2(100 BYTE),
  middle_name VARCHAR2(50 BYTE),
  given_name VARCHAR2(50 BYTE),
  surname_upper VARCHAR2(100 BYTE),
  middle_name_upper VARCHAR2(50 BYTE),
  given_name_upper VARCHAR2(50 BYTE),
  generation_qualifier_cd VARCHAR2(10 BYTE),
  qualification_suffix VARCHAR2(100 BYTE),
  personal_title VARCHAR2(10 BYTE),
  effective_start_date DATE NOT NULL,
  effective_end_date DATE,
  last_update_date DATE NOT NULL,
  last_update_user NUMBER NOT NULL
);
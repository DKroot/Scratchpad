CREATE TABLE korobskd.ned_affil_emerg_tier_desig (
  emerg_tier_desig_id NUMBER NOT NULL,
  affiliation_id NUMBER NOT NULL,
  emerg_tier_desig_type_cd VARCHAR2(10 BYTE),
  effective_start_date DATE NOT NULL,
  effective_end_date DATE,
  last_update_date DATE NOT NULL,
  last_update_user NUMBER NOT NULL
);
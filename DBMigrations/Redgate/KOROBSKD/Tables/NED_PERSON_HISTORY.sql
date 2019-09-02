CREATE TABLE korobskd.ned_person_history (
  history_id NUMBER NOT NULL,
  person_id NUMBER NOT NULL,
  gender VARCHAR2(5 BYTE),
  date_of_birth DATE,
  state_of_birth VARCHAR2(100 BYTE),
  city_of_birth VARCHAR2(100 BYTE),
  person_create_date DATE NOT NULL,
  person_create_id NUMBER NOT NULL,
  last_update_date DATE NOT NULL,
  last_update_user NUMBER NOT NULL,
  history_date DATE NOT NULL,
  date_entered_us DATE
);
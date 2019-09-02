CREATE TABLE korobskd.ned_address (
  ned_address_id NUMBER NOT NULL,
  address_line_1 VARCHAR2(200 BYTE),
  address_line_2 VARCHAR2(200 BYTE),
  address_line_3 VARCHAR2(200 BYTE),
  city_name VARCHAR2(200 BYTE),
  province_cd VARCHAR2(10 BYTE),
  state_cd VARCHAR2(2 BYTE),
  country_cd VARCHAR2(2 BYTE),
  postal_cd VARCHAR2(20 BYTE),
  full_address VARCHAR2(3900 BYTE),
  last_update_date DATE NOT NULL,
  last_update_user NUMBER NOT NULL
);
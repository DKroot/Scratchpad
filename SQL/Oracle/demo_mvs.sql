CREATE TABLE tmp_demo_mv
(
  date_time DATE
);

CREATE MATERIALIZED VIEW tmp_demo_mv
ON PREBUILT TABLE
AS
SELECT SYSDATE AS date_time
FROM DUAL;

CALL r_mv_in_place ('tmp_demo_mv');

-- ORA-12083: must use DROP MATERIALIZED VIEW to drop "LINK_OD_IREPORT"."tmp_demo_mv"
DROP TABLE tmp_demo_mv;

DROP MATERIALIZED VIEW tmp_demo_mv;
DROP TABLE tmp_demo_mv;

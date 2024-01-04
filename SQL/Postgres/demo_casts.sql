SELECT cast(TRUE AS INTEGER) AS true_int, cast(FALSE AS INTEGER) AS false_int;

SELECT CASE WHEN 'foo' IS NOT NULL THEN TRUE ELSE FALSE END AS true_bool,
  CASE WHEN NULL IS NOT NULL THEN TRUE ELSE FALSE END AS false_bool;

SELECT ('foo' IS NOT NULL) AS true_bool, (NULL IS NOT NULL) AS false_bool;

SELECT cast('42' AS INTEGER) AS number, cast(NULL AS INTEGER) AS null_int, cast(nullif('', '') AS INTEGER) AS blank_int;














































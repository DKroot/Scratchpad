CALL debug(CASE WHEN regexp_substr('foo', '<.+?>') IS NULL THEN 'NULL' ELSE 'NOT NULL' END);

CALL debug(regexp_substr('<GIVEN_NAME>.<SURNAME>@nih.gov', '<.+?>'));

-- ## Clean Duplicates: v2 ##

-- No duplicates: works
CALL debug(regexp_replace('CA174523', '([^,]+)(,\1)+', '\1'));

-- 2 duplicates: works
CALL debug(regexp_replace('CA174523,CA174523', '([^,]+)(,\1)+', '\1'));

-- 3 duplicates: works
CALL debug(regexp_replace('CA174523,CA174523,CA174523', '([^,]+)(,\1)+', '\1'));

-- 4 duplicates: works
CALL debug(regexp_replace('CA174523,CA174523,CA174523,CA174523', '([^,]+)(,\1)+', '\1'));

-- 5 duplicates: works
CALL debug(regexp_replace('CA174523,CA174523,CA174523,CA174523,CA174523', '([^,]+)(,\1)+', '\1'));

-- 2 duplicates in the middle: works
CALL debug(regexp_replace('foo,CA174523,CA174523,bar', '([^,]+)(,\1)+', '\1'));

-- 3 duplicates in the middle: works
CALL debug(regexp_replace('foo,CA174523,CA174523,CA174523,bar', '([^,]+)(,\1)+', '\1'));

-- 4 duplicates in the middle: works
CALL debug(regexp_replace('foo,CA174523,CA174523,CA174523,CA174523,bar', '([^,]+)(,\1)+', '\1'));

-- ## Clean Duplicates: Buggy v1 ##

-- No duplicates: works
CALL debug(regexp_replace('CA174523', '(^|,)(.+)(,\2)+', '\1\2'));

-- 2 duplicates: works
CALL debug(regexp_replace('CA174523,CA174523', '(^|,)(.+)(,\2)+', '\1\2'));

-- 3 duplicates: works
CALL debug(regexp_replace('CA174523,CA174523,CA174523', '(^|,)(.+)(,\2)+', '\1\2'));

-- 4 duplicates: *does not work*
CALL debug(regexp_replace('CA174523,CA174523,CA174523,CA174523', '(^|,)(.+)(,\2)+', '\1\2'));

-- 5 duplicates: *does not work*
CALL debug(regexp_replace('CA174523,CA174523,CA174523,CA174523,CA174523', '(^|,)(.+)(,\2)+', '\1\2'));

-- 2 duplicates in the middle: works
CALL debug(regexp_replace('foo,CA174523,CA174523,bar', '(^|,)(.+)(,\2)+', '\1\2'));

-- 3 duplicates in the middle: works
CALL debug(regexp_replace('foo,CA174523,CA174523,CA174523,bar', '(^|,)(.+)(,\2)+', '\1\2'));

-- 4 duplicates in the middle: *does not work*
CALL debug(regexp_replace('foo,CA174523,CA174523,CA174523,CA174523,bar', '(^|,)(.+)(,\2)+', '\1\2'));

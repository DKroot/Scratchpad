:ON ERROR EXIT

-- Inline param
PRINT concat('`', '${string_foo}', '`' + iif('${string_foo}' = '', ' is blank', ' is not blank'));
PRINT concat('datalength()=', datalength('${string_foo}'));

-- Variable assignment
DECLARE @foo VARCHAR(MAX) = trim('${string_foo}');
PRINT concat('`', @foo, '`' + iif(@foo = '', ' is blank', ' is not blank'));
PRINT concat('datalength()=', datalength(@foo));
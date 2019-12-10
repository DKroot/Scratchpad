SELECT patindex('%[^0-9]%.%', 'Some version string v1.2.3');

SELECT patindex('%[^0-9]%', '');

SELECT patindex('%[^0-9.)]%', 'v1.2.3] ');

SELECT patindex('%[^0-9.)]%', '2.3] ');

-- Opening bracket is OK to use in a set
SELECT patindex('%[^0-9.)[]%', '2.3[ ');
-- 5

-- Closing bracket can't be escaped
SELECT patindex('%[^]0-9.)]%', '2.3] ');
SELECT patindex('%[^]]0-9.)]%', '2.3] ');
SELECT patindex('%[^\]0-9.)]%', '2.3] ');

-- Closing bracket can be temporarily substituted: assumes no '}' characters
SELECT patindex('%[^}0-9.)]%', REPLACE('2.3] ', ']', '}'));
-- 5

-- Substituting closing bracket wih a random non-latin char
SELECT patindex(N'%[^π0-9.)]%', REPLACE('2.3] ', ']', N'π'));
-- 5
WITH data
AS
(
SELECT 'a' AS s, 1 AS n, TO_DATE('01 Jan 2001') AS d
FROM DUAL
UNION ALL
SELECT 'f' AS s, 42 AS n, TO_DATE('29 Oct 1969') AS d
FROM DUAL
UNION ALL
SELECT 'foo' AS s, 30 AS n, TO_DATE('12 Apr 1961') AS d
FROM DUAL
UNION ALL
SELECT 'bar' AS s, 99 AS n, TO_DATE('20 Jul 1969') AS d
FROM DUAL
UNION ALL
SELECT 'baz' AS s, 12 AS n, TO_DATE('04 Oct 1957') AS d
FROM DUAL
UNION ALL
SELECT 'z' AS s, 21 AS n, TO_DATE('18 Mar 1965') AS d
FROM DUAL
)
SELECT data.*, NLSSORT(s), RAWTOHEX(NLSSORT(s))
FROM data
-- ORDER BY NLSSORT(s) -- regular sort
-- ORDER BY NLSSORT(s, 'NLS_SORT = BINARY') -- regular sort
-- ORDER BY NLSSORT(s, 'NLS_SORT = UCA0620_DUCET') -- regular sort

-- ORDER BY n -- regular numeric sort
-- ORDER BY -n -- reverse numeric sort

-- ORDER BY d -- regular date sort
ORDER BY TO_DATE('29 Oct 1969') - d -- reverse date sort
; 

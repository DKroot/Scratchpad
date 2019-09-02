SELECT patindex('%[^0-9]%.%', 'Some version string v1.2.3');

SELECT patindex('%[^0-9]%', '');
DECLARE
  year INT := EXTRACT(YEAR FROM SYSDATE);  
BEGIN
  CASE 
    WHEN year IN (2015, 2016, 2017) THEN
      dbms_output.put_line(year);
    WHEN year IN (2018, 2022, 2026) THEN
      dbms_output.put_line('It''s The World Cup year!');
    ELSE
      dbms_output.put_line('?');
  END CASE;
END;
/

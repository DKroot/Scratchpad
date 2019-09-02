-- Right
DECLARE
  start_time TIMESTAMP;
  end_time TIMESTAMP;
BEGIN 
  start_time := TO_TIMESTAMP('01-Apr-2016');
  DBMS_OUTPUT.PUT_LINE(TO_CHAR(start_time, 'YYYY-MM-DD HH24:MI:SS'));
  end_time := TO_TIMESTAMP('06-May-2016'); -- CURRENT_TIMESTAMP;
  DBMS_OUTPUT.PUT_LINE(TO_CHAR(end_time, 'YYYY-MM-DD HH24:MI:SS'));
  DBMS_OUTPUT.PUT_LINE(end_time - start_time);
  IF end_time - start_time > INTERVAL '60' DAY THEN
    DBMS_OUTPUT.PUT_LINE('delta > interval');
  ELSE
    DBMS_OUTPUT.PUT_LINE('delta <= interval');
  END IF;
END;
/

-- Right
DECLARE
  start_time DATE;
  end_time DATE;
BEGIN 
  start_time := TO_DATE('01-Apr-2016');
  DBMS_OUTPUT.PUT_LINE(TO_CHAR(start_time, 'YYYY-MM-DD HH24:MI:SS'));
  end_time := TO_DATE('06-May-2016'); -- CURRENT_DATE;
  DBMS_OUTPUT.PUT_LINE(TO_CHAR(end_time, 'YYYY-MM-DD HH24:MI:SS'));
  DBMS_OUTPUT.PUT_LINE(end_time - start_time);
  DBMS_OUTPUT.PUT_LINE(NUMTODSINTERVAL(end_time - start_time, 'DAY'));
  IF NUMTODSINTERVAL(CURRENT_DATE - start_time, 'DAY') > INTERVAL '60' DAY THEN
    DBMS_OUTPUT.PUT_LINE('delta > interval');
  ELSE
    DBMS_OUTPUT.PUT_LINE('delta <= interval');
  END IF;
END;
/

-- *WROBG*
DECLARE
  start_time DATE;
  end_time DATE;
BEGIN 
  start_time := TO_DATE('1 Apr 2016');
  debug(TO_CHAR(start_time, 'YYYY-MM-DD HH24:MI:SS'));
  end_time := CURRENT_DATE;
  debug(TO_CHAR(end_time, 'YYYY-MM-DD HH24:MI:SS'));
  debug(end_time - start_time);
  debug(NUMTODSINTERVAL(end_time - start_time, 'DAY'));
  IF end_time - start_time > INTERVAL '60' DAY THEN
    debug('delta > interval');
  ELSE
    debug('delta <= interval');
  END IF;
END;
/

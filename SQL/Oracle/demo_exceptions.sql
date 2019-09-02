WHENEVER SQLERROR EXIT FAILURE
WHENEVER OSERROR EXIT FAILURE
SET SERVEROUTPUT ON
SET ECHO ON

DECLARE
  CustomErrorCode CONSTANT INT := -20000;
BEGIN
  debug('Starting...');
  raise_application_error(CustomErrorCode, utl_lms.format_message('Error caused by `%s`', 'foo'));
  debug('Done.');
END;
/

-- ORA-01403: no data found
DECLARE
  pattern VARCHAR2(32767) := '<FOO>';
  result VARCHAR2(32767) := pattern;
  includedFormat  VARCHAR2(130);-- ned_masked_data_formats.format_name%TYPE + 2
  includedPattern ned_masked_data_formats.pattern%TYPE;
BEGIN
  includedFormat := regexp_substr(result, '<.+?>');
  SELECT pattern
  INTO includedPattern
  FROM ned_masked_data_formats
  WHERE format_name = substr(includedFormat, 2, length(includedFormat) - 2);
  dbms_output.put_line(includedPattern);
END;
/

-- ORA-01476: divisor is equal to zero
CREATE OR REPLACE PROCEDURE tmp_demo_exception
AS
  result VARCHAR2(32767);
BEGIN
  dbms_output.put_line('tmp_demo_exception>');
  result := to_char(1 / 0);
  dbms_output.put_line(result);
  dbms_output.put_line('Done.');
END;
/

-- ORA-01476: divisor is equal to zero
CREATE OR REPLACE PROCEDURE tmp_demo_exception
AS
  result VARCHAR2(32767);
BEGIN
  dbms_output.put_line('tmp_demo_exception>');
  SELECT to_char(1 / 0)
  INTO result
  FROM dual;
  dbms_output.put_line(result);
  dbms_output.put_line('Done.');
END;
/

-- "Swallowed" NO_DATA_FOUND error
CREATE OR REPLACE PROCEDURE tmp_demo_exception
AS
  result VARCHAR2(30);
BEGIN
  dbms_output.put_line('tmp_demo_exception>');
  dbms_output.put_line('SELECT');

  SELECT table_name
  INTO result
  FROM user_tables
  WHERE tablespace_name = 'FOO';

  dbms_output.put_line('Selected.');
  dbms_output.put_line(result);
END;
/

-- No data found error propagated
CREATE OR REPLACE PROCEDURE tmp_demo_exception
AS
  pattern VARCHAR2(32767) := '<FOO>';
  result VARCHAR2(32767) := pattern;
  includedFormat  VARCHAR2(130);-- ned_masked_data_formats.format_name%TYPE + 2
  includedPattern ned_masked_data_formats.pattern%TYPE;
BEGIN
  dbms_output.put_line('tmp_demo_exception>');
  includedFormat := regexp_substr(result, '<.+?>');
  dbms_output.put_line('SELECT');
  SELECT pattern
  INTO includedPattern
  FROM ned_masked_data_formats
  WHERE format_name = substr(includedFormat, 2, length(includedFormat) - 2);
  dbms_output.put_line('Selected.');
  dbms_output.put_line(includedPattern);
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    RAISE_APPLICATION_ERROR(-20000, SQLERRM);
END;
/

-- "Swallowed" NO_DATA_FOUND error
CREATE OR REPLACE FUNCTION tmp_demo_exception_f
RETURN VARCHAR2
AS
  result VARCHAR2(30) := 'bar';
BEGIN
  SELECT table_name
  INTO result
  FROM user_tables
  WHERE tablespace_name = 'FOO';

  RETURN result;
END;
/

-- No data found error propagated
CREATE OR REPLACE FUNCTION tmp_demo_exception_f
RETURN VARCHAR2
AS
  result VARCHAR2(30);
BEGIN
  SELECT table_name
  INTO result
  FROM user_tables
  WHERE tablespace_name = 'FOO';

  RETURN result;
EXCEPTION
  WHEN OTHERS THEN
    RAISE_APPLICATION_ERROR(-20000, SQLERRM);
END;
/

CALL tmp_demo_exception();

SELECT tmp_demo_exception_f
FROM dual;

CALL dbms_output.put_line(tmp_demo_exception_f);

EXIT


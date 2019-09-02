/*
Demo of script execution exiting on the first error
*/

WHENEVER SQLERROR EXIT FAILURE
-- SET SERVEROUTPUT ON

EXEC dbms_output.put_line('Starting...');
EXEC dbms_output.put_line('Error here:' ||  1 / 0);
EXEC dbms_output.put_line('You should not see this line.');

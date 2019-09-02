-- ## SQLcl autoexec script ##

WHENEVER SQLERROR EXIT FAILURE
WHENEVER OSERROR EXIT FAILURE

SET TERMOUT OFF
SET SQLPROMPT '_USER@_CONNECT_IDENTIFIER> '

-- Displays the current time before each command prompt
SET TIME ON

-- Sets the total number of characters displayed on one line
SET LINESIZE 128

-- Controls whether to display the output (that is, DBMS_OUTPUT PUT_LINE) of stored procedures or PL/SQL blocks
SET SERVEROUTPUT ON

-- Sets the automatic printing of bind variables
SET AUTOPRINT ON

-- Whether to trim trailing blanks at the end of each spooled line
SET TRIMSPOOL ON

-- Sets the number of rows to fetch from the database at one time
SET ARRAYSIZE 1000

-- The ansiconsole option formats and resizes data according to the column widths, for easier readability
SET SQLFORMAT ansiconsole

cd /Users/DK/Cloud/Scripts/Oracle

-- Controls whether the START command lists each command in a script as the command is executed
SET ECHO ON

SET TERMOUT ON
SPOOL /tmp/oracle.log
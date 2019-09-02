@echo off
setlocal
set ERA_HOME=c:\CVS\enterprise

set CLASSPATH=.
if not "!CLASSPATH!"=="." (
  echo.
  echo ERROR: The DelayedExpansion option of CMD must be enabled.
  echo Either
  echo   1. start CMD.EXE with /V option or 
  echo   2. make HKEY_LOCAL_MACHINE or HKEY_CURRENT_USER \Software\Microsoft\Command Processor\DelayedExpansion = 0x1
  echo.
  exit /b
)
rem Put %ERA_HOME%\lib\*.jar on the CLASSPATH
for %%j in ("%ERA_HOME%\lib\*.jar") do (
  rem Exclude Ant system libraries - they will be taken from %ANT_HOME%\lib
  set EXCLUDE=N
  for %%e in (ant.jar optional.jar xercesImpl.jar xml-apis.jar) do if "%%j"=="%ERA_HOME%\lib\%%e" set EXCLUDE=Y
  
  if "!EXCLUDE!"=="N" set CLASSPATH=!CLASSPATH!;%%j
)  

rem echo.
rem echo CLASSPATH = %CLASSPATH%
rem echo.

call ant -f "%ERA_HOME%\build2.xml" %*
endlocal

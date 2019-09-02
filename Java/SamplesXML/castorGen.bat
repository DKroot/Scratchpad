@echo off
set _CP=.;%CLASSPATH%
if not "!_CP!"==".;%CLASSPATH%" (
  echo.
  echo ERROR: The DelayedExpansion option of CMD must be enabled.
  echo Either
  echo   1. start CMD.EXE with /V option or
  echo   2. make HKEY_LOCAL_MACHINE or HKEY_CURRENT_USER \Software\Microsoft\Command Processor\DelayedExpansion = 0x1
  echo.
  exit /b
)

for %%j in (lib\*.jar) do (
  set _CP=!_CP!;%%j
)

java -classpath %_CP% org.exolab.castor.builder.SourceGenerator %*

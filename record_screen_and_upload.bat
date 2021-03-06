@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  Record startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and RECORD_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set JARFILE=%APP_HOME%\record\record-and-upload-capsule.jar
set PARAM_CONFIG_FILE=--config %APP_HOME%\config\credentials.config
set PARAM_STORE_DIR=--store %APP_HOME%\record\localstore
set PARAM_SOURCECODE_DIR=--sourcecode %APP_HOME%

for /f "tokens=3" %%g in ('%JAVA_EXE% -version 2^>^&1 ^| findstr /i "version"') do (
    set JAVA_FULL_VERSION=%%g
)
set JAVA_FULL_VERSION=%JAVA_FULL_VERSION:"=%

for /f "delims=. tokens=1-3" %%v in ("%JAVA_FULL_VERSION%") do (
    set JAVA_VERSION=%%v
)

if "%JAVA_VERSION%" LSS "9" (
   echo "---> Pre-Java 9 detected <---"
   echo "Using DEFAULT_JVM_OPTS variable with value '%DEFAULT_JVM_OPTS%'"
) else (
   echo "---> Java 9 or higher detected (Java version %JAVA_VERSION%) <---"
   set DEFAULT_JVM_OPTS=--illegal-access=warn --add-modules=java.xml.bind,java.activation %DEFAULT_JVM_OPTS%
   echo "Adding JVM args to the DEFAULT_JVM_OPTS variable, new value set to '%DEFAULT_JVM_OPTS%'"
   echo "--------------------------------------------------------------------------------------------------------------"
)

@rem Execute Record
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %RECORD_OPTS% -jar "%JARFILE%" %PARAM_CONFIG_FILE% %PARAM_STORE_DIR% %PARAM_SOURCECODE_DIR% %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable RECORD_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%RECORD_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega

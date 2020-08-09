@echo off
echo.
echo [info]clean maven local failed package
echo.
pause
echo.

set REPOSITORY_PATH=D:\mvn-repo
rem searching~~~
for /f "delims=" %%i in ('dir /b /s "%REPOSITORY_PATH%\*lastUpdated*"') do (
    del /s /q %%i
)
rem 搜索完毕

pause
@echo off
echo.
echo [info] Spring code format
echo.
pause
echo.

cd %~dp0
cd..

for /D %%s in (*) do (
    call mvn spring-javaformat:apply -f %%s
)

pause
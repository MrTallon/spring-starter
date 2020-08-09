@echo off
echo.
echo [info] deploy project to warehouse
echo [warring] please try again
echo.
pause
echo.

cd %~dp0
cd..

for /D %%s in (*) do (
    call mvn install -f %%s
)

pause
echo off
setlocal
For /F "tokens=1* delims==" %%A IN (program.properties) DO (
    IF "%%A"=="version" set lversion=%%B
    IF "%%A"=="program" set lprogram=%%B
    IF "%%A"=="kod"     set lkod=%%B 
)

echo update programy set wersja = %lversion% where kod_prog = %lkod% | isql -u sysdba -p masterbartek '192.168.121.7:/home/sysom/sysomdb.fdb'
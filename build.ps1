param(
    [string]$RunClass
)

Write-Host "== Verificando java =="
java -version 2>&1 | ForEach-Object { Write-Host $_ }

Write-Host "== Compilando *.java -> out/ =="
if (-not (Test-Path -Path out)) { New-Item -ItemType Directory -Path out | Out-Null }
javac -d out *.java

if ($LASTEXITCODE -ne 0) {
    Write-Error "La compilación falló. Revisa los errores anteriores."
    exit $LASTEXITCODE
}

if ($RunClass) {
    Write-Host "== Ejecutando $RunClass =="
    java -cp out $RunClass
} else {
    Write-Host "Compilación completada. Para ejecutar una clase con main, llama: .\build.ps1 -RunClass NombreDeLaClaseConMain"
}

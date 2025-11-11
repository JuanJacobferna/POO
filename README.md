```markdown
# POO
```

## Uso y compilación (Java 21)

Este proyecto contiene clases Java sueltas. He actualizado el entorno para usar Java 21 y añadido un `pom.xml` para facilitar builds con Maven.

Pasos rápidos para comprobar y compilar en Windows (PowerShell):

1. Verificar la versión de Java activa:

```powershell
java -version
javac -version
```

2. Compilar con javac y generar clases en `out`:

```powershell
mkdir -Force out; javac -d out *.java
```

3. Ejecutar una clase con `main` (ejemplo: `Main`):

```powershell
java -cp out NombreDeLaClaseConMain
```

4. (Opcional) Usar Maven si prefieres packaging:

```powershell
mvn -v
mvn package
```

5. Script rápido incluido:

```powershell
.\build.ps1
```

Si quieres que haga el ajuste de JAVA_HOME a nivel máquina (todos los usuarios), dímelo y lo intento (requiere permisos de Administrador).
# POO
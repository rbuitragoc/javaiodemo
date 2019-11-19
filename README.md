## javaiodemo

#### Descargar Maven (ZIP)

- https://maven.apache.org/download.cgi

#### Instalación de Maven (Windows)

- https://www-us.apache.org/dist/maven/maven-3/3.6.2/binaries/apache-maven-3.6.2-bin.zip

- Verificar el valor de variable de entorno: `echo %JAVA_HOME%` (debe ser mayor a 1.7)

- Añadir a `PATH` (para poder usarlo en linea de comando)


#### Descargar Gradle (ZIP)

- https://gradle.org/next-steps/?version=6.0.1&format=bin

#### Instalacion de Gradle (windows)

- Microsoft Windows users
  Create a new directory C:\Gradle with File Explorer.
  
- In File Explorer right-click on the This PC (or Computer) icon, then click Properties -> Advanced System Settings -> Environmental Variables.

- Under System Variables select Path, then click Edit. Add an entry for C:\Gradle\gradle-6.0.1\bin. Click OK to save.

- Open a console (or a Windows command prompt) and run gradle -v to run gradle and display the version, e.g.:

```bash
$ gradle -v

------------------------------------------------------------
Gradle 6.0.1
------------------------------------------------------------
```
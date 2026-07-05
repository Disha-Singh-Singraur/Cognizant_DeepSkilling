@echo off
setlocal
set "DIR=%~dp0"
set "MAVEN_HOME=%DIR%.mvn\apache-maven-3.9.6"

if not exist "%MAVEN_HOME%\bin\mvn.cmd" (
    echo =======================================================
    echo  Maven not detected. Downloading Maven 3.9.6 locally...
    echo =======================================================
    powershell -Command "New-Item -ItemType Directory -Force -Path '%DIR%.mvn' | Out-Null; Write-Host 'Downloading Maven zip...'; Invoke-WebRequest -Uri 'https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip' -OutFile '%DIR%.mvn\maven.zip'; Write-Host 'Extracting Maven...'; Expand-Archive -Path '%DIR%.mvn\maven.zip' -DestinationPath '%DIR%.mvn'; Write-Host 'Cleaning up zip file...'; Remove-Item -Path '%DIR%.mvn\maven.zip'"
    echo =======================================================
    echo  Maven setup completed successfully!
    echo =======================================================
)

"%MAVEN_HOME%\bin\mvn.cmd" %*

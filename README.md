# selenium-google-search

This project is a minimal Selenium test using JUnit and WebDriverManager.

Upgrading Java runtime to Java 21

Requirements
- Java 21 JDK installed and available on PATH or via JAVA_HOME
- Maven 3.8+ (recommended)

How to run tests

Open a terminal (PowerShell) and run:

```powershell
mvn -v
mvn test -DskipTests=false
```

If Maven enforcer fails, ensure JAVA_HOME is set to a Java 21 JDK and that `java -version` reports Java 21.

Notes
- The POM sets the compiler release to 21 and enforces at least Java 21.
- WebDriverManager is used to download the appropriate ChromeDriver automatically.

## Descripción

Proyecto de automatización de pruebas funcionales para la aplicación web **OrangeHRM** (https://opensource-demo.orangehrmlive.com/), desarrollado como parte de un portafolio de **QA Automation**.

El proyecto utiliza Selenium WebDriver, Java, Cucumber, JUnit, Maven, el patrón Page Object Model (POM) y con PageFactory.

El objetivo es automatizar escenarios funcionales aplicando buenas prácticas de automatización, separación de responsabilidades y reutilización de componentes.

## Tecnologías y versiones

| Tecnología | Versión |
|---|---|
| Java | 21.0.9 |
| Selenium WebDriver | 4.9.0 |
| Cucumber | 7.12.0 |
| JUnit | 4.13.2 |
| Maven | 2.22.0 |
| GitHub | 5.9.2 |

## Herramientas utilizadas

- Eclipse IDE 2026-03 (4.39.0)
- Java JDK 21
- Maven
- Selenium WebDriver
- Cucumber
- JUnit
- GitHub
- Page Object Model (POM)
- PageFactory

## Instrucciones de ejecución

Para ejecutar las pruebas automatizadas:

1. Abrir el proyecto en Eclipse.
2. Dirigirse a la clase TestRunnerOrange.java ubicada en:

src/test/java/TestRunner/TestRunnerOrange.java

3. Hacer clic derecho sobre TestRunnerOrange.java.
4. Seleccionar: **Run As → JUnit Test**
5. Cucumber ejecutará los escenarios definidos en:

src/test/resources/Features/OrangeEmployee.feature

## Reportes

Una vez finalizada la ejecución, los reportes se generan automáticamente en las siguientes carpetas:

- target/HtmlReports
- target/JSONReports
- target/XMLReports

## Estructura del proyecto

```text
CucumberJava/
│
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── TestRunner/
│   │   │   │   └── TestRunnerOrange.java
│   │   │   ├── StepsDefinitions/
│   │   │   │   └── OrangeEmployeeSteps_PageFactory.java
│   │   │   └── pageFactory/
│   │   │       ├── LoginOrangePage_PageFactory.java
│   │   │       ├── HomeOrangePage_PageFactory.java
│   │   │       ├── EmployeeDetallePage_PageFactory.java
│   │   │       ├── EmployeePage_PageFactory.java
│   │   │       └── ListEmployeePage_PageFactory.java
│   │   └── resources/
│   │       ├── Features/
│   │       │   └── OrangeEmployee.feature
│   │       └── Files/
│   │           ├── imprimir.pdf
│               └── imprimir2.pdf
├── pom.xml
└── README.md
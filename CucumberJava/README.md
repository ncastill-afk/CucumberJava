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

## Estructura del proyecto

```text
CucumberJava/
│
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── TestRunner/
│   │   │   │   └── TestRunnerOrangePageFactory.java
│   │   │   ├── StepsDefinitions/
│   │   │   │   └── OrangeEmployeeSteps_PageFactory.java
│   │   │   └── pageFactory/
│   │   │       ├── LoginOrangePage_PageFactory.java
│   │   │       ├── HomeOrangePage_PageFactory.java
│   │   │       └── EmployeeDetallePage_PageFactory.java
│   │   │       └── EmployeePage_PageFactory.java
│   │   │       └── ListEmployeePage_PageFactory.java
│   │   └── resources/
│   │       └── Features/
│   │           └── OrangeEmployee.feature
│
├── pom.xml
└── README.md
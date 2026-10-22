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

## Funcionalidades automatizadas

El proyecto incluye pruebas funcionales automatizadas sobre la aplicación OrangeHRM.

- **Inicio de sesión:** acceso a la aplicación con credenciales válidas.
- **Gestión de empleados:** registro de un nuevo empleado mediante el módulo PIM.
- **Datos personales:** ingreso y validación de información del empleado.
- **Adjuntar archivos:** carga de documentos PDF y edición de información del archivo adjunto.
- **Búsqueda de empleados:** localización de empleados mediante su identificador y apellido.
- **Cierre de sesión:** finalización de la sesión del usuario.
- **Pruebas negativas de login:** validación del comportamiento de la aplicación cuando se ingresan credenciales incorrectas, si este escenario está implementado.

## Diseño y buenas prácticas

El proyecto aplica el patrón **Page Object Model (POM)** utilizando PageFactory para organizar los elementos y las acciones de las páginas web.

Las principales prácticas utilizadas son:

- **Separación de responsabilidades:** las interacciones con la página se encuentran en las clases PageFactory y las validaciones de los escenarios se realizan en los Step Definitions.
- **Reutilización de código:** los métodos permiten reutilizar acciones comunes, como iniciar sesión, guardar información y buscar empleados.
- **Localizadores de elementos:** uso de selectores CSS y XPath para identificar los componentes de la interfaz.
- **Esperas explícitas:** utilización de WebDriverWait y ExpectedConditions para esperar las condiciones necesarias antes de interactuar con los elementos.
- **Datos de prueba:** uso de archivos JSON para administrar los datos de los empleados.
- **Reportes de ejecución:** generación de reportes HTML, JSON y XML para revisar los resultados de las pruebas.

## Organización de las pruebas

Las pruebas se definen en archivos Feature utilizando Cucumber y se implementan mediante Step Definitions en Java.

- **Feature:** describe los escenarios de prueba en un lenguaje legible.
- **Step Definitions:** relaciona los pasos de Gherkin con los métodos Java.
- **PageFactory:** centraliza los localizadores y las acciones de cada página.
- **TestRunner:** permite ejecutar los escenarios mediante Cucumber y JUnit.

## Datos y archivos de prueba

Los datos de prueba se administran mediante archivos JSON.

Los documentos utilizados para las pruebas de carga de archivos se encuentran en:

src/test/resources/Files/

- imprimir.pdf
- imprimir2.pdf

Esta organización permite mantener los archivos de prueba dentro del proyecto y evitar depender de rutas locales específicas de cada computador.

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
├── target/
│   ├── HtmlReports/HtmlReport.html
│   ├── JSONReports/JSONReport.json
│   ├── XMLReports/XMLReport.xml
│   └── cucumber.json
├── pom.xml
└── README.md
```

## Requisitos previos

Antes de ejecutar el proyecto, se recomienda contar con:

- Java JDK instalado y configurado.
- Eclipse IDE.
- Maven y las dependencias del proyecto configuradas en pom.xml.
- Google Chrome instalado, si el Runner utiliza ChromeDriver.
- Acceso a Internet para ingresar al sitio de demostración OrangeHRM.

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

- target/HtmlReports/HtmlReport.html
- target/JSONReports/JSONReport.json
- target/XMLReports/XMLReport.xml

## Alcance del proyecto

Este proyecto tiene fines educativos y de portafolio profesional. Permite demostrar conocimientos de automatización de pruebas funcionales con Java, Selenium WebDriver, Cucumber y JUnit, junto con la aplicación del patrón Page Object Model y la organización de datos de prueba.

La ejecución depende de la disponibilidad del sitio público de demostración OrangeHRM y de que sus elementos e interfaz se mantengan compatibles con los localizadores utilizados en las pruebas.
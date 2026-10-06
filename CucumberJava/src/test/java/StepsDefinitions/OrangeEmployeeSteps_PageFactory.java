package StepsDefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.HomeOrangePage_PageFactory;
import pageFactory.LoginOrangePage_PageFactory;
import utils.Employee;
import utils.JsonReader;
import utils.JsonWriter;
import pageFactory.EmployeePage_PageFactory;
import pageFactory.EmployeeDetallePage_PageFactory;
import pageFactory.ListEmployeePage_PageFactory;

public class OrangeEmployeeSteps_PageFactory {
	WebDriver driver=null;
	
	//Referimos metodos de Page factory
	LoginOrangePage_PageFactory login;
	//Referimos el metodos de Home HomePage factory
	HomeOrangePage_PageFactory home;
	EmployeePage_PageFactory employee;
	EmployeeDetallePage_PageFactory employeeDetalle;
	ListEmployeePage_PageFactory employeeList;
	
	@Given("que el navegador está abierto")
	public void que_el_navegador_esta_abierto() {
		System.out.println("Inside Step - que el navegador está abierto");
		WebDriverManager.chromedriver().setup();
	    ChromeOptions options= new ChromeOptions();
		options.addArguments("--incognito");
		/*WebDriverManager.edgedriver().setup();

		EdgeOptions options = new EdgeOptions();

		options.addArguments("--inprivate");*/
		options.addArguments("enable-automation");
		options.addArguments("--disable-gov");
	    driver= new ChromeDriver(options);
		//driver = new EdgeDriver(options);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    driver.manage().window().maximize();
	}

	@And("el usuario está en la página de login")
	public void el_usuario_esta_en_pagina_de_login() {
		System.out.println("Inside Step - el usuario está en la página de login");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");	
	}

	@When("el usuario ingresa {word} y {word}")
	public void el_usuario_ingresa_username_y_password(String username, String password) {
		System.out.println("Inside Step - el usuario ingresa username and password");
		login= new LoginOrangePage_PageFactory(driver);
		login.ingresoOrange(username, password);
	}
	
	@And("el usuario inicia sesión")
	public void el_usuario_inicia_sesion() {
		System.out.println("Inside Step - el usuario inicia sesión");
		//Damos click en boton submit
		login.clickOnSubmit();
		home= new HomeOrangePage_PageFactory(driver);
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		assertTrue("❌ La página Dashboard no cargó", home.validarHome());
	}
	
	@And("el usuario selecciona agregar empleado e ingresa los datos básicos")
	public void el_usuario_selecciona_agregar_empleado_e_ingresa_los_datos_basicos() {
		System.out.println("Inside Step - el usuario selecciona agregar empleado e ingresa los datos básicos");
		employee = new EmployeePage_PageFactory(driver);
		
		Employee emp = JsonReader.getEmployee("usuario1");

		employee.ingresarMenuPIM();
		assertTrue("❌ La página Add Employee no cargó", employee.ingresarAddEmployee());
		employee.ingresarPrimerNombre(emp);
	    employee.ingresarMedioNombre(emp);
	    employee.ingresarApellido(emp);

	    String employeeId = employee.obtenerEmployeeId();
	    JsonWriter.actualizarEmployeeId("usuario1", employeeId);

	    if (emp.switchEmployee.equalsIgnoreCase("true")) {
	        employee.clickEnSwitch();
	        employee.ingresarUsername(emp);
	        employee.ingresarPassword1(emp);
	        employee.ingresarPassword2(emp);
	    }

	    employee.clickEnGuardar();

	    assertTrue("❌ Employee no fue guardado", employee.mensajeExitoso());

	}

	@And("el usuario ingresa los datos detallados")
	public void el_usuario_ingresa_los_datos_detallados() {
		System.out.println("Inside Step - el usuario ingresa los datos detallados");
		employeeDetalle = new EmployeeDetallePage_PageFactory(driver);
		employeeDetalle.paginaDetallesCargados();
		Employee emp = JsonReader.getEmployee("usuario1");
		
		assertTrue("❌ La página Personal Details no cargó", employeeDetalle.paginaDetallesCargados());
		assertEquals("❌ First Name incorrecto", emp.primerNombre, employeeDetalle.validarPrimerNombre());
		assertEquals("❌ Middle Name incorrecto", emp.medioNombre, employeeDetalle.validarNombreMedio());
	    assertEquals("❌ Last Name incorrecto", emp.apellido, employeeDetalle.validarApellido());
	    assertEquals("❌ Employee ID incorrecto", emp.id, employeeDetalle.validarEmployeeId());
				
		employeeDetalle.completarPersonalDetails(emp);
		assertTrue("❌ No se guardaron los detalles", employeeDetalle.guardarPersonalDetails(emp));
		assertTrue("❌ No se guardó el archivo adjunto", employeeDetalle.adjuntarArchivo(emp));
		assertTrue("❌ No se guardó el archivo adjunto", employeeDetalle.editarAdjunto(emp) );
	}
	
	@And("el usuario busca el empleado recién ingresado")
	public void el_usuario_busca_el_empleado_recien_ingresado() {
		System.out.println("Inside Step - el usuario busca el empleado recién ingresado");
		employeeList = new ListEmployeePage_PageFactory(driver);
		Employee emp = JsonReader.getEmployee("usuario1");
		employeeList.clickBtnEmployeeList();

	    assertTrue("❌ La página Employee List no cargó", employeeList.despliegueListEmployee());

	    employeeList.enviarId(emp);
	    employeeList.enviarApellido(emp);
	    employeeList.clickBuscar();

	    assertTrue("❌ Employee no encontrado", employeeList.validarEmployee(emp));
	    employeeList.seleccionarEmpleado(emp);
	    assertTrue("❌ Página detalle empleado no cargada", employeeDetalle.paginaDetallesCargados());
	}

	@And("el usuario intenta iniciar sesión")
	public void el_usuario_intenta_iniciar_sesion() {
	    login.clickOnSubmit();
	}
	
	@Then("debería mostrarse un mensaje de credenciales inválidas")
	public void deberia_mostrarse_un_mensaje_de_credenciales_invalidas() {
	    String mensaje = login.obtenerMensajeError();
	    assertTrue("❌ No se mostró el mensaje de credenciales inválidas", mensaje.contains("Invalid credentials"));
	}
	
	@Then("el usuario cierra sesión")
	public void el_usuario_cierra_sesion() {
		System.out.println("Inside Step - el usuario cierra sesión");
		home.salir();
		driver.quit();
	}


}

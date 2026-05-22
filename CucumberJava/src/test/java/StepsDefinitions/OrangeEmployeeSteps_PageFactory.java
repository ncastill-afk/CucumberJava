package StepsDefinitions;

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
	
	@Given("navegador esta abierto")
	public void navegador_esta_abierto() {
		//Imprimimo en pantalla
		System.out.println("***Inside OrangeEmployeeSteps_PageFactory.class");
		
		System.out.println("Inside Step - navegador esta abierto");
		WebDriverManager.chromedriver().setup();
	    ChromeOptions options= new ChromeOptions();
		System.out.println("1.4");
		options.addArguments("--incognito");
		/*WebDriverManager.edgedriver().setup();

		EdgeOptions options = new EdgeOptions();

		options.addArguments("--inprivate");*/
		System.out.println("1.5");
		//options.addArguments("--remote-allow-origins=*");
		options.addArguments("enable-automation");
		System.out.println("1.6");
		options.addArguments("--disable-gov");
		System.out.println("1.7");
	    driver= new ChromeDriver(options);
		//driver = new EdgeDriver(options);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    driver.manage().window().maximize();
	}

	@And("user está en login page")
	public void user_está_en_login_page() {
		System.out.println("Inside Step - user está en login page");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");	
	}

	@When("^user ingresa (.*) and (.*)$")
	public void user_ingresa_username_and_password(String username, String password) {
		System.out.println("Inside Step - user ingresa username and password");
		
		//Hacemos la referencia a loginPage
		login= new LoginOrangePage_PageFactory(driver);
		
		//Escribimos el username
		login.enterUsername(username);
		//Escribimos el password
		login.enterPassword(password);
		//driver.findElement(By.id("username")).sendKeys(username);
		//driver.findElement(By.id("password")).sendKeys(password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@And("user se loguea")
	public void user_se_loguea() {
		System.out.println("Inside Step - user se loguea");
		//Damos click en boton submit
		login.clickOnSubmit();
		//driver.findElement(By.id("submit")).click();
		home= new HomeOrangePage_PageFactory(driver);
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		home.validarHome();
		System.out.println("Inside Step - después de validar Home");

	}
	
	@And("user choose add employee e ingresa datos basicos")
	public void user_choose_add_employee_e_ingresa_datos_basicos() {
		System.out.println("Inside Step - user choose add employee e ingresa datos basicos");
		employee = new EmployeePage_PageFactory(driver);
		
		Employee emp = JsonReader.getEmployee("usuario1");
		employee.addEmployee(emp);
		

	}

	@And("user ingresa datos con detalle")
	public void user_ingresa_datos_con_detalle() {
		System.out.println("Inside Step - user ingresa datos con detalle");
		employeeDetalle = new EmployeeDetallePage_PageFactory(driver);
		employeeDetalle.paginaDetallesCargados();
		Employee emp = JsonReader.getEmployee("usuario1");
		employeeDetalle.validarDatosEmpleado(emp);
		employeeDetalle.completarPersonalDetails(emp);
		employeeDetalle.adjuntarArchivo(emp);
		employeeDetalle.editarAdjunto(emp);
		
	}
	
	@And("user busca el empleado recien ingresado")
	public void user_busca_el_empleado_recien_ingresado() {
		System.out.println("Inside Step - user busca el empleado recien ingresado");
		employeeList = new ListEmployeePage_PageFactory(driver);
		Employee emp = JsonReader.getEmployee("usuario1");
		employeeList.revisarEmployee(emp);
	}

	@Then("user do logout")
	public void user_do_logout() {
		System.out.println("Inside Step - user do logout");
		home.salir();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.close();
		//driver.quit();
	}


}

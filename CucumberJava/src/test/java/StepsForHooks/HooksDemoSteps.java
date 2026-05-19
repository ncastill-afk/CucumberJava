package StepsForHooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

	

	public class HooksDemoSteps {
	
	//Declaramos la variable driver
	WebDriver driver=null;
	
	//Agregamos etiqueta de antes, esto pasara antes de cada escenario
	@Before(value="@smoke", order=1)
	//Metodo vacio para inicializar el navegador
	public void browserSetup() {
		//Imprimimos en consola que la automatización esta  dentro de la inicialización del navegador
		System.out.println("Automation inside browser Setup");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		System.out.println("1.4");
		options.addArguments("--incognito");
		System.out.println("1.5");
		//options.addArguments("--remote-allow-origins=*");
		options.addArguments("enable-automation");
		System.out.println("1.6");
		options.addArguments("--disable-gov");
		System.out.println("1.7");
	    driver= new ChromeDriver(options);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    driver.manage().window().maximize();
	    
	}

	//Agregamos un metodo de setup 2 e indicamos el orden, se ejecuta antes que el setup 1
	@Before(order=0)
	//Metodo vacio de setup 2
	public void setup2() {
		//Imprimimmos en consola que la automatizacion esta dentro del setup 2
		System.out.println("Automation inside setup2");
	}
	
	//Agregamos etiqueta de antes, esto pasara antes de cada escenario
	@After(order=1)
	//Metodo vacio para terminar el caso de prueba
	public void teardown() {
		//Imprimimos en consola que la automatización esta  dentro de la finalización
		System.out.println("Automation inside teardown");
		//Cerramos las pestañas del navegador
		driver.close();
		
		//Terminamos todas las instancias del driver
		driver.quit();
	}
	
	//Etiqueta de despues con roden 0 se ejecuta antes que el teardown 1
	@After(order=0)
	//Metodo vacio para finalizacion de driver #2
	public void teardown2() {
		//Imprimmimos en pantalla dentro de finalizacion 2
		System.out.println("Automation inside teardown 2");
	}
	//Agregamos etiqueta "antes de paso" 
	@BeforeStep
	//Metodo vacio para ejecutar antes de pasos
	public void beforeSteps() {
		//Imprimimos en consola que estamos dentro del metodo antes de los pasos
		System.out.println("I'm inside before steps *******");
	}
	
	//Agregamos etiqueta "despues de paso" 
	@AfterStep
	//Metodo vacio para ejecutar despues de pasos
	public void afterSteps() {
		//Imprimimos en consola que estamos dentro del metodo antes de los pasos
		System.out.println("I'm inside after steps *******");
	}
	
	
	//Dado que el usuario está en la pagina de login
	@Given("user is on login page2")
	//Metodo usuario esta en la pagina de login
	public void user_is_on_login_page2() {
		//Imprimimos Dentro del paso -  usuario esta en la pagina login
	    System.out.println("Inside Step - user is o login page");
	}
	
	//Cuando el usuario ingresa nombre de usuario y contraseña validos
	@When("user enters valid username and password")
	//Metodo usuario ingresa nombre de usuario y contraseña
	public void user_enters_valid_username_and_password() {
		//Imprimimos Dentro del paso -  usuario esta en la pagina login
		System.out.println("Inside Step - user_enters_valid_username_and_password");
	}
	//Y da click en el boton login
	@When("clicks on login button")
	//Metodo da click en el boton login
	public void clicks_on_login_button() {
		//Imprimimos del del paso - da click en el boton login
		System.out.println("Inside Step - clicks on login button");
	}
	//Entonces el usuario es navegado a la pagina de inicio
	@Then("user is navigated to the home page2")
	//Método usuario es navegado a la pagina de inicio
	public void user_is_navigated_to_the_home_page2() {
		//Imprimimos Dentro del paso - usuario es navegado a la pagina de inicio
		System.out.println("Inside Step - user is navigated to the home page");
	}


}

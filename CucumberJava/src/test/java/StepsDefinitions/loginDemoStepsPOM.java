package StepsDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.loginPage;

public class loginDemoStepsPOM {
/*
	WebDriver driver=null;
	loginPage login;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step - browser is open");
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

	@And("user is o login page")
	public void user_is_o_login_page() {
		
		System.out.println("Inside Step - user is o login page");
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		//Llamamos el objeto para hacer referencia al constructor de la clase "loginPage"
		login=new loginPage(driver);

	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		
		//Creamos un objeto para hacer referencia al constructor de la clase "loginPage"
		login=new loginPage(driver);
		
		//Mandamos a llamar al metodo para ingresar al usuario
		login.enterUsername(username);
		login.enterPassword(password);
		System.out.println("Inside Step - user enters username and password");
		//driver.findElement(By.id("username")).sendKeys(username);
		//driver.findElement(By.id("password")).sendKeys(password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@And("user clicks on login")
	public void user_clicks_on_login() {
		//Mandamos a llamar al metodo para dar click en login
		login.clickLogin();
		System.out.println("Inside Step - user is o login page");
		//driver.findElement(By.id("submit")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("Inside Step - user is navigated to the home page");
		//Validamos el texto de login successfully
		login.checkLoginSuccessfullyText();
		//driver.getPageSource().contains("Logged in successfully");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
	}

	*/
}

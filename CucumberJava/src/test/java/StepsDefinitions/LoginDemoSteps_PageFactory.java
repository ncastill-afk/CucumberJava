package StepsDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.HomePage_PageFactory;
import pageFactory.LoginPage_PageFactory;

public class LoginDemoSteps_PageFactory {

	WebDriver driver=null;
	
	//Referimos metodos de Page factory
	LoginPage_PageFactory login;
	//Referimos el metodos de Home HomePage factory
	HomePage_PageFactory home;
	
	@Given("browser is open")
	public void browser_is_open() {
		//Imprimimo en pantalla
		System.out.println("***Inside LoginDemoSteps_PageFactory.class");
		
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
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		System.out.println("Inside Step - user enters username and password");
		
		//Hacemos la referencia a loginPage
		login= new LoginPage_PageFactory(driver);
		
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
	
	@And("user clicks on login")
	public void user_clicks_on_login() {
		System.out.println("Inside Step - user is o login page");
		//Damos click en boton submit
		login.clickOnSubmit();
		//driver.findElement(By.id("submit")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("Inside Step - user is navigated to the home page");
		home.checkLoginSuccessfullyText();
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

	
}

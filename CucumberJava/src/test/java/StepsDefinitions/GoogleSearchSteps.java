package StepsDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {


	WebDriver driver=null;
	WebElement searchBox;
	
	@Given("browser is open for google")
	public void browser_is_open_for_google() {
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

	@Given("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("Inside Step - user is on google search page");
		driver.navigate().to("https://google.com");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		System.out.println("Inside Step - user enters a text in search box");
		//driver.findElement(By.name("q")).sendKeys("QA SDET Arquitecto Automátización Pruebas Software");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		searchBox = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.name("q"))
			);

			searchBox.sendKeys("QA SDET Arquitecto Automátización Pruebas Software");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@When("hits enter")
	public void hits_enter() {
		System.out.println("Inside Step - hits enter");
		searchBox.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		System.out.println("Inside Step - user is navigated to search results");
		driver.getPageSource().contains("QA SDET Arquitecto Automátización Pruebas Software");
		driver.close();
		driver.quit();
	}


}

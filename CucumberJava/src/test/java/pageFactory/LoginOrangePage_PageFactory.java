package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOrangePage_PageFactory {
	
	WebDriver driver;
	
	//Usamos @FindBy para guardar nuestro localizador de username
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement txt_username;
	
	//Usamos @FindBy para guardar nuestro localizador de password
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txt_password;
		
	@FindBy(css = "button[type='submit']")
	WebElement btn_submit;
	

	//Método constructor
	public LoginOrangePage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		//Inicializamos los elementos haciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}
		
	
	//Método para ingresar el username
	public void enterUsername(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txt_username));
		txt_username.sendKeys(username);
		//driver.findElement(txt_username).sendKeys(username);
	}
	
	//Método para ingresar el password
	public void enterPassword(String password) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		 wait.until(ExpectedConditions.visibilityOf(txt_password));

		 txt_password.sendKeys(password);
		//driver.findElement(txt_password).sendKeys(password);
	}
	
	//Método para dar click en el botón login
	public void clickOnSubmit() {
		btn_submit.click();
		//driver.findElement(btn_login).click();
	}

}

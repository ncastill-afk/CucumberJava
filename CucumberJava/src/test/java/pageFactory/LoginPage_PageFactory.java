package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PageFactory {
	
	WebDriver driver;
	
	//Usamos @FindBy para guardar nuestro localizador de username
	@FindBy(id="username")
	WebElement txt_username;
	
	//Usamos @FindBy para guardar nuestro localizador de password
	@FindBy(id="password")
	WebElement txt_password;
		
	//Usamos @FindBy para guardar nuestro localizador de username
	@FindBy(id="submit")
	WebElement btn_submit;
	
	//Localizador para el cuadro de texto usuario
	//By txt_username=By.id("username");
	
	//Localizador para el cuadro de texto password
	//By txt_password=By.id("password");
	
	//Localizador para el botón login
	//By btn_login=By.id("submit");
	
	//Método constructor
	public LoginPage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		//Inicializamos los elementos haciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}
		
	
	/*Creamos un método de tipo constructor para poder hacer la referencia a otras
	en otras clases, le ponemos el mismo nombre que la clase loginPage*/
/*	public void LoginPage_PageFactory(WebDriver driver) {
		//Hacemos referencia al mismo driver para poder llamar a este driver desde la clase "loginDemoSteps"
		this.driver=driver;
		//Inicializamos los elementos haciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}*/
	
	//Método para ingresar el username
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
		//driver.findElement(txt_username).sendKeys(username);
	}
	
	//Método para ingresar el password
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
		//driver.findElement(txt_password).sendKeys(password);
	}
	
	//Método para dar click en el botón login
	public void clickOnSubmit() {
		btn_submit.click();
		//driver.findElement(btn_login).click();
	}
	
	
	//Método para loguearse con un usuario y password
	/*public void loginValidUser(String username, String password) {
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(password);
		driver.findElement(btn_login).click();
	}*/
	
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	WebDriver driver;
	
	//Localizador para el cuadro de texto usuario
	By txt_username=By.id("username");
	
	//Localizador para el cuadro de texto password
	By txt_password=By.id("password");
	
	//Localizador para el botón login
	By btn_login=By.id("submit");
	
	//String para el texto "Logged In Successfully"
	String logout="Logged In Successfully";

	
	/*Creamos un método de tipo constructor para poder hacer la referencia a otras
	en otras clases, le ponemos el mismo nombre que la clase loginPage*/
	public loginPage(WebDriver driver) {
		/*Hacemos referencia al mismo driver para poder llamar a este driver
		desde la clase "loginDemoSteps"*/
		this.driver=driver;
	}
	
	//Método para ingresar el username
	public void enterUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	//Método para ingresar el password
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	//Método para dar click en el botón login
	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
	
	//Metodo para validar el text de login successfully
	public void checkLoginSuccessfullyText() {
		driver.getPageSource().contains(logout);
	}
	//Método para loguearse con un usuario y password
	public void loginValidUser(String username, String password) {
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(password);
		driver.findElement(btn_login).click();
	}
	
}

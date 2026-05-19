package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PageFactory {
	
	//String para el texto "Logged In Successfully"
	String logout="Logged In Successfully";
	WebDriver driver;
	
	//Metodo para validar el text de login successfully
	public void checkLoginSuccessfullyText() {
		driver.getPageSource().contains(logout);
	}
	
	public void HomePage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		//Inicializamos los elementos hacciendo referencia al mismo driver
		PageFactory.initElements(driver, HomePage_PageFactory.class);
	}

}

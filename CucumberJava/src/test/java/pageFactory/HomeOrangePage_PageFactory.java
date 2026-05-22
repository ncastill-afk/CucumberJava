package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeOrangePage_PageFactory {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	WebElement menuSalir;

	@FindBy(xpath = "//*[@role='menuitem' and text()='Logout']")
	WebElement logout;

	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement dashboardText;
	
	public void validarHome() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement orangeSite = wait.until(ExpectedConditions.visibilityOf(dashboardText));
	    assertTrue("❌ La página Orange no cargó", orangeSite.isDisplayed());
		System.out.println("Login exitoso");
	}
	
	//Metodo para validar el text de login successfully
	public void salir() {
		System.out.println("Inside Step - salir");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement menu = wait.until(
		        ExpectedConditions.elementToBeClickable(menuSalir)
		);
		menu.click();
		System.out.println("Después de menu.click()");
		WebElement btnLogout = wait.until(
			        ExpectedConditions.elementToBeClickable(logout)
		);
		btnLogout.click();
		System.out.println("Después de btnLogout.click()");
	}
	
	public HomeOrangePage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		//Inicializamos los elementos hacciendo referencia al mismo driver
		//PageFactory.initElements(driver, HomeOrangePage_PageFactory.class);
		PageFactory.initElements(driver, this);
	}

}

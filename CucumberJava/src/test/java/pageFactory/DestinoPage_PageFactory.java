package pageFactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DestinoPage_PageFactory {
	
	WebDriver driver;
	
	//Usamos @FindBy para guardar nuestro localizador de origen
	@FindBy(name="fromPort")
	WebElement txt_fromPort;
	
	//Usamos @FindBy para guardar nuestro localizador de destino
	@FindBy(name="toPort")
	WebElement txt_toPort;
		
	//Usamos @FindBy para guardar nuestro localizador del botón Find Flights
	@FindBy(css="input[type='submit']")
	WebElement btn_FindFlights;
	
	//Localizador para el cuadro de texto usuario
	//By txt_username=By.id("username");
	
	//Localizador para el cuadro de texto password
	//By txt_password=By.id("password");
	
	//Localizador para el botón login
	//By btn_login=By.id("submit");
	
	//Método constructor
	public DestinoPage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		//Inicializamos los elementos haciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}
		
	
	//Método para ingresar el origen
	public void seleccionaOrigen(String origen) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(txt_fromPort));
	    
		Select selectOrigen = new Select(txt_fromPort);
		selectOrigen.selectByVisibleText(origen);
		//driver.findElement(txt_username).sendKeys(username);
	}
	
	//Método para ingresar el destino
	public void seleccionarDestino(String destino) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(txt_toPort));
	    
		Select selectDestino = new Select(txt_toPort);
		selectDestino.selectByVisibleText(destino);
		//driver.findElement(txt_password).sendKeys(password);
	}
	
	//Método para dar click en el botón 
	public void clickOnSubmit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(btn_FindFlights));
	    
		btn_FindFlights.click();
		//driver.findElement(btn_login).click();
	}
		
}

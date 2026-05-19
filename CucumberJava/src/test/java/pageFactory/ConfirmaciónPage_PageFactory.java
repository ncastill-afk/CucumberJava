package pageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;


public class ConfirmaciónPage_PageFactory {
	
	
	//String para el texto "Flights from Paris to Buenos Aires:"
	String txt_confirmación;
	WebDriver driver;
	
	
	
	//Metodo para validar el text de login successfully
	public void checkConfirmaciónSuccessfullyText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		System.out.println("txt_confirmación: " + txt_confirmación);
		boolean textoPresente = wait.until(
		        ExpectedConditions.textToBePresentInElementLocated(
		            By.tagName("body"),
		            txt_confirmación
		        ));
        System.out.println("Texto encontrado: " + textoPresente);
        assertTrue("❌ El texto de confirmación no apareció", textoPresente);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			
	}
	
	public ConfirmaciónPage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		this.txt_confirmación="Thank you for your";
		//Inicializamos los elementos hacciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}

}

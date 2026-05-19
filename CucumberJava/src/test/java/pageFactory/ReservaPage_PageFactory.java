package pageFactory;

import static org.junit.Assert.assertTrue;

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


public class ReservaPage_PageFactory {
	
	//String origen;
	//String destino;
	//String para el texto "Flights from Paris to Buenos Aires:"
	String txt_reserva;
	WebDriver driver;
	
	//Usamos @FindBy para guardar nuestro localizador
	@FindBy(id="inputName")
	WebElement txt_name;
	
	//Usamos @FindBy para guardar nuestro localizador
	@FindBy(id="address")
	WebElement txt_address;
	
	//Usamos @FindBy para guardar nuestro localizador
	@FindBy(id="city")
	WebElement txt_city;
	
	//Usamos @FindBy para guardar nuestro localizador
	@FindBy(id="state")
	WebElement txt_state;
	
	//Usamos @FindBy para guardar nuestro localizador
	@FindBy(id="zipCode")
	WebElement txt_zipCode;

	//Usamos @FindBy para guardar nuestro localizador
	@FindBy(id="creditCardNumber")
	WebElement txt_creditCardNumber;

	//Usamos @FindBy para guardar nuestro localizador
	@FindBy(id="creditCardMonth")
	WebElement txt_creditCardMonth;

	//Usamos @FindBy para guardar nuestro localizador
	@FindBy(id="creditCardYear")
	WebElement txt_creditCardYear;
	
	//Usamos @FindBy para guardar nuestro localizador
	@FindBy(id="nameOnCard")
	WebElement txt_nameOnCard;
	
	//Usamos @FindBy para guardar nuestro localizador
	@FindBy(css="input[type='submit']")
	WebElement btn_comprarVuelo;
	
	
	//Metodo para validar el text de login successfully
	public void checkReservaSuccessfullyText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		System.out.println("txt_reserva: " + txt_reserva);
		boolean textoPresente = wait.until(
		        ExpectedConditions.textToBePresentInElementLocated(
		            By.tagName("body"),
		            txt_reserva
		        ));
        System.out.println("Texto encontrado: " + textoPresente);
        assertTrue("❌ El texto de reserva no apareció", textoPresente);
					
	}
	
	public void ingresarDatosFormulario(String nombre, String dirección, String ciudad, String estado, String codigoZip, String tipoTarjeta, String numeroTarjCred, String mesTarjCred, String añoTarjCred, String nombreTarj) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(txt_name));
	    txt_name.sendKeys(nombre.trim());
	    txt_address.sendKeys(dirección.trim());
	    txt_city.sendKeys(ciudad.trim());
	    txt_state.sendKeys(estado.trim());
	    txt_zipCode.sendKeys(codigoZip.trim());

	    // Select tarjeta
	    Select select = new Select(driver.findElement(By.id("cardType")));
	    String[] partes = tipoTarjeta.split("_");
	    String tipoTarjFormateado = partes[0] + " " + partes[1];
	    select.selectByVisibleText(tipoTarjFormateado);

	    txt_creditCardNumber.sendKeys(numeroTarjCred.trim());
	    txt_creditCardMonth.clear();
	    txt_creditCardMonth.sendKeys(mesTarjCred.trim());
	    txt_creditCardYear.clear();
	    txt_creditCardYear.sendKeys(añoTarjCred.trim());

	    txt_nameOnCard.sendKeys(nombreTarj.trim());

	    btn_comprarVuelo.click();
	    
	}
	
	public ReservaPage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		this.txt_reserva="Your flight from";
		//Inicializamos los elementos hacciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}

}

package pageFactory;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VuelosPage_PageFactory {
	
	String origen;
	String destino;
	//String para el texto "Flights from Paris to Buenos Aires:"
	String txt_vuelos;
	By tituloVuelos = By.xpath("//h3");
	WebDriver driver;
	/*By precios = By.name("price");
	List<WebElement> listaPrecios = driver.findElements(precios);*/
	
	
	//Metodo para validar el text de login successfully
	public void checkVuelosSuccessfullyText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement elemento = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(tituloVuelos)
		    );

	    String texto = elemento.getText();

	    System.out.println("Texto encontrado: " + texto);

	    assertTrue("❌ Texto incorrecto",
	        texto.contains(txt_vuelos));
		/*boolean textoPresente = wait.until(
		        ExpectedConditions.textToBePresentInElementLocated(
		            By.tagName("body"),
		            txt_vuelos
		        ));
        System.out.println("Texto encontrado: " + textoPresente);
        assertTrue("❌ El texto de reserva no apareció", textoPresente);*/
					
	}
	
	public void seleccionarVueloMasBarato() {
		System.out.println("seleccionarVueloMasBarato");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
	    
	    List<WebElement> filas = driver.findElements(By.xpath("//table/tbody/tr"));
	    System.out.println("filas: "+filas.size());
	    double precioMin = Double.MAX_VALUE;
	    WebElement botonMasBarato = null;

	    for (WebElement fila : filas) {

	        // columna 6 = precio
	        String textoPrecio = fila.findElement(By.xpath("./td[6]")).getText();
	        //System.out.println("textoPrecio: "+textoPrecio);
	        double precio = Double.parseDouble(textoPrecio.replace("$", "").trim());
	        //System.out.println("precio: "+precio);

	        if (precio < precioMin) {
	            precioMin = precio;
	            //System.out.println("precioMin: "+precioMin);
	            // columna 1 = botón "Choose This Flight"
	            botonMasBarato = fila.findElement(By.xpath("./td[1]//input"));
	            //System.out.println("botonMasBarato: "+botonMasBarato);
	        }
	    }

	    System.out.println("Precio más barato encontrado: " + precioMin);
	    
	    if (botonMasBarato != null) {
	        botonMasBarato.click();
	    } else {
	        throw new RuntimeException("No se encontró ningún vuelo");
	    }
	}
	
	public VuelosPage_PageFactory(WebDriver driver, String origen, String destino) {
		//Hacemos referencia al driver
		this.driver=driver;
		//System.out.println("Driver: " + driver);
		this.origen = origen.trim();
		System.out.println("Origen: " + origen);
		this.destino = destino.trim();
		System.out.println("Destino: " + destino);
		this.txt_vuelos = "Flights from " + origen + " to " + destino + ":";
		//System.out.println("this.txt_vuelos: " + this.txt_vuelos);
		//Inicializamos los elementos hacciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}

}

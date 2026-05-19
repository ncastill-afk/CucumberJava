package StepsDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.ConfirmaciónPage_PageFactory;
import pageFactory.DestinoPage_PageFactory;
import pageFactory.VuelosPage_PageFactory;
import pageFactory.ReservaPage_PageFactory;

public class AgenciaViajeSteps_PageFactory {
	
	WebDriver driver=null;
	String origen;
	String destino;
	String nombre;
	String dirección;
	String ciudad;
	String estado;
	String codigoZip;
	String tipoTarjeta;
	String numeroTarjCred;
	String mesTarjCred;
	String añoTarjCred;
	String nombreTarj;
	
	//Referimos metodos de Page factory
	DestinoPage_PageFactory origenDestino;
	VuelosPage_PageFactory vuelos;
	ReservaPage_PageFactory reserva;
	ConfirmaciónPage_PageFactory confirmación;
	
	@Given("navegador está abierto")
	public void navegador_está_abierto() {
		System.out.println("***Inside DestinoSteps_PageFactory.class");
		
		System.out.println("Inside Step - el navegador está abierto");
		WebDriverManager.chromedriver().setup();
	    ChromeOptions options= new ChromeOptions();
		System.out.println("1.4");
		options.addArguments("--incognito");
		System.out.println("1.5");
		//options.addArguments("--remote-allow-origins=*");
		options.addArguments("enable-automation");
		System.out.println("1.6");
		//options.addArguments("--disable-gov");
		//System.out.println("1.7");
	    driver= new ChromeDriver(options);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    driver.manage().window().maximize();

	}
	
	@And("se está en página de viaje")
	public void se_está_en_página_de_viaje() {
		System.out.println("Inside Step - página de viaje");
		driver.navigate().to("https://www.blazedemo.com/");	
	}
	
	@When("^se selecciona el (.*) and (.*)$")
	public void se_selecciona_el_origen_and_destino(String origen, String destino) {
		System.out.println("Inside Step - se selecciona el origen y destino");
		this.origen = origen;
	    this.destino = destino;
		origenDestino= new DestinoPage_PageFactory(driver);
		origenDestino.seleccionaOrigen(origen);
		origenDestino.seleccionarDestino(destino);
		
	}
	@And("se hace click para encontrar el vuelo")
	public void se_hace_click_para_encontrar_el_vuelo() {
		System.out.println("Inside Step - se hace click para encontrar el vuelo");
		origenDestino.clickOnSubmit();
	}
	@And("se carga la pagina de vuelos")
	public void se_carga_la_pagina_de_vuelos() {
		System.out.println("Inside Step - se carga la pagina de vuelos");
		System.out.println("Inside Step - Origen: "+origen);
		System.out.println("Inside Step - Destino: "+destino);
		vuelos= new VuelosPage_PageFactory(driver, origen, destino);
		//System.out.println("Vuelos: "+vuelos);
		vuelos.checkVuelosSuccessfullyText();
		System.out.println("Inside Step - checkVuelosSuccessfullyText");
		vuelos.seleccionarVueloMasBarato();
		System.out.println("Inside Step - seleccionarVueloMasBarato");
	}
	@And("^se carga la reserva (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*)$")
	public void se_carga_la_reserva(String nombre, String dirección, String ciudad, String estado, String codigoZip, String tipoTarjeta, String numeroTarjCred, String mesTarjCred, String añoTarjCred, String nombreTarj) {
		System.out.println("Inside Step - se carga la reserva");
		reserva= new ReservaPage_PageFactory(driver);
		reserva.checkReservaSuccessfullyText();
		reserva.ingresarDatosFormulario(nombre, dirección, ciudad, estado, codigoZip, tipoTarjeta, numeroTarjCred, mesTarjCred, añoTarjCred, nombreTarj);
		
	}
	@Then("se carga la confirmación")
	public void se_carga_la_confirmación() {
		System.out.println("Inside Step - se carga la confirmación");
		confirmación= new ConfirmaciónPage_PageFactory(driver);
		confirmación.checkConfirmaciónSuccessfullyText();
		
		driver.close();
		driver.quit();
		
	}


}

package pageFactory;

import java.time.Duration;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import utils.Employee;


public class EmployeeDetallePage_PageFactory {
	
	WebDriver driver;
	
	//@FindBy(xpath = "//h6[text()='Personal Details']")
	@FindBy(css = "h6.orangehrm-main-title")
	WebElement txtPersonalDetails;
	
	@FindBy(name = "firstName")
	WebElement txt_firstName;

	@FindBy(name = "middleName")
	WebElement txt_middleName;

	@FindBy(name = "lastName")
	WebElement txt_lastName;

	@FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	WebElement txt_employeeId;
	
	@FindBy(xpath = "//label[text()='Nickname']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txt_nickname;

	@FindBy(xpath = "//label[text()='Other Id']/following::input[1]")
	WebElement txt_otherId;

	@FindBy(xpath = "//label[normalize-space()=\"Driver's License Number\"]/following::input[1]")
	WebElement txt_licenseNumber;

	@FindBy(xpath = "//label[normalize-space()='License Expiry Date']/following::input[1]")
	WebElement txt_licenseExpiry;

	@FindBy(xpath = "//label[normalize-space()='Date of Birth']/following::input[1]")
	WebElement txt_birthDate;
	
	@FindBy(xpath = "//label[normalize-space()='Nationality']/following::div[contains(@class,'oxd-select-text')][1]")
	WebElement dropdownNationality;
	
	@FindBy(xpath = "//label[normalize-space()='Marital Status']/following::div[contains(@class,'oxd-select-text')][1]")
	WebElement dropdownMaritalStatus;
	
	@FindBy(xpath = "//label[normalize-space()='Female']")
	WebElement radioFemale;
	
	@FindBy(xpath = "//label[normalize-space()='Male']")
	WebElement radioMale;
	
	@FindBy(xpath = "//h6[normalize-space()='Personal Details']/following::button[normalize-space()='Save'][1]")
	WebElement btnSave;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement btnAddAttachment;
	
	@FindBy(xpath = "//input[@type='file']")
	WebElement inputFile;
	
	@FindBy(css = "textarea[placeholder='Type comment here']")
	WebElement txt_comment;
	
	@FindBy(xpath = "//h6[normalize-space()='Add Attachment']/following::button[normalize-space()='Save'][1]")
	WebElement btnSaveAttachment;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	//@FindBy(xpath = "//h6[normalize-space()='Edit Attachment']/following::button[normalize-space()='Save'][1]")
	WebElement tercerSave;
	
	@FindBy(xpath = "//div[contains(@class,'oxd-table-cell-actions')]//i[contains(@class,'bi-pencil-fill')]")
	WebElement btnEditAttachment;
	
	@FindBy(xpath = "//p[contains(@class,'oxd-text--toast-message')]")
	WebElement toastMessage;
	
	public EmployeeDetallePage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		//Inicializamos los elementos hacciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}
	
	public boolean paginaDetallesCargados() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		 WebElement personalDetails = wait.until(ExpectedConditions.visibilityOf(txtPersonalDetails));
		 //assertTrue("❌ La página Personal Details no cargó", personalDetails.isDisplayed());
		 System.out.println("✅ Página Personal Details cargada");
		 
		 return personalDetails.isDisplayed();
	}
	
	public String validarPrimerNombre() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txt_firstName));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(txt_firstName,"value"));
		
		return txt_firstName.getAttribute("value");
	}
	
	public String validarNombreMedio(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txt_middleName));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(txt_middleName,"value"));
		
		return txt_middleName.getAttribute("value");
	}

	public String validarApellido() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txt_lastName));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(txt_lastName,"value"));
		
		return txt_lastName.getAttribute("value");
	}
	
	public String validarEmployeeId(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txt_employeeId));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(txt_employeeId,"value"));
		
		return txt_employeeId.getAttribute("value");
	}
	
	public void completarPersonalDetails(Employee emp) {
		System.out.println("completarPersonalDetails");
		ingresarNumLicencia(emp);
	    
	    /*if (txt_nickname.isDisplayed()) {
            txt_nickname.sendKeys(emp.nickname);
            System.out.println("✅ Nickname ingresado");
        }*/
	    ingresarOtroId(emp);
	    ingresarExpiracionLicencia(emp);
	    ingresarFechaNac(emp);
	    seleccionarDropdown(dropdownNationality, emp.nacionalidad);
	    seleccionarDropdown(dropdownMaritalStatus, emp.estadoCivil);
	    seleccionarGenero(emp.sexo);
	}
	
	public void ingresarNumLicencia(Employee emp) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(txt_licenseNumber));
	    txt_licenseNumber.clear();
	    txt_licenseNumber.sendKeys(emp.numLicencia);
	}
	
	public void ingresarOtroId(Employee emp) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(txt_otherId));
	    txt_otherId.clear();
	    txt_otherId.sendKeys(emp.otherId);
	}
	
	public void ingresarExpiracionLicencia(Employee emp) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(txt_licenseExpiry));
	    txt_licenseExpiry.sendKeys(emp.licenseExpiry);
	}
	
	public void ingresarFechaNac(Employee emp) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(txt_birthDate));
	    txt_birthDate.sendKeys(emp.birthDate);
	}
	
	public void seleccionarDropdown(WebElement dropdown, String valor) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.oxd-form-loader")));
		
	    dropdown.click();
	    WebElement opcion = driver.findElement(By.xpath("//span[text()='" + valor + "']"));
	    opcion.click();
	}
	
	public void seleccionarGenero(String gender) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.oxd-form-loader")));
	    
	    if (gender.equalsIgnoreCase("Female")) {
	    	wait.until(ExpectedConditions.elementToBeClickable(radioFemale));
	        radioFemale.click();
	    }
	    else {
	    	wait.until(ExpectedConditions.elementToBeClickable(radioMale));
	        radioMale.click();
	    }
	}
	
	public void presionarGuardar(WebElement boton) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(boton));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.oxd-form-loader")));
	    wait.until(ExpectedConditions.elementToBeClickable(boton));
	    boton.click();
	}
	
	public String mensajeExitoso() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement toast = wait.until(ExpectedConditions.visibilityOf(toastMessage));
	    String mensaje = toast.getText();
	    System.out.println("Toast: " + mensaje);
	    return mensaje;
	}
	
	public boolean adjuntarArchivo(Employee emp) {
		System.out.println("En adjuntar archivo");
		clickAdjuntarArchivo();
		String rutaArchivo = Paths.get(emp.file1).toAbsolutePath().toString();
		cargarArchivo(rutaArchivo);
	    ingresarComentario(emp);
		
	    
	    /*List<WebElement> botones = driver.findElements(By.xpath("//button[@type='submit']"));
	    System.out.println("Cantidad Save: " + botones.size());

	    botones.get(2).click();*/
	    //wait.until(ExpectedConditions.elementToBeClickable(btnSaveAttachment));
	    /*WebElement botonSaveAttach = wait.until(ExpectedConditions.visibilityOf(btnSaveAttachment));
	    JavascriptExecutor js2 = (JavascriptExecutor) driver;

	    js2.executeScript("arguments[0].scrollIntoView(true);", botonSaveAttach);

	    js2.executeScript("arguments[0].click();", botonSaveAttach);*/

	    presionarGuardar(btnSaveAttachment);
	    String message = mensajeExitoso();
	    
	    return message.contains("Successfully");
	}
	
	public void clickAdjuntarArchivo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(btnAddAttachment));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", boton);
	    boton.click();
	    System.out.println("✅ Botón Add presionado");
	}
	
	public void cargarArchivo(String archivo){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement upload = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
	    upload.sendKeys(archivo);
	    System.out.println("✅ Archivo adjuntado");

	}
	
	public void ingresarComentario(Employee emp){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txt_comment));
		txt_comment.clear();
	    txt_comment.sendKeys(emp.comment);
	}
	
	public boolean guardarPersonalDetails(Employee emp) {
	    presionarGuardar(btnSave);
	    String message = mensajeExitoso();

	    return message.contains("Successfully");
	}
	
	public boolean editarAdjunto(Employee emp) {
	    clickEditarAdjunto();
	    String rutaArchivo = Paths.get(emp.file2).toAbsolutePath().toString();
		cargarArchivo(rutaArchivo);
	    	    
	    /*List<WebElement> botones = driver.findElements(By.xpath("//button[@type='submit']"));
	    System.out.println("Cantidad Save: " + botones.size());*/

	    presionarGuardar(tercerSave);
	    String message = mensajeExitoso();
	    return message.contains("Successfully");
	    //assertTrue("❌ No se guardó el archivo adjunto", message.contains("Successfully"));
	}
	
	public void clickEditarAdjunto(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement editar = wait.until(ExpectedConditions.elementToBeClickable(btnEditAttachment));
	    editar.click();
	}
}

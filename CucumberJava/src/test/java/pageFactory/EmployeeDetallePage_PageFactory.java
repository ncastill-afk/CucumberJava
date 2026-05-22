package pageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

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
	
	@FindBy(xpath = "//h6[text()='Personal Details']")
	WebElement txtPersonalDetails;
	
	@FindBy(name = "firstName")
	WebElement txt_firstName;

	@FindBy(name = "middleName")
	WebElement txt_middleName;

	@FindBy(name = "lastName")
	WebElement txt_lastName;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input")
	WebElement txt_employeeId;
	
	@FindBy(xpath = "//label[text()='Nickname']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txt_nickname;

	@FindBy(xpath = "(//input[contains(@class,'oxd-input')])[7]")
	WebElement txt_otherId;

	@FindBy(xpath = "//label[contains(text(),'Driver')]//ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txt_licenseNumber;

	@FindBy(xpath = "//label[contains(text(),'License Expiry Date')]//ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txt_licenseExpiry;

	@FindBy(xpath = "//label[contains(text(),'Date of Birth')]//ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement txt_birthDate;
	
	@FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[1]")
	WebElement dropdownNationality;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[1]")
	WebElement dropdownMaritalStatus;
	
	@FindBy(xpath = "//label[text()='Female']")
	WebElement radioFemale;
	
	@FindBy(xpath = "//label[text()='Male']")
	WebElement radioMale;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSave;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement btnAddAttachment;
	
	@FindBy(xpath = "//input[@type='file']")
	WebElement inputFile;
	
	@FindBy(xpath = "//textarea")
	WebElement txt_comment;
	
	@FindBy(xpath = "//textarea/ancestor::form//button[@type='submit']")
	WebElement btnSaveAttachment;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement tercerSave;
	
	@FindBy(xpath = "(//i[contains(@class,'bi-pencil-fill')])[1]")
	WebElement btnEditAttachment;
	
	@FindBy(xpath = "//p[contains(@class,'oxd-text--toast-message')]")
	WebElement toastMessage;
	
	public EmployeeDetallePage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		//Inicializamos los elementos hacciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}
	
	public void paginaDetallesCargados() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		 WebElement personalDetails = wait.until(ExpectedConditions.visibilityOf(txtPersonalDetails));
		 assertTrue("❌ La página Personal Details no cargó", personalDetails.isDisplayed());
		 System.out.println("✅ Página Personal Details cargada");
	}
	
	public void validarDatosEmpleado(Employee emp) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    System.out.println("1");
	    wait.until(ExpectedConditions.visibilityOf(txt_firstName));
	    System.out.println("2");
	    wait.until(ExpectedConditions.visibilityOf(txt_middleName));
	    System.out.println("3");
	    wait.until(ExpectedConditions.visibilityOf(txt_lastName));
	    System.out.println("4");
	    wait.until(ExpectedConditions.visibilityOf(txt_employeeId));
	    System.out.println("5");
	    wait.until(ExpectedConditions.attributeToBeNotEmpty(txt_firstName,"value"));
	    System.out.println("6");
	    wait.until(ExpectedConditions.attributeToBeNotEmpty(txt_middleName,"value"));
	    System.out.println("7");
	    wait.until(ExpectedConditions.attributeToBeNotEmpty(txt_lastName,"value"));
	    System.out.println("8");
	    wait.until(ExpectedConditions.attributeToBeNotEmpty(txt_employeeId,"value"));
	    System.out.println("9");

	    String firstName = txt_firstName.getAttribute("value");

	    String middleName = txt_middleName.getAttribute("value");

	    String lastName = txt_lastName.getAttribute("value");

	    String employeeId = txt_employeeId.getAttribute("value");

	    System.out.println(firstName);
	    System.out.println(middleName);
	    System.out.println(lastName);
	    System.out.println(employeeId);

	    assertEquals("❌ First Name incorrecto", emp.primerNombre, firstName);

	    assertEquals("❌ Middle Name incorrecto", emp.medioNombre, middleName);
	    assertEquals("❌ Last Name incorrecto", emp.apellido, lastName);

	    assertEquals("❌ Employee ID incorrecto", emp.id, employeeId);
	    System.out.println("✅ Datos validados correctamente");
	}

	public void completarPersonalDetails(Employee emp) {
		System.out.println("completarPersonalDetails");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    System.out.println("completarPersonalDetails 0");
	    wait.until(ExpectedConditions.visibilityOf(txt_licenseNumber));
	    System.out.println("completarPersonalDetails 0.1");
	    /*if (txt_nickname.isDisplayed()) {
            txt_nickname.sendKeys(emp.nickname);
            System.out.println("✅ Nickname ingresado");
        }*/
	    System.out.println("completarPersonalDetails 1");
	    txt_otherId.sendKeys(emp.otherId);
	    System.out.println("completarPersonalDetails 2");
	    txt_licenseNumber.sendKeys(emp.numLicencia);
	    System.out.println("completarPersonalDetails 3");
	    txt_licenseExpiry.sendKeys(emp.licenseExpiry);
	    System.out.println("completarPersonalDetails 4");
	    txt_birthDate.sendKeys(emp.birthDate);
	    System.out.println("completarPersonalDetails 5");
	    seleccionarDropdown(dropdownNationality, emp.nacionalidad);
	    System.out.println("completarPersonalDetails 6");
	    seleccionarDropdown(dropdownMaritalStatus, emp.estadoCivil);
	    System.out.println("completarPersonalDetails 7");
	    seleccionarGenero(emp.sexo);
	    System.out.println("completarPersonalDetails 8");
	    btnSave.click();
	    System.out.println("✅ Personal Details completado");
	    
	    WebElement toast = wait.until(ExpectedConditions.visibilityOf(toastMessage));
	    String mensaje = toast.getText();
	    System.out.println("Toast: " + mensaje);
	    assertTrue("❌ No se guardaron los detalles", mensaje.contains("Successfully"));
	}
	
	public void seleccionarDropdown(WebElement dropdown, String valor) {

	    dropdown.click();

	    WebElement opcion = driver.findElement(By.xpath("//span[text()='" + valor + "']"));

	    opcion.click();
	}
	
	public void seleccionarGenero(String gender) {

	    if (gender.equalsIgnoreCase("Female")) {
	        radioFemale.click();
	    }
	    else {
	        radioMale.click();
	    }
	}
	
	public void adjuntarArchivo(Employee emp) {
		System.out.println("En adjuntar archivo");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(btnAddAttachment));

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].scrollIntoView(true);", boton);

	    boton.click();

	    System.out.println("✅ Botón Add presionado");
	    
	    WebElement upload = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));

	    upload.sendKeys(emp.file1);

	    System.out.println("✅ Archivo adjuntado");
	    wait.until(ExpectedConditions.visibilityOf(txt_comment));
	    txt_comment.sendKeys(emp.comment);
	    System.out.println("Comentario ingresado");
	    
	    /*List<WebElement> botones = driver.findElements(By.xpath("//button[@type='submit']"));
	    System.out.println("Cantidad Save: " + botones.size());

	    botones.get(2).click();*/
	    //wait.until(ExpectedConditions.elementToBeClickable(btnSaveAttachment));
	    /*WebElement botonSaveAttach = wait.until(ExpectedConditions.visibilityOf(btnSaveAttachment));
	    JavascriptExecutor js2 = (JavascriptExecutor) driver;

	    js2.executeScript("arguments[0].scrollIntoView(true);", botonSaveAttach);

	    js2.executeScript("arguments[0].click();", botonSaveAttach);*/

	    btnSaveAttachment.click();

	    System.out.println("Adjunto guardado");
	    
	    WebElement toast = wait.until(ExpectedConditions.visibilityOf(toastMessage));
	    String mensaje = toast.getText();
	    System.out.println("Toast: " + mensaje);
	    assertTrue("❌ No se guardó el archivo adjunto", mensaje.contains("Successfully"));
	    System.out.println("Adjunto guardado despues del asserTrue");
	}
	
	public void editarAdjunto(Employee emp) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    WebElement editar = wait.until(ExpectedConditions.elementToBeClickable(btnEditAttachment));

	    editar.click();

	    System.out.println("Edit presionado");

	    WebElement upload = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));

	    //String ruta = new File(emp.attachmentPath2).getAbsolutePath();
	    
	    upload.sendKeys(emp.file2);

	    System.out.println("Nuevo archivo cargado");
	    
	    List<WebElement> botones = driver.findElements(By.xpath("//button[@type='submit']"));
	    System.out.println("Cantidad Save: " + botones.size());

	    tercerSave.click();

	    System.out.println("Adjunto guardado");
	    
	    WebElement toast = wait.until(ExpectedConditions.visibilityOf(toastMessage));
	    String mensaje = toast.getText();
	    System.out.println("Toast: " + mensaje);
	    assertTrue("❌ No se guardó el archivo adjunto", mensaje.contains("Successfully"));
	    System.out.println("Adjunto guardado despues del asserTrue");
	}
	
}

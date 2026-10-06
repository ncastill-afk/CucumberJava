package pageFactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Employee;

public class EmployeePage_PageFactory {

    WebDriver driver;
	
	@FindBy(linkText = "PIM")
	WebElement menuPIM;

	@FindBy(linkText = "Add Employee")
	WebElement btnAddEmployee;
	
	@FindBy(css = "h6.orangehrm-main-title")
	WebElement txtAddEmployee;

	@FindBy(name = "firstName")
	WebElement txt_firstName;

	@FindBy(name = "middleName")
	WebElement txt_middleName;

	@FindBy(name = "lastName")
	WebElement txt_lastName;
	
	@FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	WebElement txt_employeeId;
	
	@FindBy(css = "span.oxd-switch-input")
	WebElement switch_emp;
	
	@FindBy(xpath = "//label[text()='Username']/following::input[1]")
	WebElement txt_username;

	@FindBy(xpath = "//label[text()='Password']/following::input[@type='password'][1]")
	WebElement txt_password1;

	@FindBy(xpath = "//label[text()='Confirm Password']/following::input[@type='password'][1]")
	WebElement txt_password2;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSave;

	@FindBy(xpath = "//div[contains(@class,'oxd-toast-container')]//*[contains(.,'Successfully Saved')]")
	WebElement toastMessage;

	
	public EmployeePage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		//Inicializamos los elementos hacciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}
	
	public void ingresarMenuPIM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement pim = wait.until(ExpectedConditions.elementToBeClickable(menuPIM));
	    pim.click();
	}
	
	public boolean ingresarAddEmployee() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement addEmployee = wait.until(ExpectedConditions.elementToBeClickable(btnAddEmployee));
 	    addEmployee.click();
 	    WebElement add_Employee = wait.until(ExpectedConditions.visibilityOf(txtAddEmployee));
 	    System.out.println("Página Add Employee cargada");

 	    return add_Employee.isDisplayed();
	}
	
	public void ingresarPrimerNombre(Employee emp) {
		By loader = By.className("oxd-form-loader");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
 	    WebElement firstName = wait.until(ExpectedConditions.visibilityOf(txt_firstName));
 	    firstName.clear();
 	    firstName.sendKeys(emp.primerNombre);
	}
	
	public void ingresarMedioNombre(Employee emp) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement middleName = wait.until(ExpectedConditions.visibilityOf(txt_middleName));
		middleName.clear();
 	    middleName.sendKeys(emp.medioNombre);
	}
	
	public void ingresarApellido(Employee emp) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement lastName = wait.until(ExpectedConditions.visibilityOf(txt_lastName));
		lastName.clear();
 	    lastName.sendKeys(emp.apellido);
	}
	
	public String obtenerEmployeeId() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(txt_employeeId));
	    String employeeId = txt_employeeId.getAttribute("value");
	    System.out.println("Employee ID: " + employeeId);
	    return employeeId;
	}
	
	public void clickEnSwitch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement switchElement = wait.until(ExpectedConditions.elementToBeClickable(switch_emp));
		switchElement.click();
	    System.out.println("Switch activado");
	}
	
	public void ingresarUsername(Employee emp) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement username = wait.until(ExpectedConditions.visibilityOf(txt_username));
		username.clear();
        username.sendKeys(emp.username);

	}
	
	public void ingresarPassword1(Employee emp) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement password1 = wait.until(ExpectedConditions.visibilityOf(txt_password1));
		password1.clear();
		password1.sendKeys(emp.password1);
	}
	
	public void ingresarPassword2(Employee emp) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement password2 = wait.until(ExpectedConditions.visibilityOf(txt_password2));
		password2.clear();
		password2.sendKeys(emp.password2);
	}
	
	public void clickEnGuardar() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement save = wait.until(ExpectedConditions.elementToBeClickable(btnSave));
 	    save.click();
 	    System.out.println("Botón Save presionado");
	}
	
	public boolean mensajeExitoso() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 	    WebElement toast = wait.until(ExpectedConditions.visibilityOf(toastMessage));
 	    String mensaje = toast.getText();
 	    System.out.println("Toast: " + mensaje);
 	    
 	    return mensaje.contains("Successfully");
	}
}

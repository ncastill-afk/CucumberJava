package pageFactory;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Employee;
import utils.JsonWriter;

public class EmployeePage_PageFactory {

    WebDriver driver;
	
	@FindBy(xpath = "//span[text()='PIM']")
	WebElement menuPIM;

	@FindBy(xpath = "//a[text()='Add Employee']")
	WebElement btnAddEmployee;
	
	@FindBy(xpath = "//h6[text()='Add Employee']")
	WebElement txtAddEmployee;

	@FindBy(name = "firstName")
	WebElement txt_firstName;

	@FindBy(name = "middleName")
	WebElement txt_middleName;

	@FindBy(name = "lastName")
	WebElement txt_lastName;
	
	@FindBy(xpath = "(//input[contains(@class,'oxd-input')])[5]")
	WebElement txt_employeeId;
	
	@FindBy(xpath = "//span[contains(@class,'oxd-switch-input')]")
	WebElement switch_emp;
	
	@FindBy(xpath = "(//input[contains(@class,'oxd-input')])[6]")
	WebElement txt_username;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement txt_password1;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement txt_password2;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSave;

	@FindBy(xpath ="//p[contains(@class,'oxd-text--toast-message')]")
	WebElement toastMessage;

	
	public EmployeePage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		//Inicializamos los elementos hacciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}
	
	public void addEmployee(Employee emp) {
		 By loader = By.className("oxd-form-loader");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
         WebElement pim = wait.until(ExpectedConditions.elementToBeClickable(menuPIM));
 	     pim.click();
 	     
 	    WebElement addEmployee = wait.until(ExpectedConditions.elementToBeClickable(btnAddEmployee));
 	    addEmployee.click();
 	    
 	    WebElement add_Employee = wait.until(ExpectedConditions.visibilityOf(txtAddEmployee));
 	    assertTrue("❌ La página Add Employee no cargó", add_Employee.isDisplayed());
 		System.out.println("Página Add Employee cargada");
 		
 		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

 	    WebElement firstName = wait.until(ExpectedConditions.visibilityOf(txt_firstName));

 	    firstName.sendKeys(emp.primerNombre);
 	    //txt_firstName.sendKeys(emp.primerNombre);
 	    txt_middleName.sendKeys(emp.medioNombre);
 	    txt_lastName.sendKeys(emp.apellido);
 	    
 	    
 	    String employeeId = obtenerEmployeeId();
 	    JsonWriter.actualizarEmployeeId("usuario1",employeeId);
 	  
 	    if (emp.switchEmployee.equalsIgnoreCase("true")) {
 	        WebElement switchElement = wait.until(
 	            ExpectedConditions.elementToBeClickable(switch_emp)
 	        );
 	        switchElement.click();
 	        System.out.println("Switch activado");
 	        
 	        wait.until(ExpectedConditions.visibilityOf(txt_username));

 	        txt_username.sendKeys(emp.username);

 	        txt_password1.sendKeys(emp.password1);

 	        txt_password2.sendKeys(emp.password2);

 	        System.out.println("Login Details ingresados");
 	    }
 	    WebElement save = wait.until(
 	            ExpectedConditions.elementToBeClickable(btnSave)
 	    );
 	    save.click();
 	    System.out.println("Botón Save presionado");
 	    
 	    WebElement toast = wait.until(ExpectedConditions.visibilityOf(toastMessage));
 	    String mensaje = toast.getText();
 	    System.out.println("Toast: " + mensaje);
 	    assertTrue("❌ Employee no fue guardado", mensaje.contains("Successfully"));
 	    
	}
	
	public String obtenerEmployeeId() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    wait.until(ExpectedConditions.visibilityOf(txt_employeeId));

	    String employeeId = txt_employeeId.getAttribute("value");

	    System.out.println("Employee ID: " + employeeId);

	    return employeeId;
	}
}

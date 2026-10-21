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

public class ListEmployeePage_PageFactory {
	
	WebDriver driver;
	
	@FindBy(linkText = "Employee List")
	WebElement btnEmployeeList;
	
	@FindBy(xpath = "//h5[normalize-space()='Employee Information']")
	WebElement txtEmployeeList;
	
	@FindBy(xpath = "//label[normalize-space()='Employee Id']/following::input[1]")
	WebElement txt_employeeIdSearch;
	
	@FindBy(xpath = "//label[normalize-space()='Employee Name']/following::input[@placeholder='Type for hints...'][1]")
	WebElement txt_employeeName;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//div[contains(@class,'oxd-table-body')]")
	WebElement tablaResultados;
	
	
	public ListEmployeePage_PageFactory(WebDriver driver) {
		//Hacer referencia al driver
		this.driver=driver;
		//Inicializar los elementos hacciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}
	
	public void clickBtnEmployeeList() {
		//Hacer click en botón de List Employee
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement btnEmployee = wait.until(ExpectedConditions.elementToBeClickable(btnEmployeeList));
		btnEmployee.click();
	}
	
	public boolean despliegueListEmployee() {
		//Despiegue de List Employee
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement list_Employee = wait.until(ExpectedConditions.visibilityOf(txtEmployeeList));

 	    return list_Employee.isDisplayed();
	}
	
	public void enviarId(Employee emp){
		//Enviar el id del employee para buscarlo
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(txt_employeeIdSearch));
 		txt_employeeIdSearch.clear();
 	    txt_employeeIdSearch.sendKeys(emp.id);
	}
	
	public void enviarApellido(Employee emp){
		//Enviar el apellido del employee para buscarlo
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 		wait.until(ExpectedConditions.visibilityOf(txt_employeeName));
 		txt_employeeName.clear();
 	    txt_employeeName.sendKeys(emp.apellido);
	}
	
	public void clickBuscar(){
		//Hacer click en buscar
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    btnSearch.click();
 	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-table-body')]")));
	}
	
	public boolean validarEmployee(Employee emp) {
		//Validar empleado
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement tabla = wait.until(ExpectedConditions.visibilityOf(tablaResultados));
	    String resultado = tabla.getText();

	    return resultado.contains(emp.apellido) && resultado.contains(emp.id);
	}
	
	public void seleccionarEmpleado(Employee emp) {
		//Seleccionar empleado
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement tabla = wait.until(ExpectedConditions.visibilityOf(tablaResultados));
	    tabla.click();
	}

}

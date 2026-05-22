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

public class ListEmployeePage_PageFactory {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Employee List']")
	WebElement btnEmployeeList;
	
	@FindBy(xpath = "//h5[text()='Employee Information']")
	WebElement txtEmployeeList;
	
	@FindBy(xpath = "(//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input)[1]")
	WebElement txt_employeeIdSearch;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement txt_employeeName;
	
	@FindBy(xpath =	"//button[@type='submit']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//div[contains(@class,'oxd-table-body')]")
	WebElement tablaResultados;
	
	
	public ListEmployeePage_PageFactory(WebDriver driver) {
		//Hacemos referencia al driver
		this.driver=driver;
		//Inicializamos los elementos hacciendo referencia al mismo driver
		PageFactory.initElements(driver, this);
	}
	
	public void revisarEmployee(Employee emp) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement btnEmployee = wait.until(ExpectedConditions.elementToBeClickable(btnEmployeeList));
		btnEmployee.click();
		
		WebElement list_Employee = wait.until(ExpectedConditions.visibilityOf(txtEmployeeList));
 	    assertTrue("❌ La página Employee List no cargó", list_Employee.isDisplayed());
 		System.out.println("Página Employee List cargada");
 		
 		wait.until(ExpectedConditions.visibilityOf(txt_employeeIdSearch));

        txt_employeeIdSearch.clear();

 	    txt_employeeIdSearch.sendKeys(emp.id);

 	    txt_employeeName.sendKeys(emp.apellido);
 	    System.out.println("Antes del click en search");
 	    btnSearch.click();
 	    System.out.println("Después del click en search");
 	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-table-body')]")));
 	    
 	    System.out.println("Búsqueda realizada");

 	    assertTrue("❌ Employee no encontrado", tablaResultados.getText().contains(emp.apellido));
 	    assertTrue("❌ Employee no encontrado", tablaResultados.getText().contains(emp.id));
 	    System.out.println("Empleado encontrado");
	}

}

package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage extends AdminHomePage {
	WebDriver driver;

	public EmployeePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//new employee element
	@FindBy(how=How.ID, using="BtnNew")
	private WebElement newEmployee;
	
	//click on new employee 
	public void clickNewEmployee() {
		this.newEmployee.click();
	}

}

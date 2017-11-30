package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreationPage extends AdminHomePage{
	WebDriver driver;
	public EmployeeCreationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//employee name
	@FindBy(how=How.ID, using="txtUname")
	private WebElement emeployeeName;
	
	//login password
	@FindBy(how=How.ID, using="txtLpwd")
	private WebElement loginPassword;
	
	//role
	@FindBy(how=How.ID, using="lst_Roles")
	private WebElement role;
	
	//branch
	@FindBy(how=How.ID, using="lst_Branch")
	private WebElement branch;
	
	//submit
	@FindBy(how=How.ID, using="BtnSubmit")
	private WebElement submit;
	
	//reset
	@FindBy(how=How.ID, using="btnreset")
	private WebElement reset;
	
	//cancel
	@FindBy(how=How.ID, using="btnCancel")
	private WebElement cancel;
	
	//fill employee name
	public void fillEmployeeName(String employeeName) {
		this.emeployeeName.sendKeys(employeeName);
	}
	
	//fill login password
	public void fillLoginPassword(String loginPassword) {
		this.loginPassword.sendKeys(loginPassword);
	}
	//select role
	public void selectRole(String role) {
		new Select(this.role).selectByVisibleText(role);
	}
	
	//select branch
	public void selectBranch(String branch) {
		new Select(this.branch).selectByVisibleText(branch);
	}
	//click submit
	public void clickSubmit() {
		this.submit.click();
	}
	
	//click reset
	public void clickReset() {
		this.reset.click();
	}
	
	//click cancel
	public void clickCancel() {
		this.cancel.click();
	}
}

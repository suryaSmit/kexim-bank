package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RoleCreationPage extends AdminHomePage{
	WebDriver driver;
	
	public RoleCreationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// RoleName
		@FindBy(how = How.ID, using = "txtRname")
		private WebElement RoleName;

		// RoleDes
		@FindBy(how = How.ID, using = "txtRDesc")
		private WebElement RoleDes;

		// RoleType
		@FindBy(how = How.ID, using = "lstRtypeN")
		private WebElement RoleType;

		// submit
		@FindBy(how = How.ID, using = "btninsert")
		private WebElement submit;

		// Reset
		@FindBy(how = How.ID, using = "Btn_Reset")
		private WebElement Reset;

		// cancel
		@FindBy(how = How.ID, using = "Btn_cancel")
		private WebElement cancel;
		
		// Enter RoleName
		public void fillRollName(String RoleName) {
			// anonymous class
			this.RoleName.sendKeys(RoleName);
		}

		// Enter RoleDes
		public void fillRollDes(String RoleDes) {
			this.RoleDes.sendKeys(RoleDes);
		}

		// Select RoleType
		public void selectRoleType(String RoleType) {
			new Select(this.RoleType).selectByVisibleText(RoleType);
		}

		// click Submit
		public void clickSubmit() {
			this.submit.click();
		}

		// click Recet
		public void clickReset() {
			this.Reset.click();
		}

		// click cancel
		public void clickcancel() {
			this.cancel.click();
		}
}

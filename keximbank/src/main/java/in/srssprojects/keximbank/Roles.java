package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Roles extends AdminHomePage {

WebDriver driver;
	
	public Roles(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//NewRole
		@FindBy(id="btnRoles")
		private WebElement NewRole;
		
		//RoleName
		@FindBy(how=How.ID, using="Label17")
		private WebElement RoleName;
		
		//RoleDes
		@FindBy(how = How.ID, using="Label15")
		private WebElement RoleDes;
		
		//RoleType
		@FindBy(how = How.ID, using="lbRtypeN")
		private WebElement RoleType;
		
		//submit
		@FindBy(how = How.ID, using="btninsert")
		private WebElement submit;
		
		//Reset
		@FindBy(how = How.ID, using="Btn_Reset")
		private WebElement Reset;
		
		//cancel
			@FindBy(how = How.ID, using="Btn_cancel")
			private WebElement cancel;
		
		//click NewRole
		public void clickNewRole() {
			this.NewRole.click();
		}
		
		//Enter RoleName
		public void RollName(String RoleName) {
			//anonymous class
			this.RoleName.sendKeys(RoleName);
		}
		
		//Enter RoleDes
		public void RollDes(String RoleDes) {
			this.RoleDes.sendKeys(RoleDes);
		}
		
		//Select RoleType
		public void RoleType(String RoleType) {
			new Select(this.RoleType).selectByVisibleText(RoleType);
		}
		
		//click Submit
		public void clickSubmit() {
			this.submit.click();
		}
		
		//click Recet
		public void clickRecet() {
			this.Reset.click();
		}
		
		//click cancel
				public void clickcancel() {
					this.cancel.click();
				}
}

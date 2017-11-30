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

	// NewRole
	@FindBy(id = "btnRoles")
	private WebElement NewRole;

	// click NewRole
	public void clickNewRole() {
		this.NewRole.click();
	}

	
}

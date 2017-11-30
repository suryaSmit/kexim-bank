package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage extends AdminHomePage {

	WebDriver driver;

	public BranchCreationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// branch name
	@FindBy(how = How.ID, using = "txtbName")
	private WebElement branchName;
	// address 1
	@FindBy(how = How.ID, using = "txtAdd1")
	private WebElement address1;
	// address 2
	@FindBy(how = How.ID, using = "Txtadd2")
	private WebElement address2;
	// address 3
	@FindBy(how = How.ID, using = "txtadd3")
	private WebElement address3;
	// area
	@FindBy(how = How.ID, using = "txtArea")
	private WebElement area;
	// zipcode
	@FindBy(how = How.ID, using = "txtZip")
	private WebElement zipcode;
	// country
	@FindBy(how = How.ID, using = "lst_counrtyU")
	private WebElement country;
	// state
	@FindBy(how = How.ID, using = "lst_stateI")
	private WebElement state;
	// city
	@FindBy(how = How.ID, using = "lst_cityI")
	private WebElement city;
	// submit
	@FindBy(how = How.ID, using = "btn_insert")
	private WebElement submit;
	// reset
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;
	// cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	// fill branch name
	public void fillBranchName(String branchName) {
		this.branchName.sendKeys(branchName);
	}

	// fill address1
	public void fillAddress1(String address1) {
		this.address1.sendKeys(address1);
	}

	// fill address2
	public void fillAddress2(String address2) {
		this.address2.sendKeys(address2);
	}

	// fill address3
	public void fillAddress3(String address3) {
		this.address3.sendKeys(address3);
	}

	// fill area
	public void fillArea(String area) {
		this.area.sendKeys(area);
	}
	
	//fill zipcode
	public void fillZipCode(String zipcode) {
		this.zipcode.sendKeys(zipcode);
	}
	
	//select country
	public void selectCountry(String country) {
		new Select(this.country).selectByVisibleText(country);
	}
	
	//select state
	public void selectState(String state) {
		new Select(this.state).selectByVisibleText(state);
	}
	
	//select city
	public void selectCity(String city) {
		new Select(this.city).selectByVisibleText(city);
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

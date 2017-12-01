 package in.srssprojects.keximbank;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Reporter;

public class TestExecution {
	WebDriver driver;
	KeximHomePage keximHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchesPage branchesPageObj;
	Roles Rolesobj;
	BranchCreationPage branchCreationPageObj;
	RoleCreationPage roleCreationPageObj;
	
	
	public void setup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		keximHomePageObj = new KeximHomePage();
		adminHomePageObj = new AdminHomePage(driver);
		branchesPageObj = new BranchesPage(driver);
		branchCreationPageObj = new BranchCreationPage(driver);
		Rolesobj = new Roles(driver);
		roleCreationPageObj = new RoleCreationPage(driver);
	}
	
	@Test(priority=0, timeOut=10000, groups= {"branches","search","clear","create","reset","cancel","roles"})            
	@Parameters({"username","password"})
	public void testLogin(String username, String password) throws InterruptedException {
		keximHomePageObj.fillUserName(username, driver);
		Reporter.log("username entered");
//		Thread.sleep(2000);
		keximHomePageObj.fillPassword(password, driver);
		Reporter.log("password entered");
		keximHomePageObj.clickLoginButton(driver);
		Reporter.log("login button clicked");
		assertTrue(Validations.urlContains("adminflow", driver));
		
	}
	
	@Test(priority=1,dependsOnMethods= {"testLogin"}, groups= {"branches", "search"})
	public void testBranchSearch() {
		adminHomePageObj.clickBranches();
		Reporter.log("branches clicked");
		branchesPageObj.selectCountry("UK");
		Reporter.log("UK as country selected");
		branchesPageObj.selectState("England");
		Reporter.log("England as state selected");
		branchesPageObj.selectCity("oxford");
		Reporter.log("oxford as city selected");
		branchesPageObj.clickSearch();
		Reporter.log("serach button clicked");
		assertTrue(true);
		
	}
	
	@Test(priority=2, dependsOnMethods= {"testBranchSearch", "testLogin"}, groups= {"branches","search"})
	public void testBranchSearchClear() {
		branchesPageObj.clickClear();
		Reporter.log("clear button clicked");
		Validations.isTextOfOptionEquals("ALL", branchesPageObj.getCountry());
	}
	
	@Test(priority = 3,groups= {"branches","create"})
	public void testBranchCreation(){
		adminHomePageObj.clickBranches();
		branchesPageObj.clickNewBranch();
		branchCreationPageObj.fillBranchName("miyapur 1234");
		branchCreationPageObj.fillAddress1("miyapur");
		branchCreationPageObj.fillZipCode("12345");
		branchCreationPageObj.selectCountry("INDIA");
		branchCreationPageObj.selectState("GOA");
		branchCreationPageObj.selectCity("GOA");
		branchCreationPageObj.clickSubmit();
		String actualAlertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		assertTrue(Validations.alertTextContains("New Branch with id", actualAlertText));
	}
	
	@Test(priority = 4,groups= {"branches","reset"})
	public void testBranchCreationReset() {
		adminHomePageObj.clickBranches();
		branchesPageObj.clickNewBranch();
		branchCreationPageObj.fillBranchName("miyapur 1234");
		branchCreationPageObj.fillAddress1("miyapur");
		branchCreationPageObj.fillZipCode("12345");
		branchCreationPageObj.selectCountry("INDIA");
		branchCreationPageObj.selectState("GOA");
		branchCreationPageObj.selectCity("GOA");
		branchCreationPageObj.clickReset();
		assertTrue(Validations.isTextOfOptionEquals("Select", branchCreationPageObj.getCountry()));
	}
	
	
	@Test(priority = 5, groups= {"branches","cancel"})
	public void testBranchCreationCancel() {
		adminHomePageObj.clickBranches();
		branchesPageObj.clickNewBranch();
		branchCreationPageObj.fillBranchName("ajhfkjahdjkfahjk");
		branchCreationPageObj.clickCancel();
		assertTrue(Validations.isElementPresent(branchesPageObj.getCountry()));
		
	}
	@Test(priority=6,groups= {"roles","create"})
	public void testRoleCreation() {
		adminHomePageObj.clickRoles();
		Rolesobj.clickNewRole();
		roleCreationPageObj.fillRollName("branch manager");
		roleCreationPageObj.selectRoleType("E");
		roleCreationPageObj.clickSubmit();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		
	}
	
	@Test(priority = 7,groups= {"roles","reset"})
	public void testRoleCreationReset(){
		adminHomePageObj.clickRoles();
		Rolesobj.clickNewRole();
		roleCreationPageObj.fillRollName("branch manager");
		roleCreationPageObj.selectRoleType("E");
		roleCreationPageObj.clickReset();
	}
	
	@Test(priority  =8, groups= {"branches","search","clear","create","reset","cancel","roles"})
	public void testLogout() throws InterruptedException {
		Thread.sleep(2000);
		adminHomePageObj.clickLogout();
	}

}

package in.srssprojects.keximbank;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestExecution {
	WebDriver driver;
	KeximHomePage keximHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchesPage branchesPageObj;
	Roles Rolesobj;
	BranchCreationPage branchCreationPageObj;
	RoleCreationPage roleCreationPageObj;
	
	
	
	@BeforeClass(groups= {"branches","search","clear","create","reset","cancel","roles"})
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://www.srssprojects.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		keximHomePageObj = new KeximHomePage();
		adminHomePageObj = new AdminHomePage(driver);
		branchesPageObj = new BranchesPage(driver);
		branchCreationPageObj = new BranchCreationPage(driver);
		Rolesobj = new Roles(driver);
		roleCreationPageObj = new RoleCreationPage(driver);
		
//		by hashcode we can confirm we are passing same webdriver object to each and every page class
//		System.out.println(driver.hashCode());
	}
	
	@AfterClass(groups= {"branches","search","clear","create","reset","cancel","roles"})    
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test(priority=0, timeOut=10000, groups= {"branches","search","clear","create","reset","cancel","roles"})            
	public void testLogin() throws InterruptedException {
		keximHomePageObj.fillUserName("Admin", driver);
//		Thread.sleep(2000);
		keximHomePageObj.fillPassword("Admin", driver);
		keximHomePageObj.clickLoginButton(driver);
	}
	
	@Test(priority=1,dependsOnMethods= {"testLogin"}, groups= {"branches", "search"})
	public void testBranchSearch() {
		adminHomePageObj.clickBranches();
		branchesPageObj.selectCountry("UK");
		branchesPageObj.selectState("England");
		branchesPageObj.selectCity("oxford");
		branchesPageObj.clickSearch();
		assertTrue(true);
		
	}
	
	@Test(priority=2, dependsOnMethods= {"testBranchSearch", "testLogin"}, groups= {"branches","search"})
	public void testBranchSearchClear() {
		branchesPageObj.clickClear();
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
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
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
	}
	
	
	@Test(priority = 5, groups= {"branches","cancel"})
	public void testBranchCreationCancel() {
		adminHomePageObj.clickBranches();
		branchesPageObj.clickNewBranch();
		branchCreationPageObj.fillBranchName("ajhfkjahdjkfahjk");
		branchCreationPageObj.clickCancel();
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
	
	@Test(priority=8,dependsOnMethods= {"testLogin"}, groups= {"branches","search","clear","create","reset","cancel","roles"})
	public void testLogout() throws InterruptedException {
		Thread.sleep(2000);
		adminHomePageObj.clickLogout();
	}

}

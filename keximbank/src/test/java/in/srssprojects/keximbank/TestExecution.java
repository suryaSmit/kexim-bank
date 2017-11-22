package in.srssprojects.keximbank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestExecution {
	WebDriver driver;
	KeximHomePage keximHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchesPage branchesPageObj;
	Roles Rolesobj;
	
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", ".\\resources\\geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://www.srssprojects.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		keximHomePageObj = new KeximHomePage();
		adminHomePageObj = new AdminHomePage(driver);
		branchesPageObj = new BranchesPage(driver);
		Rolesobj = new Roles(driver);
		
//		by hashcode we can confirm we are passing same webdriver object to each and every page class
//		System.out.println(driver.hashCode());
	}
	
	@AfterClass          
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test(priority=0)            
	public void testLogin() {
		keximHomePageObj.fillUserName("Admin", driver);
		keximHomePageObj.fillPassword("Admin", driver);
		keximHomePageObj.clickLoginButton(driver);
	}
	
	@Test(priority=1)
	public void testBranches() {
		adminHomePageObj.clickBranches();
		branchesPageObj.clickNewBranch();
	}
	
	@Test(priority=2)
	public void testRoles() {
		adminHomePageObj.clickRoles();
		Rolesobj.clickNewRole();
		Rolesobj.RollName("Tester");
		Rolesobj.RollDes("For Testing");
		Rolesobj.RoleType("E");
		Rolesobj.clickSubmit();
		
		
	}
	
	
	@Test(priority=3)
	public void testLogout() throws InterruptedException {
		Thread.sleep(2000);
		adminHomePageObj.clickLogout();
	}

}

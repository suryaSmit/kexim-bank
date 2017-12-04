 package in.srssprojects.keximbank;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.Reporter;
//@Listeners(TestListerner.class)
public class TestExecution {
	WebDriver wdriver;
	EventFiringWebDriver driver;
	KeximHomePage keximHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchesPage branchesPageObj;
	Roles Rolesobj;
	BranchCreationPage branchCreationPageObj;
	RoleCreationPage roleCreationPageObj;
	
	public void eventsSetup() {
		driver = new EventFiringWebDriver(wdriver);
		Listener listener = new Listener();
		driver.register(listener);
	}
	
	public static String getSystemTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd-MMM/hh:mm:ss");
		return df.format(date);
	}
	public void setup() {
		eventsSetup();
		driver.get("http://srssprojects.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		report = new ExtentReports(".//reports/report"+getSystemTime()+".html");
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
//		test = report.startTest("testLogin");
		keximHomePageObj.fillUserName(username, driver);
//		test.log(LogStatus.INFO, "username entered");
//		Reporter.log("username entered");
//		Thread.sleep(2000);
		keximHomePageObj.fillPassword(password, driver);
//		test.log(LogStatus.INFO, "password entered");
//		Reporter.log("password entered");
		keximHomePageObj.clickLoginButton(driver);
//		test.log(LogStatus.INFO, "login button clicked");
//		Reporter.log("login button clicked");
		assertTrue(Validations.urlContains("adminflow", driver));
//		test.log(LogStatus.PASS, "test passed");
//		report.endTest(test);
		
	}
	
	@Test(priority=1,dependsOnMethods= {"testLogin"}, groups= {"branches", "search"})
	public void testBranchSearch() {
//		test = report.startTest("testBranchSearch");
		adminHomePageObj.clickBranches();
//		test.log(LogStatus.INFO, "branhces clicked");
//		Reporter.log("branches clicked");
		branchesPageObj.selectCountry("UK");
//		test.log(LogStatus.INFO, "UK as country selected");
//		Reporter.log("UK as country selected");
		branchesPageObj.selectState("England");
//		test.log(LogStatus.INFO, "England as state selected");
//		Reporter.log("England as state selected");
		branchesPageObj.selectCity("oxford");
//		test.log(LogStatus.INFO, "oxford as city selected");
//		Reporter.log("oxford as city selected");
		branchesPageObj.clickSearch();
//		test.log(LogStatus.INFO, "search button clikced");
//		Reporter.log("serach button clicked");
		assertTrue(true);
//		test.log(LogStatus.PASS, "test passed");
//		report.endTest(test);
		
	}
	
	@Test(priority=2, dependsOnMethods= {"testBranchSearch", "testLogin"}, groups= {"branches","search"})
	public void testBranchSearchClear() {
//		test = report.startTest("testBranchSearchClear");
		branchesPageObj.clickClear();
//		test.log(LogStatus.INFO, "clear button clicked");
//		Reporter.log("clear button clicked");
		
		assertTrue(Validations.isTextOfOptionEquals("All", branchesPageObj.getCountry()));
//		test.log(LogStatus.PASS, "test passed");
//		report.endTest(test);
		
	}
	
	@Test(priority = 3,groups= {"branches","create"})
	public void testBranchCreation(){
		adminHomePageObj.clickBranches();
		branchesPageObj.clickNewBranch();
		branchCreationPageObj.fillBranchName("miyapur12391");
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
		branchCreationPageObj.fillBranchName("miyapur1234");
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
//		test = report.startTest("testLogout");
		Thread.sleep(2000);
		adminHomePageObj.clickLogout();
//		test.log(LogStatus.INFO, "logout button clicked");
//		test.log(LogStatus.PASS, "test passed");
//		report.endTest(test);
		
	}

}

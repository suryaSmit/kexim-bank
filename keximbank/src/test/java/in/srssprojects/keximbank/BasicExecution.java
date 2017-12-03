package in.srssprojects.keximbank;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution {
	
	@BeforeClass(groups= {"branches","search","clear","create","reset","cancel","roles"})
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
		wdriver = new FirefoxDriver();
		setup();
		
//		by hashcode we can confirm we are passing same webdriver object to each and every page class
//		System.out.println(driver.hashCode());
	}
	
	@AfterClass(groups= {"branches","search","clear","create","reset","cancel","roles"})    
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		wdriver.close();
		report.flush();
	}
	

}

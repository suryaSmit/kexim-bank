package in.srssprojects.keximbank;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BrowserCompatibility extends TestExecution{
	@BeforeClass(groups= {"branches","search","clear","create","reset","cancel","roles"})
	@Parameters("browsername")
	public void browserLaunch(String browserName) {
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//resources/geckodriver");
			driver = new FirefoxDriver();
		}
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//resources/chromedriver");
			driver = new ChromeDriver();
		}
		driver.get("http://www.srssprojects.in");
		setup();
	}
	
	@AfterClass(groups= {"branches","search","clear","create","reset","cancel","roles"})
	public void closeBrowser() {
		driver.close();
	}

}

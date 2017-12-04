package in.srssprojects.keximbank;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution{
	DesiredCapabilities caps;
	@BeforeClass(groups= {"branches","search","clear","create","reset","cancel","roles"})
	@Parameters({"browsername","nodeUrl","platform"})
	public void browserLaunch(String browserName,String nodeUrl, String os) {
		if(browserName.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
			caps.setBrowserName("firefox");
		}
		if(browserName.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
			caps.setBrowserName("chrome");
		}
		if(os.equals("mac")) {
			caps.setPlatform(Platform.MAC);
		}
		if(os.equals("linux")) {
			caps.setPlatform(Platform.LINUX);
		}
		try {
			wdriver = new RemoteWebDriver(new URL(nodeUrl), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setup();
		
	}
	
	@AfterClass(groups= {"branches","search","clear","create","reset","cancel","roles"})
	public void closeBrowser() {
		driver.close();
	}

}

package in.srssprojects.keximbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeximHomePage {
	
	//user name
	public WebElement userName(WebDriver driver) {
		System.out.println(driver.hashCode());
		return driver.findElement(By.id("txtuId"));
		
	}
	
	//password
	public WebElement password(WebDriver driver) {
		return driver.findElement(By.id("txtPword"));
	}
	
	//login button
	public WebElement loginButton(WebDriver driver) {
		return driver.findElement(By.id("login"));
	}
	
	//enter user name
	public void fillUserName(String username, WebDriver driver) {
		System.out.println(driver.hashCode());
		this.userName(driver).sendKeys(username);
	}
	
	//enter password
	public void fillPassword(String password, WebDriver driver) {
		this.password(driver).sendKeys(password);
	}
	
	//click login
	public void clickLoginButton(WebDriver driver) {
		this.loginButton(driver).click();
	}

}

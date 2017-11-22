package in.srssprojects.keximbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage {
	WebDriver driver;
	
	/*
	 * create a parameterized constructor which accepts webdriver as an argument
	 * assing this class webdriver obj to constructor webdriver argument
	 */
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
	}
	//home button
	public WebElement home() {
		System.out.println(driver.hashCode());
		return driver.findElement(By.xpath("//a[@href='adminflow.aspx']"));
	}
	
	//change password button
	public WebElement changePassord() {
		return driver.findElement(By.xpath("//a[@href='change_password1234.aspx']"));
	}
	//logout button
	public WebElement logout() {
		return driver.findElement(By.xpath("//a[@href='home.aspx']"));
	}
	//branches button
	public WebElement branches() {
		return driver.findElement(By.xpath("//a[@href='admin_banker_master.aspx']"));
	}
	//roles button
	public WebElement roles() {
		return driver.findElement(By.xpath("//a[@href='Admin_Roles_details.aspx']"));
	}
	//employee button
	public WebElement employee() {
		return driver.findElement(By.xpath("//a[@href='Admin_Emp_details.aspx']"));
	}
	//users button
	public WebElement users() {
		return driver.findElement(By.xpath("//a[@href='userdetails.aspx']"));
	}
	
	//click home button
	public void clickHome() {
		this.home().click();
	}
	
	//click change password
	public void clickChangePassord() {
		this.changePassord().click();
	}
	
	//click logout
	public void clickLogout() {
		this.logout().click();
	}
	
	//click branches
	public void clickBranches() {
		this.branches().click();
	}
	
	//click roles
	public void clickRoles() {
		this.roles().click();
	}
	
	//click employee
	public void clickEmployee() {
		this.employee().click();
	}
	
	//click users
	public void clickUsers() {
		this.users().click();
	}
}

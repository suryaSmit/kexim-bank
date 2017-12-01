package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Validations {

	//verify by using url of the page
	public static boolean urlContains(String expectedResult, WebDriver driver) {
		String actualResult = driver.getCurrentUrl();
		System.out.println(expectedResult+"\t"+actualResult);
		if(actualResult.contains(expectedResult)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	//verify by using page title
	public static boolean titleContains(String expectedTitle,WebDriver driver) {
		return driver.getTitle().contains(expectedTitle);
	}
	
	//verify by using the alert text
	public static boolean alertTextContains(String expectedAlertText, String actualAlertText) {
		return actualAlertText.contains(expectedAlertText);
	}
	
	//verify by using element visiblity
	public static boolean isElementPresent(WebElement expectedElement) {
		return expectedElement.isDisplayed();
	}
	
	//verify element is selected or not
	public static boolean isElementSelected(WebElement expectedElement) {
		return expectedElement.isSelected();
	}
	
	//
	public static boolean isTextOfOptionEquals(String expectedOption, WebElement selectElement) {
		String actualOption = new Select(selectElement).getFirstSelectedOption().getText();
		return expectedOption.equals(actualOption);
	}
}

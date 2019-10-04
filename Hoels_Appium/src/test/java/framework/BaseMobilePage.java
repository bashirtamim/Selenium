package framework;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import stepdefinition.SharedSD;

public class BaseMobilePage {

	/**
	 * This method is used to tap on element
	 *
	 * @param mobileElement
	 *            element to tap on
	 */
	public void clickOn(By locator) {
		try {
			SharedSD.getAppiumDriver().findElement(locator).click();	
		} catch (NoSuchElementException e) {
			// Take screenshot here
			throw new NoSuchElementException("Unable to locate the Element using: " + locator.toString());
		}
	}

	/**
	 * This method is used to set value in text field
	 * 
	 * @param mobileElement
	 * @param setValue
	 */
	public void setValue(By locator, String setValue) {

		try {
			SharedSD.getAppiumDriver().findElement(locator).sendKeys(setValue);
		} catch (NoSuchElementException e) {
			// Take screenshot here
			throw new NoSuchElementException("Unable to locate the Element using: " + locator.toString());
		}
	}

	public String getValueFromElementByText(By locator) {

		try {
			return SharedSD.getAppiumDriver().findElement(locator).getText();

		} catch (NoSuchElementException e) {
			// Take screenshot here
			throw new NoSuchElementException("Unable to locate the Element using: " + locator.toString());
		}
	}
}

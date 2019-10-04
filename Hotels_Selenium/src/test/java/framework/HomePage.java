package framework;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.allure.annotations.Step;
import stepdefinition.SharedSD;

public class HomePage extends BasePage{

	private By destinationTextField = By.id("qf-0q-destination");
	private By checkInField = By.id("qf-0q-localised-check-in");
	private By checkOutField = By.id("qf-0q-localised-check-out");
	private By rooms = By.xpath(".//*[@id='qf-0q-compact-occupancy']/option[1]");
	private By search = By.cssSelector(".cta.cta-strong");
	private static By errorMessage = By.className("form-error");
	private By widget = By.className("cta widget-overlay-close");
	private By continueOn = By.linkText("Continue to Hotels.com");
	private By datePicker = By.xpath("//*[@class='widget-datepicker-bd']/descendant::a");
	
	
	public void clickOnDestinationField() {
		clickOn(destinationTextField);
	}

	public void enterDestination(String enterDestination) {
		sendText(destinationTextField, enterDestination);
	}
	
	public void enterCheckinDate(String givenDate) throws InterruptedException{
		clearText(checkInField);
		Thread.sleep(1000);
		sendText(checkInField, givenDate);
	}
	
	public void enterCheckoutDate(String givenDate) throws InterruptedException{
		clearText(checkOutField);
		Thread.sleep(1000);
		sendText(checkOutField, givenDate);
	}
	
	public void clickOnCheckin(){
		clickOn(checkInField);
	}
	
	public void clickOnCheckout(){
		clickOn(checkOutField);
	}
	
	public void clickOnRooms() {
		clickOn(rooms);
	}
	
	public void clickOnSearch(){
		clickOn(search);
	}
	
	public String getErrorText(){
		return getTextFromElement(errorMessage);	
	}
	
	public void closeWidget(){
		clickOn(widget);
	}
	
	public void continueOnHotels(){
		clickOn(continueOn);
	}
	
	public String getDate(){
		return findElement(checkInField).getAttribute("value");
	}
	
}

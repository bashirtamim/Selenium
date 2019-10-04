package framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GroupsPage extends BasePage{
//#And I set the ideal monthly budget from $70 to $108
	private By destiantion = By.id("txtCity1");
	private By clickOutsideOnPage = By.id("group-form-custom-fields");
	private By checkin = By.id("CheckInDate1_disp");
	private By checkout = By.id("CheckOutDate1_disp");
	private By checkOutDateText = By.id("CheckOutDate1");
//	private By addAnotherCity = By.id("addDestination");
	private By groupType = By.id("groupType");
	private By roomField = By.id("rooms");
	private By twoToFourRating = By.xpath(".//*[@id='starRatingRow']/div/ul/li[4]");
	private By continuteButton = By.className("Submit");
	private By closeCalendar = By.className("closeDatepicker");
//	private By closeCalendar = By.linkText("CLOSE");
	
	private By formBox = By.id("frmRequestSmart");
	private By groupsAndMeetingPage = By.id("hdr-groups");
	private By enterfullName = By.id("FullName");
	private By email = By.id("input-email");
	private By errorMsg = By.className("errorMsg");
	private By individualBooking = By.linkText("Click here for individual bookings");
	private By secretPriceMsg = By.className("title");
	private By businessMeeting = By.xpath(".//*[@id='groupType']/option[5]");
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By ratingButton = By.className("star-select");
	
	private By destinationDropDown = By.cssSelector(".pac-container.pac-logo.hdpi");
	private By numberOfDestinationSuggestions = By.className("pac-item");
	private By leftMonthTitleInCheckinCalendar = By.className("ui-datepicker-title");
	private By rightMonthTitileInCheckinCalendar = By.className("ui-datepicker-title");
	
	private By destinationErrorMsg = By.xpath(".//*[@id='group-form-destination']/div[1]/div[1]/div/span[1]");
	private By CheckinErrorMsg = By.xpath(".//*[@id='group-form-destination']/div[1]/div[1]/div/span[2]");
	private By CheckoutErrorMsg = By.xpath(".//*[@id='group-form-destination']/div[1]/div[1]/div/span[3]");
	
	//click on groups and meetings link from Home Page
	public void clickOnGroupsPage(){
		clickOn(groupsAndMeetingPage);
	}
	//clicks on close icon from calender pop up in check-in/check-out box
	public void clickOnCloseCalendar(){
		clickOn(closeCalendar);
	}
	public void clickOnDestination() {
		clickOn(destiantion);
	}
	
	public void clickOnChecInField(){
		clickOn(checkin);
	}

	public void enterDestination(String enterDestination) {
		sendText(destiantion, enterDestination);
	}
	
	public void enterCheckinDate(String givenDate) throws InterruptedException{
		clearText(checkin);
		Thread.sleep(1000);
		sendText(checkin, givenDate);;
	}
	
	public void enterCheckoutDate(String givenDate) throws InterruptedException{
		clearText(checkout);
		Thread.sleep(1000);
		sendText(checkout, givenDate);;
	}
	
	public String getTextFromCheckOutFieldOnGroupsPage(){
		return findElement(checkOutDateText).getAttribute("value");
	}
	
	public void clickOnBusinessMeetingFromDropDown() throws InterruptedException{
		clickOn(groupType);
		Thread.sleep(1000);
		clickOn(businessMeeting);
	}
	
	public void enterRoomNumber(String numberOfRooms){
		sendText(roomField, numberOfRooms);;
	}
	
	public void selectRating() throws InterruptedException{
		clickOn(ratingButton );
		Thread.sleep(2000);
		clickOn(twoToFourRating);
	}
	
	public void enterName(String givenName){
		clickOn(enterfullName);
		sendText(enterfullName, givenName);
	}
	
	public String getFirstName(){
		return findElement(firstName).getAttribute("placeholder");
	}
	
	public String getLastName(){
		return findElement(lastName).getAttribute("placeholder");
	}
	
	public void enterEmail(String givenEmail){
		clickOn(email);
		sendText(email, givenEmail);
	}
	
	public void clickOnContinue(){
		clickOn(continuteButton);
	}
	
	public String getErrorMessage(){
		return findElement(errorMsg).getText();
	}
	
	public void clickOnIndiviaulLink(){
		clickOn(individualBooking);
	}
	
	public String getSceretMessage(){
		return findElement(secretPriceMsg).getText();
	}
	
	public void scrollDown() throws InterruptedException{
		scrollToTheBottomOfPage();
	}
	
	public void scrollUp() throws InterruptedException{
		scrollUpToTheTopOfPage();
	}
	
	public void getCoordinatesOFormfBox(){
		getCoordinates(formBox);
	}
	
	public int getDestinationDropDown(){
		List<WebElement> numberOfSuggestions =  findElement(destinationDropDown).findElements(numberOfDestinationSuggestions);
		return numberOfSuggestions.size();
	}
	
	public void clearDestinationField(){
		clearText(destiantion);
		clickOn(clickOutsideOnPage);
	}
	
	public void verifyCurrentAndFollowingMonthDisplayed(){
		Assert.assertEquals(findElement(leftMonthTitleInCheckinCalendar).getText(), getCurrentMonth());
		Assert.assertEquals(findElement(rightMonthTitileInCheckinCalendar).getText(), getNextMonth());
	}
	
	public void veriifyErrorMsg(){
		Assert.assertEquals(findElement(destinationErrorMsg).getText(), "Specify \"Destination City\" before submitting");
		Assert.assertEquals(findElement(CheckinErrorMsg).getText(), "Specify \"Check-in Date\" before submitting");
		Assert.assertEquals(findElement(CheckoutErrorMsg).getText(), "Specify \"Check-out Date\" before submitting");
	}
	
}

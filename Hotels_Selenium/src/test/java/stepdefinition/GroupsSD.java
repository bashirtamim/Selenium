package stepdefinition;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.GroupsPage;
import framework.HomePage;

public class GroupsSD  {
	
	GroupsPage groupsPage = new GroupsPage();
	HomePage homepage = new HomePage();
	
	@Given ("^I am on Groups and Meetings page in hotels.com website$")
	public void iAmOnGroupsPage() throws InterruptedException {
//		homepage.continueOnHotels();
		groupsPage.clickOnGroupsPage();
		Thread.sleep(2000);
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Group Hotel Quote Request", "Invalid Home Page");
        Thread.sleep(1000);
    }
	
	@When("^I enter (.+) into destination text field on Gourps and Meetings Page$")
	public void enterDataInDestinationField(String destination) throws InterruptedException {
	    groupsPage.clickOnDestination();
	    groupsPage.enterDestination(destination);
	   	Thread.sleep(1000);
	}

	@And("^I enter date (.*?) into Check In text field on Groups Page$")
    public void enterDateInCheckin(String givenDate) throws InterruptedException{
		groupsPage.enterCheckinDate(givenDate);
		Thread.sleep(1000);
	}

//	@And("^Then I verify that ‘2nd August’ is selected as default for Check-out date$")
//	public void enterDateInCheckout(String givenDate) throws InterruptedException {
//		groupsPage.enterCheckoutDate(givenDate);
//		Thread.sleep(1000);
//	}
	
	@Then ("^I verify that (.*?) is selected as default for Check-out date on Groups Page$")
	public void verifyCheckOutDate(String givenDate) throws InterruptedException{
		Assert.assertEquals(groupsPage.getTextFromCheckOutFieldOnGroupsPage(), givenDate);
		Thread.sleep(1000);
	}
	
	@And("^I click on close button in the date dropdown menu on Groups Page$")
	public void closeCalendarDropdown() throws InterruptedException{
		groupsPage.clickOnCloseCalendar();
		Thread.sleep(1000);
	}
	
	@And("^I click on group type dropdown menu and choose business meeting$")
	public void clickOnBusinessMeeting() throws InterruptedException{
		groupsPage.clickOnBusinessMeetingFromDropDown();
		Thread.sleep(1000);
	}
	
	@And("^I enter (.+) into the number rooms per night text input field")
	public void enterRoomNumber(String numberOfRooms) throws InterruptedException{
		groupsPage.enterRoomNumber(numberOfRooms);
		Thread.sleep(1000);
	}
	
	@And("^I click on ideal star rating and select 2-4 star$")
	public void clickOnRating() throws InterruptedException{
		groupsPage.selectRating();
		Thread.sleep(1000);
	}
	
	@And("^I enter (.+) into full name text input field$")
	public void enterFullName(String givenName) throws InterruptedException{
		groupsPage.enterName(givenName);
		Thread.sleep(1000);
	}
	
	@Then("^I verify that full name textfield gets separated into first name and last name input field$")
	public void verifyFirstAndLastName() throws InterruptedException{
		String actual1 = groupsPage.getFirstName();
		String actual2 = groupsPage.getLastName();
		String expected1 = "First Name";
		String expected2 = "Last Name";
		Assert.assertEquals(actual1, expected1);
		Assert.assertEquals(actual2, expected2);
		Thread.sleep(1000);
	}
	
	@And ("^I enter (.+) into Email text input field$")
	public void enterEmailInGroupsPage(String givenEmail) throws InterruptedException{
		groupsPage.enterEmail(givenEmail);
		Thread.sleep(1000);
	}
	
	@And ("^I click on continue button in Groups Page$")
	public void clickOnContinueButton() throws InterruptedException{
		groupsPage.clickOnContinue();
		Thread.sleep(1000);
	}
	
	@Then ("^I verify that a message is displayed with individual booking link and room number being minimum 9$")
	public void verifyErrorMessage() throws InterruptedException{
		Assert.assertEquals(groupsPage.getErrorMessage(), "The Hotels.com groups and extended stay quotation service is for groups of 9+ rooms per night or a 29+ night extended stay. Click here for individual bookings");
		Thread.sleep(2000);
	}
	
	@When ("^I click on link for individual booking$")
	public void clickOnBookingLink(){
		groupsPage.clickOnIndiviaulLink();
	}
	@Then("^I verify that I am on hotels.com home page$")
    public void iAmOnHomePage() throws InterruptedException {
		Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals", "Invalid Home Page");
        Thread.sleep(2000);
    }
	
	@And ("^I verify that a pop-up box suggesting secret prices in displayed on page’s bottom right$")
	public void verifyPopUp() throws InterruptedException{
		groupsPage.scrollDown();
		Thread.sleep(2000);
		Assert.assertEquals(groupsPage.getSceretMessage(), "Save an extra $32 on average with Secret Prices");
		Thread.sleep(2000);
	}
	
	//regression 5
	@When ("^I scroll down to the bottom of the page$")
	public void scrollDownToBottom() throws InterruptedException{
		groupsPage.scrollDown();
		Thread.sleep(1000);
	}
	
	@Then ("^I verify that the form request box is on the right side of the page$")
	public void verifyFormBoxLocation() throws InterruptedException{
		groupsPage.getCoordinatesOFormfBox();
		Thread.sleep(2000);
	}
	
	@When ("^I scroll to the top of the page$")
	public void scrollUpToTop() throws InterruptedException{
		groupsPage.scrollUp();
		Thread.sleep(3000);
	}
	
	@Then ("^I verify that (.+) dropdown suggestions are displayed$")
	public void verifyNumberOfDestinationSugesstions(int numberOfSuggestion) throws InterruptedException{
		Assert.assertEquals(groupsPage.getDestinationDropDown(), numberOfSuggestion);
		Thread.sleep(1000);
	}
	
	@And ("^I clear the destination textfield$")
	public void clearDestinationTextField() throws InterruptedException{
		groupsPage.clearDestinationField();
		Thread.sleep(1000);
	}
	
	@When ("^I click in check in box$")
	public void clickOnCheckinBox() throws InterruptedException{
		groupsPage.clickOnChecInField();
		Thread.sleep(1000);
	}
	
	@Then ("^I verify that current month and following month is displayed$")
	public void verifyCurrentMonthDisplayed() throws InterruptedException{
		groupsPage.verifyCurrentAndFollowingMonthDisplayed();
		Thread.sleep(1000);
	}
	
	@Then ("^I verify that three specific warning messages are displayed$")
	public void verifySpecificErrorMessage() throws InterruptedException{
		groupsPage.veriifyErrorMsg();
		Thread.sleep(1000);
	}
}









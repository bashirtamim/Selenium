package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HomePage;
import org.testng.Assert;

public class HomeSD {

    private HomePage homePage = new HomePage();

    @Given("^I am on hotels.com home page.$")
    public void iAmOnHomePage() throws InterruptedException {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals", "Invalid Home Page");
        Thread.sleep(2000);
    }

    @When("^I enter (.+) into destination text field on home screen$")
    public void enterDataInDestinationField(String destination) throws InterruptedException {
//    	homePage.continueOnHotels();
    	homePage.clickOnDestinationField();
    	homePage.enterDestination(destination);
    	Thread.sleep(2000);
    }

    @And("^I enter date (.*?) into Check In text field.$")
    public void enterDateInCheckin(String givenDate) throws InterruptedException{
//    	homePage.clickOnCheckin();
    	homePage.enterCheckinDate(givenDate);
    	Thread.sleep(2000);
    }

    @And("^I enter date (.*?) into Check out text field.$")
    public void enterDateInCheckout(String givenDate) throws InterruptedException {
//    	homePage.clickOnCheckout();
    	homePage.enterCheckoutDate(givenDate);
    	Thread.sleep(2000);
    }
    
    @And("^I select 1 room, 1 adult from rooms drop down$")
    public void selectOneRoomOneAdult() throws InterruptedException{
    	homePage.clickOnRooms();
    	Thread.sleep(2000);
    }
    
    @And ("^I click on search button$")
    public void clickOnSearchButton() throws InterruptedException{
    	homePage.clickOnSearch();
    	Thread.sleep(2000);
    }
    @Then("^I verify that error message is displayed on search screen.$")
    public void verifySearchMessage() throws InterruptedException {
        Assert.assertEquals(homePage.getErrorText(), "To book more than 28 nights, look at Long Stays");
        Thread.sleep(2000);
    }
    @Then("^I verify the Check In date (.*?) is displayed on Check In text field$")
    public void verifyDate(String expectedDate) throws InterruptedException{
    	homePage.clickOnRooms();
    	Thread.sleep(2000);
    	Assert.assertEquals(homePage.getDate(), expectedDate);
    }
}
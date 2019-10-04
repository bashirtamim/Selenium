package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.SigninPage;

public class SigninSD {

	 private SigninPage signinPage = new SigninPage();
	 
	 @When("^I click on ‘sign in’ link$")
	 public void clickOnSigninLink() throws InterruptedException{
		 signinPage.clickOnSigninLink();
		 Thread.sleep(1000);
	 }
	 
	 @Then("^I verify that I am on sign in page$")
	 public void verifySigninPage() throws InterruptedException{
		Assert.assertEquals(SharedSD.getDriver().getTitle(), "Sign In");
		Thread.sleep(1000);
	 }
	 
	 @When ("^I enter (.+) into Email textfield$")
	 public void enterEmailinSignin(String givenEmail) throws InterruptedException{
		 signinPage.enterEmail(givenEmail);
		 Thread.sleep(1000);
	 }
	 
	 @And ("^I enter (.+) into password text input field$")
	 public void enterPasswordinSignin(String givenPassword) throws InterruptedException{
		 signinPage.enterPassword(givenPassword);
		 Thread.sleep(2000);
	 }
	 
	 @And("^I click on Sign in Button$")
	 public void clickOnSignin() throws InterruptedException{
		 signinPage.clickOnSignInButton();
		 Thread.sleep(1000);
	 }
	 
	 @Then ("^I verify that the page contains “Book Online or call 866-476-8771’$")
	 public void verifyPhoneNumber() throws InterruptedException{
		 Assert.assertEquals(signinPage.getBookingOnlineMsg(), "Book online or call");
		 Assert.assertEquals(signinPage.getPhoneNumber(), "866-476-8771");
		 Thread.sleep(1000);
	 }
	 
	 @And ("^I verify that the page contains six dropdown at the bottom of the page and get their titles$")
	 public void verifyDropDownTextTitle() throws InterruptedException{
		 JavascriptExecutor jsx = (JavascriptExecutor)SharedSD.getDriver();
	     jsx.executeScript("window.scrollBy(0,450)", "");
			
		 Assert.assertEquals(signinPage.gettopDestinationText(), "Top Destinations");
		 Assert.assertEquals(signinPage.gettopCountriesText(), "Top Countries");
		 Assert.assertEquals(signinPage.getcustomerServiceText(), "Customer Service");
		 Thread.sleep(1000);
		 Assert.assertEquals(signinPage.getOtherExpediaText(), "Other Expedia Inc. sites");
		 Assert.assertEquals(signinPage.getForSuppliersText(), "For Suppliers, Affiliates and the Media");
		 Thread.sleep(1000);
		 Assert.assertEquals(signinPage.getUserTermsText(), "User Terms and Privacy Policy");
	 }
	 @And ("^I get the titles all the individual links that this page contains$")
	 public void getIndividualLinks() throws InterruptedException{
		 signinPage.getAllLinksFromWebPage();
		 Thread.sleep(1000);
	 }
	 
	 @And ("^I verify that (Top Destination|Top Countries|Customer Service|Other Expedia Inc.|For Suppliers|User Terms and Privacy Policy) dropdown contains (.+) links$")
	 public void verifyLinkNumbers(String linkDescription, int linkNumbers) throws InterruptedException{
		 switch(linkDescription){
		 	case "Top Destination" :
		 		Assert.assertEquals(signinPage.verifyDestinationLinks(), linkNumbers);
		 		break;
		 	case "Top Countries" :
		 		Assert.assertEquals(signinPage.verifyCountriesLinks(), linkNumbers);
		 		break;
		 	case "Customer Service" :
		 		Assert.assertEquals(signinPage.verifyCustomerLinks(), linkNumbers);
		 		break;
		 	case "Other Expedia Inc." :
		 		Assert.assertEquals(signinPage.verifyOtherExpediaLinks(), linkNumbers);
		 		break;
		 	case "For Suppliers" :
		 		Assert.assertEquals(signinPage.verifyForSuppliersLinks(), linkNumbers);
		 		break;
		 	case "User Terms and Privacy Policy" :
		 		Assert.assertEquals(signinPage.verifyUserTermsLinks(), linkNumbers);
		 		break;
		 }
	 }
	 
	 @When ("^I click on Sign out button$")
	 public void clickOnSignout() throws InterruptedException{
		 JavascriptExecutor jsx = (JavascriptExecutor)SharedSD.getDriver();
	     jsx.executeScript("window.scrollBy(0,-450)", "");
	     Thread.sleep(1000);
	     signinPage.clickOnSignOutButton();
	     Thread.sleep(1000);
	 }
	 
	 @Then ("^I verify that I am on log out page$")
	 public void verifyLogOutPage() throws InterruptedException{
		 Thread.sleep(1000);
		 Assert.assertEquals(signinPage.verifyLogOut(), "You have been logged out successfully.");
		 Thread.sleep(1000);
	 }	 
}
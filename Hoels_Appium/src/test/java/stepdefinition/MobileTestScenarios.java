package stepdefinition;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.SignInScreen;
import framework.SplashScreen;

public class MobileTestScenarios {
	private SplashScreen splashScreen = new SplashScreen();
	private SignInScreen signInScreen = new SignInScreen();

	@Given("^I click on (ok|menu|sign in|your reservation) button on splash screen$")
	public void clickOnSplashScreenButton(String button) {
		switch (button) {
		case "ok":
			splashScreen.clickOnOkButton();
			break;
		case "menu":
			splashScreen.clickOnMenuIcon();
			break;
		case "sign in":
			splashScreen.clickOnSignInButton();
			break;
		case "your reservation":
			splashScreen.clickOnYourReservationButton();
			break;
		}
	}

	@When("^I enter (.+) into (username|password) text field on sign in screen$")
	public void enterUsernameAndPassword(String value, String field) {
		if (field.equals("password")) {
			signInScreen.enterPasswordField(value);
		} else {
			signInScreen.enterUserName(value);
		}
	}

	@When("^I click on sign in button on sign in screen$")
	public void signInButton() {
		signInScreen.clickOnSignInButton();
	}

	@Then("^I verify invalid sign in error message$")
	public void verifyInvalidSignInErrorMessage() {
		Assert.assertEquals(signInScreen.getInvalidLoginErrorMessage(),
				"Sorry, we can’t verify your sign-in details. Please check that your email address and password are correct.");
	}
}

package framework;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignInScreen extends BaseMobilePage {
	
    private static By emailField = MobileBy.id("com.hcom.android:id/txt_sign_in_email_address");
    private static By passwordField = MobileBy.id("com.hcom.android:id/txt_sign_in_password");
    private static By signInButton = MobileBy.id("com.hcom.android:id/aut_sig_p_signin_btn_sign_in");
    private static By alertMessage = MobileBy.id("com.hcom.android:id/alertMessage");

    public void enterUserName(String email) {
        setValue(emailField, email);
    }

    public void enterPasswordField(String password) {
        setValue(passwordField, password);
    }

    public void clickOnSignInButton() {
        clickOn(signInButton);
    }

    public String getInvalidLoginErrorMessage() {

        return getValueFromElementByText(alertMessage);
    }

}

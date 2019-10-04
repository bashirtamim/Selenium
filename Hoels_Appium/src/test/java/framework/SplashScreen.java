package framework;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
public class SplashScreen extends BaseMobilePage{

    private static By okButton = MobileBy.id("com.hcom.android:id/btnPositive");
    private static By menuImageButton = MobileBy.className("android.widget.ImageButton");
    private static By signInButton = MobileBy.id("com.hcom.android:id/drawer_header_sign_in");
    private static By yourReservationButton = MobileBy.xpath("//android.widget.TextView[@text='Your reservations']");

    public void clickOnOkButton() {
        clickOn(okButton);
    }

    public void clickOnMenuIcon() {
        clickOn(menuImageButton);
    }

    public void clickOnSignInButton() {
        clickOn(signInButton);
    }

    public void clickOnYourReservationButton() {
        clickOn(yourReservationButton);
    }
}

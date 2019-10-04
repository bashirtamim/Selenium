package stepdefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SharedSD {
//	public static final String USERNAME = "TestUser";
//	public static final String ACCESS_KEY = "423be000-ef59-4e60-a23d-e45a98064f4c";
//	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	private static final String myURL = "https://hotels.com/";
	private static final String GroupsURL = "https://groups.hotels.com/GroupForm.cfm?locale=en_US&intlid=HOME+%3A%3A+header_main_section&kw=header3";
	private static WebDriver driver = null;

	@Given("^I open the default browser$")
	@Before
	public static void before() throws MalformedURLException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/Bashir/Desktop/ChromeDriver/chromedriver");
//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//	    caps.setCapability("platform", "Windows XP");
//	    caps.setCapability("version", "43.0");
	    
//		driver = new RemoteWebDriver(new URL(URL), caps);
	    driver = new ChromeDriver();
	    Dimension d = new Dimension(1440, 900);
        driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(myURL);
		
	}

	@Then("^I close the default browser$")
	@After
	public static void after() {
		driver.quit();

//		if (driver != null) {
//			driver.manage().deleteAllCookies();
//			driver.quit();
		
		}
	

	public static WebDriver getDriver() {
		return driver;
	}
}

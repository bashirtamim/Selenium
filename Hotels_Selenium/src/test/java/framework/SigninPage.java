package framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

public class SigninPage extends BasePage {
	
	private By signinLink = By.linkText("Sign in");
	private By emailField = By.name("Email");
	private By passField = By.name("Password");
	private By signinButton = By.xpath(".//*[@id='Sign-In-Box']/form/div[2]/div[3]/button");
	private By signoutButton = By.linkText("Sign out");
	private By bookOnlineMsg = By.className("msg");
	private By phoneNumber = By.className("phone-1");
	
	private By logoutText = By.className("logout-intro");
	
	private By topDestination = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[1]/h3");
	private By linkOfTopDestination = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[1]/ul");
	
	private By topCountries	 = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[2]/h3");
	private By linkOfTopCountries = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[2]/ul");
	
	private By customerService = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[3]/h3");
	private By linkOfCustomerService = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[3]/ul");
	
	private By otherExpedia = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[4]/h3");
	private By linksOfOtherExpedia = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[4]/ul");
	
	private By forSuppliers = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[5]/h3");
	private By linkOfSuppliers = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[5]/ul");
	
	private By userTerms = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[6]/h3");
	private By linkOfUsers = By.xpath(".//*[@id='section-links']/div[1]/ul[1]/li[6]/ul");
	
	public void clickOnSigninLink(){
		clickOn(signinLink);
	}
	
	public void clickOnSignInButton(){
		clickOn(signinButton);
	}
	
	public void enterEmail(String givenEmail){
		sendText(emailField, givenEmail);
	}
	
	public void enterPassword(String givenPassword){
		sendText(passField, givenPassword);
	}
	
	public String getBookingOnlineMsg(){
		return findElement(bookOnlineMsg).getText();
	}
	
	public String getPhoneNumber(){
		return findElement(phoneNumber).getText();
	}
	
	public String gettopDestinationText(){
       return findElement(topDestination).getText();
	}
	public String gettopCountriesText(){
        return findElement(topCountries).getText();
	}
	public String getcustomerServiceText(){
        return findElement(customerService).getText();
	}
	public String getOtherExpediaText(){
        return findElement(otherExpedia).getText();
	}
	public String getForSuppliersText(){
        return findElement(forSuppliers).getText();
	}
	public String getUserTermsText(){
        return findElement(userTerms).getText();
	}
	
	public void getLinks(){
		getAllLinksFromWebPage();
	}
	
	public int verifyDestinationLinks() throws InterruptedException{
		clickOn(topDestination);
		Thread.sleep(1000);
		WebElement sel = SharedSD.getDriver().findElement(linkOfTopDestination);
		List<WebElement> links = sel.findElements(By.tagName("a"));
		return links.size();

	}
	
	public int verifyCountriesLinks() throws InterruptedException{
		scrollToTheBottomOfPage();
		clickOn(topCountries);
		Thread.sleep(1000);
		WebElement sel = SharedSD.getDriver().findElement(linkOfTopCountries);
		List<WebElement> links = sel.findElements(By.tagName("a"));
		return links.size();
	}
	
	public int verifyCustomerLinks() throws InterruptedException{
		scrollToTheBottomOfPage();
		clickOn(customerService);
		Thread.sleep(1000);
		WebElement sel = SharedSD.getDriver().findElement(linkOfCustomerService);
		List<WebElement> links = sel.findElements(By.tagName("a"));
		return links.size();
	}
	
	public int verifyOtherExpediaLinks() throws InterruptedException{
		clickOn(otherExpedia);
		Thread.sleep(1000);
		WebElement sel = SharedSD.getDriver().findElement(linksOfOtherExpedia);
		List<WebElement> links = sel.findElements(By.tagName("a"));
		return links.size();
	}
	
	public int verifyForSuppliersLinks() throws InterruptedException{
		scrollToTheBottomOfPage();
		clickOn(forSuppliers);
		Thread.sleep(1000);
		WebElement sel = SharedSD.getDriver().findElement(linkOfSuppliers);
		List<WebElement> links = sel.findElements(By.tagName("a"));
		return links.size();
	}
	
	public int verifyUserTermsLinks() throws InterruptedException{
		scrollToTheBottomOfPage();
		clickOn(userTerms);
		Thread.sleep(1000);
		WebElement sel = SharedSD.getDriver().findElement(linkOfUsers);
		List<WebElement> links = sel.findElements(By.tagName("a"));
		return links.size();
	}
	
	public void clickOnSignOutButton(){
		clickOn(signoutButton);
	}
	
	public String verifyLogOut(){
		return findElement(logoutText).getText();
	}
}
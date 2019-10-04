package framework;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import stepdefinition.SharedSD;


public class BasePage {

	public void clickOn(By locator) {
		try {
			SharedSD.getDriver().findElement(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void sendText(By locator, String text) {
		try {
			SharedSD.getDriver().findElement(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public static String getTextFromElement(By locator) {
		String text = null;
		try {
			text = SharedSD.getDriver().findElement(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}

	public void clickOnBrowserBackArrow() {
		SharedSD.getDriver().navigate().back();
	}

	public void clickOnBrowserForwardArrow() {
		SharedSD.getDriver().navigate().forward();
	}

	public void refreshBrowser() {
		SharedSD.getDriver().navigate().refresh();
	}
	
	public void clearText(By locator){
		SharedSD.getDriver().findElement(locator).clear();
	}
	
	public WebElement findElement(By locator){
		return SharedSD.getDriver().findElement(locator);
	}
	
	//method to get all the links from a page
	public void getAllLinksFromWebPage(){
		java.util.List<WebElement> links = SharedSD.getDriver().findElements(By.tagName("a"));
		System.out.println("Number of links this page contains : "+links.size());
//		for (int i = 1; i<=links.size(); i=i+1){
//			System.out.println(links.get(i).getText());
//		}
	}
	
	public void scrollToTheBottomOfPage() throws InterruptedException{
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
		//vertical scroll down by 450 pixel
		 js.executeScript("window.scrollBy(0,450)", "");
	}
	
	public void scrollUpToTheTopOfPage() throws InterruptedException{
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
		//vertical scroll down by 450 pixel
		 js.executeScript("window.scrollBy(0,-450)", "");
	}
	
	//method to select element from drop down 
	public void selectFromDropDown(By locator) throws InterruptedException{
		//select value from drop
		Select dropdown = new Select(findElement(locator));
		//select element by visible text
		dropdown.selectByVisibleText("jan");
		Thread.sleep(5000);
		//select element by index
		dropdown.selectByIndex(3);
		//select element by value
		dropdown.selectByValue("4");
		Thread.sleep(5000);
		
		
		List<WebElement> allOptions = dropdown.getOptions();
		boolean isFOund = false;
		for(WebElement option: allOptions){
			if(option.getText().equals("jan")){
				System.out.println("January was found in Dropdown");
				isFOund = true;
				break;
			}
		}
		if(isFOund == false){
			Assert.fail("Specified month was not found in dropdown");
		}
	}
	
	//method to get position of an element from the page
	public void getCoordinates(By locator){
		WebElement Image = SharedSD.getDriver().findElement(locator);
	        
	    //Used points class to get x and y coordinates of element.
		Point point = Image.getLocation();
		int xcord = point.getX();
		System.out.println("Element's Position from left side Is "+xcord +" pixels.");
		int ycord = point.getY();
		System.out.println("Element's Position from top side Is "+ycord +" pixels.");
	}
	
	//this method gets current month and year in upper case letter
	public String getCurrentMonth(){
		Calendar c = new GregorianCalendar();
		c.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("MMMMMMMM YYYY");
		String currentMonth = sdf.format(c.getTime());
		String upperCaseMonth = currentMonth.toUpperCase();
		return upperCaseMonth;   // NOW
	}
	
	//this method gets next month and year in upper case letter
	public String getNextMonth(){
		Calendar c = new GregorianCalendar();
		c.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("MMMMMMMM YYYY");
//		c.add(Calendar.MONTH, +1);
		String nextMonth = sdf.format(c.getTime());
		String upperCaseMonth =  nextMonth.toUpperCase();
		return  upperCaseMonth;  // One month ago
	}
	
	//Scroll automatically to Webelement 
	
//	Point hoverItem =driver.findElement(By.xpath("Value")).getLocation();
//	((JavascriptExecutor)driver).executeScript("return window.title;");    
//	Thread.sleep(6000);
//	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");"); 
//	// Adjust your page view by making changes right over here (hoverItem.getY()-400)
	
//	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("Value')]")));
//	(or)
//	WebElement element = driver.findElement(By.xpath("Value"));
//	Coordinates coordinate = ((Locatable)element).getCoordinates(); 
//	coordinate.onPage(); 
//	coordinate.inViewPort();
	
	//method to select todays date
	public void selectDateFromCalendar(String givenDate, By locator) throws InterruptedException{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/d/yy");
		Date date = new Date();
		givenDate = sdf.format(date);
		
		SharedSD.getDriver().findElement(By.xpath(".//*[@id='qf-0q-localised-check-in']")).click();
		List<WebElement> days = SharedSD.getDriver().findElements(locator);
		ArrayList<String> selectDays = new ArrayList<>();
		
		
			for(WebElement day: days){
			String expectedDay = day.getText();
			if(expectedDay.equals(givenDate)){
				selectDays.add(expectedDay);
				day.click();
				Thread.sleep(3000);
				break;
			}
		}
	}
	
}

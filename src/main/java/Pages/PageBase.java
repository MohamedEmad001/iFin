package Pages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {

	//define protect webdriverclass object to be visible through this class or child classes only
	//public static WebDriver driver;
	//Create Constructor to centralize the webdriver

	protected static WebDriver driver1;
	public Select select;
	public Actions Action;


	private static WebDriver jsWaitDriver;
	private static WebDriverWait jsWait;
	private static JavascriptExecutor jsExec;

	public PageBase(WebDriver driver)

	{

		//this.driver = driver;
		PageFactory.initElements(driver, this);
		driver1=driver;

	}




	//create generic method to click function
	//create generic method to send keys function with passing the key words string

	protected static void DropListSelect (WebElement dropList,int Value)
	{
		Select dropMenuSelect = new Select(dropList);
		dropMenuSelect.selectByIndex(Value);
	}

	protected void clickButton(WebElement button)
	{
		button.click();
	}

	protected void setTextElementText (WebElement textbox , String text)
	{
		textbox.sendKeys(text);
	}

	protected void Checkingcheckbox (WebElement Checkbox)
	{
		Checkbox.click();
	}

	protected void DoubleClickonElement(WebElement button)
	{
		Action = new Actions(driver1);
		Action.doubleClick(button).perform();

	}

	protected void SingleClickonElement(WebElement button)
	{
		Action = new Actions(driver1);
		Action.doubleClick(button).perform();

	}

	protected void switchFrame (String frameID)
	{
		//WebDriverWait wait = new WebDriverWait(driver1,3000);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameID));
		driver1.switchTo().frame(frameID);
	}

	protected void waitMethod(int timeInSeconds)
	{
		driver1.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);

	}



	protected void ConfirmAlert()
	{
		driver1.switchTo().alert().accept();
	}

	protected void deleteValueFromControl(WebElement element)
	{
		element.clear();
	}


	/*	protected void SearchModule (WebElement textbox , String moduleName , String frameID) throws InterruptedException
	{
		Thread.sleep(20000);
		textbox.sendKeys(moduleName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		textbox.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		textbox.sendKeys(Keys.ALT, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame(frameID);

	}*/


	public void TakeScreenShots(WebDriver driver , String ScreenShortname) throws IOException
	{

		Path dest = Paths.get("./ScreenShots" , ScreenShortname +".png");
		Files.createDirectories(dest.getParent());		
		FileOutputStream out = new FileOutputStream(dest.toString());
		out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
		out.close();

	}


	protected String  StoreData (WebElement textbox)
	{
		return textbox.getAttribute("value");
	}


	public WebElement waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver1,30);		
		element = wait.until(ExpectedConditions.elementToBeClickable(element));


		return element;
	}

	public WebElement waitForElementPresenceinDOM(String xpathString) {

		WebDriverWait wait = new WebDriverWait(driver1,30);	

		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathString)));

	}




	public Boolean waitForCheckResult(WebElement element, String text) {

		WebDriverWait wait = new WebDriverWait(driver1,30);		
		return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/*public Boolean waitForExpectedGeneratedAttribute(WebElement element,String GeneratedValue ) {

		WebDriverWait wait = new WebDriverWait(driver1,30);	
		return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, GeneratedValue));
		/*GeneratedValue = element.getAttribute("Value");
		return wait.until(ExpectedConditions.attributeToBe(element, "Value", GeneratedValue));*/


	public Boolean waitForGeneratedCode(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver1,30);	
		String GeneratedValue = element.getAttribute("Value");
		return wait.until(ExpectedConditions.attributeToBe(element, "Value", GeneratedValue));
	}

	public Boolean waitForGeneratedValue(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver1,30);	
		return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "Value"));
	}

	public Boolean waitForExpectedGeneratedValue(WebElement element, String Value) {

		WebDriverWait wait = new WebDriverWait(driver1,30);	
		return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, Value));
	}

	public WebDriver waitForFrame(String FrameID) {

		WebDriverWait wait = new WebDriverWait(driver1,50);		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameID));

	}


	public WebElement waitForSelection(WebElement element22) {

		WebDriverWait wait = new WebDriverWait(driver1,50);		
		return wait.until(ExpectedConditions.visibilityOf(element22));

	}

	public boolean waitForElementToBeEmpty(WebElement targetElement) {

		WebDriverWait wait = new WebDriverWait(driver1,50);		
		return wait.until(ExpectedConditions.attributeToBe(targetElement, "value", ""));

	}

	public Alert waitForConfirmationMsg() {

		WebDriverWait wait = new WebDriverWait(driver1,30);		
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	//////////Method to open LOV and Saerch on item then select it from the results////////////
	public void openLOVAndSearch(WebElement lovIcon, String subFrameId, WebElement quickSearchField, String searchItem, WebElement searchResult, String parentFrameId ) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver1,30);	
		wait.until(ExpectedConditions.elementToBeClickable(lovIcon));
		clickButton(lovIcon);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(subFrameId));
		wait.until(ExpectedConditions.elementToBeClickable(quickSearchField));
		setTextElementText(quickSearchField, searchItem);
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		Thread.sleep(4000);
		DoubleClickonElement(searchResult);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(parentFrameId));

	}


	//FluentWait Method for polling a wait time for a specific locator
	public void fluentWaitMethod(WebElement targetElement)
	{

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver1)
				.withTimeout(Duration.ofSeconds(200))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>()
		{

			public WebElement apply(WebDriver d) {
				d = driver1;
				return targetElement;
			}
		});

	}

	/*
	////////////////////////////wait until javascript and jQuery to finish loading///////////////////////////////////
	public boolean waitForJStoLoad() {

	    WebDriverWait wait = new WebDriverWait(driver1, 30);

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Long)js.executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        return ("return document.readyState")
	            .toString().equals("complete");
	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	 */


	////////////////////////wait until javascript to finish loading/////////////////////////////////
	public void checkPageIsReady() {

		JavascriptExecutor js = (JavascriptExecutor)driver1;
		//WebDriverWait wait = new WebDriverWait(driver1, 30);

		//Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")){ 
			System.out.println("Page Is loaded.");
			return; 
		} 

		//This loop will rotate for 25 times to check If page Is ready after every 1 second.
		//You can replace your value with 25 If you wants to Increase or decrease wait time.
		for (int i=0; i<25; i++){ 
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {} 
			//To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")){ 
				break; 
			}   
		}
	}
	//method to verify the space of download folder before and after the download to assert the downloading is suuccessfully finished
	public boolean isFileDownloaded(String downloadPath) 
	{
		boolean flag = false;
		File dir = new File(downloadPath);
		//File[] dir_contents = dir.listFiles();
		long currentFileileUsableSpace = dir.getUsableSpace(); 

		for (int i = 0; i < dir.length();) {

			if (dir.getUsableSpace()> currentFileileUsableSpace)

				i++;
			return flag=true;
		}

		return flag;
	}

	//Get the Currenct DAy to handle the date picker
	public String getCurrentDay(){
		//Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		//Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Int: " + todayInt +"\n");

		//Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Str: " + todayStr + "\n");

		return todayStr;
	}


	public static void setDriver(WebDriver driver) {
		jsWaitDriver = driver;
		jsWait = new WebDriverWait(jsWaitDriver, 200);
		jsExec = (JavascriptExecutor) jsWaitDriver;
	}


	public static boolean waitForLazyLoading() throws InterruptedException {

		// waitForJQueryLoadIfDefined();
		//waitForAngularIfDefined();
		waitForJSLoadIfDefined();
		return true;
	}
		//private static WebDriver jsWaitDriver;
		public static void waitForJSLoadIfDefined() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver1, 200);
			JavascriptExecutor jsExec = (JavascriptExecutor) driver1;

			// Wait for Javascript to load
			ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver1)
					.executeScript("return document.readyState").toString().trim().equalsIgnoreCase("complete");

			// Get JS is Ready
			boolean jsReady = (Boolean) jsExec.executeScript("return document.readyState").toString().trim()
					.equalsIgnoreCase("complete");

			// Wait Javascript until it is Ready!
			if (!jsReady) {
				// Wait JS until it is Ready!
				int tryCounter = 0;
				while ((!jsReady) && (tryCounter < 5)) {
					// Wait for Javascript to load
					wait.until(jsLoad);
					// More Wait for stability (Optional)
					sleep(20);
					tryCounter++;
					jsReady = (Boolean) jsExec.executeScript("return document.readyState").toString().trim()
							.equalsIgnoreCase("complete");
				}
			}
		}

		//define a method for the sleep period
		private static void sleep(Integer milliSeconds) throws InterruptedException 
		{
			long secondsLong = (long) milliSeconds;
			Thread.sleep(secondsLong);
		}



	}

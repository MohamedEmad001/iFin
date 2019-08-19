package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;

import tests.TestBase;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		driver1 = driver;
	}

	WebDriver driver1;

	TestBase testBaseObj;

	@FindBy (xpath="//*[@id=\"Username\"]")
	WebElement LoginName;

	@FindBy (xpath = "//*[@id=\"Password\"]")
	WebElement Loginpassword;


	@FindBy (xpath = "//*[@id=\"login-box\"]/div/div[1]/form/fieldset/div/button")
	WebElement Loginbtn;


	@FindBy (xpath = "//*[@id=\"select2-prodClassDropDown-container\"]/span")
	WebElement productType;


	public void UserLogin() throws InterruptedException
	{

		setTextElementText(LoginName, "creator123@gmail.com");
		setTextElementText(Loginpassword, "123456");
		clickButton(Loginbtn);
		/*
		if(driver1.getTitle().contains("5002"))
		{
		waitForElement(LoginName);
		setTextElementText(LoginName, "dealcreator@alizzislamic.com");
		setTextElem entText(Loginpassword, "123456");
		clickButton(Loginbtn);
		}
		 */
		waitForLazyLoading();
		driver1.get("http://192.168.112.44:5002");
		//driver1.getTitle().replaceAll("http://192.168.112.44:5002/signin-oidc/", "http://192.168.112.44:5002");
		Actions action = new Actions(driver1);
		action.sendKeys(Keys.ENTER);


		//waitForElement(productType);

	}



}

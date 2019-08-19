package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import Pages.LoginPage;
import Pages.newDealPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;


public class newDealTest extends TestBase {

	@Test (priority = 0)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin();

	}

	@Test (dependsOnMethods = {"CheckLogin"})
	@Description ("Create New Deal TC")
	@Link (name ="Google",url="http://www.google.com")
	public void createNewDeal() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		
		//Thread.sleep(5000);
		//tests.TestBase.driver.get("http://192.168.112.44:5002");
		//driver1.getTitle().replaceAll("http://192.168.112.44:5002/signin-oidc/", "http://192.168.112.44:5002");
		//Actions action = new Actions(driver);
		//action.sendKeys(Keys.ENTER);

		
		newDealPage newDealObj = new newDealPage(driver);
		newDealObj.CreateNewDeal();
	}

}


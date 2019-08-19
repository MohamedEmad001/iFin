package tests;


import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Pages.LoginPage;



public class LoginTest extends TestBase {
	

	@Test (priority = 0)
	public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin();
	
	}
	

}

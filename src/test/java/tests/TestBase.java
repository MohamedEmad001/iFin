package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.qameta.allure.Attachment;
import utilities.Helper;




public class TestBase {
	
	//define public object from webdriver 
	public static WebDriver driver;
	
	/*String jsonFilePath = "/src/test/java/TestData/FundData.json";
	String [] jkeys = {"UserName", "UserPass"};
	String [] testCaseInputs = {"UserName", "UserPass"};*/
	
	//String JsonWriterFile = System.getProperty("user.dir") + "/src/test/java/TestData/WriteData.json";
	//before suite will run before any @Test annotation
	//at this before suite will open the browser ans maxmize the window, also wait for miximazation then pass the URL
	@BeforeSuite
	@Parameters ({"browser"})
	public void startDriver(@Optional ("chrome") String browsername) throws InterruptedException, IOException, ParseException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		
		driver.navigate().to("http://192.168.112.44:5002");
		//driver.navigate().to("https://apps.ifin-services.com/uatOAuth2/account/login?returnUrl=%2FuatOAuth2%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dretailers_uat%26redirect_uri%3Dhttps%253A%252F%252Fapps.ifin-services.com%252Fuatretailers%252F%26response_mode%3Dform_post%26response_type%3Dcode%2520id_token%2520token%26scope%3Dopenid%2520profile%2520role%2520offline_access%2520organizationid%2520clientid%2520inactiveclient%2520forcereset%2520LegalEntityApis%2520TokenServerApis%2520branchid%26state%3DOpenIdConnect.AuthenticationProperties%253DkSmVlI8FUQtpN5TKjWTHLYEUdgR3zh5Fd4rjkDP1Lxm67whZTaWX1W2mD9JaJICVCjXtBHmY5S6qPnSGZiBJ2U5oIYvz-PjHKAkCHogd5MqvaDV1FnsveGs4jMWRPe29tJRPsVruMlhqZZ1jgYrw6mzFTaq-wLnHoAMW5Z_8PZKa8KB-vGMrwhnzKW0jANVWrrXS1vCJQS3oErMaNl-7uWqex97AzpQvC31jn3PXSB2qWVxLFTgEgcbu8zmh8676%26nonce%3D636975829290682519.NWMyYTJhYWQtZDQxOS00YjYyLWI1N2UtNDQ1NjIyZjBjNzg0MTdiZTU4NGUtNzU2MS00NmE3LTkyMmItMDQxMTM3ZTMwYzRl");
		
		
		
		
		
		//driver.navigate().to("http://192.168.112.33/I50FINDemo/Default.aspx");	
		//driver.navigate().to("http://192.168.113.4/i50qc/Default.aspx");	
		//driver.navigate().to("http://192.168.112.44/I50QC/Security/SignIn.aspx");
		//driver.navigate().to("http://192.168.112.44/I50GulfQC/security/Signin.aspx");
		//driver.navigate().to("http://192.168.112.33/I50DEV/security/Signin.aspx");

	}
	
	
	
	/*public void CheckLogin() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		JsonDataReader jsonFileReader = new JsonDataReader();
		//define hashtable object to recieve the return value of jsonreaderdata method based on the prefix, keys and TC inputs
		Hashtable<String,String> jData = jsonFileReader.JsonReaderData(jsonFilePath, "CheckLogin" , jkeys, testCaseInputs);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.UserLogin(jData);
		
		JsonDataWriter jsonFileWriter = new JsonDataWriter();
		String [] x = {"adminstartor"};
		String [] y = {"admin12"};
		jsonFileWriter.JsonWriteData(JsonWriterFile, "LoginData", x, y);
	}*/
	
	/*
	@AfterMethod
	@Attachment (value = "Page screenshot", type = "image/png")
	public String takeScreenshots(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Success!...." + "Taking Screenshot " + result.getMethod().getMethodName() + " " + result.getMethod().getDate());
			Helper.CaptureScreenshots(driver, result.getMethod().getMethodName());
				
		}
		
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			System.out.println("Success!...." + "Taking Screenshot " + result.getMethod().getMethodName() + " " + result.getMethod().getDate());
			Helper.CaptureScreenshots(driver, result.getMethod().getMethodName());
		}
		
		else
		{
			System.out.println("Success!...." + "Taking Screenshot " + result.getMethod().getMethodName() + " " + result.getMethod().getDate());
			Helper.CaptureScreenshots(driver, result.getMethod().getMethodName());
		}
		return result.toString();
			
	}
	*/
	//after suite annotation will execute code after any @Test annotation
	//here after @Test code finished will close the driver
	@AfterSuite
	public void stopDriver()
	{
		//driver.quit();
	}


}

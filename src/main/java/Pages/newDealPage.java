package Pages;

import static org.testng.Assert.assertEquals;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.google.common.base.Function;

public class newDealPage extends PageBase {

	public newDealPage(WebDriver driver) {
		super(driver);
		driver1 = driver;
	}

	WebDriver driver1;
	Faker fakeData = new Faker();
	
	@FindBy (xpath="//*[@id=\"prodClassDropDown\"]")
	WebElement productType;
	
	
	@FindBy (xpath="//*[@id=\"brandDropDown\"]")
	WebElement productBrand;
	

	
	@FindBy (xpath="//*[@id=\"prodNameDropDown\"]")
	WebElement productName;
	

	@FindBy (xpath="//*[@id=\"itemSerialDropDown\"]")
	WebElement serialNO;
	
	@FindBy (xpath="//*[@id=\"colorSelectorId\"]")
	WebElement colorType;
	
	@FindBy (xpath="//*[@id=\"DeliveryDate\"]")
	WebElement delivaryDatePanel;
	
	@FindBy (xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody")
	WebElement delivaryDateCalender;
	//*[@id="ui-datepicker-div"]/table/tbody/tr[1]/td[3]/a
	//*[@id="ui-datepicker-div"]/table/tbody/tr[1]/td[4]/a
	@FindBy (xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[4]")
	WebElement DelivaryDate;
	
	@FindBy (xpath="//*[@id=\"addToCart\"]/div[5]/div[2]/a")
	WebElement addToCartBtn;
	//*[@id="deal-wizard"]/div[3]/ul/li[2]/a
	//*[@id="deal-wizard"]/div[3]/ul/li[2]/a
	//*[@id="deal-wizard"]/div[3]/ul/li[2]
	
	@FindBy (xpath="//*[@id=\"deal-wizard\"]/div[3]/ul/li[2]")
	WebElement nextButton;

	@FindBy (xpath="//*[@id=\"cartItems\"]/tbody/tr/td[2]/label")
	WebElement confirmSerialNo;
	
	//locate the deal price
	@FindBy (xpath="//*[@id=\"cartItems\"]/tbody/tr/td[6]/div/label")
	WebElement dealPrice;
	//locate the sepecific product setup
	@FindBy (xpath="//*[@id=\"#product\"]")
	WebElement productSetup;
	
	@FindBy (xpath="//*[@id=\"totalAmount\"]")
	WebElement totalAmount;
	
	@FindBy (xpath="//*[@id=\"widget-box-6\"]/div[1]")
	WebElement paymentPlanDiv;
	//locate elements of Customer Details page
	
	@FindBy (xpath="//*[@id=\"type\"]")
	WebElement idTypeDropList;
	
	@FindBy (xpath="//*[@id=\"customerId\"]")
	WebElement customerId;
	
	@FindBy (xpath="//*[@id=\"btnSearch\"]")
	WebElement customerSearchBtn;
	
	@FindBy (xpath="//*[@id=\"GenInsFrom\"]")
	WebElement installmentsStartDate;
	
	@FindBy (xpath="/html/body/div[4]/div[2]/div/div/div/div/div/div/div/div[4]/button[1]")
	WebElement continueBtn;
	
	@FindBy (xpath="//*[@id=\"widget-box-6\"]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/div")
	WebElement finalProductSetup;
	
	@FindBy (xpath="//*[@id=\"tenure\"]")
	WebElement paymentTenorMonth;
	
	@FindBy (xpath="//*[@id=\"widget-box-6\"]/div[2]/div/div/div/div[1]/table/tbody/tr/td[5]/div")
	WebElement paymentMonthlyInstallments;

	@FindBy (xpath="//*[@id=\"widget-box-6\"]/div[2]/div/div/div/div[1]/table/tbody/tr/td[6]/div/a")
	WebElement paymentCharges;
	
	@FindBy (xpath="//*[@id=\"deal-wizard\"]/div[3]/ul/li[3]/a")
	WebElement finalSubmitBtn;
	
	@FindBy (css="body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-buttons > button.btn.btn-blue")
	WebElement submitBtn;
	
	@FindBy (css="body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-buttons > button")
	WebElement okBtn;

	@FindBy (css="body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div")
	WebElement statusText;	
	
	@FindBy (xpath ="//*[@id=\"jconfirm-box17178\"]")
	WebElement approvalRefNo;
	
	@FindBy (css ="body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-content-pane.no-scroll")
	WebElement ApprovalMsg;
	
	@FindBy (css ="body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-buttons > button:nth-child(1)")
	WebElement continueWithDealBtn ;
	
	@FindBy (css ="#main-container > div.main-content > div > div > div.container > div:nth-child(2)")
	WebElement productPanelContainer ;
	
	@FindBy (xpath ="//*[@id=\"Deal_details_dv\"]/table/tbody/tr/td[4]")
	WebElement finalSerialNo;
	
	@FindBy (xpath ="//*[@id=\"deal_financial_details_dv\"]/table/tbody/tr[1]/td[2]")
	WebElement finalTotalPrice;
	
	@FindBy (xpath ="//*[@id=\"btnPrint\"]")
	WebElement printContractBtn;
	
	@FindBy (xpath ="//*[@id=\"btnRePrint\"]")
	WebElement rePrintContractBtn;
	
	@FindBy (xpath ="//*[@id=\"deal_financial_details_dv\"]/table/tbody/tr[5]/td[2]")
	WebElement finalInstallmentsNo;
	
	public static String SerialNo; 
	public static String DealPrice; 
	public static String InstallmentDate = "01082019";
	public static String ProductSetupName;
	public static String PaymentTenorMonth;
	public static String PaymentMonthlyInstallments;
	public static String Paymentcharges;
	public static String AcceptMsg = "Dear ( Alizz Retailer We hereby accept your offer and hereby complete the purchase of the items specified in the Application";
	private static String downloadPath = "C:\\Users\\Mohamed.Emad\\Downloads";
	private String today;
	
	
	
	public void CreateNewDeal() throws InterruptedException
	{
		//create new deal and save serial no for assertion
		waitForElement(productType);
		DropListSelect(productType, 2);
		
		waitForElement(productBrand);
		DropListSelect(productBrand, 2);
		
		waitForElement(productName);
		DropListSelect(productName, 2);
		
		SerialNo = fakeData.code().isbn10();
		setTextElementText(serialNO,SerialNo);
		setTextElementText(colorType, "werw");
		System.out.println(SerialNo);
		clickButton(delivaryDatePanel);
		waitForElement(DelivaryDate);
		
		//get the current day, Open the Calender date picker, loop on the table columns"td" and click on the current day date
		today = getCurrentDay();
	    System.out.println("Today's number: " + today + "\n");
	    
	    List<WebElement> columns = delivaryDateCalender.findElements(By.tagName("td"));
	    
	    for (WebElement cell: columns) {
            //Select Today's Date
            if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
        }
	    
		//clickButton(DelivaryDate);
		clickButton(addToCartBtn);
		Thread.sleep(3000);
		clickButton(nextButton);
		//navigate to Deal Items and assert on the serial No
		waitForElement(confirmSerialNo);
		DealPrice = dealPrice.getText();
		assertEquals(confirmSerialNo.getText(), SerialNo);
		clickButton(nextButton);
		//Naviagte to Finance Offers to select the product setup and assert on the total mount then click next after payment div shown up
		waitForElement(productSetup);
		assertEquals(totalAmount.getText(), DealPrice);
		clickButton(productSetup);
		ProductSetupName = productSetup.getText();
		waitForElement(paymentPlanDiv);
		clickButton(nextButton);
		//Navigate to Customer Details and select National Id then insert the cutomer code "95667755" then insert the Installment Date from pop-up
		//then click continue
		waitForElement(idTypeDropList);
		DropListSelect(idTypeDropList, 1);
		setTextElementText(customerId, "95667755");
		clickButton(customerSearchBtn);
		waitForElement(installmentsStartDate);
		setTextElementText(installmentsStartDate, InstallmentDate);
		clickButton(continueBtn);
		Thread.sleep(3000);
		clickButton(nextButton);
		//Navigate to Finish Page and assert on the Tenor, Monthly Installment, Charges and Plan Name then click submit and confirm the submit from the alert
		//check the status of the deal and reference No for assertion
		//then click on continue with the same deal
		waitForElementPresenceinDOM("//*[@id=\"widget-box-6\"]/div[1]"); 
		//assertEquals(finalProductSetup.getAttribute("	Text").replaceAll("\\s+",""), ProductSetupName.replaceAll("\\s+",""));
		PaymentTenorMonth = paymentTenorMonth.getAttribute("Value");
		PaymentMonthlyInstallments = paymentMonthlyInstallments.getText();
		Paymentcharges = paymentCharges.getText(); 
		clickButton(finalSubmitBtn);
		waitForElement(submitBtn);
		clickButton(submitBtn);
		//System.out.println(approvalRefNo.getAttribute("innerHTML"));
		Thread.sleep(2000);
		waitForElement(okBtn);
		clickButton(okBtn);
		waitForElement(continueWithDealBtn);
		System.out.println(ApprovalMsg.getText());
		assertEquals(ApprovalMsg.getText(), AcceptMsg);
		clickButton(continueWithDealBtn);
		//Assert on Serial No and total price of deal 
		waitForElement(productPanelContainer);
		assertEquals(finalSerialNo.getText(), SerialNo);
		//assert on the installments No by get the last Payable in: and replace all the characters of the sentence with empty char  
		String FinalInstallmentsNo = finalInstallmentsNo.getText();
		assertEquals(FinalInstallmentsNo.replaceAll(FinalInstallmentsNo.substring(2, FinalInstallmentsNo.length()), ""), PaymentTenorMonth);
		assertEquals(finalTotalPrice.getText().replaceAll(" OMR", ""), DealPrice);
		//print the contract and verify the downloading is done successfully to the local drive
		clickButton(printContractBtn);
		waitForElement(rePrintContractBtn);
	    Assert.assertTrue(isFileDownloaded(downloadPath), "Failed to download Expected document");
	    
	}
	
	public void openContractReport()
	{
		
		
	}
	
}

package com.amplify.test.suite1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amplify.test.baseTest.Functions;
import com.amplify.test.pages.AddNewLoanPopUp;
import com.amplify.test.pages.AdminHomePage;
import com.amplify.test.pages.AdminLoanOverview;
import com.amplify.test.pages.Login;
import com.amplify.test.pages.UnderwriterChecklistReviewPage;
import com.amplify.test.pages.UnderwriterHomePage;
import com.amplify.test.pages.UnderwriterLoanOverviewPage;
import com.amplify.test.pages.UnderwriterTasksPage;
import com.amplify.test.pages.ViewLoanPopup;
import com.amplify.test.util.ExcelUtils;
import com.amplify.test.util.Log1;

public class TC001_VerifyAddLoanFunctionality extends Functions {
	

	public static Functions func;
	static SoftAssert softAssert;
	Login login ;
	AdminHomePage adminHomePage;
	AdminLoanOverview adminLoanOverview;
	AddNewLoanPopUp addNewLoanPopUp;
	@BeforeTest
	public static void setUp() throws Exception{
		func=new Functions();
		func.readProperties();
		func.LoadBrowser();
		softAssert =new SoftAssert();
			}
	
	@Test(priority=0)
	public void VerifyLoginThroughAdminUserRole(){
		try{
		login = new Login(driver);
		Log1.info("**************Starting VerifyLoginThroughAdminUserRole Test*****************");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Log1.info("Login with Admin");
		
		login.setUserName(propertiesData.getProperty("admin.userName"));
		login.setPassword(propertiesData.getProperty("admin.pass"));
		
		Log1.info("Click Login Button");
		login.clickLogin();
		Log1.info("Verifying Successfull Login Through Administrator");
		Assert.assertEquals(driver.getTitle(),"AMPLIFY - Administration Overview");
		
		Log1.info("*************Ending VerifyLoginThroughAdminUserRole Test");
		}
		catch(Exception e){
			System.out.println("******Exception occured==" + e);
			Assert.fail();
			Log1.error("Exception in VerifyLoginThroughUnderwriterUserRole Test Case "+e);		
		}
	}
	@Test(priority=1,enabled=true)
	public void VerifyAdditionOfLoanThroughAdminRole(){
		try{
		Log1.info("**************Starting VerifyAdditionOfLoanForAdmin Test*****************");
		adminLoanOverview= new AdminLoanOverview(driver);
		adminHomePage=new AdminHomePage(driver);
		addNewLoanPopUp =new AddNewLoanPopUp(driver);
		
		adminHomePage.clickLoanOverview();
		adminLoanOverview.clickAddNewLoanButton();
		addNewLoanPopUp.sendLoanNumber(propertiesData.getProperty("LoanNo"));
		addNewLoanPopUp.sendBorrowersFirstName("Sahil");
		addNewLoanPopUp.sendBorrowersLastName("Test");
		addNewLoanPopUp.sendPropertyStreetAddress("123");
		addNewLoanPopUp.sendPropertyCity("city");
		addNewLoanPopUp.selectPropertyStateDropdown();
		addNewLoanPopUp.sendPropertyZipCode("123");
		addNewLoanPopUp.sendTotalLoanAmountField("32");
		addNewLoanPopUp.selectlNProgDropdown(); 
		addNewLoanPopUp.selectdocTypeDropdown();
		func.scrollPageDown();
		addNewLoanPopUp.selectloanTypeDropdown();
		addNewLoanPopUp.selectOccupancyDropdown();
        addNewLoanPopUp.sendRespaApplicationDate("11/1/2017");
        addNewLoanPopUp.sendestimatedClosingDate("11/1/2017");
        addNewLoanPopUp.sendlockExpDate("11/1/2017");
        addNewLoanPopUp.clickAddNewLoanButton();
        String successMsg= addNewLoanPopUp.getSuccessMessage();
        addNewLoanPopUp.clickOkButtonOnInfoPopup();
        
        Log1.info("Verifying Success Message");
        Assert.assertEquals(successMsg, "Loan added successfully!");
		Log1.info("*************Ending VerifyAdditionOfLoanForAdmin Test");
		}catch(Exception e){
			System.out.println("******Exception occured==" + e);
			Assert.fail();
			Log1.error("Exception in VerifyLoginThroughUnderwriterUserRole Test Case "+e);		
		}
		
	}
}

package com.amplify.test.suite1;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amplify.test.baseTest.Functions;
import com.amplify.test.pages.AddNewLoanPopUp;
import com.amplify.test.pages.AdminFileAssPage;
import com.amplify.test.pages.AdminHomePage;
import com.amplify.test.pages.AdminLoanOverview;
import com.amplify.test.util.Log1;

public class TC002_VerifyingFileAssignmentFunctionality extends Functions {
	
	public static Functions func;
	static SoftAssert softAssert;
	AdminFileAssPage adminFileAssPage;
	AdminHomePage adminHomePage;
	
	@BeforeClass
	public static void setUp() throws Exception{
		func=new Functions();
		func.readProperties();
		/*func.LoadBrowser();*/
		softAssert =new SoftAssert();
			}

@Test(priority=1)
public void ValidateAssignLoantoUnderwriterRole(){
	try{
	Log1.info("**************Starting ValidateAssignLoantoUnderwriterRole Test*****************");
	adminFileAssPage= new AdminFileAssPage(driver);
	adminHomePage=new  AdminHomePage(driver);
	ImplicitWait(5);
	adminHomePage.clickFileAssTab();
	adminFileAssPage.clickUnderwriterTab();
	adminFileAssPage.clickSearchButton();
	adminFileAssPage.sendLoan(propertiesData.getProperty("LoanNo"));
	adminFileAssPage.clickSecondSearchButton();

	adminFileAssPage.SelectloanInTable();
	adminFileAssPage.clickAssistedAssignSelectedButton();
	Thread.sleep(4000);
	adminFileAssPage.clickYesRadioButtonOnLevelOfAuthorityPopup();
	adminFileAssPage.clickSelectButtonOnLevelOfAuthorityPopup();
	adminFileAssPage.clickSearchButtonInside();
	adminFileAssPage.sendTextInNameField("Abhishek.Devaraj");
	adminFileAssPage.clicksecondSearchButtonInside();
	scrollPageDown();
	/*adminFileAssPage.selectUserFromUserList();*/
	Thread.sleep(2000);
	adminFileAssPage.clickLoanPopulatingInTable();
	adminFileAssPage.clickAssignLoanButton();
	softAssert.assertEquals(adminFileAssPage.verifyAssignableLoansCount(),"Assignable Loans: 0 | Unassignable Loans:");
	adminFileAssPage.clickCloseButton();
	softAssert.assertAll();
    Log1.info("Verifying Success Message");
	Log1.info("*************Ending ValidateAssignLoantoUnderwriterRole Test");
	}catch(Exception e){
		System.out.println("******Exception occured==" + e);
		Assert.fail();
		Log1.error("Exception in ValidateAssignLoantoUnderwriterRole Test Case "+e);		
	}
	
}
	
}

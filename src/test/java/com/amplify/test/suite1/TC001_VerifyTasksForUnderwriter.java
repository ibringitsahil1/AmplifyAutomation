package com.amplify.test.suite1;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amplify.test.functions.Functions;
import com.amplify.test.pages.UnderwriterHomePage;
import com.amplify.test.pages.UnderwriterLoanOverviewPage;
import com.amplify.test.pages.UnderwriterTasksPage;
import com.amplify.test.pages.ViewLoanPopup;
import com.amplify.test.pages.Login;
import com.amplify.test.pages.UnderwriterChecklistReviewPage;
import com.amplify.test.util.ExcelUtils;
import com.amplify.test.util.Log1;

public class TC001_VerifyTasksForUnderwriter extends Functions {
	public static Functions func;
	public static boolean Result=false;
	public String loanNo="5123456700200";
	
	Login login;
	UnderwriterHomePage underwriterHomePage;
	UnderwriterLoanOverviewPage underwriterLoanOverPage;
	ViewLoanPopup viewLoanPopup;
	UnderwriterTasksPage underwriterTasksPage;
	UnderwriterChecklistReviewPage underwriterChecklistReviewPage;
	static SoftAssert softAssert;
	@BeforeClass
	public static void setUp() throws Exception{
		func=new Functions();
		func.readProperties();
		func.LoadBrowser();
		func.maxWindowFunc();
		softAssert =new SoftAssert();
			}
	@Test(priority=0)
	public void VerifyLoginThroughUnderwriterUserRole(){
		try{
			login=new Login(driver);
			underwriterHomePage=new UnderwriterHomePage(driver);
			underwriterLoanOverPage=new UnderwriterLoanOverviewPage(driver);
			viewLoanPopup=new ViewLoanPopup(driver);
			underwriterTasksPage=new UnderwriterTasksPage(driver);
		Log1.info("**************Starting VerifyLoginThroughUnderwriterUserRole Test*****************");
		underwriterChecklistReviewPage=new UnderwriterChecklistReviewPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Log1.info("Login with Underwriter");
		login.setUserName("Abhijit.More");
		login.setPassword("Digital123");
		login.clickLogin();
		
		Log1.info("Click Login Button");
		Assert.assertEquals(driver.getTitle(),"AMPLIFY - Underwriter");
		Log1.info("*************Ending VerifyLoginThroughUnderwriterUserRole Test");
		}
		catch(Exception e){
			System.out.println("******Exception occured==" + e);
			Assert.fail();
			Log1.error("Exception in VerifyLoginThroughUnderwriterUserRole Test Case "+e);		
			ExcelUtils.setCellData(3,4,"Fail","VerifyLoginThroughUnderwriterUserRole");
		
		}
	}
		
	@Test(priority=1,dependsOnMethods="VerifyLoginThroughUnderwriterUserRole",enabled=true)
	public void VerifyOpeningOfUWTasksForUnderwriter(){
		try{
		Log1.info("**************Starting VerifyOpeningOfUWTasksForUnderwriter Test*****************");
		login=new Login(driver);
		underwriterHomePage=new UnderwriterHomePage(driver);
		underwriterLoanOverPage=new UnderwriterLoanOverviewPage(driver);
		viewLoanPopup=new ViewLoanPopup(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log1.info("Click Loan Overview Tab");
		underwriterHomePage.clickLoanOverview();
	
		Log1.info("Click Search Button");
		underwriterLoanOverPage.clickSearchButton();
		
		Log1.info("Enter Loan in Loan Number Search Box");
		underwriterLoanOverPage.sendLoan(loanNo);
		
		Log1.info("Click Second Search Button");
		underwriterLoanOverPage.clickSecondSearchButton();
		Thread.sleep(2000);
		Log1.info("Select Loan in Loan Overview Tab");
		underwriterLoanOverPage.SelectloanInTable();
		
		Log1.info("Click Create Checklist Button");
		underwriterLoanOverPage.clickCreateChecklist();
		
		Log1.info("Get Popup Title");
		underwriterLoanOverPage.getAlertMessage();
		
		Log1.info("close Popup window");
		underwriterLoanOverPage.clickOkayButtonOnPopup();
		
		Log1.info("Select Loan in Loan Overview Tab");
		underwriterLoanOverPage.SelectloanInTable();
		
		Log1.info("clickViewLoanButton");
		underwriterLoanOverPage.clickViewLoanButton();
		
		Log1.info("clickTasksTabinViewLoanPopup");
		viewLoanPopup.clockTasksTabinViewLoanPopup();
		
		viewLoanPopup.clickTaskNameColumn();viewLoanPopup.clickTaskNameColumn();
		
		viewLoanPopup.getTaskNameinFirstRow();
		Thread.sleep(2000);
		softAssert.assertEquals(viewLoanPopup.getStatusNameinFirstRow(),"Open");	//has to be changed to OPEN
		viewLoanPopup.closeViewLoanPopup();
		softAssert.assertAll();
		}catch(Exception e){
			System.out.println("******Exception occured =" + e);
			Assert.fail();
			Log1.error("Exception in VerifyOpeningOfUWTasksForUnderwriter Test Case "+e);		
			ExcelUtils.setCellData(3,4,"Fail","VerifyOpeningOfUWTasksForUnderwriter");
		}
		
	}
	@Test(priority=2,enabled=true)
	public void VerifyifOpenedUWTasksPopulatesInMyTasksForUnderwriter(){
		try{
		Log1.info("**************Starting VerifyifOpenedUWTasksPopulatesInMyTasksForUnderwriter Test*****************");	
		Thread.sleep(4000);
		underwriterTasksPage.clickTasksTab();
		Thread.sleep(3000);
		underwriterTasksPage.clickNewAndOpenSubTab();
		Thread.sleep(3000);
		underwriterTasksPage.clickSearchButton();
		underwriterTasksPage.sendLoan(loanNo);
		underwriterTasksPage.clickSecondSearchButton();
		Thread.sleep(2000);
		System.out.println(underwriterTasksPage.getTaskNameOfloanSearched());
		Assert.assertEquals(underwriterTasksPage.getTaskNameOfloanSearched(), "UW");
		Log1.info("*************Ending VerifyifOpenedUWTasksPopulatesInMyTasksForUnderwriter Test");

		}catch(Exception e){
			System.out.println("*******Exception occured" + e);
			Assert.fail();
			Log1.error("Exception in VerifyifOpenedUWTasksPopulatesMyTasksForUnderwriter Test Case "+e);		
			ExcelUtils.setCellData(3,4,"Fail","VerifyifOpenedUWTasksPopulatesMyTasksForUnderwriter");
		}
		
	}
	@Test(priority=3,dependsOnMethods="VerifyifOpenedUWTasksPopulatesInMyTasksForUnderwriter",enabled=true)
	public void VerifyCompletionOfUWTaskForUnderwriter(){
		try{
		Log1.info("**************Starting VerifyCompletionOfUWTaskForUnderwriter Test*****************");


		underwriterChecklistReviewPage.clickChecklistReviewTab();
		underwriterChecklistReviewPage.clickSearchButton();
		Thread.sleep(2000);
		underwriterChecklistReviewPage.sendLoan(loanNo);
		underwriterChecklistReviewPage.clickSecondSearchButton();
		Thread.sleep(2000);
		underwriterChecklistReviewPage.SelectloanInTable();
		underwriterChecklistReviewPage.clickPerformReviewButton();
		underwriterChecklistReviewPage.clickFirstIssueRadioButton();
		underwriterChecklistReviewPage.clickUpdateCommentLink();
		underwriterChecklistReviewPage.sendTextInCommentTextBox("Test Comment");
		underwriterChecklistReviewPage.clickSaveCommentTextBox();
		underwriterChecklistReviewPage.clickSecondNoIssueRadioButton();
		underwriterChecklistReviewPage.clickThirdNoIssueRadioButton();
		underwriterChecklistReviewPage.clickCompleteReviewButton();
		underwriterChecklistReviewPage.clickYesButton();
		Log1.info("*************Ending VerifyCompletionOfUWTaskForUnderwriter Test");

		}catch(Exception e){
			System.out.println("*******Exception occured" + e);
			Log1.error("Exception in VerifyCompletionOfUWTaskForUnderwriter Test Case "+e);		
			ExcelUtils.setCellData(3,4,"Fail","VerifyCompletionOfUWTaskForUnderwriter");
			Assert.fail();		
		}
		
	}
	@Test(priority=4)
	public void VerifyifClosedUWTasksPopulatesInMyTasksForUnderwriter(){
		try{
		Log1.info("**************Starting VerifyifClosedUWTasksPopulatesInMyTasksForUnderwriter Test*****************");
		Thread.sleep(7000);
		underwriterTasksPage.clickTasksTab();
		Thread.sleep(3000);
		underwriterTasksPage.clickCompletedTab();
		Thread.sleep(3000);
		underwriterTasksPage.clickSearchButtonInCompletedTab();
		underwriterTasksPage.sendLoanInCompletedTab(loanNo);
		underwriterTasksPage.clickSecondSearchButtonInCompletedTab();
		Thread.sleep(2000);
		System.out.println(underwriterTasksPage.getTaskNameOfloanSearchedInCompletedTab());
		Assert.assertEquals(underwriterTasksPage.getTaskNameOfloanSearchedInCompletedTab(), "UW");
		Log1.info("*************Ending VerifyifClosedUWTasksPopulatesInMyTasksForUnderwriter Test");

		}catch(Exception e){
			System.out.println("*******Exception occured" + e);
			Assert.fail();
			Log1.error("Exception in VerifyifClosedUWTasksPopulatesInMyTasksForUnderwriter Test Case "+e);		
			ExcelUtils.setCellData(3,4,"Fail","VerifyifClosedUWTasksPopulatesInMyTasksForUnderwriter");
		}
		
	}
}

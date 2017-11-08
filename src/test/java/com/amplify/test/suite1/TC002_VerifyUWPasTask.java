package com.amplify.test.suite1;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amplify.test.functions.Functions;
import com.amplify.test.pages.Login;
import com.amplify.test.pages.UnderwriterChecklistReviewPage;
import com.amplify.test.pages.UnderwriterHomePage;
import com.amplify.test.pages.UnderwriterLoanOverviewPage;
import com.amplify.test.pages.UnderwriterTasksPage;
import com.amplify.test.pages.ViewLoanPopup;
import com.amplify.test.util.ExcelUtils;
import com.amplify.test.util.Log1;

public class TC002_VerifyUWPasTask extends Functions {
	
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
	public void VerifyIfQCUserSucessfullyPerformUWPass(){
		try{
			login=new Login(driver);
			underwriterHomePage=new UnderwriterHomePage(driver);
			underwriterLoanOverPage=new UnderwriterLoanOverviewPage(driver);
			viewLoanPopup=new ViewLoanPopup(driver);
			underwriterTasksPage=new UnderwriterTasksPage(driver);
		Log1.info("**************Starting VerifyIfQCUserSucessfullyPerformUWPass Test*****************");
		underwriterChecklistReviewPage=new UnderwriterChecklistReviewPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Log1.info("Login with QCUser");
		login.setUserName("AutomationQCUser");
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
			ExcelUtils.setCellData(3,4,"Fail","VerifyIfQCUserSucessfullyPerformUWPass");
		
		}
	}
}

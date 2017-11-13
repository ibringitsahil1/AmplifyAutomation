/*package com.amplify.test.suite1;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amplify.test.baseTest.Functions;
import com.amplify.test.pages.AdminHomePage;
import com.amplify.test.pages.AdminLoanOverview;
import com.amplify.test.pages.Login;
import com.amplify.test.util.ExcelUtils;
import com.amplify.test.util.Log1;

public class VerifyLogin {
	public  WebDriver driver;
	public static Functions func;
	public static boolean Result=false;
	
	Login login=new Login(driver);
	AdminHomePage adminHome =new AdminHomePage();
	AdminLoanOverview adminLoanOverview=new AdminLoanOverview();
	 String TestCaseName="Verify Login";
	 String TestCaseNameSheetName="Sheet1";
	
	@BeforeTest
	public static void setUp() throws Exception{
		func=new Functions();
		func.readProperties();
		func.LoadBrowser();
		func.maxWindowFunc();
			}
	
	//test opening of Login Page
    @Test(description = "Test opening of Login Page")
	public void TestCase_1() throws Exception{
		try{
			Log1.info("Test opening of Login Pages");																		
		Assert.assertEquals(func.getTitle(),"DigitalRisk-Amplify");

		ExcelUtils.setCellData(3,1,"Pass","Test opening of Login Page");
		}
		catch (Exception e) {
			Log1.info("Exception in Test Case 1"+e);		
			ExcelUtils.setCellData(3,1,"Fail","Test opening of Login Page");
		}
		}
	
	//test SuccessFull login
    @Test(description = "test SuccessFull login",dataProvider="LoginUser")
	public void TestCase_2(String user, String pass) throws Exception{
    	try{
			Log1.info("test SuccessFull login");	
 		login.setUserName(user);
		login.setPassword(pass);
		login.clickLogin();
		func.wait(4);
		Thread.sleep(20000);
		Assert.assertEquals(func.getTitle(), "AMPLIFY");
		ExcelUtils.setCellData(3,2,"Pass","test SuccessFull login");
    	}catch(Exception e){
			Log1.info("Exception in Test Case 2"+e);		
			ExcelUtils.setCellData(3,2,"Fail","test SuccessFull login");
    	}
	}
	@DataProvider
	public Object[][] LoginUser() throws Exception{

		return new Object[][]{{"sahil.singh","Digital123"}};
	}
	
	//test Role Changing or not
	@AfterTest
	public void TestCase_3() throws Exception{
		try{
		Thread.sleep(10000);
		adminHome.setUserRole("ClientAdmin");
		Thread.sleep(10000);
		adminLoanOverview.clickLoanOverTab();	
		Thread.sleep(3000);
		adminLoanOverview.fetchLoans();
		ExcelUtils.setCellData(3,3,"Pass","");
		}catch(Exception e){
			Log1.info("Exception in Test Case 3"+e);		
			ExcelUtils.setCellData(3,3,"Fail","");
		}
	}
		
	
}
*/
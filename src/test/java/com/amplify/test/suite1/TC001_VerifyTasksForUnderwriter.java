package com.amplify.test.suite1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amplify.test.functions.Functions;
import com.amplify.test.pages.AddNewLoan;
import com.amplify.test.pages.AdminHomePage;
import com.amplify.test.pages.AdminLoanOverview;
import com.amplify.test.pages.UnderwriterHomePage;
import com.amplify.test.pages.Login;
import com.amplify.test.util.ExcelUtils;
import com.amplify.test.util.Log1;

public class TC001_VerifyTasksForUnderwriter {
	public static WebDriver driver;
	public static Functions func;
	public static boolean Result=false;
	
	Login login=new Login();
	UnderwriterHomePage underwriterHomePage;
	
	@BeforeTest
	public static void setUp() throws Exception{
		func=new Functions();
		func.readProperties();
		func.LoadBrowser();
		func.maxWindowFunc();
			}
	@Test
	public void VerifyUWTasksForCloser(){
		try{
		Log1.info("**************Stating VerifyUWTasksForCloser Test*****************");
		underwriterHomePage=new UnderwriterHomePage(driver);
		login.setUserName("Abhijit.More");
		login.setPassword("Digital123");
		login.clickLogin();
		underwriterHomePage.clickLoanOverview();

		}catch(Exception e){
			System.out.println("Exception occured" + e);
			Log1.info("Exception in AddNewLoan1 Test Case "+e);		
			ExcelUtils.setCellData(3,4,"Fail","Test opening of Login Page");
		}
		
	}
}

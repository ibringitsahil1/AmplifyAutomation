package com.amplify.test.suite1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amplify.test.functions.Functions;
import com.amplify.test.pages.AddNewLoan;
import com.amplify.test.pages.AdminHomePage;
import com.amplify.test.pages.AdminLoanOverview;
import com.amplify.test.pages.Login;
import com.amplify.test.util.ExcelUtils;
import com.amplify.test.util.Log1;

public class AddLoanTest {
	public static WebDriver driver;
	public static Functions func;
	public static boolean Result=false;
	
	Login login=new Login(driver);
	AdminHomePage adminHome =new AdminHomePage();
	AdminLoanOverview adminLoanOverview=new AdminLoanOverview();	
	AddNewLoan addNewLoan=new AddNewLoan();
	
	@BeforeTest
	public static void setUp() throws Exception{
		func=new Functions();
		func.readProperties();
		func.LoadBrowser();
		func.maxWindowFunc();
			}
	@Test
	public void AddNewLoan1(){
		try{
		Log1.info("Test Add New Loan1 Starts");	
		login.setUserName("sahil.singh");
		login.setPassword("Digital123");
		login.clickLogin();
		/*Thread.sleep(60000);*/
		func.visibilityOfElementLocated("//a[contains(.,'Loan Overview')]");
		func.initWclicebLinkText("Loan Overvie").click();
		func.visibilityOfElementLocated("//button[contains(.,'Add New Loan')]");
		func.initWebXpath("//button[@class='btn mx-button mx-name-actionButton9 btn-default']").click();
		func.wait(5);
		Thread.sleep(4000);
		addNewLoan.AddLoan1("123456789","Test");
		}catch(Exception e){
			System.out.println("Exception occured" + e);
			Log1.info("Exception in AddNewLoan1 Test Case "+e);		
			ExcelUtils.setCellData(3,4,"Fail","Test opening of Login Page");
		}
		
	}
}

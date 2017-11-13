package com.amplify.test.customListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.amplify.test.baseTest.Functions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;


/**
 * 
 * @author Bhanu Pratap
 *
 */
public class Listener extends Functions implements ITestListener{

	


	public void onStart(ITestContext arg0) {
		Reporter.log("Test Starts :" + arg0.getName());
		System.out.println("onStart Count ");
	}
	
	public void onFinish(ITestContext arg0) {
		Reporter.log("Test is finished :" + arg0.getName());
		System.out.println("onFinish");
		/*extentReports.close();*/

	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	// Invoked each time a test fails.
	public void onTestFailure(ITestResult result) {
		if(!result.isSuccess()){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			String methodName = result.getName();

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				//System.getProperty("user.dir") tells us current projrct location
				//getAbsolutePath gives complete path of file starting from drive name like absolute xpath
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/amplify/test/";
				File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
				String dest=(String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png";
				FileUtils.copyFile(scrFile, destFile);
				
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
				
				//Write Report in ReportNG
				extentTest.log(LogStatus.FAIL,"Result "+ methodName + " Has Failed");
				extentTest.log(LogStatus.FAIL,"Screenshot of Failed Test : "+ extentTest.addScreenCapture(dest));
				extentTest.log(LogStatus.ERROR,"Test Script Failed Due to Below :-"+System.lineSeparator() + result.getThrowable());
				extentReports.endTest(extentTest);
				extentReports.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}


	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test is skipped:" + arg0.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult arg0) {
		extentReports.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		extentTest=extentReports.startTest(arg0.getName());
	}
	// Invoked each time a test Pass.
	public void onTestSuccess(ITestResult arg0) {
			//ITestResult(testng Class) tells us the status of Test Script pass/fail/skip
		if(arg0.isSuccess()){
			Calendar calendar = Calendar.getInstance(); //to get time
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"); //to format Date/time
			
			String methodName = arg0.getName();
			
			try {
				
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/amplify/test/";
				File destFile = new File((String) reportDirectory + "/pass_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
				String dest=(String) reportDirectory + "/pass_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png";
				FileUtils.copyFile(scrFile, destFile);
				
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
				
				//Write Report in ReportNG
				
				extentTest.log(LogStatus.PASS,"Result : "+ methodName + " Has Passed");
				extentTest.log(LogStatus.PASS,"Screenshot of Passed Test : "+extentTest.addScreenCapture(dest));
				extentReports.endTest(extentTest);
				extentReports.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
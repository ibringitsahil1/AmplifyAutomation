package com.amplify.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amplify.test.baseTest.Functions;

public class AdminHomePage extends Functions{

	@FindBy(xpath="//a[contains(.,'Loan Overview')]")
	WebElement LoanOverviewTab;
	
	@FindBy(partialLinkText="Loan Overvie")
	WebElement clickOnLoanOver;
	
	@FindBy(partialLinkText="File Assignment ")
	WebElement fileAssTab;
	
	public AdminHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoanOverview(){
		waitForElement(driver, 100, LoanOverviewTab);
		clickOnLoanOver.click();	
	}
	public void clickFileAssTab(){
		waitForElement(driver, 10, fileAssTab);
		fileAssTab.click();	
	}
}

package com.amplify.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amplify.test.functions.Functions;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class UnderwriterLoanOverviewPage extends Functions {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id='mxui_widget_ControlBarButton_1']")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@class='mx-grid-search-input mx-name-searchField46']/input")
	WebElement searchLoanNumber;
	
	@FindBy(xpath="//*[@id='mxui_widget_Button_6']")
	WebElement secondSearchButton;
	
	@FindBy(xpath="//*[@id='mxui_widget_DataGrid_1']/div[3]/div/table[2]/tbody/tr[1]/td[1]")
	WebElement loanSearched;
	
	@FindBy(xpath="//*[@id='mxui_widget_ControlBarButton_5']")
	WebElement createChecklistButton;
	
	@FindBy(xpath="//*[contains(@id,'mxui_widget_DialogMessage_')]/div[1]/div[1]/h4")
	WebElement getAlertMessage;
	
	@FindBy(xpath="//*[contains(@id,'mxui_widget_DialogMessage_')]/div[1]/div[1]/button")
	WebElement okButtonPopup;
	
	@FindBy(xpath="//button[@id='mxui_widget_ControlBarButton_3']")
	WebElement viewLoanButton;
	
	@FindBy(linkText="Tasks")
	WebElement tasksTabinViewLoanPopup;
	
	
	
	public  UnderwriterLoanOverviewPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	public void clickSearchButton(){
		waitForElement(driver, 100, searchButton);
		searchButton.click();
	}
	public void sendLoan(String loan){
		waitForElement(driver, 100, searchLoanNumber);
		searchLoanNumber.sendKeys(loan);
	}
	
	public void clickSecondSearchButton(){
		secondSearchButton.click();
	}
	
	public void SelectloanInTable(){
		loanSearched.click();
	}
	public void clickCreateChecklist(){
		createChecklistButton.click();
	}
	public String getAlertMessage(){
		return getAlertMessage.getText();
	}
	public void clickOkayButtonOnPopup(){
		okButtonPopup.click();
	}
	public void clickViewLoanButton(){
		viewLoanButton.click();
		waitForElement(driver,10, tasksTabinViewLoanPopup);
	}
	
}

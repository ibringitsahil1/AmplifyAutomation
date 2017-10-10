package com.amplify.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amplify.test.functions.Functions;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class UnderwriterChecklistReviewPage extends Functions{
WebDriver driver;
	
	@FindBy(xpath="//*[@id='mxui_widget_TabContainer_0']/ul/li[3]/a")
	WebElement checklistReviewTab;
	
	@FindBy(xpath="//*[@id='mxui_widget_ControlBarButton_25']")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@class='mx-grid-search-input mx-name-searchField12']/input")
	WebElement searchLoanNumber;
	
	@FindBy(xpath="//*[@id='mxui_widget_Button_49']")
	WebElement secondSearchButton;
	
	@FindBy(xpath="//*[@id='mxui_widget_DataGrid_7']/div[3]/div/table[2]/tbody/tr[1]/td[1]")
	WebElement loanSearched;
	
	@FindBy(xpath="//*[@data-id='859']")
	WebElement performReviewButton;
	
	@FindBy(xpath="(//input[@type='radio'])[1]")
	WebElement firstIssueRadioButton;
	
	@FindBy(partialLinkText="Update Comment")
	WebElement updateCommentLink;
	
	@FindBy(xpath="//*[@id='mxui_widget_TextArea_3']/textarea")
	WebElement commentTextBox;
	
	@FindBy(xpath="//button[contains(@id,'mxui_widget_SaveButton_')]")
	WebElement clickSaveCommentTextBox;
	
	@FindBy(xpath="(//input[@type='radio'])[4]")
	WebElement secondNoIssueRadioButton;
	
	@FindBy(xpath="(//input[@type='radio'])[6]")
	WebElement thirdNoIssueRadioButton;
	
	@FindBy(xpath="//button[contains(.,'Complete Review')]")
	WebElement completeReviewButton;
	
	@FindBy(xpath="//button[contains(.,'Yes')]")
	WebElement yesButton;
	
	public UnderwriterChecklistReviewPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickChecklistReviewTab(){
		checklistReviewTab.click();
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
		waitForElement(driver, 5, secondSearchButton);
		secondSearchButton.click();
	}
	
	public void SelectloanInTable(){
		loanSearched.click();
	}
	
	public void clickPerformReviewButton(){
		performReviewButton.click();
	}
	public void clickFirstIssueRadioButton(){
		waitForElement(driver, 15, firstIssueRadioButton);
		firstIssueRadioButton.click();
	}
	public void clickUpdateCommentLink(){
		waitForElement(driver, 8, updateCommentLink);
		updateCommentLink.click();
	}
	public void sendTextInCommentTextBox(String comment){
		waitForElement(driver, 8, commentTextBox);
		commentTextBox.sendKeys(comment);;
	}
	public void clickSaveCommentTextBox(){
		clickSaveCommentTextBox.click();
	}
	public void clickSecondNoIssueRadioButton(){
		waitForElement(driver, 8, secondNoIssueRadioButton);
		secondNoIssueRadioButton.click();
	}
	public void clickThirdNoIssueRadioButton(){
		thirdNoIssueRadioButton.click();
	}
	public void clickCompleteReviewButton(){
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(completeReviewButton));
		completeReviewButton.click();
	}
	public void clickYesButton(){
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(yesButton));
		yesButton.click();
	}
}

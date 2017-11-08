package com.amplify.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amplify.test.functions.Functions;

public class UnderwriterChecklistReviewPage extends Functions{
WebDriver driver;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-tabPage18')]")
	WebElement checklistReviewTab;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-searchButton24')]")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@class='mx-grid-search-input mx-name-searchField12']")
	WebElement searchLoanNumber;
	
	@FindBy(xpath="//*[@class='mx-grid mx-datagrid mx-name-grid4']/div/div/button[1]")
	WebElement secondSearchButton;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid mx-datagrid mx-name-grid4')]/div[3]/div/table[2]/tbody/tr[1]/td[1]")
	WebElement loanSearched;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-microflowButton3')]")
	WebElement performReviewButton;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	WebElement firstIssueRadioButton;
	
	@FindBy(partialLinkText="Update Comment")
	WebElement updateCommentLink;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-textArea1')]/textarea")
	WebElement commentTextBox;
	
	@FindBy(xpath="//h4[contains(.,'Responsible Party Comments')]")
	WebElement responsiblePartyCommentsTitle;
	
	@FindBy(xpath="//*[@class='mx-dataview mx-name-dataView2']/div[2]/button[1]")
	WebElement clickSaveCommentTextBox;
	
	@FindBy(xpath="(//input[@type='radio'])[4]")
	WebElement secondNoIssueRadioButton;
	
	@FindBy(xpath="(//input[@type='radio'])[6]")
	WebElement thirdNoIssueRadioButton;
	
	@FindBy(xpath="//button[contains(.,'Complete Review')]")
	WebElement completeReviewButton;
	
	@FindBy(xpath="//button[contains(.,'Yes')]")
	WebElement yesButton;
	
	@FindBy(xpath="//*[contains(@class,'modal-dialog mx-dialog mx-dialog-info')]/div/div[3]/button")
	WebElement okButtonOnInfoPopup;
	
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
	public void clickFirstNoIssueRadioButton(){
		waitForElement(driver, 15, firstIssueRadioButton);
		firstIssueRadioButton.click();
	}

	public void clickSecondNoIssueRadioButton(){
		waitForElement(driver, 8, secondNoIssueRadioButton);
		secondNoIssueRadioButton.click();
	}
	public void clickThirdNoIssueRadioButton(){
		/*JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='222-2222';", commentTextBox);*/
		/*commentTextBox.sendKeys(comment);*/
		Actions action=new Actions(driver);
		 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", thirdNoIssueRadioButton);
		 /*((JavascriptExecutor) driver).executeScript("0,document.body.scrollHeight");*/
		 waitForElement(driver, 8, thirdNoIssueRadioButton);		 
		 action.sendKeys(Keys.PAGE_DOWN).build().perform();
		 action.moveToElement(thirdNoIssueRadioButton).click().build().perform();
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
	public void clickOkButtonOnInfoPopup(){
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(okButtonOnInfoPopup));
		try{
		driver.switchTo().alert().accept();}
		catch(Exception e){
		okButtonOnInfoPopup.click();
		}
	}
}

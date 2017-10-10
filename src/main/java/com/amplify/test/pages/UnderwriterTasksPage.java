package com.amplify.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amplify.test.functions.Functions;

public class UnderwriterTasksPage extends Functions {
	WebDriver driver;
	
	@FindBy(xpath="//*[@class='mx-tabcontainer mx-name-tabControl1']/ul/li[5]/a")
	WebElement tasksTab;
	
	@FindBy(xpath="//a[contains(.,'New & Open')]")
	WebElement newAndOpenTab;
	
	
	@FindBy(xpath="//a[contains(.,'Completed')]")
	WebElement completedTab;
	
	@FindBy(xpath="//button[contains(@class,'btn mx-button mx-name-searchButton36')]")
	WebElement searchButton;
	
	@FindBy(xpath="//button[contains(@class,'btn mx-button mx-name-searchButton29')]")
	WebElement searchButtonInCompletedTab;
	
	@FindBy(xpath="//*[@class='mx-grid-search-input mx-name-searchField213']/input")
	WebElement searchLoanNumber;
	
	@FindBy(xpath="//*[@class='mx-grid-search-input mx-name-searchField193']/input")
	WebElement searchLoanNumberInCompletedTab;
	
	@FindBy(xpath="//div[contains(@class,'mx-grid mx-datagrid mx-name-grid46')]/div/div/button")
	WebElement secondSearchButton;
	
	@FindBy(xpath="//div[contains(@class,'mx-grid mx-datagrid mx-name-grid39')]/div/div/button")
	WebElement secondSearchButtonInCompletedTab;
	
	@FindBy(xpath="//div[contains(@class,'mx-grid mx-datagrid mx-name-grid46')]/div[3]/div/table[2]/tbody/tr[1]/td[2]")
	WebElement taskNameOfloanSearched;
	
	@FindBy(xpath="//div[contains(@class,'mx-grid mx-datagrid mx-name-grid39')]/div[3]/div/table[2]/tbody/tr[2]/td[2]")
	WebElement taskNameOfloanSearchedInCompletedTab;
	
	public UnderwriterTasksPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickTasksTab(){
		WebDriverWait wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(tasksTab));
		wait.until(ExpectedConditions.elementToBeClickable(tasksTab));
		tasksTab.click();
	}
	public void clickNewAndOpenSubTab(){
		newAndOpenTab.click();
	}
	public void clickCompletedTab(){
		completedTab.click();
	}
	public void clickSearchButton(){
		searchButton.click();
	}
	public void sendLoan(String loan){
		searchLoanNumber.sendKeys(loan);
	}
	public void sendLoanInCompletedTab(String loan){
		searchLoanNumberInCompletedTab.sendKeys(loan);
	}
	public void clickSecondSearchButton(){
		secondSearchButton.click();
	}
	
	public String getTaskNameOfloanSearched(){
		return taskNameOfloanSearched.getText();
	}
	
												/*******************Completed Tab*************/
	public void clickSearchButtonInCompletedTab(){
		searchButtonInCompletedTab.click();
	}
	
	public void clickSecondSearchButtonInCompletedTab(){
		secondSearchButtonInCompletedTab.click();
	}
	
	public String getTaskNameOfloanSearchedInCompletedTab(){
		return taskNameOfloanSearchedInCompletedTab.getText();
	}
}

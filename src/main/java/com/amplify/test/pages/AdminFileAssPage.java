package com.amplify.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amplify.test.baseTest.Functions;

public class AdminFileAssPage extends Functions{

	@FindBy(xpath="//*[contains(@class,'mx-tabcontainer mx-name-tabControl33')]/ul/li[6]/a")
	WebElement underwriterTab;
	
	@FindBy(xpath="//*[contains(@class,'btn mx-button mx-name-searchButton184')]")
	WebElement searchButton;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid-search-input mx-name-searchField1165')]/input")
	WebElement searchLoanNumber;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid mx-datagrid mx-name-grid154')]/div/div/button")
	WebElement secondSearchButton;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid mx-datagrid mx-name-grid154')]/div[3]/div/table[2]/tbody/tr[1]/td[1]")
	WebElement loanSearched;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid mx-datagrid mx-name-grid154')]/div[2]//button[contains(@class,'btn mx-button mx-name-microflowButton221')]")
	WebElement  assistedAssignSelectedButton;
	
	@FindBy(xpath="(//*[contains(@class,'mx-layoutgrid mx-layoutgrid-fluid container-fluid mx-name-layoutGrid1')]/div/div/div/div//child::input[@type='radio'])[1]")
	WebElement  yesRadioButtonOnLevelOfAuthorityPopup;
	
	@FindBy(xpath="//*[contains(@class,'mx-layoutgrid mx-layoutgrid-fluid container-fluid mx-name-layoutGrid1')]/div//button[contains(@class,'btn mx-button mx-name-actionButton1')]")
	WebElement  selectButtonOnLevelOfAuthorityPopup;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid mx-datagrid mx-name-grid28')]/div[3]/div/table[2]/tbody/tr[1]")
	WebElement  loanPopulatingInTable;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid mx-datagrid mx-name-grid27')]/div[2]/div[2]/button")
	WebElement  searchButtonInside;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid mx-datagrid mx-name-grid27')]/div/div[2]/div/div[2]/input[1]")
	WebElement  nameField;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid mx-datagrid mx-name-grid27')]/div/div/button")
	WebElement  secondSearchButtonInside;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid mx-datagrid mx-name-grid27')]/div[3]/div/table[2]/tbody/tr")
	WebElement  userFromUserList;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid mx-datagrid mx-name-grid28')]/div[2]/div[2]/button[2]")
	WebElement  assignLoanButton;
	
	@FindBy(xpath="//*[contains(@class,'mx-table mx-name-table8')]/tbody/tr/td/div")
	WebElement assignableLoansCount;
	
	@FindBy(xpath="//*[contains(@class,'mx-dataview mx-name-dataView1')]/div[2]/button")
	WebElement  closeButton;
	
	public AdminFileAssPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void clickUnderwriterTab(){
		waitForElement(driver,8, underwriterTab);
		underwriterTab.click();
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
		scrollPageDown();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		loanSearched.click();
		/*action.moveToElement(loanSearched).click().build().perform();*/
	}
	public void clickAssistedAssignSelectedButton(){
		assistedAssignSelectedButton.click();
	}
	public void clickYesRadioButtonOnLevelOfAuthorityPopup(){
		waitForElement(driver,11, yesRadioButtonOnLevelOfAuthorityPopup);
		yesRadioButtonOnLevelOfAuthorityPopup.click();
	}
	public void clickSelectButtonOnLevelOfAuthorityPopup(){
		selectButtonOnLevelOfAuthorityPopup.click();
	}

	public void clickSearchButtonInside(){
		waitForElement(driver, 45, searchButtonInside);
		waitForElement(driver, 45, userFromUserList);
		searchButtonInside.click();
	}
	public void sendTextInNameField(String strName){
		nameField.sendKeys(strName);
	}
	public void clicksecondSearchButtonInside(){
		secondSearchButtonInside.click();
	}
	public void selectUserFromUserList(){
		action.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).build().perform();
		if(!userFromUserList.isSelected()){
		userFromUserList.click();}
	}
	public void clickLoanPopulatingInTable(){
		waitForElement(driver, 5, loanPopulatingInTable);
		loanPopulatingInTable.click();
	}
	public void clickAssignLoanButton(){
		assignLoanButton.click();
	}
	public String verifyAssignableLoansCount(){
		WebDriverWait wait =new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.invisibilityOf(loanPopulatingInTable));
		return assignableLoansCount.getText();
	}
	public void clickCloseButton(){
		closeButton.click();
	}
}

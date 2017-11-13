package com.amplify.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amplify.test.baseTest.Functions;

public class AddNewLoanPopUp extends Functions{
	
	@FindBy(xpath="//*[contains(@class,'mx-name-textBox1')]/input")
	WebElement loanNumberField;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-textBox2')]/input")
	WebElement borrowersFirstNameField;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-textBox3')]/input")
	WebElement borrowersLastNameField;
	
	@FindBy(xpath="//*[contains(@class,'mx-textarea mx-name-textArea1')]/textArea")
	WebElement propertyStreetAddressField;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-textBox4')]/input")
	WebElement propertyCityField;
	
	@FindBy(xpath="//*[contains(@class,'mx-referenceselector mx-name-referenceSelector1')]/div/select")
	WebElement propertyStateDropdown;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-textBox5')]/input")
	WebElement propertyZipCodeField;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-textBox6')]/input")
	WebElement totalLoanAmountField;
	
	@FindBy(xpath="//*[contains(@class,'mx-referenceselector mx-name-referenceSelector3')]/div/select")
	WebElement lNProgDropdown;
	
	@FindBy(xpath="//*[@class='mx-table mx-name-table1 myform-custom']/tbody/tr[10]/td[2]/div/div/select")
	WebElement docTypeDropdown;
	
	@FindBy(xpath="//*[contains(@class,'mx-referenceselector mx-name-referenceSelector4')]/div/select")
	WebElement loanTypeDropdown;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-dropDown1')]/select")
	WebElement occupancyDropdown;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-datePicker5')]/div/div/input")
	WebElement respaApplicationDateField;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-datePicker2')]/div/div/input")
	WebElement estimatedClosingDateField;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-datePicker4')]/div/div/input")
	WebElement lockExpDateField;
	
	@FindBy(xpath="//*[contains(@class,'btn mx-button mx-name-actionButton1')]")
	WebElement AddNewLoanButton;
	
	@FindBy(xpath="//*[contains(@class,'modal-dialog mx-dialog mx-dialog-info')]/div/div[3]/button")
	WebElement okButtonOnInfoPopup;
	
	@FindBy(xpath="//*[contains(@class,'modal-dialog mx-dialog mx-dialog-info')]/div/div[2]")
	WebElement successMessage;
	
	public AddNewLoanPopUp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void sendLoanNumber(String strLoanNo){
		waitForElement(driver, 6, loanNumberField);
		loanNumberField.sendKeys(strLoanNo);
	}
	
	public void sendBorrowersFirstName(String strBorrowersFirstName){
		borrowersFirstNameField.sendKeys(strBorrowersFirstName);
	}
	
	public void sendBorrowersLastName(String strBorrowersLastNameField){
		borrowersLastNameField.sendKeys(strBorrowersLastNameField);
	}
	
	public void sendPropertyStreetAddress(String strPropertyStreetAddressField){
		propertyStreetAddressField.sendKeys(strPropertyStreetAddressField);
	}
	public void sendPropertyCity(String strPropertyCityField){
		propertyCityField.sendKeys(strPropertyCityField);
	}
	
	public void selectPropertyStateDropdown(){
		selectFunction(propertyStateDropdown, 1);
	}
	public void sendPropertyZipCode(String strPropertyZipCode){
		propertyZipCodeField.sendKeys(strPropertyZipCode);
	}
	public void sendTotalLoanAmountField(String strTotalLoanAmountField){
		totalLoanAmountField.sendKeys(strTotalLoanAmountField);
	}
	public void selectlNProgDropdown(){
		selectFunction(lNProgDropdown, 1);
	}
	public void selectdocTypeDropdown(){
		selectFunction(docTypeDropdown, 2);
		action=new Actions(driver);
		/*actions.moveToElement(docTypeDropdown).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();*/
	}
	public void selectloanTypeDropdown(){
		selectFunction(loanTypeDropdown, 1);
	}
	public void selectOccupancyDropdown(){
		selectFunction(occupancyDropdown, 1);
	}
	public void sendRespaApplicationDate(String strRespaApplicationDateField){
		respaApplicationDateField.sendKeys(strRespaApplicationDateField);
	}
	public void sendestimatedClosingDate(String strEstimatedClosingDateField){
		estimatedClosingDateField.sendKeys(strEstimatedClosingDateField);
	}
	public void sendlockExpDate(String strLockExpDateField){
		lockExpDateField.sendKeys(strLockExpDateField);
	}
	public void clickAddNewLoanButton(){
		AddNewLoanButton.click();
	}
	public void clickOkButtonOnInfoPopup(){
		okButtonOnInfoPopup.click();
	}
	public String getSuccessMessage(){
		waitForElement(driver,8,successMessage);
		return successMessage.getText();
	}
	/*public boolean AddLoan1(String loanNo,String FirstName) throws Exception{
		Thread.sleep(4000);
		Actions action=new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox1']/input")).click().sendKeys(loanNo).build().perform();

		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox2']/input")).click().sendKeys(FirstName).build().perform();

		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox3']/input")).click().sendKeys("Test Last").build().perform();
		action.moveToElement(initWebXpath("//div[@class='mx-textarea mx-name-textArea1']/textarea")).click().sendKeys("Test Address").build().perform();
		
		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox4']/input")).click().sendKeys("Test City").build().perform();
		
	    action.moveToElement(initWebXpath("//div[@class='mx-referencesSelector mx-name-referenceSelector1']")).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform(); //State
	    
		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox5']/input")).click().sendKeys("1000").build().perform(); //Zip Code
		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox6']/input")).click().sendKeys("1000").release().build().perform();  //Loan Amount
		

		action.moveToElement(initWebXpath("/html/body/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div[1]/table/tbody/tr[11]/td[3]")).click().build().perform();

		
			action.moveToElement(initWebXpath("//div[@class='mx-referenceselector mx-name-referenceSelector3']")).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).release().build().perform(); //Ln Prog
		action.moveToElement(initWebXpath("//div[@class='mx-referenceselector mx-name-referenceSelector2']")).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).release().build().perform(); //Doc Type		
			action.moveToElement(initWebXpath("//div[@class='mx-referenceselector mx-name-referenceSelector4']")).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).release().build().perform(); // Loan Type
		action.moveToElement(initWebXpath("//div[@class='mx-name-dropDown1']")).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform(); //occup
			roleDropDownFunc(initWebXpath("//div[@class='mx-referenceselector mx-name-referenceSelector2']/div/select"), "86131342873460738");
		roleDropDownFunc(initWebXpath("//div[@class='mx-referenceselector mx-name-referenceSelector3']/div/select"), "71213169107796069");
	
		initWebXpath("//div[@class='mx-name-datePicker5']").sendKeys("9/12/2018");   //RAD
		initWebXpath("//div[@class='mx-name-datePicker2']").sendKeys("9/12/2018");  //ECD
		initWebXpath("//div[@class='mx-name-datePicker4']").sendKeys("9/12/2018");  //LExp
	
		initWebXpath("//button[@class='btn mx-button mx-name-actionButton1 btn-default']").click();
		return true;
	}*/
}

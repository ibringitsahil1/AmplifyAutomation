package com.amplify.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amplify.test.baseTest.Functions;

public class AdminLoanOverview  extends Functions{
	List<WebElement> statusColumn=null;

	WebDriver driver;
	@FindBy(xpath="//*[contains(@class,'btn mx-button mx-name-searchButton57')]")
	WebElement searchButton;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid-search-input mx-name-searchField203')]/input")
	WebElement searchLoanNumber;
	
	@FindBy(xpath="//*[contains(@class,'mx-name-search mx-grid-search-button')]")
	WebElement secondSearchButton;
	
	@FindBy(xpath="//*[contains(@class,'btn mx-button mx-name-actionButton9')]")
	WebElement addNewLoanButton;
	
	@FindBy(xpath="//*[contains(@class,'mx-grid mx-datagrid mx-name-grid42')]/div[3]/div/table[2]/tbody/tr[1]/td[1]")
	WebElement loanSearched;
	
	@FindBy(xpath="//*[contains(@id,'mxui_widget_DialogMessage_')]/div[1]/div[1]/h4")
	WebElement getAlertMessage;
	
	@FindBy(xpath="//*[contains(@id,'mxui_widget_DialogMessage_')]/div[1]/div[1]/button")
	WebElement okButtonPopup;
	
	@FindBy(xpath="//button[contains(@class,'btn mx-button mx-name-microflowButton20')]")
	WebElement viewLoanButton;
	
	@FindBy(linkText="Tasks")
	WebElement tasksTabinViewLoanPopup;
	
	
	
	public  AdminLoanOverview(WebDriver driver){
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
	
	public void clickAddNewLoanButton(){
		waitForElement(driver,5, addNewLoanButton);
		addNewLoanButton.click();
	}
	
	public void SelectloanInTable(){
		loanSearched.click();
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
/*	public void fetchLoans() throws Exception{
		List<WebElement> rowdata =funcMultipleXpath("//*[contains[@id,'mxui_widget_DataGrid_']/div[3]/div/table[2]/tbody/tr");
		statusColumn=new ArrayList<WebElement>(rowdata.size());
		
		for(int z=0;z<=rowdata.size();z++){
			statusColumn.addAll(funcMultipleXpath("//*[@id='mxui_widget_DataGrid_2']/div[3]/div/table[2]/tbody/tr["+z+"]/td[3]"));
			System.out.println(statusColumn);
		}
		
		String[] s=new String[rowdata.size()];
		int i=0;
		for( WebElement singleStatus: statusColumn){
			s[i]=singleStatus.getText();
			System.out.println(s[i]);
			i++;
		}

		String[] str={"In Process","Application"};
	
		for(int k=0;k<rowdata.size();k++){
				switch (s[k]) {
				case "In Process":
					System.out.println("In process is present");
					break;
				case "Application":
					System.out.println("In Application is present");
					break;
				default:
					System.out.println(s[k]+"invalid");
					Assert.fail("Invalid Status Found");
					break;
				}
		}
		 boolean b=false;
		for(int k=0;k<rowdata.size();k++){
			  b=false;
			for(int t=0;t<str.length;t++){
				if(s[k].equalsIgnoreCase(str[t])){
					System.err.println(s[k]+" is valid Status");
					b=true;
				}
			}
			if(!b){
				System.out.println(s[k]+" is invalid status");
			}
		}
		fetchLoans2();
	}
	public void fetchLoans2() throws Exception{
		if(initWeb("mxui_widget_Button_20",driver).isEnabled()){
			initWeb("mxui_widget_Button_20",driver).click();
			Thread.sleep(10000);
			List<WebElement> rowdata1 =funcMultipleXpath("//*[contains(@id,'mxui_widget_DataGrid_']/div[3]/div/table[2]/tbody/tr");
			statusColumn=new ArrayList<WebElement>(rowdata1.size());
			
			for(int z=0;z<=rowdata1.size();z++){
				statusColumn.addAll(funcMultipleXpath("//*[contains(@id,'mxui_widget_DataGrid_']/div[3]/div/table[2]/tbody/tr["+z+"]/td[3]"));
				System.out.println(statusColumn);
			}
			
			String[] s1=new String[rowdata1.size()];
			int i=0;
			for( WebElement singleStatus1: statusColumn){
				s1[i]=singleStatus1.getText();
				System.out.println(s1[i]);
				i++;
			}

			String[] str1={"In Process","Application"};

			 boolean b=false;
			for(int k=0;k<rowdata1.size();k++){
				  b=false;
				for(int t=0;t<str1.length;t++){
					if(s1[k].equalsIgnoreCase(str1[t])){
						System.err.println(s1[k]+" is valid Status");
						b=true;
					}
				}
				if(!b){
					System.out.println(s1[k]+" is invalid status");
				}
			}
		}

		
	
	}*/
	
	}



package com.amplify.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amplify.test.functions.Functions;

public class Login extends Functions{
	WebDriver driver;
	
	@FindBy(id="usernameInput")
	WebElement userName;
	
	@FindBy(id="passwordInput")
	WebElement password;
	
	@FindBy(id="loginButton")
	WebElement clickLoginButton;
	
	@FindBy(xpath="//a[contains(.,'Loan Overview')]")
	WebElement LoanOverviewTab;
	
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	
	//InputFieds
		public void setUserName(String user){
			userName.sendKeys(user);
		}
		public void setPassword(String pass){
			password.sendKeys(pass);
		}
		public void clickLogin(){
			clickLoginButton.click();
			waitForElement(driver,120, LoanOverviewTab);
		}
}

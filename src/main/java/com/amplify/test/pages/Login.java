package com.amplify.test.pages;

import com.amplify.test.functions.Functions;

public class Login extends Functions{
	
	//InputFieds
		public void setUserName(String userName){
			initWeb(properties.getProperty("multiple.userName")).sendKeys(userName);
		}
		public void setPassword(String pass){
			initWeb(properties.getProperty("multiple.password")).sendKeys(pass);
		}
		public void clickLogin(){
			initWeb(properties.getProperty("login")).click();
		}
}

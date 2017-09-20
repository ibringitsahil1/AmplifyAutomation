package com.amplify.test.pages;

import org.openqa.selenium.WebElement;
import com.amplify.test.functions.Functions;

public class AdminHomePage extends Functions{

	public void setUserRole(String role){
		/*roleDropDownFunc(initWebCss("select.form-control.mx-focus"), role);*/
		WebElement e=funcClassSelector(properties.getProperty("maindrop.clientAdmin.className"));
		if(funcIsDisplayed(e)==true){
		roleDropDownFunc(e,role);
	}
	}
}

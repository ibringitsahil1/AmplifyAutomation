package com.amplify.test.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import com.amplify.test.functions.Functions;

public class Home extends Functions {
	
	
	

	public void clickReg() throws IOException{
		System.out.println(properties.getProperty("reg"));
		initWclicebLinkText(properties.getProperty("reg")).click();
		
	} 
}

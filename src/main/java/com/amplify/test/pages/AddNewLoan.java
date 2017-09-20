package com.amplify.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.amplify.test.functions.Functions;

public class AddNewLoan extends Functions{
	
	public boolean AddLoan1(String loanNo,String FirstName) throws Exception{
		Thread.sleep(4000);
		Actions action=new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox1']/input")).click().sendKeys(loanNo).build().perform();

		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox2']/input")).click().sendKeys(FirstName).build().perform();

		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox3']/input")).click().sendKeys("Test Last").build().perform();
		action.moveToElement(initWebXpath("//div[@class='mx-textarea mx-name-textArea1']/textarea")).click().sendKeys("Test Address").build().perform();
		
		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox4']/input")).click().sendKeys("Test City").build().perform();
		
	    action.moveToElement(initWebXpath("//div[@class='mx-referenceselector mx-name-referenceSelector1']")).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform(); //State
	    
		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox5']/input")).click().sendKeys("1000").build().perform(); //Zip Code
		action.moveToElement(initWebXpath("//div[@class='mx-name-textBox6']/input")).click().sendKeys("1000").release().build().perform();  //Loan Amount
		

		/*action.moveToElement(initWebXpath("/html/body/div[1]/div/div/div/div[2]/div/div/div/div/div/div/div/div[1]/table/tbody/tr[11]/td[3]")).click().build().perform();*/

		
		/*	action.moveToElement(initWebXpath("//div[@class='mx-referenceselector mx-name-referenceSelector3']")).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).release().build().perform(); //Ln Prog
		action.moveToElement(initWebXpath("//div[@class='mx-referenceselector mx-name-referenceSelector2']")).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).release().build().perform(); //Doc Type		
			action.moveToElement(initWebXpath("//div[@class='mx-referenceselector mx-name-referenceSelector4']")).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).release().build().perform(); // Loan Type
		action.moveToElement(initWebXpath("//div[@class='mx-name-dropDown1']")).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform(); //occup
*/			roleDropDownFunc(initWebXpath("//div[@class='mx-referenceselector mx-name-referenceSelector2']/div/select"), "86131342873460738");
		roleDropDownFunc(initWebXpath("//div[@class='mx-referenceselector mx-name-referenceSelector3']/div/select"), "71213169107796069");
	
		initWebXpath("//div[@class='mx-name-datePicker5']").sendKeys("9/12/2018");   //RAD
		initWebXpath("//div[@class='mx-name-datePicker2']").sendKeys("9/12/2018");  //ECD
		initWebXpath("//div[@class='mx-name-datePicker4']").sendKeys("9/12/2018");  //LExp
	
		initWebXpath("//button[@class='btn mx-button mx-name-actionButton1 btn-default']").click();
		return true;
	}
}

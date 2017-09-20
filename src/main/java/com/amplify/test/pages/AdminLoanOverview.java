package com.amplify.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.amplify.test.functions.Functions;

public class AdminLoanOverview  extends Functions{
	List<WebElement> statusColumn=null;

	public void clickLoanOverTab(){
		initWebCss(properties.getProperty("cssLoanOver")).click();;
	}
	public void fetchLoans() throws Exception{
		List<WebElement> rowdata =funcMultipleXpath("//*[contains[@id,'mxui_widget_DataGrid_']/div[3]/div/table[2]/tbody/tr");
		statusColumn=new ArrayList<WebElement>(rowdata.size());
		
		for(int z=0;z<=rowdata.size();z++){
			statusColumn.addAll(funcMultipleXpath("//*[@id='mxui_widget_DataGrid_2']/div[3]/div/table[2]/tbody/tr["+z+"]/td[3]"));
			/*System.out.println(statusColumn);*/
		}
		
		String[] s=new String[rowdata.size()];
		int i=0;
		for( WebElement singleStatus: statusColumn){
			s[i]=singleStatus.getText();
			System.out.println(s[i]);
			i++;
		}

		String[] str={"In Process","Application"};
	
/*		for(int k=0;k<rowdata.size();k++){
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
		}*/
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
		if(initWeb("mxui_widget_Button_20").isEnabled()){
			initWeb("mxui_widget_Button_20").click();
			Thread.sleep(10000);
			List<WebElement> rowdata1 =funcMultipleXpath("//*[contains(@id,'mxui_widget_DataGrid_']/div[3]/div/table[2]/tbody/tr");
			statusColumn=new ArrayList<WebElement>(rowdata1.size());
			
			for(int z=0;z<=rowdata1.size();z++){
				statusColumn.addAll(funcMultipleXpath("//*[contains(@id,'mxui_widget_DataGrid_']/div[3]/div/table[2]/tbody/tr["+z+"]/td[3]"));
				/*System.out.println(statusColumn);*/
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

		
	
	}
	
	}



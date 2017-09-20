package com.amplify.test.functions;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.automation.uiAutomation.customListner.WebEventListener;

public class Functions<WebElements> {
	public static WebDriver driver;
    
	public static Properties properties;
	public static Properties propertiesData;
	
	public WebEventListener eventListener;
	public EventFiringWebDriver e_driver;

		//Reading ElementsProperties
		public void readProperties() throws Exception{
		File file=new File("C:\\Project\\AmplifyAutomation\\Elements.properties");
		properties=new Properties();
		FileInputStream fis=new FileInputStream(file);
		properties.load(fis);
		    }
		//Reading TestDataProperties
		public void readTestDataProperties() throws Exception{
		File file=new File("C:\\Project\\AmplifyAutomation\\TestData.properties");
		propertiesData=new Properties();
		FileInputStream fis=new FileInputStream(file);
		propertiesData.load(fis);
		    }
		
		
		public void LoadBrowser() throws IOException{	
		String url=properties.getProperty("url");
		String browserType=properties.getProperty("browser");
		switch (browserType) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sahil.singh\\Documents\\New folder\\New folder\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();	
			eventListener = new WebEventListener();
			e_driver = new EventFiringWebDriver(driver);
			e_driver.register(eventListener);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sahil.singh\\Documents\\New folder\\New folder\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
			eventListener = new WebEventListener();
			e_driver = new EventFiringWebDriver(driver);
			e_driver.register(eventListener);
			break;
		default:
			System.out.println("no browser defined");
			break;
		}
		driver.get(url);
		
		}
		public void getUrl(){
			String url=properties.getProperty("url");
			driver.get(url);
		}
		public WebElement initWeb(String id) {
			return driver.findElement(By.id(id));

		}
		public WebElement initWebId(String name) {
			return driver.findElement(By.name(name));

		}
		//By xpath
		public WebElement initWebXpath(String xpath) {
			return driver.findElement(By.xpath(xpath));

		}
		//By Multiple xpath
		public List<WebElement> funcMultipleXpath(String xpath) {
			return driver.findElements(By.xpath(xpath));

		}
		//By cssSelector
		public WebElement initWebCss(String selector) {
			return driver.findElement(By.cssSelector(selector));

		}
		public WebElement initWclicebLinkText(String linkText) {
			return driver.findElement(By.partialLinkText(linkText));

		}
		//By Class
		public WebElement funcClassSelector(String className) {
			return driver.findElement(By.className(className));

		}
		public String getTitle(){
		return	driver.getTitle();
		}
		public void wait(int timeOutInSeconds){
			driver.manage().timeouts().implicitlyWait(timeOutInSeconds,TimeUnit.SECONDS);
			
		}
		public WebElement funcCssSelector(String selector){
			return driver.findElement(By.cssSelector(selector));
		}
		//Click
		public void clickFunc(String click){
			 initWeb(click).click();
		}
		//ZoomOut
		public void zoomOutFunc(
){
			Actions action=new Actions(driver);
			action.keyDown(Keys.CONTROL).keyDown(Keys.SUBTRACT).keyUp(Keys.CONTROL).keyUp(Keys.SUBTRACT).perform();
		}
		//maximize window
		public void maxWindowFunc(){
			driver.manage().window().maximize();;
		}
		//role DropDown by Value
		public void roleDropDownFunc(WebElement roleDropElement,String DropValue){
			Select select=new Select(roleDropElement);
			select.selectByValue(DropValue);
		}
		
		public boolean funcIsDisplayed(WebElement element){
			if(element.isDisplayed()){
				return true;
			}else{
				return false;
			}
		}
		public void visibilityOfElementLocated(String text){
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(text)));
		}
		/*******************************************************************/
		public void waitForElement(WebDriver driver, int timeOutInSeconds, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
}

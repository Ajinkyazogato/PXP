	package com.jbk.keywordFrmework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyWordMethods {

	static WebDriver driver;
	static WebDriverWait wait;

	public void open_Browser(String browserName) {
		System.out.println("");
		try {
			if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} /*else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","D:/Jars/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver","D:/Jars/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}*/
			
			//HTMLUNITDRIVER
			
			
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	public void enter_URL(String URL) {
		driver.navigate().to(URL);
	}

	public By locatorValue(String locatorTpye, String value) {
		int x=0;
		By by;
		if("id".equals(locatorTpye)){
			x=1;
		}
		if("name".equals(locatorTpye)){
			x=2;
		}
		if("xpath".equals(locatorTpye)){
			x=3;
		}
		if("css".equals(locatorTpye)){
			x=4;
		}
		if("linkText".equals(locatorTpye)){
			x=5;
		}
		if("partialLinkText".equals(locatorTpye)){
			x=6;
		}
		
		switch (x) {
		case 1:
			by = By.id(value);
			break;
		case 2:
			by = By.name(value);
			break;
		case 3:
			by = By.xpath(value);
			break;
		case 4:
			by = By.cssSelector(value);
			break;
		case 5:
			by = By.linkText(value);
			break;
		case 6:
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		
		return by;
	}
/*
 * 
 * 
 */
	//id // "ename" // kiran
	
	public void enter_Text(String locatorType, String value, String text) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.sendKeys(text);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	public void click_On_Link(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	public void click_On_Button(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
	}
	
	public void Select_from_Dropdown(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
			Select se=new Select(element);
			se.selectByValue("");
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
	}
	
	public void Update_Content_Name(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
			Actions acttions = new Actions(driver);
			acttions.doubleClick();
			acttions.sendKeys(Keys.BACK_SPACE);
			acttions.sendKeys("new name");
			acttions.build().perform();
			acttions.sendKeys(Keys.TAB);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
	}
	public void pause( int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void close_Browser() {
		driver.quit();
	}
}















package com.qa.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory {

	//This method used to initialize threadlocal driver on the basis of given browser 
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();
	
	public WebDriver initializeDriver(String browser) {
		
		System.out.println("Browser value is:"+browser);
		
		if(browser.toLowerCase().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.toLowerCase().equals("egde")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		else {
			System.out.println("please enter correct browser value");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	//this used to get driver from threadlocal
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
		
	}
}

package com.qa.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class driverManager {

	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver==null) {
			String browser= System.getProperty("browser","chrome");
		
		if(browser.equalsIgnoreCase("chome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			driver= new EdgeDriver();
		}
	}
		return driver;
}
}

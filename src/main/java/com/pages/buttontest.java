package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class buttontest extends basePage{

	public buttontest(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//*[text()='Double Click Me']")
	WebElement doubleClick;
	
	@FindBy(id="doubleClickMessage")
	WebElement message;
	
	public String doubleClickTest() {
		
		Actions act= new Actions(driver);
		act.doubleClick(doubleClick).build().perform();
		
		if(message.isDisplayed()) {
			String msg= message.getText();
			return msg;
		}
		else {
			return "message not displayed";
		}		
	}
	
	
}

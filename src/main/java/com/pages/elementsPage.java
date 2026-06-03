package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class elementsPage extends basePage{

	public elementsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//div[@class='col-12 mt-4  col-md-3']//span[text()='Buttons']")
	WebElement buttonLink;
	
	public void buttonClick() {
		buttonLink.click();
	}
	
}

package com.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage extends basePage{
	
	public homePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//div[@class='card mt-4 top-card']//h5[text()='Elements']")
	WebElement elements;

	public void clickonElements() {
		elements.click();
		
		
	}
	public void practice() throws IOException {
		
		//waits
		//implicit
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//explicit
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(elements));
	
		//fluent
	FluentWait w= new FluentWait(driver);
	w.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1));
	
	driver.findElement(By.id(""));
	
	
	WebElement dropdown= driver.findElement(By.xpath(""));
	Select s= new Select(dropdown);
	List<WebElement> options= s.getOptions();
	Set<WebElement> sorted= new TreeSet<>();
	for(WebElement web:options) {
		sorted.add(web);
	}
	
	String parent= driver.getWindowHandle();
	Set<String> winds= driver.getWindowHandles();
	for(String wds:winds) {
		if(!wds.equals(parent)) {
			driver.switchTo().window(wds);
			
		}
		driver.switchTo().window(parent);
	}
	
	// read excel
	String file="";
	FileInputStream fi= new FileInputStream(file);
	XSSFWorkbook wo= new XSSFWorkbook(fi);
	XSSFSheet sh= wo.getSheet("Sheet1");
	int rowCount= sh.getLastRowNum()-sh.getFirstRowNum();
	
	for(int i=0;i<rowCount;i++) {
		String uname= sh.getRow(i).getCell(0).getStringCellValue();
		String pass=  sh.getRow(i).getCell(1).getStringCellValue();
		String num= sh.getRow(i).getCell(2).getRawValue();
		
		String result=driver.findElement(By.id(num)).getText();
		sh.getRow(i).createCell(3).setCellValue(result);
	}
	
	FileOutputStream fo= new FileOutputStream(file);
	wo.write(fo);
	fo.close();
	wo.close();
	
	//mouse actions
	//mouse hover
	Actions act= new Actions(driver);
	act.moveToElement(dropdown).build();
	}
} 

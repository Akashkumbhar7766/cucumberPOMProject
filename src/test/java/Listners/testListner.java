package Listners;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testListner implements ITestListener{
public WebDriver driver;
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("dest/fileName.png");
		try {
			FileHandler.copy(source, dest);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			driver.close();
		}
		
	}
}

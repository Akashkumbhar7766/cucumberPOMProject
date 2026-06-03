package AppsHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Utilities.configReader;
import com.qa.Factory.driverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class applicationHooks {

	private driverFactory driFactory;
	private configReader coReader;
	private WebDriver driver;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		coReader= new configReader();
		prop=coReader.readProp();
	}
	
	@Before(order=1)
	public void launchBrowser() {
		String browserName=prop.getProperty("browser");
		//driver=driFactory.initializeDriver(browserName);
	}
	
	@After(order=0)
	public void quitBrowser() {
		//driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take Screenshot
			String ssName=scenario.getName().replaceAll(" ", "_");
			
			byte[] sourcepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png",ssName );
			 
		}
	}
}

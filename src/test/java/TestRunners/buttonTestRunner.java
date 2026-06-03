package TestRunners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
			features="src/test/resources/FeatureFiles",
			glue="stepDefinations",
			plugin= {
					"pretty",
					"html:target/cucumber-reports.html",
					"json:target/cucumber.json"
			}
)
public class buttonTestRunner extends AbstractTestNGCucumberTests {

}

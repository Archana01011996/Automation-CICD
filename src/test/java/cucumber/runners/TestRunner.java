package cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resource/Features",
	    glue = "cucumber.stepDefinitions",
	    monochrome = true,
	    tags="@Regression",
	    plugin = {
	    		
	         "html:target/cucumber-report.html"
	    }
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	}

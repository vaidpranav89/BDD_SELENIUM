package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/java/features", plugin = "json:target/jsonReports/cucumber-report.json", glue = "stepDefinations"

)

public class TestRunner extends AbstractTestNGCucumberTests {

}

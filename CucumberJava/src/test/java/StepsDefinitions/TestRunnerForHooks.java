package StepsDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/HooksDemo/Hooks.feature",
glue = {"StepsForHooks"}, 
monochrome=true,
plugin= {"pretty", "html:target/HtmlReports/HtmlReport.html",
 "json:target/JSONReports/JSONReport.json",
"junit:target/XMLReports/XMLReport.xml",
"json:target/cucumber.json"}
//tags="@SmokeTest"
)

public class TestRunnerForHooks {

}

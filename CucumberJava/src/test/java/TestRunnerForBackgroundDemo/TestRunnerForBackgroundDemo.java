package TestRunnerForBackgroundDemo;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/BackgroundDemo/BackgroundDemo.feature",
glue = {"StepsForBackground"}, 
monochrome=true,
plugin= {"pretty", "html:target/HtmlReports/HtmlReport.html",
 "json:target/JSONReports/JSONReport.json",
"junit:target/XMLReports/XMLReport.xml",
"json:target/cucumber.json"}
//tags="@SmokeTest"
)

public class TestRunnerForBackgroundDemo {


}

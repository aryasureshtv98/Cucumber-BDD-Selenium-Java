package steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue= {"Steps"},tags="@login",  monochrome=true, plugin= {"pretty", "html:target/HtmlReports/test.html"})
public class Testrunner {

	
}

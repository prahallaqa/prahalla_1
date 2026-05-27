package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\login.feature",   // Path to feature files
        glue = "stepDefinitions",                   // Package for step definitions
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        monochrome = true,
        dryRun = false,
        tags = "@smoke"      // Change/remove tag as needed
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

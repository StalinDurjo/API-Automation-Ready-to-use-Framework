package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"json:target/jsonReports/cucumber.json"},
//        tags = "@only",
        dryRun = false
)
public class TestRunner {}

package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@Wiki",
        dryRun = false,
        monochrome = false,
        plugin = "html:target/cucumber-reports"
)

public class Runner {
}

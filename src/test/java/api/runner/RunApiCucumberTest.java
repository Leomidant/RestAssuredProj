package api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = "src/test/resources/features", // Replace with the path to your feature files
        glue = "api/stepDefinitions", // Replace with the package containing your step definitions
        tags = "@api",
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Optional: specify plugins for report generation
)

@RunWith(Cucumber.class)
public class RunApiCucumberTest {
}
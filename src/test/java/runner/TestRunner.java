package runner;

import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features"
        ,glue={"stepDefinitions"}
)

public class TestRunner {
    private TestRunner() {
        RestAssured.baseURI = "https://09215xnnrg.execute-api.us-east-1.amazonaws.com/singular";
    }
}

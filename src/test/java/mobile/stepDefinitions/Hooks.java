package mobile.stepDefinitions;

import api.steps.CommonSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import mobile.pages.BaseClass;

public class Hooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@mobile")) {
            BaseClass.setAppiumDriver();
        }

    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@mobile")) {
            BaseClass.resetApp();
            BaseClass.quitDriver();
            System.out.println("Re-Install APP");
        }

    }
}

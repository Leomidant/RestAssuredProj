package api.stepDefinitions;


import io.cucumber.java.After;
import api.steps.CommonSteps;
import io.cucumber.java.Scenario;

public class Hooks {

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@api")) {
            CommonSteps.reset();
            System.out.println("Resetting CommonSteps");
        }

    }
}

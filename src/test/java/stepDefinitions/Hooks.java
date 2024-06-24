package stepDefinitions;


import io.cucumber.java.After;
import steps.CommonSteps;

public class Hooks {

    @After
    public void afterScenario() {
        CommonSteps.reset();
    }
}

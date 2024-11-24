package api.stepDefinitions;

import api.steps.CommonSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import api.steps.UserSteps;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserDefinitions {
    public UserSteps userSteps = new UserSteps();

    @Given("I set base URL")
    public void iSetBaseURL() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Given("the user retrieves the list of users with the following parameters:")
    public void theUserRetrievesTheListOfUsersWithTheFollowingParameters(Map<String, Object> queryParams) {
        userSteps.getUsersList(queryParams);
        userSteps.assertUserListParams(queryParams);
    }

    @And("the response contains data for {int} users")
    public void userChecksResponseContainsUserData(int expectedCount) {
        userSteps.assertUserListsDataSize(expectedCount);
    }

    @Then("the user validates that the user IDs start from {string}")
    public void userChecksUserIdsStartsFrom(String expectedId) {
        userSteps.assertUserListsFirstUserId(expectedId);
    }

    @Given("the user registers new user with the following parameters:")
    public void theUserRegistersNewUserWithTheFollowingParameters(Map<String, Object> jsonBody) {
        userSteps.registerNewUser(jsonBody);
    }

    @Given("the user log in with following parameters:")
    public void theUserLogInWithFollowingParameters(Map<String, Object> jsonBody) {
        userSteps.loginWithUser(jsonBody);
    }

    @Given("the user retrieves the user with it's id {string}")
    public void theUserRetrievesTheUserWithItSId(String userId) {
        userSteps.getUsersWithId(userId);
    }

    @And("the user response contains user with following parameters:")
    public void theUserResponseContainsUserWithFollowingParameters(Map<String, Object> expectedParameters) {
        userSteps.assertUserDataWithParameters(expectedParameters);
    }

    @Then("the response contains the error message {string}")
    public void theResponseContainsTheErrorMessage(String expectedErrorMessage) {
        userSteps.assertErrorMessage(expectedErrorMessage);

    }

    @And("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        CommonSteps.assertStatusCode(expectedStatusCode);
    }

    @Given("the user deletes user with id {string}")
    public void theUserDeletesUserWithId(String userId) {
        userSteps.deleteUsersWithId(userId);
    }

    @Given("the user updates user with id {string}")
    public void theUserUpdatesUserWithId(String userId) {
        userSteps.updateUsersWithId(userId);
    }

    @Then("the response contains correct update time")
    public void theResponseContainsCorrectUpdateTime() {
        userSteps.assertUpdateTime();
    }
}

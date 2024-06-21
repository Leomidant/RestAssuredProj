package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import steps.UserSteps;

import static io.restassured.RestAssured.given;

public class UserDefinitions {
    public UserSteps userSteps = new UserSteps();

    @Given("I set base URL")
    public void iSetBaseURL() {
        RestAssured.baseURI = "https://09215xnnrg.execute-api.us-east-1.amazonaws.com/singular";
    }

    @Given("User sends request with correct credentials")
    public void userSendsRequestWithCorrectCredentials() throws Exception {
        userSteps.authorizeUser();
    }

    @And("The user gets status code {int} in message body")
    public void theUserGetsStatusCodeInMessageBody(int statusCode) {
        userSteps.assertUserResponseStatusCode(statusCode);
    }

    @And("The user gets message {string} in message body")
    public void theUserGetsMessageInMessageBody(String expectedMessage) {
        userSteps.assertUserMessageValue(expectedMessage);
    }

    @Then("Token value in response body is not empty")
    public void tokenValueInResponseBodyIsNotEmpty() {
        userSteps.assertUserAuthorizationTokenIsNotEmpty();
    }

    @Given("User sends get request with authorization token")
    public void userSendsGetRequestWithAuthorizationToken() throws Exception {

        userSteps.getUserInformation();
    }


}

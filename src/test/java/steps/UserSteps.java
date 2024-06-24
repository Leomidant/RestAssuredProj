package steps;

import requestBodies.UserRequestBody;

public class UserSteps {
    public void authorizeUser() throws Exception {
        CommonSteps.sendRequestWithJsonBody("POST","/authorize", new UserRequestBody().authorizeUser());
    }

    public void getUserInformation() throws Exception {
        CommonSteps.sendRequest("GET","/info");
    }

    public void assertUserResponseStatusCode(int statusCode){
        CommonSteps.assertStatusCode(statusCode);
    }

    public void assertUserResponseDoseNotContainsStatusCode(int statusCode){
        CommonSteps.assertDoesNotContainsStatusCode(statusCode);
    }

    public void assertUserMessageValue(String expectedMessage){
        CommonSteps.assertValueOfKey("message",expectedMessage);
    }

    public void assertUserResponseDoesNotContainsMessageValue(String expectedMessage){
        CommonSteps.assertDoesNotContainsValueOfKey("message",expectedMessage);
    }

    public void assertUserAuthorizationTokenIsNotEmpty(){
        CommonSteps.assertValueOfKeyIsNotEmpty("token");
    }

    public void getUserSessionIdAndSetToken() throws Exception {
        authorizeUser();
        CommonSteps.setAuthorizationToken();
    }

    public void setInvalidSessionId(){
        CommonSteps.setIncorrectAuthorizationToken();
    }
}

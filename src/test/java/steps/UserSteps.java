package steps;

import requestBodies.UserRequestBody;

public class UserSteps {
    public void authorizeUser() throws Exception {
        CommonSteps.sendRequestWithJsonBody("POST","/authorize", new UserRequestBody().authorizeUser());
    }

    public void assertUserResponseStatusCode(int statusCode){
        CommonSteps.assertStatusCode(statusCode);
    }

    public void assertUserMessageValue(String expectedMessage){
        CommonSteps.assertValueOfKey("message",expectedMessage);
    }

    public void assertUserAuthorizationTokenIsNotEmpty(){
        CommonSteps.assertValueOfKeyIsNotEmpty("token");
    }

    public void getUserInformation() throws Exception {
        authorizeUser();
        CommonSteps.setAuthorizationToken();
        CommonSteps.sendRequest("GET","/info");
    }
}

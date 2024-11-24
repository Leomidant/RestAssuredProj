package api.steps;

import api.requestBodies.UserRequestBody;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class UserSteps {
    public void assertUpdateTime(){
        CommonSteps.assertDifferenceBetweenTimes("updatedAt");
    }

    public void assertErrorMessage(String expectedErrorMessage){
        CommonSteps.assertValueOfKey("error", expectedErrorMessage);
    }

    public void registerNewUser(Map<String, Object> jsonMap){
        CommonSteps.sendRequestWithJsonBody("POST","/register", new UserRequestBody().userJsonBody(jsonMap));
    }

    public void loginWithUser(Map<String, Object> jsonMap){
        CommonSteps.sendRequestWithJsonBody("POST","/login", new UserRequestBody().userJsonBody(jsonMap));
    }

    public void getUsersList(Map<String, Object> queryParams){
        CommonSteps.sendRequestWithQueryParams("GET","/users", queryParams);
    }

    public void getUsersWithId(String userId){
        CommonSteps.sendRequest("GET","/users/" + userId);
    }

    public void deleteUsersWithId(String userId){
        CommonSteps.sendRequest("DELETE","/users/" + userId);
    }

    public void updateUsersWithId(String userId){
        CommonSteps.sendRequest("PUT","/users/" + userId);
    }

    public void assertUserDataWithParameters(Map<String, Object> expectedParameters){
        expectedParameters.forEach((key, value) -> CommonSteps.assertValueOfNestedKey("data."+key, value.toString()));
    }

    public void assertUserListParams(Map<String, Object> queryParams){
        queryParams.forEach((key, value) -> CommonSteps.assertValueOfKey(key, value.toString()));
    }

    public void assertUserListsDataSize(int expectedCount){
        CommonSteps.assertObjectCount("data", expectedCount);
    }

    public void assertUserListsFirstUserId(String expectedId){
        CommonSteps.assertValueOfNestedKey("data[0].id", expectedId);
    }

}

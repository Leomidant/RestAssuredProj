package steps;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.test.Service;
import org.testng.Assert;

import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CommonSteps {
    private static Response mainResponse;
    private static RequestSpecification requestSpecification = given();
    private static String token = null;

    public static String readJsonFileAsString(String filePath)throws Exception {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }


    public static void sendRequest(String method, String endpoint) {
        if(token != null){
            requestSpecification.header("Authorization", token);
        }
        requestSpecification.header("Content-Type","application/json");

        Response response = Service.sendRequest(requestSpecification, method, endpoint)
                .then()
                .extract().response();
        response.prettyPrint();

        mainResponse = response;
    }


    public static void sendRequestWithJsonBody(String method, String endpoint, String body) {
        requestSpecification.body(body);
        sendRequest(method,endpoint);
    }

    public static void assertStatusCode(int excpectedStatusCode){
        Response response = mainResponse;

        int actualStatusCode = response.jsonPath().getInt("code");
        Assert.assertEquals(excpectedStatusCode, actualStatusCode);
    }

    public static void assertDoesNotContainsStatusCode(int excpectedStatusCode){
        Response response = mainResponse;

        int actualStatusCode = response.jsonPath().getInt("code");
        Assert.assertNotEquals(excpectedStatusCode, actualStatusCode);
    }

    public static void assertValueOfKey(String key, String expectedValue){
        Response response = mainResponse;

        String actualValue = response.jsonPath().getString(key);
        Assert.assertEquals(expectedValue, actualValue);
    }

    public static void assertDoesNotContainsValueOfKey(String key, String expectedValue){
        Response response = mainResponse;

        String actualValue = response.jsonPath().getString(key);
        Assert.assertNotEquals(expectedValue, actualValue);
    }

    public static void assertValueOfKeyIsNotEmpty(String key){
        Response response = mainResponse;

        String actualValue = response.jsonPath().getString(key);
        Assert.assertFalse(actualValue.isEmpty());
    }

    public static void setAuthorizationToken(){
        Response response = mainResponse;
        token = response.jsonPath().getString("token");
    }

    public static void setIncorrectAuthorizationToken(){
        token = ("testToken");
    }

}

package steps;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.Service;
import org.json.JSONObject;
import org.testng.Assert;

import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

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

    public static void assertValueOfKey(String key, String expectedValue){
        Response response = mainResponse;

        String actualValue = response.jsonPath().getString(key);
        Assert.assertEquals(expectedValue, actualValue);
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

}

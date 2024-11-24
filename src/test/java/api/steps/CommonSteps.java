package api.steps;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.test.Service;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CommonSteps {
    private static Response mainResponse;
    private static RequestSpecification requestSpecification = given();
    private static String token = null;

    public static String readJsonFileAsString(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public static void assertStatusCode(int expectedStatusCode) {
        int actualStatusCode = mainResponse.getStatusCode();

        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    public static void sendRequestWithJsonBody(String method, String endpoint, String body) {
        requestSpecification.body(body);
        sendRequest(method,endpoint);
    }

    public static void sendRequestWithQueryParams(String method, String endpoint, Map<String, Object> queryParams){
        requestSpecification.queryParams(queryParams);
        sendRequest(method,endpoint);

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

    public static void assertValueOfNestedKey(String jsonPath, String expectedValue) {
        Response response = mainResponse;

        String actualValue = response.jsonPath().getString(jsonPath);
        Assert.assertEquals(actualValue, expectedValue, "The value for the key '" + jsonPath + "' is incorrect.");
    }

    public static void assertObjectCount(String jsonPath, int expectedCount) {
        Response response = mainResponse;

        List<Object> objects = response.jsonPath().getList(jsonPath);

        Assert.assertEquals(objects.size(), expectedCount,
                "The number of objects at '" + jsonPath + "' is incorrect.");
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

    public static void assertDifferenceBetweenTimes(String key){
        Response response = mainResponse;

        String responseTimestamp = response.jsonPath().getString(key);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        ZonedDateTime responseTime = ZonedDateTime.parse(responseTimestamp, formatter);

        ZonedDateTime londonTime = ZonedDateTime.now(ZoneId.of("Europe/London"));

        long secondsDifference = ChronoUnit.SECONDS.between(responseTime, londonTime);

        long maximumTimeout = 15;
        Assert.assertTrue(Math.abs(secondsDifference) <= maximumTimeout, "The time difference exceeds the tolerance of " + maximumTimeout + " seconds.");
    }

    public static void reset() {
        mainResponse = null;
        requestSpecification = given();
        token = null;
    }

}

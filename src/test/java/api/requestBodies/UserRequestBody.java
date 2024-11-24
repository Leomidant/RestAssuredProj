package api.requestBodies;

import api.steps.CommonSteps;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class UserRequestBody {

    //We will use this class when not all parameters are variables in json and need to change only few parameters.
    private static final String dataDir = System.getProperty("user.dir") + "/src/test/resources/data";


    public String userJsonBody(Map<String, Object> jsonBody) {
        String requestBody;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            requestBody = objectMapper.writeValueAsString(jsonBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return requestBody;

    }
}

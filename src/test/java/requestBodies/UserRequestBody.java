package requestBodies;

import steps.CommonSteps;

public class UserRequestBody {
    private static final String dir = System.getProperty("user.dir");


    public String authorizeUser() throws Exception {
        String requestBody = CommonSteps.readJsonFileAsString(dir + "/src/test/resources/data/AuthorizeRequestBody.json");
        return requestBody.replace("$USERNAME","testUser")
                .replace("$PASSWORD","testPassword");
    }
}

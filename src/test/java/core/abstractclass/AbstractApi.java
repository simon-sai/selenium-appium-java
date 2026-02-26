package core.abstractclass;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/*
 * Read me: https://github.com/rest-assured/rest-assured/wiki/Usage
 */
public abstract class AbstractApi extends AbstractBase {
    // ThreadLocal ensures each thread (scenario) has its own response — thread-safe
    private static final ThreadLocal<Response> sharedResponse = new ThreadLocal<>();

    protected void setResponse(Response response) {
        sharedResponse.set(response);
    }

    protected Response getResponse() {
        return sharedResponse.get();
    }

    public int getStatus() {
        return getResponse().getStatusCode();
    }

    public String getJsonPath(String jsonPath) {
        JsonPath jsonPathEvaluator = getResponse().jsonPath();
        return jsonPathEvaluator.getString(jsonPath);
    }

    public String getBody() {
        return getResponse().asString();
    }

}
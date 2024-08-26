package core.abstractclass;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/*
 * Read me: https://github.com/rest-assured/rest-assured/wiki/Usage
 */
public abstract class AbstractApi extends AbstractBase {
    protected static Response response;

    public int getStatus() {
        return AbstractApi.response.getStatusCode();
    }

    public String getJsonPath(String jsonPath) {
        JsonPath jsonPathEvaluator = AbstractApi.response.jsonPath();
        return jsonPathEvaluator.getString(jsonPath);
    }

    public String getBody() {
        return AbstractApi.response.asString();
    }

}
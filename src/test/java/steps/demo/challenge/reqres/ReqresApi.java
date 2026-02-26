package steps.demo.challenge.reqres;

import core.abstractclass.AbstractApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public abstract class ReqresApi extends AbstractApi {
    protected String domain = "https://reqres.in";

    // ThreadLocal so the token is shared across all step classes within the same scenario/thread
    private static final ThreadLocal<String> sharedToken = new ThreadLocal<>();

    protected abstract String getUri();

    protected String getDomain() {
        return this.domain;
    }

    protected String getUrl() {
        return this.getDomain() + this.getUri();
    }

    protected String getToken() {
        String token = sharedToken.get();
        return token != null ? token : "";
    }

    protected String setToken(String newToken) {
        sharedToken.set(newToken);
        return newToken;
    }

    protected Response postJson(String url, String jsonBody) {
        Response response = RestAssured.given()
                .body(jsonBody)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + this.getToken())
                .post(url);
        this.setResponse(response);
        return response;
    }

    protected Response getJson(String url) {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + this.getToken())
                .get(url);
        this.setResponse(response);
        return response;
    }

    protected Response putJson(String url, String jsonBody) {
        Response response = RestAssured.given()
                .body(jsonBody)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + this.getToken())
                .put(url);
        this.setResponse(response);
        return response;
    }
}

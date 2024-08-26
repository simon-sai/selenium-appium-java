package steps.demo.challenge.reqres;

import core.abstractclass.AbstractApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public abstract class ReqresApi extends AbstractApi {
    protected String domain = "https://reqres.in";
    protected String token = "";

    protected abstract String getUri();

    protected String getDomain() {
        return this.domain;
    }

    protected String getUrl() {
        return this.getDomain() + this.getUri();
    }

    protected String getToken() {
        return this.token;
    }

    protected String setToken(String newToken) {
        this.token = newToken;
        return this.token;
    }

    protected Response postJson(String url, String jsonBody) {
        AbstractApi.response = RestAssured.given()
                .body(jsonBody)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + this.token)
                .post(url);
        return AbstractApi.response;
    }

    protected Response getJson(String url) {
        AbstractApi.response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + this.token)
                .get(url);
        return AbstractApi.response;
    }

    protected Response putJson(String url, String jsonBody) {
        AbstractApi.response = RestAssured.given()
                .body(jsonBody)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + this.token)
                .put(url);
        return AbstractApi.response;
    }
}

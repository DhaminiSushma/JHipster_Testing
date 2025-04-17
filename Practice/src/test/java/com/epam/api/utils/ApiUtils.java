package com.epam.api.utils;

import com.epam.hooks.ApiHooks;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;

public class ApiUtils {
    public static RequestSpecification requestSpecification;

    public ApiUtils(String accessToken) {
        String baseUrl = ApiHooks.getBaseUrl();

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setAuth(oauth2(accessToken))
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "*/*")
                .build();
    }


    public Response get(String api){
        return given().spec(requestSpecification)
                .when()
                .get(api);

    }

    public Response post(String api, Object object){
        return given().spec(requestSpecification)
                .body(object)
                .when()
                .post(api);

    }

    public Response put(String api, Object object){
        return given().spec(requestSpecification)
                .body(object)
                .when()
                .put(api);

    }

    public Response patch(String api, Object object){
        return given().spec(requestSpecification)
                .body(object)
                .when()
                .patch(api);

    }

    public Response delete(String api){
        return given().spec(requestSpecification)
                .when()
                .delete(api);
    }
}
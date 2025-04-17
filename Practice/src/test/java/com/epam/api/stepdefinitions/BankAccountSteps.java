package com.epam.api.stepdefinitions;

import com.epam.api.utils.ApiUtils;
import com.epam.api.utils.AuthenticationUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class BankAccountSteps {
    private Response response;
    private static ApiUtils apiUtils;

    @Given("User is at the base URL")
    public void setBaseUrl() throws JsonProcessingException {
        String accessToken = AuthenticationUtil.getToken("admin", "admin");
        apiUtils = new ApiUtils(accessToken);
    }


    @When("I send a GET request to endpoint {string}")
    public void iSendAGETRequestToEndpoint(String endpoint) {
        response = apiUtils.get(endpoint);
    }

    @Then("User checks if they Receive Status Code {int}")
    public void verifySuccessStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }


    @Then("the response content type should be {string}")
    public void theResponseContentTypeShouldBe(String contentType) {
        String actualContentType = response.getContentType();
        assertEquals(contentType, actualContentType);
    }
}

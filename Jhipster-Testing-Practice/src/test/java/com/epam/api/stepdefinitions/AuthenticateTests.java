package com.epam.api.stepdefinitions;

import com.epam.api.pojos.Authenticate;
import com.epam.api.requestspecs.AuthenticateSpec;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class AuthenticateTests {
    private static RequestSpecification requestSpecification;
    Authenticate authenticate;
    AuthenticateSpec authenticateSpec=new AuthenticateSpec();
    Response response;
    @Given("User with url endpoint {string}")
    public void userGoesToTheUrlEndpoint(String url) {
        requestSpecification=authenticateSpec.post(url);
    }

    @When("User enters Username {string}, valid Password {string} and RememberMe {string}")
    public void userEntersUsernameValidPasswordAndRememberMe(String username, String password, String rememberMe) {
        authenticate=new Authenticate.AuthenticateBuilder().withUsername(username).withPassword(password).withRememberMe(Boolean.valueOf(rememberMe)).build();
        response=given().spec(requestSpecification).contentType(ContentType.JSON).body(authenticate).when().post("/authenticate");
        authenticate=null;
    }

    @Then("User checks if they Receive correct Status Code {int}")
    public void validateStatusCode(int statusCode) {
        response.then().assertThat().statusCode(statusCode).and().body("id_token", Matchers.notNullValue());
    }

    @When("User enters incorrect Username {string} or incorrect Password {string} and RememberMe {string}")
    public void userEntersIncorrectUsernameOrIncorrectPasswordAndRememberMe(String username, String password, String rememberMe) {
        authenticate=new Authenticate.AuthenticateBuilder().withUsername(username).withPassword(password).withRememberMe(Boolean.valueOf(rememberMe)).build();
        response=given().spec(requestSpecification).contentType(ContentType.JSON).body(authenticate).when().post("/authenticate");
        authenticate=null;
    }

    @Then("User will get Status Code as {int}")
    public void userWillGetStatusCodeAs(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}

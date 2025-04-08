package com.epam.hooks;

import com.epam.api.pojos.Authenticate;
import com.epam.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIHook {
    private Response response;
    private final ConfigReader configReader=ConfigReader.getInstance();
    @Before
    public void authenticate(){
        Authenticate authenticate=new Authenticate.AuthenticateBuilder().withUsername("admin").withPassword("admin").withRememberMe(true).build();
        //String url= configReader.getProperty("url");
        response=given().body(authenticate).when().post("http://localhost:9000/api/authenticate");
    }
    public String getToken(){
        return response.jsonPath().getString("id_token");
    }
    public String getBaseUri(){return configReader.getProperty("url");}
    @After
    public void destroy(){
        response=null;
    }
}

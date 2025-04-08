package com.epam.api.requestspecs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
    public RequestSpecification get(String BaseUri){
        return requestSpecBuilder.setBaseUri(BaseUri).build();
    }
    public RequestSpecification post(String BaseUri){
        return requestSpecBuilder.setBaseUri(BaseUri).setContentType(ContentType.JSON).addHeader("accept","*/*").build();
    }
    public RequestSpecification post(String BaseUri, String token){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer "+token).build();
    }
    public RequestSpecification put(String BaseUri,String token){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer "+token).build();
    }
    public RequestSpecification patch(String BaseUri,String token){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer "+token).build();
    }
    public RequestSpecification delete(String BaseUri,String token){
        return requestSpecBuilder.setBaseUri(BaseUri).addHeader("accept","*/*").addHeader("Authorization","Bearer "+token).build();
    }
}

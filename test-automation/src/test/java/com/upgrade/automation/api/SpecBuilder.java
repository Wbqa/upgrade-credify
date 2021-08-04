package com.upgrade.automation.api;

import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class SpecBuilder {

    public static RequestSpecification getRequestSpec(String apiUrl, String contentType, Map<String,String> headers){
        return new RequestSpecBuilder().
                setBaseUri(apiUrl).
                setContentType(contentType).
                		addHeaders(headers).
                        setContentType(ContentType.JSON).    
                        build();
    }
    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                build();
    }
}

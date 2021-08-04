package com.upgrade.automation.api;

import static io.restassured.RestAssured.given;
import java.util.Map;
import io.restassured.response.Response;

public class RestResourceUtil {

    public static Response post(String apiUrl, String contentType, Map<String,String> headers, Object request){
        return given(SpecBuilder.getRequestSpec(apiUrl, contentType, headers)).
                body(request).
                when().post(apiUrl).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }
}

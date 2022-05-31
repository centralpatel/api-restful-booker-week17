package com.herokuapp.booker.restful.restfulinfo;

import com.herokuapp.booker.restful.model.TokenPojo;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateToken {
    String token;

    public String gettingToken() {
        TokenPojo tokenPojo = new TokenPojo();
        tokenPojo.setUsername("admin");
        tokenPojo.setPassword("password123");


        Response response = given()
                .header("Content-Type", "application/json")
                .body(tokenPojo)
                .when()
                .post("/auth");
        response.then().statusCode(200);
        token = (response.path("token"));
        response.prettyPrint();
        return token;
    }
}

package com.herokuapp.booker.restful.restfulinfo;

import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestfulGetTest extends TestBase {

    @Test
    public void getAllBookingInfo() {
        Response response = given()
                .when()
                .get("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getSingleBookingInfo() {
        Response response = given()
                .basePath("/booking")
                .pathParam("id", 1000)
                .when()
                .get("{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}

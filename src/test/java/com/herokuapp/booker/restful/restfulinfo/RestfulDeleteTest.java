package com.herokuapp.booker.restful.restfulinfo;

import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestfulDeleteTest extends TestBase {
    @Test
    public void deleteAllBookingInfo() {

        CreateToken createToken = new CreateToken();
        String token = createToken.gettingToken();

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token = " + token)
                .basePath("/booking")
                .pathParam("id", 1904)
                .when()
                .delete("/{id}");
        response.prettyPrint();
        response.then().statusCode(201);
    }
}

package com.herokuapp.booker.restful.restfulinfo;

import com.herokuapp.booker.restful.model.BookingPojo;
import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class RestfulPatchTest extends TestBase {

    @Test
    public void patchTest() {
        CreateToken createToken = new CreateToken();
        String token = createToken.gettingToken();
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Bina");
        bookingPojo.setLastname("Shah");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token =" + token)
                .basePath("/booking")
                .pathParam("id", 2040)
                .body(bookingPojo)
                .when()
                .patch("/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}

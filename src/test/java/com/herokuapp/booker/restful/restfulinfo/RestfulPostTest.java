package com.herokuapp.booker.restful.restfulinfo;

import com.herokuapp.booker.restful.model.RestFulPojo;
import com.herokuapp.booker.restful.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestfulPostTest extends TestBase {

    @Test
    public void createBookingTest() {

        Map<String, String> bookingdates = new HashMap<>(); // creating map variable which is key and value
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        RestFulPojo restFulPojo = new RestFulPojo();
        restFulPojo.setFirstname("Nehal");
        restFulPojo.setLastname("Patel");
        restFulPojo.setTotalprice(101);
        restFulPojo.setDepositpaid(true);
        restFulPojo.setBookingdates(bookingdates);
        restFulPojo.setAdditionalneeds("Veggie Dinner");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(restFulPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}

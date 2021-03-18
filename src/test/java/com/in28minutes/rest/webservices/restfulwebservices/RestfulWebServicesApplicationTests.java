package com.in28minutes.rest.webservices.restfulwebservices;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RestfulWebServicesApplicationTests {

    @Test
    void getUsers() {
        get("/users").
                then().
                contentType(JSON).
                body("[0].name", equalTo("name1")).
                body("[1].name", equalTo("name2"))
        ;
    }

    @Test
    void createUser() {
        RequestSpecification request = given();
        request.header("content-type", MediaType.APPLICATION_JSON_VALUE);
        request.body(new User(105, "name5", new Date()));
        Response response = request.post("/users").andReturn();
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        //String location = response.getHeader("location");
        //assertTrue(String.format("%s should end with /users/5", location), location.endsWith("/users/5"));
    }

}

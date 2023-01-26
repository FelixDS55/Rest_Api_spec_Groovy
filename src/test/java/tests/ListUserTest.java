package tests;

import models.ListUserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import specs.Spec;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static specs.Spec.request;

public class ListUserTest {
    @Test
    public void listEmailUserTest(){
        given()
                .spec(request)
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem("janet.weaver@reqres.in"));

    }
}

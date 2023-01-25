package tests;

import io.restassured.specification.ResponseSpecification;
import models.UserCreateRequest;
import models.UserCreateResponse;
import org.junit.jupiter.api.Test;
import specs.Spec;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateUserTest {
    String id = "601";

    @Test
    void createUserTest(){
        UserCreateRequest userCreate = new UserCreateRequest();
        userCreate.setName("morpheus");
        userCreate.setJob("leader");

        UserCreateResponse userCreateNew = Spec.request
                .body(userCreate)
                .when()
                .post("/users")
                .then().spec(Spec.responseSpec201())
                .log().all().extract().as(UserCreateResponse.class);

        assertThat(userCreateNew)
                .isNotNull()
                .extracting(UserCreateResponse::getName)
                .isEqualTo(userCreate.getName());

        assertThat(userCreateNew)
                .isNotNull()
                .extracting(UserCreateResponse::getJob)
                .isEqualTo(userCreate.getJob());
    }
}

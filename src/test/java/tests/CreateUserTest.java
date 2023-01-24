package tests;

import models.UserCreateRequest;
import models.UserCreateResponse;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import specs.Spec;
import specs.SpecCreate;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateUserTest {
    String id = "601";

    @Test
    void createUserTest(){
        UserCreateRequest userCreate = new UserCreateRequest();
        userCreate.setName("morpheus");
        userCreate.setJob("leader");

        UserCreateResponse uC = SpecCreate.request
                .body(userCreate)
                .when()
                .post()
                .then().log().all().extract().as(UserCreateResponse.class);

        assertThat(uC)
                .isNotNull()
                .extracting(UserCreateResponse::getName)
                .isEqualTo(userCreate.getName());

        assertThat(uC)
                .isNotNull()
                .extracting(UserCreateResponse::getJob)
                .isEqualTo(userCreate.getJob());
    }
}

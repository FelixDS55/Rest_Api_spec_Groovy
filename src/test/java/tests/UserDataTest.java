package tests;

import models.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import specs.Spec;

public class UserDataTest {

    @Test
    void userDataTest(){
        UserData userData = new UserData();
        UserData data = Spec.request
                .when()
                .get("/users/2")
                .then()
                .log().all()
                .extract().as(UserData.class);

        Assertions.assertNotNull(data.getData().getId());
        Assertions.assertNotNull(data.getData().getFirstName());
        Assertions.assertNotNull(data.getData().getLastName());

        Assertions.assertEquals(userData.getIdRequest(), data.getData().getId());
        Assertions.assertEquals(userData.getFirstNameRequest(), data.getData().getFirstName());
        Assertions.assertEquals(userData.getLastNameRequest(), data.getData().getLastName());
        Assertions.assertTrue(userData.getEmailRequest().contains(data.getData().getEmail()));
    }
}

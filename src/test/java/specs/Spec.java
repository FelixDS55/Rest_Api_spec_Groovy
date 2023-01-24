package specs;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;

public class Spec {
    public static RequestSpecification request = with()
            .baseUri("https://reqres.in/api")
            .basePath("/api")
            .log().all()
            .contentType(ContentType.JSON);
}

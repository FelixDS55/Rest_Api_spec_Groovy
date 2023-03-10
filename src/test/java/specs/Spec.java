package specs;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Spec {
    public static RequestSpecification request = with()
            .baseUri("https://reqres.in")
            .basePath("/api")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpec201(){
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }
}

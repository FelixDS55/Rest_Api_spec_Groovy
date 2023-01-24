package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class SpecCreate {
    public static RequestSpecification request = with()
            .baseUri("https://reqres.in")
            .basePath("/api/users")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification requestSpec200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}

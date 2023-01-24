import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RequestSpecificationTest {
    RequestSpecification spec;
    ResponseSpecification resSpec;

    @BeforeClass
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:3000")
                .setBasePath("posts")
                .build();
        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200).build();

        ResponseLoggingFilter resFilter = new ResponseLoggingFilter();
        RequestLoggingFilter reqFilter = new RequestLoggingFilter();
        RestAssured.filters(reqFilter, resFilter);
    }

    @Test
    public void getPosts() {
        given()
                .spec(spec).
        when()
                .get().
        then()
                .spec(resSpec);
    }
    @Test
    public void getPost() {
        given()
                .spec(spec).
        when()
                .get("/1").
        then()
                .spec(resSpec);
    }
}



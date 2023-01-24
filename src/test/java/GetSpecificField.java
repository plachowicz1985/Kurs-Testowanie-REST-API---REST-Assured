import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class GetSpecificField {


    @Test
    public void checkSpecificField() {

        Response response = RestAssured.get("http://localhost:3000/posts/1");
        String author = response.path("author");
        Assert.assertEquals(author, "Daria");

        String author2 = RestAssured.get("http://localhost:3000/posts/1").path("author");
        Assert.assertEquals(author2, "Daria");
    }

    //korzystanie z klasy json path
    @Test
    public void checkSpecificFieldJsonPath() {

        Response response = RestAssured.get("http://localhost:3000/posts/1");
        JsonPath jsonPath = new JsonPath(response.asString());

        String author = jsonPath.get("author");

        Assert.assertEquals(author, "Daria");

        String stringResponse = RestAssured.get("http://localhost:3000/posts/1").asString();
        String author2 =  JsonPath.from(stringResponse).get("author");

        Assert.assertEquals(author2, "Daria");
    }
}

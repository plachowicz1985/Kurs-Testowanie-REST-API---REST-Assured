import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FilterPosts {

    @Test
    public void filterPosts() {
        //korzystamy z sekcji given aby moc uzyc query params
        given().log().all().queryParam("author", "Daria")
                .when().get("http://localhost:3000/posts")
                .then().log().all();

    }

    @Test
    public void filterPostsAuthorTitle() {
        //korzystamy z sekcji given aby moc uzyc query params

        Map<String, Object> params = new HashMap<>();
        params.put("author", "Bartek");
        params.put("title", "Pierwszy post");

        given().log().all().queryParams(params)
                .when().get("http://localhost:3000/posts")
                .then().log().all().statusLine(Matchers.containsString("OK"));

    }
    @Test
    public void filterPostsById() {
        //korzystamy z sekcji given aby moc uzyc query params
        given().log().all().queryParam("id", "1","3")
                .when().get("http://localhost:3000/posts")
                .then().log().all();

    }
}

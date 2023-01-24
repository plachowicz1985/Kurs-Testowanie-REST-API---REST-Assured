import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PathParam {
//unikamy kardcodowania wartoci, na sztywno, w naszych testach
    @Test
    public void getPostPathParam() {
        //given().log().all().pathParam("postId",1).when().get("http://localhost:3000/posts/{postId}").then().log().all();

        given().log().all().when().get("http://localhost:3000/posts/{postId}", 1).then().log().all();
    }
}

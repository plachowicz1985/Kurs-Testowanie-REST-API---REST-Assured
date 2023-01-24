import Model.Post;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class VerifyResponse {
    @Test
    public void getPost() {
        String expected = "{\n" +
                "  \"author\": \"Daria\",\n" +
                "  \"title\": \"tytuł po aktualizacji 2\",\n" +
                "  \"id\": 1\n" +
                "}";
        when().get("http://localhost:3000/posts/1").then().log().all().body(equalTo(expected));
    }

    @Test
    public void getPostContains() {

        given().get("http://localhost:3000/posts/1").then().log().all().body(Matchers.containsStringIgnoringCase("aria"));
    }

    @Test
    public void checkSpecificField() {

        when().
                get("http://localhost:3000/posts/1").
        then().
                assertThat().body("title", equalTo("tytuł po aktualizacji 2")).
        and().
                assertThat().body("author", equalTo("Daria"));
    }

    @Test
    public void getPostObject() {
        Integer id =1;
        Post newPost = given().get("http://localhost:3000/posts/{postid}", id).then().log().all().
                body("title", equalTo("tytuł po aktualizacji 2")).
                and().body("author", equalTo("Daria")).extract().body().as(Post.class);

        Assert.assertEquals(newPost.getAuthor(), "Daria");
        Assert.assertEquals(newPost.getTitle(), "tytuł po aktualizacji 2");
        Assert.assertEquals(newPost.getId(),id);
    }

    @Test
    public void addPostObject() {
        Post newPost = new Post();
        newPost.setTitle("Tytuł obiektowy");
        newPost.setAuthor("Autor obiektowy");

        Post createdPost = given().log().all().contentType(ContentType.JSON).body(newPost).
                when().post("http://localhost:3000/posts").then().log().all().extract().body().as(Post.class);

        Assert.assertEquals(newPost, createdPost);

        Assert.assertEquals(newPost.getAuthor(), "Autor obiektowy");
        Assert.assertEquals(newPost.getTitle(), "Tytuł obiektowy");
    }
}

import Model.Post;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AddPostTest {

    @Test
    public void addPost() {

        String newPost = "{\n" +
                "    \"title\": \"Pierwszy post\",\n" +
                "    \"author\": \"Bartek\"\n" +
                "}";

        given().log().all().contentType(ContentType.JSON).body(newPost).
            when().post("http://localhost:3000/posts").then().log().all();
    }

    //dodawanie postu za pomocją pliku
    @Test
    public void addPostFromFile() {

        File newPost = new File("src/test/resources/post.json");

        given().log().all().contentType(ContentType.JSON).body(newPost).
                when().post("http://localhost:3000/posts").
                then().log().all();
    }

    //dodawanie postu za pomocją body jako mapa
    @Test
    public void addPostMap() {
        Map<String, Object> newPost = new HashMap<>();
        newPost.put("title", "tytuł z mapy");
        newPost.put("autor", "Daria");

        given().log().all().contentType(ContentType.JSON).body(newPost).
                when().post("http://localhost:3000/posts").
                then().log().all();
    }

    //dodawanie postu za pomocją java object
    @Test
    public void addPostObject() {
        Post newPost = new Post();
        newPost.setTitle("Tytuł obiektowy");
        newPost.setAuthor("Autor obiektowy");

        given().log().all().contentType(ContentType.JSON).body(newPost).
                when().post("http://localhost:3000/posts").
                then().log().all();
    }
}

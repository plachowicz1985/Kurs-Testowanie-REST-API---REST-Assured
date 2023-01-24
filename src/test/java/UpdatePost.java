import Model.Post;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdatePost {

    @Test
    public void replacePost() {
        //metoda put zaktualizuje nam cały post

        Map<String, Object> newPost = new HashMap<>();
        newPost.put("title", "Legia Warszata");
        newPost.put("author", "To najlepszy klub");

        given().log().all().contentType(ContentType.JSON).body(newPost).
                //metoda put
                when().put("http://localhost:3000/posts/2").
                then().log().all();
    }

    @Test
    public void replacePostObject() {
        //metoda put zaktualizuje nam cały post

        Post newPost = new Post();
        newPost.setAuthor("Tomek");
        //newPost.setTitle("Dupson");
    //wewnatrz klasy mamy dwa pola tytul i autor, kazde z nich ma wartosc domyslna null,
        // restassured wrzuca/wysyla te wartosc domyslna jak my nie podamy jakiejs konkretnej

        given().log().all().contentType(ContentType.JSON).body(newPost).
                //metoda put
                        when().put("http://localhost:3000/posts/2").
                then().log().all();
    }

    @Test
    public void updatePostObject() {
        Post newPost = new Post();
        newPost.setTitle("Marunia");


        given().log().all().contentType(ContentType.JSON).body(newPost).
                //metoda patch
                        when().patch("http://localhost:3000/posts/2").
                then().log().all();
    }
}

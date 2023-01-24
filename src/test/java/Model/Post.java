package Model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

//adnotacja, nie bedziemy wysylali metod ktore sa nullami
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {

    private int id;
    private String title;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //metoda pobierajaca tytul
    public String getTitle() {
        return title;
    }

    //metoda ustawiajaca tytul
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) && Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}

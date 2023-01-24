import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.element.Node;
import org.testng.annotations.Test;

import java.util.List;

public class XmlPathTest {

    @Test
    public void testXmlPath() {

        String xml = "<filmy>\n" +
                "\t<film gatunek = \"komedia\">\n" +
                "\t<id>1</id>\n" +
                "\t<nazwa>Forrest Gunp</nazwa>\n" +
                "\t<ocena>8</ocena>\n" +
                "\t</film>\n" +
                "\t<film gatunek = \"komedia\">\n" +
                "\t<id>2</id>\n" +
                "\t<nazwa>American Pie</nazwa>\n" +
                "\t<ocena>7</ocena>\n" +
                "\t</film>\n" +
                "\t<film gatunek = \"dramat\">\n" +
                "\t<id>3</id>\n" +
                "\t<nazwa>Zielona mila</nazwa>\n" +
                "\t<ocena>9</ocena>\n" +
                "\t</film>\n" +
                "</filmy>";

            String nazwa = XmlPath.from(xml).get("filmy.film.nazwa[0]");

            //pobieramy nazwy wszystkich filmów
            List<String> nazwy = XmlPath.from(xml).getList("filmy.film.nazwa");

            //pobieramy atrybut(nie ma w json) gatunek dla pierwszego filmu
            String gatunek = XmlPath.from(xml).get("filmy.film[0].@gatunek");

            List<Node> filmy = XmlPath.from(xml).get("filmy.film.findAll {element -> return element}");
            String nazwaFilmu = filmy.get(2).get("nazwa").toString();

            //gałęzie zawierające tylko i wyłącznie filmy komediowe
            List<Node> komedie = XmlPath.from(xml).get("filmy.film.findAll {film -> film.@gatunek=='komedia'}");

            //film o ocenie równej 9
            Node filmOcenaDziewiec = XmlPath.from(xml).get("filmy.film.find {film -> def ocena = film.ocena; ocena == 9}");

            //filmy o ocenie wyzszej niz 7
            List<Node> wiekszeNizSiedem = XmlPath.from(xml).get("filmy.film.findAll {film -> def ocena = film.ocena.toFloat(); ocena >7}");
            List<String> nazwyAll = XmlPath.from(xml).get("filmy.film.collect {it.nazwa}");
    }


}

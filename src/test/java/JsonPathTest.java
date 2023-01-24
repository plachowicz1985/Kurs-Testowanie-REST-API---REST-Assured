import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class JsonPathTest {
    @Test
    public void checkSpecificFieldJsonPath() {

        Response response = RestAssured.get("http://localhost:3000/posts/1");

        System.out.println(response.asString());

//        String secretString = response.path("secretString");
//        List<Integer> winningNumbers = response.path("winning-numbers");
//        String firstWinnerName = response.path("winners.name[0]");
//        String firstWinnerName1 = response.path("winners[0].name");
//        String secondWinnerName = response.path("winners[1].name");
//        String lastWinnerName = response.path("winners[-1].name");
//        List<String> winnerNames = response.path("winners.name");
//        Map<String, ?> winner = response.path("winners[0]");
//        List<Map<String, ?>> winners = response.path("winners");

//        Map<String, ?> winnerInfo = response.path("winners.find{it.name=='Andrew'}");
//                //it mowi o tym abysmy przeszli przez wszystkich zwyciezcow i sprawdzili wartosc pola imie i szukali tylko zwyciezcow andrew
//        Integer winnerId = response.path("winners.find{it.name=='Andrew'}.winnerId");
//        Integer maxNumber = response.path("winning-numbers.max()");
//        Integer minNumber = response.path("winning-numbers.min()");
//
//        //znajdujemy zwyciezce ktorego id jest maksymalne
//        Map<String, ?> winnerMaxId = response.path("winners.max{it.winnerId}");
//
//        //sumujemy pieniadze ktre zostały wygrane w naszej loterii
//        Integer moneySum = response.path("winners.collect{it.money}.sum()");

        //metoda find znajdzie nam tylko jeden element
       // Integer winnerId = response.path("winners.find{it.name=='John'}.winnerId");

        //metoda findAll znajdzie nam wszystkie szukane lementy
        List<Integer> winnerId = response.path("winners.findAll{it.name=='John'}.winnerId");

        }
}

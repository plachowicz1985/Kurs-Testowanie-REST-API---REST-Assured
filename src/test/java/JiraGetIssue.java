import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class JiraGetIssue {

    @Test
    public void getIssue() {
        //preemptive wysyla dane logowania do tych endpointow ktore tego wymagaja
        given().auth().preemptive().basic("piotr.lachowicz1985@gmail.com", "qjD4fd942clnvDxsLDwPBD61").
        when()
                .get("https://piotrlachowicz.atlassian.net/rest/api/2/issue/P1-1")
        .then()
                .log().all();
    }
}

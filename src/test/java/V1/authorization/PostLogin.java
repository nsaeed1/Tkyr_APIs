package V1.authorization;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PostLogin {
    @Test
    public void validateResponseCode()
    {
        RestAssured.baseURI = "https://customer-qa.tkyr.net/api/Authentication/Login?api-version=veniamirure";
        String jsonBody = "{\n" +
                "  \"mobile\": \"0544444444\"\n" +
                "}";
        given().contentType("application/json")
                .body(jsonBody).log().all()
                .post()
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

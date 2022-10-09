package V1.authorization;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRegister {
    @Test
    public void validateResponseCode()
    {
        RestAssured.baseURI = "https://customer-qa.tkyr.net/api/Authentication/Login?api-version=veniamirure";
        String jsonBody = "{\n" +
                "  \"name\": \"Noura\",\n" +
                "  \"mobile\": \"0571733402\",\n" +
                "  \"email\": \"nsaeed@tkyr.net\",\n" +
                "  \"gender\": \n" +
                "}";
        given().contentType("application/json")
                .body(jsonBody).log().all()
                .post()
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

}

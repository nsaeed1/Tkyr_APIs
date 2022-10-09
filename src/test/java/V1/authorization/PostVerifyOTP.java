package V1.authorization;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PostVerifyOTP {
    public String token;
    @Test
    public void postVerifyOTPEn(){
        RestAssured.baseURI = "https://customer-qa.tkyr.net";
        String json = "{\n" +
                "  \"mobile\": \"0544444444\",\n" +
                "  \"otp\": \"4111\",\n" +
                "  \"uuid\": \"Test\"\n" +
                "}";
        Response response = given().contentType("application/json")
                .body(json).log().all()
                .post("/api/Authentication/VerifyOTP?api-version=veniamirure")
                .then().log().all()
                .assertThat()
                .statusCode(200).extract().response(); //extract.response adds the json response in the response object
        token = response.path("data.token");
    }
}

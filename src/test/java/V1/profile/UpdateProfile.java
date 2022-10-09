package V1.profile;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateProfile {
    PostVerifyOTP postVerifyOTP;

    @Test
    public void validateResponseCode(){
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        String jsonBody  = "{\n" +
                "  \"name\": \"nour\",\n" +
                "  \"mobile\": \"0544444444\",\n" +
                "  \"email\": \"n@tkyr.net\",\n" +
                "  \"dateOfBirth\": \"1997-10-23\",\n" +
                "  \"gender\": \"0\"\n" +
                "}";
        RestAssured.baseURI = "https://customer-qa.tkyr.net";
        given().auth().oauth2(postVerifyOTP.token)
                .contentType("application/json")
                .body(jsonBody).log().all()
                .when()
                .put("/api/Profile/UpdateProfile?api-version=veniamirure")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

package V1.profile;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SaveFcmToken {
    PostVerifyOTP postVerifyOTP;

    @Test
    public void validateResponseCode(){
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        String jsonBody  = "{\n" +
                "  \"isAndroid\": true,\n" +
                "  \"fcmToken\": \"esse non dolor sint\",\n" +
                "  \"fcmTokenLanguage\": \"est ut id in sint\"\n" +
                "}";
        RestAssured.baseURI = "https://customer-qa.tkyr.net";
        given().auth().oauth2(postVerifyOTP.token)
                .contentType("application/json")
                .body(jsonBody).log().all()
                .when()
                .post("/api/Profile/saveFcmToken?api-version=veniamirure")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

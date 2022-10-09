package V1.card_registration;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostAddCard {
    PostVerifyOTP postVerifyOTP;
    @Test
    public void validateResponseCode(){
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        String jsonBody = "{\n" +
                "  \"paymentMethod\": Visa,\n" +
                "  \"resourcePath\": \"ad in\"\n" +
                "}";

        RestAssured.baseURI = "https://customer-qa.tkyr.net/api/CardRegisteration/GetAll?api-version=veniamirure";
        given().auth().oauth2(postVerifyOTP.token)
                .when()
                .post()
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

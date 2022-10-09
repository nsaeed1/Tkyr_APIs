package V1.store;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetProductDetails {
    PostVerifyOTP postVerifyOTP;

    @Test
    public void validateResponseCode() {
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        RestAssured.baseURI = "https://customer-qa.tkyr.net";
        given().auth().oauth2(postVerifyOTP.token)
                .when()
                .get("/api/Order/AddOrder?api-version")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

package V1.address;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PostDeleteAddress {
    PostVerifyOTP postVerifyOTP;
    @Test
    public void validateResponseCode(){
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();
       /* RestAssured.baseURI = "https://customer-qa.tkyr.net/api/Address/Delete/:customerAddressId?api-version=veniamirure";*/
        given().auth().oauth2(postVerifyOTP.token)
        .when()
                .post("https://customer-qa.tkyr.net/api/Address/Delete/4622?api-version=veniamirure")
        .then()
                .assertThat()
                .statusCode(200);

    }
}

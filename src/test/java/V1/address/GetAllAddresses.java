package V1.address;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllAddresses {
    PostVerifyOTP postVerifyOTP;
    @Test
    public void validateResponseCode(){
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        RestAssured.baseURI = "https://customer-qa.tkyr.net/api/Address/GetAll?api-version=veniamirure";
        given().auth().oauth2(postVerifyOTP.token)
                .when()
                .get()
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

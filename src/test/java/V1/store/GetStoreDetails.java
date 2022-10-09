package V1.store;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetStoreDetails {
    PostVerifyOTP postVerifyOTP;

    @Test
    public void validateResponseCode(){
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        String jsonBody  = "{\n" +
                "  \"branchId\": 37,\n" +
                "  \"latitude\": 24.682488,\n" +
                "  \"longitude\": 46.669718,\n" +
                "  \"isPickup\": false\n" +
                "}";
        RestAssured.baseURI = "https://customer-qa.tkyr.net";
        given().auth().oauth2(postVerifyOTP.token)
                .contentType("application/json")
                .body(jsonBody).log().all()
                .when()
                .post("/api/Store/GetStoreDetails?api-version=veniamirure")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

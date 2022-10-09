package V1.store;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetStoreBranches {
    PostVerifyOTP postVerifyOTP;

    @Test
    public void validateResponseCode() {
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        String jsonBody = "{\n" +
                "  \"storeId\": 27,\n" +
                "  \"latitude\": 24.639918551,\n" +
                "  \"longitude\": 46.18975359\n" +
                "}";
        RestAssured.baseURI = "https://customer-qa.tkyr.net";
        given().auth().oauth2(postVerifyOTP.token)
                .contentType("application/json")
                .body(jsonBody).log().all()
                .when()
                .post("/api/Store/GetStoreBranches?api-version")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

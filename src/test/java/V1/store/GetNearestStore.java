package V1.store;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetNearestStore {
    PostVerifyOTP postVerifyOTP;
    @Test
    public void validateResponseCode(){
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        String jsonBody  = "{\n" +
                "  \"pageNumber\": 1000,\n" +
                "  \"pageSize\": 1000,\n" +
                "  \"key\": \"amet id\",\n" +
                "  \"latitude\": 24.689715,\n" +
                "  \"longitude\": 46.667844,\n" +
                "  \"isPickup\": true,\n" +
                "  \"bannerId\": 3,\n" +
                "  \"zoneId\": 11,\n" +
                "  \"tagId\": 1,\n" +
                "  \"isFavourite\": false\n" +
                "}";
        RestAssured.baseURI = "https://customer-qa.tkyr.net";
        given().auth().oauth2(postVerifyOTP.token)
                .contentType("application/json")
                .body(jsonBody).log().all()
                .when()
                .post("/api/Store/GetNearestStores?api-version=veniamirure")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

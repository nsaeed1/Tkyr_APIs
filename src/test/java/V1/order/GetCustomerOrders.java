package V1.order;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCustomerOrders {
    PostVerifyOTP postVerifyOTP;
    @Test
    public void validateResponseCode_deliveryOrders()
    {
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        String jsonString = "{\n" +
                "  \"pageNumber\": 1,\n" +
                "  \"pageSize\": 1000,\n" +
                "  \"orderType\": 1\n" +
                "}";

        RestAssured.baseURI = "https://customer-qa.tkyr.net";
        given().auth().oauth2(postVerifyOTP.token)
                .when()
                .contentType("application/json")
                .body(jsonString).log().all()
                .post("/api/Order/GetCustomerOrders")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void validateResponseCode_takeawayOrders()
    {
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        String jsonString = "{\n" +
                "  \"pageNumber\": 1,\n" +
                "  \"pageSize\": 1000,\n" +
                "  \"orderType\": 2\n" +
                "}";

        given().auth().oauth2(postVerifyOTP.token)
                .when()
                .contentType("application/json")
                .body(jsonString).log().all()
                .post("/api/Order/GetCustomerOrders")
                .then().log().all()
                .assertThat()
                .statusCode(200);

    }
}

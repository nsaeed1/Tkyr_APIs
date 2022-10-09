package V1.order;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CalculateTotal {
    PostVerifyOTP postVerifyOTP;
    @Test
    public void validateResponseCode(){
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        String jsonBody= "{\n" +
                "  \"branchId\": 37,\n" +
                "  \"customerAddressId\": 4643,\n" +
                "  \"paymentMethodId\": 1,\n" +
                "  \"couponCode\": null,\n" +
                "  \"useWallet\": false,\n" +
                "  \"isPickup\": false,\n" +
                "  \"latitude\": 24.689715,\n" +
                "  \"longitude\": 46.667844,\n" +
                "  \"calculateOrderTotalProductRequests\": [\n" +
                "    {\n" +
                "      \"productId\": 306,\n" +
                "      \"productSizeId\": 81,\n" +
                "      \"quantity\": 1,\n" +
                "      \"price\": 35.00,\n" +
                "      \"calculateOrderTotalProductOptionRequests\": [\n" +
                "        {\n" +
                "            \"optionId\": 251,\n" +
                "            \"price\": 0.00\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"productId\": 334,\n" +
                "      \"productSizeId\": null,\n" +
                "      \"quantity\": 2,\n" +
                "      \"price\": 80\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        RestAssured.baseURI = "https://customer-dev.tkyr.net";
        given().auth().oauth2(postVerifyOTP.token)
                .contentType("application/json")
                .body(jsonBody).log().all()
                .post("/api/Order/CalculateTotal")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

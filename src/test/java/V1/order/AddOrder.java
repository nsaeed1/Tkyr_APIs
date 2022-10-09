package V1.order;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddOrder {
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
                "  \"driverNote\": \"driver note\",\n" +
                "  \"storeNote\": \"store note\",\n" +
                "  \"useWallet\": false,\n" +
                "  \"isPickup\": false,\n" +
                "  \"arrivalTime\": 30,\n" +
                "  \"fromVehicle\": false,\n" +
                "  \"customerName\": \"Noura\",\n" +
                "  \"vehiclePlate\": null,\n" +
                "  \"vehicleColorId\": null,\n" +
                "  \"vehicleTypeId\": null,\n" +
                "  \"customerCardId\": null,\n" +
                "  \"orderProductRequests\": [\n" +
                "    {\n" +
                "      \"productId\": 306,\n" +
                "      \"productSizeId\": 81,\n" +
                "      \"quantity\": 1,\n" +
                "      \"price\": 35.00,\n" +
                "      \"note\": \"order note\",\n" +
                "      \"orderProductOptionRequests\": [\n" +
                "         {\n" +
                "            \"optionId\": 251,\n" +
                "            \"price\": 0\n" +
                "         }\n" +
                "        ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        RestAssured.baseURI = "https://customer-qa.tkyr.net";
        given().auth().oauth2(postVerifyOTP.token)
                .contentType("application/json")
                .body(jsonBody).log().all()
                .post("/api/Order/AddOrder")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

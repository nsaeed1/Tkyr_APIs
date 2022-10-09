package V1.address;

import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PutAddress {
    PostVerifyOTP postVerifyOTP;
    @Test
    public void validateResponseCode(){
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        String jsonBody = "{\n" +
                "  \"latitude\": 24.757869,\n" +
                "  \"longitude\": 46.666060,\n" +
                "  \"name\": \"API Automation PUT2\",\n" +
                "  \"isDefault\": true,\n" +
                "  \"districtName\": \"Al Mather Al shamali\",\n" +
                "  \"cityName\": \"Riyadh\",\n" +
                "  \"street\": \"Al mather street\",\n" +
                "  \"details\": \"ea culpa incididunt consequat dolor\",\n" +
                "  \"houseNumber\": \"12\",\n" +
                "  \"isVisible\": false,\n" +
                "  \"id\": 4638\n" +
                "}";

        RestAssured.baseURI = "https://customer-qa.tkyr.net/api/Address?api-version=veniamirure";
        given().auth().oauth2(postVerifyOTP.token)
                .contentType("application/json")
                .body(jsonBody).log().all()
                .put()
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

}

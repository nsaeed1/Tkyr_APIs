package V1.address;
import V1.authorization.PostVerifyOTP;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PostAddress {
    PostVerifyOTP postVerifyOTP;
    @Test
    public void validateResponseCode(){
        postVerifyOTP = new PostVerifyOTP();
        postVerifyOTP.postVerifyOTPEn();

        String jsonBody= "{\n" +
                "  \"latitude\": 24.7555872982218\t,\n" +
                "  \"longitude\": 46.66732830461115,\n" +
                "  \"name\": \"Automation API\",\n" +
                "  \"isDefault\": false,\n" +
                "  \"districtName\": \"Al M\",\n" +
                "  \"cityName\": \"Riyadh\",\n" +
                "  \"street\": \"officia sed consectetur tempor\",\n" +
                "  \"details\": \"cillum Duis ex ad sed\",\n" +
                "  \"houseNumber\": \"1234\",\n" +
                "  \"isVisible\": true\n" +
                "}";

        RestAssured.baseURI = "https://customer-qa.tkyr.net/api/Address?api-version=veniamirure";
        given().auth().oauth2(postVerifyOTP.token)
                .contentType("application/json")
                .body(jsonBody).log().all()
                .post()
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }
}

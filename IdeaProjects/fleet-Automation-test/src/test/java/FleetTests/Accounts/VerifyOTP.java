package FleetTests.Accounts;

import FunctionTestModels.Accounts.OtpLogin;
import Utilities.Constants;
import Utilities.HttpsUtils;
import Utilities.TestHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Utilities.FileUtils.FilePathCSV;
import static io.restassured.RestAssured.given;

public class VerifyOTP {






   // @Test
    public static void verifyotp() {
        //"/accounts/login/"

        OtpLogin OL = new OtpLogin();
        OL.setMobile("6361859543");
        OL.setOtp("134680");
        RestAssured.baseURI = Constants.AveeshaFleetBaseURL;
        System.out.println(RestAssured.baseURI);

        Response response= given().

                header("X-App-Version", "29").
                header("ContentType", "application/json").

                body(OL).contentType(ContentType.JSON)

                .when().post("/accounts/verify/");

        response.then().log().all();

    }

    //***********************************************************************************************************************

    @DataProvider(name = "OTPLogin")
    public Object[][] OTPLogin() {
        return TestHelper.getDataForDataProvider(FilePathCSV, OtpLogin.class);
    }


//
    //@Test(dataProvider = "OTPLogin")
    @Test
    public static void verify_otp() {
        //"/accounts/login/"

        OtpLogin OL = new OtpLogin();
        OL.setMobile("6361859543");
        OL.setOtp("134680");
        RestAssured.baseURI = Constants.AveeshaFleetBaseURL;
        System.out.println(RestAssured.baseURI);

        HttpsUtils HU = new HttpsUtils();
        Response response = given().
                headers(HU.constantHeaders()).
                body(OL).contentType(ContentType.JSON)
                .when().post("/accounts/verify/");
        ResponseBody body = response.getBody();

        // To check for sub string presence get the Response body as a String.
        // Do a String.contains
        String responseBody = body.asString();
        System.out.println(responseBody);

        //HU.ParseJSON(Response,"access_token");

    }
}
package FleetTests.Accounts;

import FunctionTestModels.Accounts.OtpLogin;
import Utilities.Constants;
import Utilities.HttpsUtils;
import Utilities.TestHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class VerifyOTP {


    public static String AccessToken;
    // public static final String Access_token = "40516d19401336f8efd574405fe8953629d6f3fd";

    @DataProvider(name = "dataForVerifyPass")
    public Object[][] dataForVerifyPass()
    {
        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/verfiy_otp_pass.csv", OtpLogin.class);
    }



    @Test(dataProvider = "dataForVerifyPass")
    public static void verify_otp_pass(String  VerifyOTPRequestBody) {




        System.out.println("Control in VerifyOtp");
        RestAssured.baseURI= Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
       // System.out.println(VerifyOTPRequestBody);


        Response response = given().
                headers(new HttpsUtils().constantHeaders()).body(VerifyOTPRequestBody).
                when().post("/accounts/verify/");
        response.then().log().all();
        int actual_status_code=response.getStatusCode();
        Assert.assertEquals(actual_status_code, Constants.successcode);




        String responseBody = response.asString();
       System.out.println(responseBody);

//       String responseBody = null;
         //Access_token= HttpsUtils.ParseJSON(responseBody,"access_token");
 // System.setProperty("Token",Access_token);
 // System.out.println(Access_token);
//        String responseBody = response.asString();
//        System.out.println(responseBody);

        AccessToken= HttpsUtils.ParseJSON(responseBody,"access_token");
        //System.setProperty("StartAssetTrackId",AssetTrackId);
        System.out.println(AccessToken);
        Assert.assertEquals(response.getStatusCode(), Constants.successcode);

    }


      @DataProvider(name = "dataForVerifyFail")
    public Object[][] dataForVerifyFailmethod()
    {
       return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/verfiy_otp_fail.csv", OtpLogin.class);

    }


    //
    //@Test(dataProvider = "OTPLogin")
    @Test(dataProvider = "dataForVerifyFail")
    public static void verify_otp_fail(String  VerifyOTPRequestBody) {
        //"/accounts/login/"



        System.out.println("Control in VerifyOtp");
        RestAssured.baseURI= Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
       // System.out.println(VerifyOTPRequestBody);


        Response response = given().
                headers(new HttpsUtils().constantHeaders()).body(VerifyOTPRequestBody).
                when().post("/accounts/verify/");
        response.then();



        int actual_status_code=response.getStatusCode();
        Assert.assertEquals(actual_status_code, Constants.failurecode_appCheck);




    }
}
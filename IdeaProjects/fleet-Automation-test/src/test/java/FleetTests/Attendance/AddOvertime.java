package FleetTests.Attendance;


import FleetTests.Accounts.VerifyOTP;
import FunctionTestModels.Attendance.AddOvertimePojo;
import Utilities.Constants;
import Utilities.HttpsUtils;
import Utilities.TestHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddOvertime {


    public static String AccessToken;
    // public static final String Access_token = "40516d19401336f8efd574405fe8953629d6f3fd";

    @DataProvider(name = "AddOvertime")
    public Object[][] AddOvertimemethod() {
        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AddOvertime.csv", AddOvertimePojo.class);
    }


    @Test(dataProvider = "AddOvertime")
    public static void verifAddOvertime(String VerifyAddOvertimeBody) {


        System.out.println("Control in AddOvertime");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println(VerifyOTPRequestBody);


        //Response response = given().
          //      headers(new HttpsUtils().constantHeaders()).body(VerifyAddOvertimeBody).

                HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).body(VerifyAddOvertimeBody).

                when().post("/attendance/punch-in/");
        response.then().log().all();
        int actual_status_code = response.getStatusCode();
        Assert.assertEquals(actual_status_code, Constants.successcode);


        String responseBody = response.asString();
        System.out.println(responseBody);

//       String responseBody = null;
        //Access_token= HttpsUtils.ParseJSON(responseBody,"access_token");
        // System.setProperty("Token",Access_token);
        // System.out.println(Access_token);
//        String responseBody = response.asString();
//        System.out.println(responseBody);

        //AccessToken = HttpsUtils.ParseJSON(responseBody, "access_token");
        //System.setProperty("StartAssetTrackId",AssetTrackId);
       // System.out.println(AccessToken);
        Assert.assertEquals(response.getStatusCode(), Constants.successcode);

    }
    @DataProvider(name = "AddIncorrectOvertime")
    public Object[][] AddIncorrectOvertimemethod() {
        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/IncorrectAddOvertime.csv", AddOvertimePojo.class);
    }


    //@Test(dataProvider = "AddIncorrectOvertime")
    public static void verifyIncorrectAddOvertime(String VerifyInAddOvertimeBody) {


        System.out.println("Control in PunchIn");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println(VerifyOTPRequestBody);


        Response response = given().
                headers(new HttpsUtils().constantHeaders()).body(VerifyInAddOvertimeBody).
                when().post("/api/v1/attendance/punch-in/");
        response.then();
        int actual_status_code = response.getStatusCode();
        Assert.assertEquals(actual_status_code, Constants.failurecode);


        String responseBody = response.asString();
        System.out.println(responseBody);

//       String responseBody = null;
        //Access_token= HttpsUtils.ParseJSON(responseBody,"access_token");
        // System.setProperty("Token",Access_token);
        // System.out.println(Access_token);
//        String responseBody = response.asString();
//        System.out.println(responseBody);

        //AccessToken = HttpsUtils.ParseJSON(responseBody, "access_token");
        //System.setProperty("StartAssetTrackId",AssetTrackId);
        //System.out.println(AccessToken);
        Assert.assertEquals(response.getStatusCode(), Constants.failurecode);

    }
}

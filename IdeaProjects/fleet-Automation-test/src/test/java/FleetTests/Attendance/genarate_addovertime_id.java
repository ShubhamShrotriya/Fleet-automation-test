/*


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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class genarate_addovertime_id<AddOvertime_Id> {


    public static String AccessToken;
    public static String AddOvertime_Id ;
    // public static final String Access_token = "40516d19401336f8efd574405fe8953629d6f3fd";


    static Properties prop = new Properties();

//
//    public genarate_addovertime_id() throws FileNotFoundException {
//    }

    @DataProvider(name = "AddOvertime")
    public Object[][] AddOvertimemethod() {

        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AddOvertime.csv", AddOvertimePojo.class);
    }


    @Test(dataProvider = "AddOvertime")
    public static void verifyAddOvertime(String VerifyAddOvertimeBody) throws IOException {


        System.out.println("Control in AddOvertime for generation of overtime id 1st ");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println(VerifyOTPRequestBody);


        //Response response = given().
        //      headers(new HttpsUtils().constantHeaders()).body(VerifyAddOvertimeBody).

        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token " + VerifyOTP.AccessToken)).body(VerifyAddOvertimeBody).

                when().post("/attendance/overtime/");
        response.then();
        int actual_status_code = response.getStatusCode();
       // Assert.assertEquals(actual_status_code, Constants.successcode);


        String responseBody = response.asString();
        System.out.println(responseBody);

        AddOvertime_Id = HttpsUtils.ParseJSON(responseBody, "id");
        //System.setProperty("StartAssetTrackId",AssetTrackId);
        System.out.println(" Before setting up the property"+ AddOvertime_Id);


        FileInputStream file = new FileInputStream("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/variable_required.properties ");
        prop.load(file);
        prop.setProperty("overtimeId",AddOvertime_Id);

        System.out.println(prop.getProperty("overtimeId"));
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
}
    /*


    @DataProvider(name = "AddOvertimeAgainMethod")
    public Object[][] AddOvertimeAgainMethod() {
        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AddOvertime.csv", AddOvertimePojo.class);
    }


  //  @Test(dataProvider = "AddOvertimeAgainMethod",priority=2)
    public static void verifyIncorrectAddOvertime(String VerifyInAddOvertimeBody) {


        System.out.println("Control in add overtime same overtime request again gives 400");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println(VerifyOTPRequestBody);

    HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).body(VerifyInAddOvertimeBody).
                when().post("/attendance/overtime/");
        response.then();
        int actual_status_code = response.getStatusCode();

        String responseBody = response.asString();
        AddOvertime_Id= HttpsUtils.ParseJSON(responseBody,"id");
        //System.setProperty("StartAssetTrackId",AssetTrackId);
        System.out.println(AddOvertime_Id);


        Assert.assertEquals(actual_status_code, Constants.failurecode);



        //System.out.println(responseBody);

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


    @DataProvider(name = "RejectAddOvertime")
    public Object[][] RejectAddOvertimemethod() throws Exception {
        ACSVwriting.AddOvertimeDataReject("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/RejectAddOvertime.csv",AddOvertime_Id);

        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/RejectAddOvertime.csv", RejectOvertimePojo.class);
    }


    @Test(dataProvider = "RejectAddOvertime",priority=3)
    public static void rejectAddOvertime(String VerifyRejectAddOvertimeBody) {


        System.out.println("Control in reject AddOvertime request ");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println(VerifyOTPRequestBody);


        //Response response = given().
        //      headers(new HttpsUtils().constantHeaders()).body(VerifyAddOvertimeBody).

        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).body(VerifyRejectAddOvertimeBody).

                when().put("/attendance/overtime/");
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

    @DataProvider(name = "AddOvertimePostReject")
    public Object[][] AddOvertimePostrejectmethod() {
        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AddOvertime.csv", AddOvertimePojo.class);
    }


    @Test(dataProvider = "AddOvertimePostReject",priority=4)
    public static void RequestAddOvertimeAgain(String VerifyAddOvertimePostRejectBody) {


        System.out.println("Control in AddOvertime again post reject");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println(VerifyOTPRequestBody);


        //Response response = given().
        //      headers(new HttpsUtils().constantHeaders()).body(VerifyAddOvertimeBody).

        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).body(VerifyAddOvertimePostRejectBody).

                when().post("/attendance/overtime/");
        response.then().log().all();
        int actual_status_code = response.getStatusCode();
        Assert.assertEquals(actual_status_code, Constants.successcode);


        String responseBody = response.asString();
        System.out.println(responseBody);

        AddOvertime_Id= HttpsUtils.ParseJSON(responseBody,"id");
        //System.setProperty("StartAssetTrackId",AssetTrackId);
        System.out.println(AddOvertime_Id);

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

    @DataProvider(name = "AddOverChangeHourApproveOvertimetime")
    public Object[][] ChangeHourApproveOvertimeMethod() throws Exception {


        //String AddOvertime_Id_Reject= VehicleRegNumber.getkmreading();
        //System.out.println("AddOvertime_Id_Reject="+AddOvertime_Id_Reject);
        ACSVwriting.AddOvertimeChangeHourApprove("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/ChangeHourAddOvertime.csv",AddOvertime_Id);

        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/ChangeHourAddOvertime.csv", ChangeHousrAddOvertimePojo.class);
    }


    @Test(dataProvider = "AddOverChangeHourApproveOvertimetime",priority=5)
    public static void ChangeHourApproveOvertimeMethod(String AddOverChangeHourApproveOvertimetimeBody) {


        System.out.println("Control in change hour and approve AddOvertime");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println(VerifyOTPRequestBody);


        //Response response = given().
        //      headers(new HttpsUtils().constantHeaders()).body(VerifyAddOvertimeBody).

        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).body(AddOverChangeHourApproveOvertimetimeBody).

                when().put("/attendance/overtime/");
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



    @DataProvider(name = "ApproveOvertime")
    public Object[][] ApproveOvertimeMethod() {
        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/ApproveAddOvertime.csv", ApproveAddOvertimePojo.class);
    }


    @Test(dataProvider = "ApproveOvertime",priority=6)
    public static void VerifyApproveOvertime(String ApproveOvertimeBody) {


        System.out.println("Control in add overtime simple approve and no hour change gives 400 I hope");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println(VerifyOTPRequestBody);


        Response response = given().
                headers(new HttpsUtils().constantHeaders()).body(ApproveOvertimeBody).
                when().put("/api/v1/attendance/punch-in/");
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


     */
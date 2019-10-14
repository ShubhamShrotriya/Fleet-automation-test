package FleetTests.Attendance;


import FleetTests.Accounts.VerifyOTP;
import FleetTests.AssetTrack.ACSVwriting;
import FunctionTestModels.Attendance.AddOvertimePojo;
import FunctionTestModels.Attendance.ApproveAddOvertimePojo;
import FunctionTestModels.Attendance.ChangeHousrAddOvertimePojo;
import FunctionTestModels.Attendance.RejectOvertimePojo;
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

public class AddOvertime {

     Properties prop = new Properties();

    public static String AccessToken;
    public static String OvertimeId;
    public static String AddOvertime_Id;
    public static String AddOvertime_IdPostRejct;

    @DataProvider(name = "AddOvertime")
    public Object[][] AddOvertimemethod() {

        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AddOvertime.csv", AddOvertimePojo.class);
    }


    @Test(dataProvider = "AddOvertime",priority=1)
    public void verifyAddOvertime(String VerifyAddOvertimeBody) throws IOException {


       System.out.println("Control in AddOvertime");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);

                HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).body(VerifyAddOvertimeBody).

                when().post("/attendance/overtime/");
        response.then().log().all();
        int actual_status_code = response.getStatusCode();
        Assert.assertEquals(actual_status_code, Constants.successcode);


        String responseBody = response.asString();
        System.out.println(responseBody);



        AddOvertime_Id = HttpsUtils.ParseJSON(responseBody, "id");
           System.out.println(" Before setting up the property"+ AddOvertime_Id);


        FileInputStream file = new FileInputStream("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/variable_required.properties");
        prop.load(file);

        prop.setProperty("overtimeId",AddOvertime_Id);
System.out.println( "overtimeId is set" );


        System.out.println("My Set " +prop.getProperty("overtimeId"));
        System.out.println(" Pre Existing "+ prop.getProperty("overtime_id"));
        Assert.assertEquals(response.getStatusCode(), Constants.successcode);

    }

    @DataProvider(name = "AddOvertimeAgainMethod")
    public Object[][] AddOvertimeAgainMethod() {
        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AddOvertime.csv", AddOvertimePojo.class);
    }


    @Test(dataProvider = "AddOvertimeAgainMethod",priority=2)
    public static void verifyIncorrectAddOvertime(String VerifyInAddOvertimeBody) {


        System.out.println("Control in add overtime same overtime request again gives 400 2nd ");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);

    HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).body(VerifyInAddOvertimeBody).
                when().post("/attendance/overtime/");
        response.then();
        int actual_status_code = response.getStatusCode();



        Assert.assertEquals(response.getStatusCode(), Constants.failurecode_unsupported_media);

        //Assert.assertEquals(response.getStatusCode(), Constants.failurecode);
    }


    @DataProvider(name = "RejectAddOvertime")
    public Object[][] RejectAddOvertimemethod() throws Exception {

        OvertimeId= AddOvertime_Id;
        ACSVwriting.AddOvertimeDataReject("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/RejectAddOvertime.csv",OvertimeId);

        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/RejectAddOvertime.csv",RejectOvertimePojo.class);
    }


    @Test(dataProvider = "RejectAddOvertime",priority=3)
    public static void rejectAddOvertime(String VerifyRejectAddOvertimeBody) {


        System.out.println("Control in reject AddOvertime request 3rd ");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).body(VerifyRejectAddOvertimeBody).

                when().put("/attendance/overtime/");
        response.then().log().all();
        int actual_status_code = response.getStatusCode();



        String responseBody = response.asString();
        System.out.println(responseBody);


        Assert.assertEquals(response.getStatusCode(), Constants.successcode);

    }

    @DataProvider(name = "AddOvertimePostReject")
    public Object[][] AddOvertimePostrejectmethod() {

        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AddOvertime.csv", AddOvertimePojo.class);
    }


   @Test(dataProvider = "AddOvertimePostReject", priority=4)
    public void RequestAddOvertimeAgain(String VerifyAddOvertimePostRejectBody) throws IOException {


        System.out.println("Control in AddOvertime again post reject 4rth ");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);

        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).body(VerifyAddOvertimePostRejectBody).

                when().post("/attendance/overtime/");
        response.then();
        int actual_status_code = response.getStatusCode();



        String responseBody = response.asString();


       AddOvertime_IdPostRejct = HttpsUtils.ParseJSON(responseBody, "id");
        System.out.println(" New Overtime Id post reject"+ AddOvertime_IdPostRejct);


       FileInputStream file = new FileInputStream("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/variable_required.properties");
       prop.load(file);
       prop.setProperty("overtimeId",AddOvertime_IdPostRejct);



       System.out.println(prop.getProperty("overtimeId"));
       Assert.assertEquals(response.getStatusCode(), Constants.successcode);




        Assert.assertEquals(actual_status_code, Constants.successcode);


        System.out.println(responseBody);

        Assert.assertEquals(response.getStatusCode(), Constants.successcode);

    }

    @DataProvider(name = "AddOverChangeHourApproveOvertimetime")
    public Object[][] ChangeHourApproveOvertimeMethod() throws Exception {


        OvertimeId= AddOvertime_IdPostRejct;
        ACSVwriting.AddOvertimeChangeHourApprove("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/ChangeHourAddOvertime.csv",OvertimeId);

        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/ChangeHourAddOvertime.csv", ChangeHousrAddOvertimePojo.class);
    }


    @Test(dataProvider = "AddOverChangeHourApproveOvertimetime",priority=5)
    public static void ChangeHourApproveOvertimeMethod(String AddOverChangeHourApproveOvertimetimeBody) {


        System.out.println("Control in change hour and approve AddOvertime  5th ");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).body(AddOverChangeHourApproveOvertimetimeBody).

                when().put("/attendance/overtime/");
        response.then().log().all();
        int actual_status_code = response.getStatusCode();
        Assert.assertEquals(actual_status_code, Constants.successcode);


        String responseBody = response.asString();
        System.out.println(responseBody);

        Assert.assertEquals(response.getStatusCode(), Constants.successcode);

    }



    @DataProvider(name = "ApproveOvertime")
    public Object[][] ApproveOvertimeMethod() throws Exception {
        OvertimeId= AddOvertime_IdPostRejct;
        ACSVwriting.AddOvertimeApprove("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/ApproveAddOvertime.csv",OvertimeId);

        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/ApproveAddOvertime.csv", ApproveAddOvertimePojo.class);
    }


    @Test(dataProvider = "ApproveOvertime",priority=6)
    public static void VerifyApproveOvertime(String ApproveOvertimeBody) {


        System.out.println("Control in add overtime simple approve and no hour change gives 400 6th ");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);

        HttpsUtils HU = new HttpsUtils();

        Response response = given().headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).body(ApproveOvertimeBody).
                when().post("/attendance/overtime/");
        response.then();
        int actual_status_code = response.getStatusCode();


        String responseBody = response.asString();
        System.out.println(responseBody);

        Assert.assertEquals(response.getStatusCode(), Constants.failurecode_unsupported_media);

    }
}

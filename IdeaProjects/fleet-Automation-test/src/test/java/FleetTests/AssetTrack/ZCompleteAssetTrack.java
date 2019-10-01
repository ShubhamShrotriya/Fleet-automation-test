package FleetTests.AssetTrack;

import FleetTests.Accounts.VerifyOTP;
import FunctionTestModels.AssetTracking.CompleteAssetTrackPojo;
import Utilities.Constants;
import Utilities.HttpsUtils;
import Utilities.TestHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ZCompleteAssetTrack {


    @DataProvider(name = "CompleteAssetTrack")
    public Object[][] CompleteAssetTrack() throws Exception {
        System.out.println(" data provider control in complete asset track");
    if(VehicleRegNumber.getkmreading()!=null){


            String Vehiclekmreading=VehicleRegNumber.getkmreading();
                 System.out.println("Km reading="+Vehiclekmreading);
            System.out.println("start writing in complete CSV)");
             //ACSVwriting.writeDataLineByLineForStartingAT("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AssetTrackId.csv",qr_identifier);
            ACSVwriting.writeDataLineByLineForCompletingAT("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/CompleteAssetTrackId.csv",Vehiclekmreading);
            System.out.println("End writing in complete CSV)");
            // return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/CompleteAssetTrackBody.csv", CompleteAssetTrackPojo.class);
            return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/CompleteAssetTrackId.csv", CompleteAssetTrackPojo.class);



        }else{
            System.out.println("Vehicle QR is null");
            return null;
        }


  //      ******************************************************
    }


    @Test(dataProvider = "CompleteAssetTrack")
    public static void CompleteAssetTracknormal(String CompleteAssetTrackBody) throws Exception {
        //"/accounts/login/"

        System.out.println("Control in Complete  Asset Track normal one");
        RestAssured.baseURI= Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        System.out.println(CompleteAssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        ////just commenedted this below
        //String AssetTrackId=System.getProperty("AssetTrackId");

        Response response = given().
                // headers(new HttpsUtils().constantHeaders()).body(AssetTrackBody).
                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).
                        body(CompleteAssetTrackBody ).contentType(ContentType.JSON).

                        when().post("/asset/" + AssetTrackForId.AssetTrackId  + "/complete/");
        response.then();
        int actual_status_code=response.getStatusCode();
        System.out.println(actual_status_code +" " + " " +  Constants.successcode);
        System.out.println(" this is the line in normal asset track please check");
        VehicleRegNumber.GetInventoryAtStation();

        Assert.assertEquals(actual_status_code, Constants.successcode);
        // Assert.assertEquals(response.toString(), "OTP sent");
    }










    @DataProvider(name = "InCompleteAssetTrack")
    public Object[][] InCompleteAssetTrackMethod() throws Exception {
        System.out.println(" data provider control in complete asset track");
        if(VehicleRegNumber.getkmreading()!=null){


            String Vehiclekmreading=VehicleRegNumber.getkmreading();
            System.out.println("Km reading="+Vehiclekmreading);
            System.out.println("start writing in complete CSV for Incorrect AT)");
            //ACSVwriting.writeDataLineByLineForStartingAT("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AssetTrackId.csv",qr_identifier);
            ACSVwriting.writeDataLineByLineForInCompletingAT("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/InCompleteAssetTrackId.csv",Vehiclekmreading);
            System.out.println("End writing in complete CSV for incorrect AT )");
            // return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/CompleteAssetTrackBody.csv", CompleteAssetTrackPojo.class);
            return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/InCompleteAssetTrackId.csv", CompleteAssetTrackPojo.class);



        }else{
            System.out.println("Vehicle QR is null");
            return null;
        }


        //      ******************************************************
    }


    @Test(dataProvider = "InCompleteAssetTrack")
    public static void InCompleteAssetTrackWrongKMreading(String CompleteAssetTrackBody) throws Exception {
        //"/accounts/login/"

        System.out.println("Control in InComplete  Asset Track 400 bad data");
        RestAssured.baseURI= Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        System.out.println(CompleteAssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        String AssetTrackId=System.getProperty("AssetTrackId");

        Response response = given().
                // headers(new HttpsUtils().constantHeaders()).body(AssetTrackBody).
                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).
                        body(CompleteAssetTrackBody ).contentType(ContentType.JSON).

                        when().post("/asset/" + AssetTrackForId.AssetTrackId  + "/complete/");
        response.then();
        int actual_status_code=response.getStatusCode();
        System.out.println(actual_status_code +" " + " " +  Constants.failurecode);
        VehicleRegNumber.GetInventoryAtStation();

        Assert.assertEquals(actual_status_code, Constants.failurecode);
        // Assert.assertEquals(response.toString(), "OTP sent");
    }


    @Test//(dataProvider = "CompleteAssetTrack")
    public static void CompleteAssetTrackUM() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/UMjson.json");

            //Read JSON file
          JSONObject obj = (JSONObject)jsonParser.parse(reader);

            //JSONArray vehicleUM = (JSONArray) obj;
            System.out.println(obj.toString());


        System.out.println("Control in complete Asset Track Under Maintenance");
        RestAssured.baseURI= Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
       // System.out.println(CompleteAssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        //String AssetTrackId=System.getProperty("AssetTrackId");

        Response response = given().

                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).
                        body(obj.toString()).contentType(ContentType.JSON).

                        when().post("asset/" + AssetTrackForId.AssetTrackId  + "/complete/");
        response.then();
        int actual_status_code=response.getStatusCode();
        System.out.println(actual_status_code +" " + " " +  Constants.successcode);
        Assert.assertEquals(actual_status_code, Constants.successcode);






    }


}

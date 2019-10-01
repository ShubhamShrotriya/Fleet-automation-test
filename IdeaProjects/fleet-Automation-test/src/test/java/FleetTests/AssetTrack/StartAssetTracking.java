package FleetTests.AssetTrack;

import FleetTests.Accounts.VerifyOTP;
import FunctionTestModels.AssetTracking.AssetTrackForIdPojo;
import Utilities.Constants;
import Utilities.HttpsUtils;
import Utilities.TestHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StartAssetTracking {



    @DataProvider(name = "StartAssetTrack")
    public Object[][] StartAssetTrack() throws Exception {
     if(VehicleRegNumber.GetInventoryAtStation()!=null){


            String qr_identifier=VehicleRegNumber.GetInventoryAtStation();
            //VehicleRegNumber.GetInventoryAtStation();
            System.out.println("qr_identifier="+qr_identifier);
            System.out.println("start writing in CSV)");
            // ACSVwriting.writeDataLineByLineForStartingAT("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AssetTrackId.csv", VehicleRegNumber.qr_identifier);
            ACSVwriting.writeDataLineByLineForStartingAT("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AssetTrackId.csv",qr_identifier);
            System.out.println("End writing in CSV)");
            return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AssetTrackBody.csv", AssetTrackForIdPojo.class);



        }else{
            System.out.println("Vehicle QR is null");
            return null;
        }
    }




    @Test(dataProvider = "StartAssetTrack")
    public static void StartAssetTrack(String StartAssetTrackBody)
    {
        //"/accounts/login/"

        System.out.println("Control in Start Asset Track");
        System.out.println(AssetTrackForId.AssetTrackId);
        RestAssured.baseURI= Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        System.out.println(StartAssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).
                        body(StartAssetTrackBody ).contentType(ContentType.JSON).

                        when().post("/asset/" + AssetTrackForId.AssetTrackId + "/start/");
        response.then();
        int actual_status_code=response.getStatusCode();
        System.out.println(actual_status_code +" " + " " +  Constants.successcode);
        Assert.assertEquals(actual_status_code, Constants.successcode);

    }






}

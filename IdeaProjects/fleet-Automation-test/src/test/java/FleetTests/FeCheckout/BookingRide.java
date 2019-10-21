package FleetTests.FeCheckout;

import FleetTests.Accounts.VerifyOTP;
import FleetTests.AssetTrack.ACSVwriting;
import FleetTests.AssetTrack.AssetTrackForId;
import FleetTests.AssetTrack.VehicleRegNumber;
import FunctionTestModels.AssetTracking.CompleteAssetTrackPojo;
import Utilities.Constants;
import Utilities.HttpsUtils;
import Utilities.TestHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.given;

public class BookingRide {



    @DataProvider(name = "bookingRidedata")
    public Object[][] CompleteAssetTrack() throws Exception {
        System.out.println(" data provider control in complete asset track");
        if(VehicleRegNumber.getkmreading()!=null){


            String Vehiclekmreading=VehicleRegNumber.getkmreading();
            System.out.println("Km reading="+Vehiclekmreading);
            System.out.println("start writing in complete CSV)");
            ACSVwriting.writeDataLineByLineForCompletingAT("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/CompleteAssetTrackId.csv",Vehiclekmreading);
            System.out.println("End writing in complete CSV)");
            return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/CompleteAssetTrackId.csv", CompleteAssetTrackPojo.class);



        }else{
            System.out.println("Vehicle QR is null");
            return null;
        }


        //      ******************************************************
    }


    ////////////////////////@Test(dataProvider = "CompleteAssetTrack")
    public static void BookingRide(String CompleteAssetTrackBody) throws Exception {

        System.out.println("Control in Complete  Asset Track normal one");
        RestAssured.baseURI= Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        System.out.println(CompleteAssetTrackBody);
        HttpsUtils HU = new HttpsUtils();


        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).
                body(CompleteAssetTrackBody ).contentType(ContentType.JSON).

                when().post("/asset/" + AssetTrackForId.AssetTrackId  + "/complete/");
        response.then().log().all();
        int actual_status_code=response.getStatusCode();
        System.out.println(actual_status_code +" " + " " +  Constants.successcode);
        System.out.println(" this is the line in normal asset track please check");

        Assert.assertEquals(actual_status_code, Constants.successcode);
    }




}

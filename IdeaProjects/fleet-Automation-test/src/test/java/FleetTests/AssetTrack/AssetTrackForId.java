
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

public class AssetTrackForId{

    public static String AssetTrackId;


    @DataProvider(name = "trackingid")
    public static Object[][] trackingidmethod() throws Exception {

        if(VehicleRegNumber.GetInventoryAtStation()!=null){


            String qr_identifier=VehicleRegNumber.GetInventoryAtStation();

            System.out.println("qr_identifier="+qr_identifier);
            System.out.println("start writing in CSV)");

            ACSVwriting.writeDataLineByLineForStartingAT("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AssetTrackId.csv",qr_identifier);
            System.out.println("End writing in CSV)");
            return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AssetTrackId.csv", AssetTrackForIdPojo.class);




        }else{
            System.out.println("VEHICLE QR IS NULL , WE ARE NOT FINDING THE REQUIRED VEHICLE AS THERE IS NO VEHICLE IN IOT FLASE & AVAILABLE FOR BOOKING STATUS");
            return null;
        }

    }




    @Test(dataProvider = "trackingid")
    public static void ATtrackingidmethod(String AssetTrackBody) throws Exception {


        System.out.println("Control in AssetTrackForId");
        RestAssured.baseURI= Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);

        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                       headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).
                body(AssetTrackBody).contentType(ContentType.JSON).

        when().post("/asset/");
        response.then();

        int actual_status_code=response.getStatusCode();
        System.out.println(actual_status_code +" " + " " +  Constants.successcode);


        String responseBody = response.asString();
        System.out.println(responseBody);

        AssetTrackId= HttpsUtils.ParseJSON(responseBody,"id");

        System.out.println(AssetTrackId);

        Assert.assertEquals(actual_status_code, Constants.successcode);



    }






}

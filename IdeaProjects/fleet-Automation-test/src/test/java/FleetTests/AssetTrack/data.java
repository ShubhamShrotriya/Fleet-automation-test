package FleetTests.AssetTrack;

import FleetTests.Accounts.VerifyOTP;
import Utilities.Constants;
import Utilities.HttpsUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class data {


    private static String Vehicles_status;

    public static String getvehiclestatus() throws Exception {
        //"/accounts/login/"

        System.out.println("Control in GetvehicleStatus");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token " + VerifyOTP.AccessToken)).
                        contentType(ContentType.JSON).

                        when().get("vehicles/current-status/?registration_number=" + VehicleRegNumber.GetInventoryAtStation());
        response.then();

        JSONParser parser = new JSONParser();
        JSONObject VehicleDetails = (JSONObject) parser.parse(response.getBody().asString());


        boolean status = (boolean) VehicleDetails.get("is_iot_enabled");

        Vehicles_status= (String) VehicleDetails.get("status");

        int actual_status_code = response.getStatusCode();
        System.out.println(actual_status_code + " " + " " + Constants.successcode);
        Assert.assertEquals(actual_status_code, Constants.successcode);

        String responseBody = response.asString();



        return Vehicles_status;
    }
}

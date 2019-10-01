package FleetTests.AssetTrack;

import Utilities.Constants;
import Utilities.HttpsUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Vehicle_details {

    private static String Vehicles_status;

    static String km_reading;
    static String VehiclesStatus;
    static String helmet_count;
    static String qr_identifier;
    static String registration_number;
    static String fuel_level;


    public static String getvehiclestatus(String vehicle_reg_number) throws Exception {

        System.out.println("Control in GetvehicleStatus");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println("AssetTrackBody" + AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token 40516d19401336f8efd574405fe8953629d6f3fd")).
                        contentType(ContentType.JSON).

                        when().get("vehicles/current-status/?registration_number=" + vehicle_reg_number);
        response.then();

        JSONParser parser = new JSONParser();
        JSONObject VehicleDetails = (JSONObject) parser.parse(response.getBody().asString());



        boolean status = (boolean) VehicleDetails.get("is_iot_enabled");

        Vehicles_status= (String) VehicleDetails.get("status");




        int actual_status_code = response.getStatusCode();
        System.out.println(actual_status_code + " " + " " + Constants.successcode);
        Assert.assertEquals(actual_status_code, Constants.successcode);

        String responseBody = response.asString();

        return (Vehicles_status);

    }




   // @Test
    public static void getvehiclestatuswithdetails() throws Exception {
        //"/accounts/login/"

        String Vehicletogetdetailsfor = getvehiclebasedonstatus.GetVehiclesBasedOnStatus();

        System.out.println("Control in GetvehicleStatus");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println("AssetTrackBody" + AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().

                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token 40516d19401336f8efd574405fe8953629d6f3fd")).
                        contentType(ContentType.JSON).

                        when().get("vehicles/current-status/?registration_number=" + Vehicletogetdetailsfor);;
        response.then();

        JSONParser parser = new JSONParser();
        JSONObject VehicleDetails = (JSONObject) parser.parse(response.getBody().asString());

        boolean status = (boolean) VehicleDetails.get("is_iot_enabled");
        qr_identifier = (String) VehicleDetails.get("qr_identifier");
        km_reading = String.valueOf(VehicleDetails.get("km_reading"));
        helmet_count= Constants.helmet_count;
        Vehicles_status= (String) VehicleDetails.get("status");
        registration_number= (String) VehicleDetails.get("registration_number");
        fuel_level = String.valueOf(VehicleDetails.get("fuel_level"));



        System.out.println(" is_iot_enabled status" +  " " +status);
        System.out.println("qr_identifier" + " "+ qr_identifier);
        System.out.println("km_reading"+ " " +km_reading);
        System.out.println("helmet_count" + " " +helmet_count);
        System.out.println("Vehicles_status"+ " " +Vehicles_status);
        System.out.println("fuel_level"+ " " +fuel_level);
        System.out.println("registration_number" + " " +registration_number);


        int actual_status_code = response.getStatusCode();
        System.out.println(actual_status_code + " " + " " + Constants.successcode);
        Assert.assertEquals(actual_status_code, Constants.successcode);

        String responseBody = response.asString();



    }


}

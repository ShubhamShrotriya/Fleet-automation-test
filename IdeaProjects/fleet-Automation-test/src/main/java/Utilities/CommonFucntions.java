package Utilities;/*

package Utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class CommonFucntions {

    private static String lat, lon, station_address, stationLat, stationLon, vehicle_reg_number;
    public static String station_name;
    private static long nearestStationId, txn_mode, payment_amount;
    private static double dist, kilometerDist, meterDist;
    private static String newNumber;
    final static String dir = System.getProperty("user.dir");

  /*
    // final static String intermediatePath = Constants.intermediatePath;
 

    //Get the vehicle available for booking

    public static String getVehicleAvailableForBooking(long nearestStationId) throws Exception {
        boolean vehicleFound = false;
        Response response = HttpUtils.callGetListOfVehicles(Constants.stageFleetBaseURL, nearestStationId);
        //response.then().log().all();
        JSONParser parser = new JSONParser();
        JSONArray vehiclesList = (JSONArray) parser.parse(response.getBody().asString());
        //pick a non-iot vehicle
        for (int i = 0; i < vehiclesList.size(); i++) {
            JSONObject vehicleObj = (JSONObject) vehiclesList.get(i);
            if (vehicleObj.get("is_iot_enabled").equals(true)) {
                System.out.println("This is IOT enabled vehicle");
                vehicleFound = false;
            } else {
                System.out.println("This is non-iot vehicle");
                vehicle_reg_number = (String) vehicleObj.get("registration_number");

                //Check the availability of the vehicle

                String vehicleStatus = HttpUtils.callGetCurrentStatusOfTheVehicle(Constants.stageFleetBaseURL, vehicle_reg_number);
                if (vehicleStatus.equals("AVAILABLE_FOR_BOOKING")) {
                    System.out.println(vehicle_reg_number);
                    vehicleFound = true;
                } else {
                    System.out.println("Vehicle " + vehicle_reg_number + " is : " + vehicleStatus);
                    vehicleFound = false;
                }
            }
            if (vehicleFound) {

                break;
            }
        }
        return vehicle_reg_number;
    }


 //

 // public static void main(String[] args) throws ParseException {
      GetInventoryAtStation();
      getvehiclestatus();


  }



//    public static void GetInventoryAtStation() throws ParseException {
        //"/accounts/login/"

        System.out.println("Control in AvailableIventoryAtStation");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
       // System.out.println("AssetTrackBody" + AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                // headers(new HttpsUtils().constantHeaders()).body(AssetTrackBody).
                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token " + System.getProperty("Token"))).contentType(ContentType.JSON).

                        when().post("stations/111/vehicles/");
        response.then().log().all();

        JSONParser parser = new JSONParser();
        JSONArray vehiclesList = (JSONArray) parser.parse(response.getBody().asString());
        //pick a non-iot vehicle
        for (int i = 0; i < vehiclesList.size(); i++) {
            JSONObject vehicleObj = (JSONObject) vehiclesList.get(i);
            if (vehicleObj.get("is_iot_enabled").equals(false)) {
                System.out.println("This is non IOT enabled vehicle");
                boolean vehicleFound = true;
            } else {
                System.out.println("This is iot vehicle");
            }
            vehicle_reg_number = (String) vehicleObj.get("registration_number");
            System.out.println(vehicle_reg_number);
            int actual_status_code = response.getStatusCode();
            System.out.println(actual_status_code + " " + " " + Constants.successcode);
            Assert.assertEquals(actual_status_code, Constants.successcode);

            String responseBody = response.asString();
            System.out.println(responseBody);


            //Check the availability of the vehicle


//       String responseBody = null;
//        AssetTrackId= HttpsUtils.ParseJSON(responseBody,"id");
//        System.setProperty("AssetTrackId",AssetTrackId);
//        System.out.println(AssetTrackId);


        }
    }

///vehicles/current-status/?registration_number=KA-05-AJ-1234

    public static void getvehiclestatus() throws ParseException {
        //"/accounts/login/"

        System.out.println("Control in GetvehicleStatus");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
       // System.out.println("AssetTrackBody" + AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                // headers(new HttpsUtils().constantHeaders()).body(AssetTrackBody).
                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token " + System.getProperty("Token"))).
                        contentType(ContentType.JSON).

                        when().post("vehicles/current-status/?registration_number=" + vehicle_reg_number);
        response.then().log().all();

        JSONParser parser = new JSONParser();
        JSONObject VehicleDetails = (JSONObject) parser.parse(response.getBody().asString());
        //pick a non-iot vehicle
        //for (int i = 0; i < VehicleDetails.size(); i++) {


        String status = (String) VehicleDetails.get("is_iot_enabled");
        String qr_identifier = (String) VehicleDetails.get("qr_identifier");
        String km_reading = (String) VehicleDetails.get("km_reading");
        String helemt_count= Constants.helmet_count;
        String Vehicles_status= (String) VehicleDetails.get("status");


//            if (vehicleObj.get("is_iot_enabled").equals(true)) {
//                System.out.println("This is non IOT enabled vehicle");
//                boolean vehicleFound = true;
//            } else {
//                System.out.println("This is iot vehicle");
//            }
//            vehicle_reg_number = (String) vehicleObj.get("registration_number");

        int actual_status_code = response.getStatusCode();
        System.out.println(actual_status_code + " " + " " + Constants.successcode);
        Assert.assertEquals(actual_status_code, Constants.successcode);

        String responseBody = response.asString();
        System.out.println(responseBody);


    }
}

*/

//package FleetTests.AssetTrack;

import FunctionTestModels.AssetTracking.AssetTrackForIdPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static io.restassured.RestAssured.given;

//import org.testng.Assert;

public  class CommonFucntions {

    private static String lat, lon, station_address, stationLat, stationLon, vehicle_reg_number;
    //@Test

    public static void main(String[] args) throws Exception {
        System.out.println("Hello");
        GetInventoryAtStation();
        getvehiclestatus();
        dynamicdata();


    }


    public static void GetInventoryAtStation() throws ParseException {
        //"/accounts/login/"

        System.out.println("Control in AvailableIventoryAtStation");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println("AssetTrackBody" + AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                // headers(new HttpsUtils().constantHeaders()).body(AssetTrackBody).
                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token " + System.getProperty("Token"))).contentType(ContentType.JSON).

                        when().get("stations/111/vehicles/");
        response.then();

        JSONParser parser = new JSONParser();
        JSONArray vehiclesList = (JSONArray) parser.parse(response.getBody().asString());
        //pick a non-iot vehicle
        for (int i = 0; i < vehiclesList.size(); i++) {
            JSONObject vehicleObj = (JSONObject) vehiclesList.get(i);
            if (vehicleObj.get("is_iot_enabled").equals(false)) {
                System.out.println("This is non IOT enabled vehicle");
                boolean vehicleFound = true;
                //} else {
                //  // System.out.println("This is iot vehicle");
                //}
                vehicle_reg_number = (String) vehicleObj.get("registration_number");
                System.out.println(vehicle_reg_number);
                break;
            }
        }
        int actual_status_code = response.getStatusCode();
        System.out.println(actual_status_code + " " + " " + Constants.successcode);
        //  Assert.assertEquals(actual_status_code, Constants.successcode);

        String responseBody = response.asString();
        //System.out.println(responseBody);


        //Check the availability of the vehicle


//       String responseBody = null;
//        AssetTrackId= HttpsUtils.ParseJSON(responseBody,"id");
//        System.setProperty("AssetTrackId",AssetTrackId);
//        System.out.println(AssetTrackId);


    }

    ///vehicles/current-status/?registration_number=KA-05-AJ-1234
    //@Test
    public static void getvehiclestatus() throws ParseException {
        //"/accounts/login/"

        System.out.println("Control in GetvehicleStatus");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println("AssetTrackBody" + AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                // headers(new HttpsUtils().constantHeaders()).body(AssetTrackBody).
                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token " + System.getProperty("Token"))).
                        contentType(ContentType.JSON).

                        when().get("vehicles/current-status/?registration_number=" + vehicle_reg_number);
        response.then().log().all();

        JSONParser parser = new JSONParser();
        JSONObject VehicleDetails = (JSONObject) parser.parse(response.getBody().asString());
        //pick a non-iot vehicle
        //for (int i = 0; i < VehicleDetails.size(); i++) {


        boolean status = (boolean) VehicleDetails.get("is_iot_enabled");
        String qr_identifier = (String) VehicleDetails.get("qr_identifier");
        //String km_reading = (String) VehicleDetails.get("km_reading"); // String.valueOf
        String km_reading = String.valueOf(VehicleDetails.get("km_reading"));
        String helmet_count = Constants.helmet_count;
        String Vehicles_status = (String) VehicleDetails.get("status");
        String registration_number = (String) VehicleDetails.get("registration_number");


        System.out.println(" status" + status);
        System.out.println("qr_identifier" + qr_identifier);
        System.out.println("km_reading" + km_reading);
        System.out.println("helmet_count" + helmet_count);
        System.out.println("Vehicles_status" + Vehicles_status);

        System.out.println("registration_number" + registration_number);


//            if (vehicleObj.get("is_iot_enabled").equals(true)) {
//                System.out.println("This is non IOT enabled vehicle");
//                boolean vehicleFound = true;
//            } else {
//                System.out.println("This is iot vehicle");
//            }
//            vehicle_reg_number = (String) vehicleObj.get("registration_number");

        int actual_status_code = response.getStatusCode();
        System.out.println(actual_status_code + " " + " " + Constants.successcode);
        //Assert.assertEquals(actual_status_code, Constants.successcode);

        String responseBody = response.asString();
        //System.out.println(responseBody);


    }


    public static void dynamicdata() throws ParseException {

        Object[][] Json = TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/AssetTrackBody.csv", AssetTrackForIdPojo.class);

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(String.valueOf(Json));
        System.out.println(json.get("qridentifier"));



        ;
    }

}


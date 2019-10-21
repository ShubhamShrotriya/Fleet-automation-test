

package FleetTests.AssetTrack;

import FleetTests.Accounts.VerifyOTP;
import Utilities.Constants;
import Utilities.HttpsUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class VehicleRegNumber {


    static String km_reading;
    static String status;
    static String helmet_count;
    static String qr_identifier;
    static String registration_number;
    static String fuel_level;


    public static String lat, lon, station_address, stationLat, stationLon, vehicle_reg_number;
    public static boolean vehicleFound;
    private static String Vehicles_status;
    private static String Vehicleqridentifier;
    private static String vehicleqr;
    private static String Kmreading;
    public static String UB_vehicle_reg_number=Constants.UnderBooking_vehicle_reg_number;
    private static String UnderBookingvehicleqr;

    // @Test(priority = 1)
    public static String GetInventoryAtStation() throws Exception {
        //"/accounts/login/"
        System.out.println("Control in AvailableIventoryAtStation");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println("AssetTrackBody" + AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                        headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).
                contentType(ContentType.JSON).
                when().
                get("stations/" + Constants.station_id + "/vehicles/");
            response.then();

        JSONParser parser = new JSONParser();
        JSONArray vehiclesList = (JSONArray) parser.parse(response.getBody().asString());
        //pick a non-iot vehicle
        
        for (int i = 0; i < vehiclesList.size(); i++)
        {
            JSONObject vehicleObj = (JSONObject) vehiclesList.get(i);
            if (vehicleObj.get("is_iot_enabled").equals(false))
            {
                System.out.println("This is non IOT enabled vehicle" + vehicleObj.get("registration_number"));
                vehicle_reg_number = (String) vehicleObj.get("registration_number");

                //Vehicles_status = Vehicle_details.getvehiclestatus((String)vehicleObj.get("registration_number"));
                Vehicles_status=getvehiclesdetails(vehicle_reg_number);
                //Vehicleqridentifier= getvehicleqr(vehicle_reg_number);
                System.out.println(Vehicles_status);
                if ((Vehicles_status).equals(Constants.AVAILABLE_FOR_BOOKING) )
                //if ((Vehicles_status).equals(Status))
                {
                    vehicleqr= getvehicleqr(vehicle_reg_number);
                    System.out.println( " got respective details of the vehicle :- " + vehicle_reg_number );
                    //getvehiclesdetails(vehicle_reg_number);
                    //String Vehicle_registration_num = getvehiclebasedonstatus.GetVehiclesBasedOnStatus();
                    System.out.println(" this is the qr identifier you need to write CSV" + vehicleqr);




                    //} else {
                    //  // System.out.println("This is iot vehicle");
                    //}
                    //vehicle_reg_number = (String) vehicleObj.get("registration_number");

                    break;
                }

            }
        }
        return vehicleqr;


    }
//*******************************************************************************************************************

    public static String getkmreading() throws Exception {
        //"/accounts/login/"
        System.out.println("Control in AvailableIventoryAtStation");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println("AssetTrackBody" + AssetTrackBody); postmn
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token 40516d19401336f8efd574405fe8953629d6f3fd")).
                contentType(ContentType.JSON).
                when().
                get("stations/" + Constants.station_id + "/vehicles/");
        response.then().log().all();

        JSONParser parser = new JSONParser();
        JSONArray vehiclesList = (JSONArray) parser.parse(response.getBody().asString());
        //pick a non-iot vehicle

        for (int i = 0; i < vehiclesList.size(); i++)
        {
            JSONObject vehicleObj = (JSONObject) vehiclesList.get(i);
            if (vehicleObj.get("is_iot_enabled").equals(false))
            {
                System.out.println("This is non IOT enabled vehicle" + vehicleObj.get("registration_number"));
                vehicle_reg_number = (String) vehicleObj.get("registration_number");

                //Vehicles_status = Vehicle_details.getvehiclestatus((String)vehicleObj.get("registration_number"));
                Vehicles_status=getvehiclesdetails(vehicle_reg_number);
                Vehicleqridentifier= getvehicleqr(vehicle_reg_number);
                System.out.println(Vehicles_status);
                if ((Vehicles_status).equals(Constants.AVAILABLE_FOR_BOOKING) )
                {

                    Kmreading= getvehiclekm(vehicle_reg_number);
                    System.out.println( " got respective details of the vehicle :- " + vehicle_reg_number );
                    //getvehiclesdetails(vehicle_reg_number);
                    //String Vehicle_registration_num = getvehiclebasedonstatus.GetVehiclesBasedOnStatus();
                    System.out.println(" this is the Kmreading you need to write CSV" + Kmreading);


                    break;
                }


            }
        }
        return Kmreading;

    }

   // *****************************************************************************************************************


    public static String getvehiclesdetails(String vehicle_reg_number) throws Exception {
        //"/accounts/login/"

        //String Vehicletogetdetailsfor = getvehiclebasedonstatus.GetVehiclesBasedOnStatus();
        System.out.println("vehicle_reg_number" + " " + vehicle_reg_number);
        System.out.println("Control in Get vehicle Status");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println("AssetTrackBody" + AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().

                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token 40516d19401336f8efd574405fe8953629d6f3fd")).
                contentType(ContentType.JSON).

                when().get("/vehicles/current-status/?registration_number=" + vehicle_reg_number);;
        response.then();

        JSONParser parser = new JSONParser();
        JSONObject VehicleDetails = (JSONObject) parser.parse(response.getBody().asString());

        boolean IOTstatus = (boolean) VehicleDetails.get("is_iot_enabled");
        String qr_identifier = (String) VehicleDetails.get("qr_identifier");
        km_reading = String.valueOf(VehicleDetails.get("km_reading"));
        helmet_count= Constants.helmet_count;
        Vehicles_status= (String) VehicleDetails.get("status");
        registration_number= (String) VehicleDetails.get("registration_number");
        fuel_level = String.valueOf(VehicleDetails.get("fuel_level"));



        System.out.println(" is_iot_enabled status" +  " " +IOTstatus);
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

        return Vehicles_status;

    }




// *****************************************************************************************************************

    public static String getvehicleqr(String vehicle_reg_number) throws Exception {
        //"/accounts/login/"

        //String Vehicletogetdetailsfor = getvehiclebasedonstatus.GetVehiclesBasedOnStatus();
        System.out.println("vehicle_reg_number" + " " + vehicle_reg_number);
        System.out.println("Control in Get vehicle Status");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println("AssetTrackBody" + AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().

                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token 40516d19401336f8efd574405fe8953629d6f3fd")).
                contentType(ContentType.JSON).

                when().get("/vehicles/current-status/?registration_number=" + vehicle_reg_number);;
        response.then();

        JSONParser parser = new JSONParser();
        JSONObject VehicleDetails = (JSONObject) parser.parse(response.getBody().asString());

        boolean IOTstatus = (boolean) VehicleDetails.get("is_iot_enabled");
        String qr_identifier = (String) VehicleDetails.get("qr_identifier");
        System.out.println("QR CODE is : "+qr_identifier);
        km_reading = String.valueOf(VehicleDetails.get("km_reading"));
        helmet_count= Constants.helmet_count;
        Vehicles_status= (String) VehicleDetails.get("status");
        registration_number= (String) VehicleDetails.get("registration_number");
        fuel_level = String.valueOf(VehicleDetails.get("fuel_level"));



        int actual_status_code = response.getStatusCode();
        System.out.println(actual_status_code + " " + " " + Constants.successcode);
        Assert.assertEquals(actual_status_code, Constants.successcode);

        String responseBody = response.asString();

        return qr_identifier;

    }




    public static String getvehiclekm(String vehicle_reg_number) throws Exception {
        System.out.println("Control in getvehiclekm");
        //"/accounts/login/"

        //String Vehicletogetdetailsfor = getvehiclebasedonstatus.GetVehiclesBasedOnStatus();
        System.out.println("vehicle_reg_number" + " " + vehicle_reg_number);
        System.out.println("Control in Get vehicle Status");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println("AssetTrackBody" + AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().

                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token 40516d19401336f8efd574405fe8953629d6f3fd")).
                contentType(ContentType.JSON).

                when().get("/vehicles/current-status/?registration_number=" + vehicle_reg_number);
        ;
        response.then().log().all();

        JSONParser parser = new JSONParser();
        JSONObject VehicleDetails = (JSONObject) parser.parse(response.getBody().asString());

        boolean IOTstatus = (boolean) VehicleDetails.get("is_iot_enabled");
        String qr_identifier = (String) VehicleDetails.get("qr_identifier");
        //int Enterkm_reading = Integer.parseInt((String) VehicleDetails.get("km_reading"));

        double km_reading1 = (double)VehicleDetails.get("km_reading");

        System.out.println("this is the actual km from backend " + " " + km_reading1 );
        //Enterkm_reading=Enterkm_reading+1;
        int fe_km_reading = ((int)km_reading1)+1;
        System.out.println("this is the km value I am getting from the backend " + " " + fe_km_reading );
        //km_reading = String.valueOf(Enterkm_reading);
       km_reading = String.valueOf(fe_km_reading);
        helmet_count = Constants.helmet_count;
        Vehicles_status = (String) VehicleDetails.get("status");
        registration_number = (String) VehicleDetails.get("registration_number");
        fuel_level = String.valueOf(VehicleDetails.get("fuel_level"));


        int actual_status_code = response.getStatusCode();
        System.out.println(actual_status_code + " " + " " + Constants.successcode);
        Assert.assertEquals(actual_status_code, Constants.successcode);

        String responseBody = response.asString();

        return km_reading;


    }


    // @Test(priority = 1)
    public static String getvehicleqrfornonATvehicles(String NON_AT_vehicle_reg_number, String vehicleStatus) throws Exception {


                Vehicles_status=getvehiclesdetails(NON_AT_vehicle_reg_number);

                //Vehicleqridentifier= getvehicleqr(vehicle_reg_number);
                System.out.println(Vehicles_status);
                if ((Vehicles_status).equals(vehicleStatus) )
                //if ((Vehicles_status).equals(Status))
                {
                    vehicleqr= getvehicleqr(vehicle_reg_number);
                    System.out.println( " got respective details of this Under booking vehicle :- " + vehicle_reg_number );
                    //getvehiclesdetails(vehicle_reg_number);
                    //String Vehicle_registration_num = getvehiclebasedonstatus.GetVehiclesBasedOnStatus();
                    System.out.println(" this is the qr identifier you need to write CSV" + vehicleqr);
                   // break;
                }

        return vehicleqr;

}


    // @Test(priority = 1)
    public static String getUnderBookingVehicleQR() throws Exception {
        //"/accounts/login/"
        System.out.println("Control in AvailableIventoryAtStation");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        // System.out.println("AssetTrackBody" + AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token 40516d19401336f8efd574405fe8953629d6f3fd")).
               // headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token "+ VerifyOTP.AccessToken)).
                contentType(ContentType.JSON).
                when().
                get("stations/" + Constants.station_id + "/vehicles/");
        response.then().log().all();

        JSONParser parser = new JSONParser();
        System.out.println("Starting to parse the json");
        JSONArray vehiclesList = (JSONArray)parser.parse(response.getBody().asString());
        //pick a non-iot vehicle

        for (int i = 0; i < vehiclesList.size(); i++)
        {
            JSONObject vehicleObj = (JSONObject) vehiclesList.get(i);
            if (vehicleObj.get("is_iot_enabled").equals(false))
            {
                System.out.println("This is non IOT enabled vehicle" + vehicleObj.get("registration_number"));
                vehicle_reg_number = (String) vehicleObj.get("registration_number");

                //Vehicles_status = Vehicle_details.getvehiclestatus((String)vehicleObj.get("registration_number"));
                Vehicles_status=getvehiclesdetails(vehicle_reg_number);
                //Vehicleqridentifier= getvehicleqr(vehicle_reg_number);
                System.out.println(Vehicles_status);
                if ((Vehicles_status).equals(Constants.UNDER_BOOKING) )
                //if ((Vehicles_status).equals(Status))
                {
                    UnderBookingvehicleqr= getvehicleqr(vehicle_reg_number);
                    System.out.println( " got respective details of the vehicle :- " + vehicle_reg_number );
                    //getvehiclesdetails(vehicle_reg_number);
                    //String Vehicle_registration_num = getvehiclebasedonstatus.GetVehiclesBasedOnStatus();
                    System.out.println(" this is the qr identifier you need to write CSV" + UnderBookingvehicleqr);

                    break;
                }

            }
        }
        System.out.println("this is under booking vehicle" + UnderBookingvehicleqr);
        return UnderBookingvehicleqr;


    }
}




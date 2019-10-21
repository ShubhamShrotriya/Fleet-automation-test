package FleetTests.Stations;

import FleetTests.Accounts.VerifyOTP;
import Utilities.Constants;
import Utilities.HttpsUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class Stations

{


    public static String StationsId;
    public static String Station_Id;
    public static String Stationlatitude;
    public static String Stationlongitude;
    public static String Stationaddress;

    @Test
    public static void StationsDetails() throws ParseException {

        System.out.println(VerifyOTP.AccessToken);

        System.out.println("Control in Stations Details ");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        HttpsUtils HU = new HttpsUtils();
        Response response = given().headers(HU.constantHeaders()).
              //  headers(HU.updateHeaders("Authorization", "Token "+ VerifyOTP.AccessToken)).
               headers(HU.updateHeaders("Authorization", "Token "+ Constants.FleetAccessToken)).
                        contentType(ContentType.JSON)

                .when().get("stations/"+Constants.station_id+"/");

        response.then().log().all();
        String responsebody=response.toString();

        System.out.println(responsebody);

        JSONParser parser = new JSONParser();
        JSONObject StationObject = (JSONObject) parser.parse(response.getBody().asString());



//        double km_reading1 = (double)VehicleDetails.get("km_reading");
//
//        System.out.println("this is the actual km from backend " + " " + km_reading1 );
//        //Enterkm_reading=Enterkm_reading+1;
//        int fe_km_reading = ((int)km_reading1)+1;
//        System.out.println("this is the km value I am getting from the backend " + " " + fe_km_reading );
//        //km_reading = String.valueOf(Enterkm_reading);
//        km_reading = String.valueOf(fe_km_reading);


        long StationlongId= (long) StationObject.get("id");
        Station_Id=String.valueOf(StationlongId);


        double Stationlonglatitude= (double) StationObject.get("latitude");
        Stationlatitude=String.valueOf(Stationlonglatitude);


        double Stationlonglongitude= (double) StationObject.get("longitude");
        Stationlongitude=String.valueOf(Stationlonglongitude);



        //Station_Id= (String) StationObject.get("id");
        //Stationlatitude= (String) StationObject.get("latitude");
        //Stationlongitude= (String) StationObject.get("longitude");
        Stationaddress = (String) StationObject.get("address");
        System.out.println("Stationaddress = " + Stationaddress);
        System.out.println("Station_Id = " + Station_Id);
        System.out.println("Stationlatitude = " + Stationlatitude);
        System.out.println("Stationlongitude = " + Stationlongitude);

        Assert.assertEquals(response.getStatusCode(), Constants.successcode);
    }

    @Test
    public static void StationsDetails_IncorrectId() {

        System.out.println(VerifyOTP.AccessToken);

        System.out.println("Control in Stations Details incorrect station id");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);


        HttpsUtils HU = new HttpsUtils();
        Response response = given().headers(HU.constantHeaders()).
                headers(HU.updateHeaders("Authorization", "Token "+ VerifyOTP.AccessToken)).
                        contentType(ContentType.JSON)

                .when().get("stations/"+"4535345"+"/");
        response.then();

        String responsebody=response.toString();
        System.out.println(responsebody);

//
        Assert.assertEquals(response.getStatusCode(), Constants.failurecode_IncorrectEndPoint);
    }
}

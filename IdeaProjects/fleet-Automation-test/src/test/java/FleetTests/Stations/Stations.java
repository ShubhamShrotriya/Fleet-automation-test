package FleetTests.Stations;

import FleetTests.Accounts.VerifyOTP;
import Utilities.Constants;
import Utilities.HttpsUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class Stations

{


    @Test
    public static void StationsDetails() {

        System.out.println(VerifyOTP.AccessToken);

        System.out.println("Control in Stations Details ");
        //GetProfile GP = new GetProfile();
        // GP.setAccesstoken("6361859543");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);


        //       PropertiesFile prop = new PropertiesFile();
//        String access_token = prop.accesstoken;
        // System.out.println("Token 40516d19401336f8efd574405fe8953629d6f3fd");

        HttpsUtils HU = new HttpsUtils();
        Response response = given().headers(HU.constantHeaders()).
                headers(HU.updateHeaders("Authorization", "Token "+ VerifyOTP.AccessToken)).
                // headers(HU.updateHeaders("Authorization", "Token "+ access_token))
                        contentType(ContentType.JSON)

                .when().get("stations/"+Constants.station_id+"/");

        response.then();

        String responsebody=response.toString();
        System.out.println(responsebody);

//
        Assert.assertEquals(response.getStatusCode(), Constants.successcode);
    }

    @Test
    public static void StationsDetails_IncorrectId() {

        System.out.println(VerifyOTP.AccessToken);

        System.out.println("Control in Stations Details incorrect station id");
        //GetProfile GP = new GetProfile();
        // GP.setAccesstoken("6361859543");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);


        //       PropertiesFile prop = new PropertiesFile();
//        String access_token = prop.accesstoken;
        // System.out.println("Token 40516d19401336f8efd574405fe8953629d6f3fd");

        HttpsUtils HU = new HttpsUtils();
        Response response = given().headers(HU.constantHeaders()).
                headers(HU.updateHeaders("Authorization", "Token "+ VerifyOTP.AccessToken)).
                // headers(HU.updateHeaders("Authorization", "Token "+ access_token))
                        contentType(ContentType.JSON)

                .when().get("stations/"+"4535345"+"/");

        response.then();

        String responsebody=response.toString();
        System.out.println(responsebody);

//
        Assert.assertEquals(response.getStatusCode(), Constants.failurecode_IncorrectEndPoint);
    }
}

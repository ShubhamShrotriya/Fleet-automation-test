package FleetTests.Attendance;

import FleetTests.Accounts.VerifyOTP;
import Utilities.Constants;
import Utilities.HttpsUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class Summary

{


    @Test
    public static void AttendanceSummary() {

        System.out.println(VerifyOTP.AccessToken);

        System.out.println("Control in Attendance Summary ");
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

                .when().get("attendance/summary/");

        response.then();

        String responsebody=response.toString();
        System.out.println(responsebody);

//
        Assert.assertEquals(response.getStatusCode(), Constants.successcode);
    }
}

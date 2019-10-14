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


public class Penality

{


    @Test
    public static void PenalityDetails() {

        System.out.println(VerifyOTP.AccessToken);

        System.out.println("Control in Penality Details ");

        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);

        HttpsUtils HU = new HttpsUtils();
        Response response = given().headers(HU.constantHeaders()).
                headers(HU.updateHeaders("Authorization", "Token "+ VerifyOTP.AccessToken)).

                        contentType(ContentType.JSON)

                .when().get("attendance/penalty/");

        response.then();

        String responsebody=response.toString();
        System.out.println(responsebody);

//
        Assert.assertEquals(response.getStatusCode(), Constants.successcode);
    }

    @Test
    public static void PenalityDetails_IncorrectToken() {

        System.out.println(VerifyOTP.AccessToken);

        System.out.println("Control in Penality Details ");

        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);

        HttpsUtils HU = new HttpsUtils();
        Response response = given().headers(HU.constantHeaders()).
                headers(HU.updateHeaders("Authorization", "Token 3231331"+ VerifyOTP.AccessToken)).

                contentType(ContentType.JSON)

                .when().get("attendance/penalty/");

        response.then();

        String responsebody=response.toString();
        System.out.println(responsebody);

//
        Assert.assertEquals(response.getStatusCode(), Constants.Failure_unauthorizedUser);
    }
}

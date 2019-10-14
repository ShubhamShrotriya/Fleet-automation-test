package FleetTests.Accounts;

import FunctionTestModels.Accounts.GetProfile;
import Utilities.Constants;
import Utilities.HttpsUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class verifyProfile

{


    @Test
    public static void verifyProfile() {

        System.out.println(VerifyOTP.AccessToken);

        System.out.println("Control in Verify Profile");
        GetProfile GP = new GetProfile();
        GP.setAccesstoken("6361859543");
         RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);

        HttpsUtils HU = new HttpsUtils();
        Response response = given().headers(HU.constantHeaders()).
                headers(HU.updateHeaders("Authorization", "Token "+ VerifyOTP.AccessToken)).
                body(GP).contentType(ContentType.JSON)

                .when().get("/accounts/profile/");

                response.then();

//
        Assert.assertEquals(response.getStatusCode(), Constants.successcode);
    }

    @Test
    public static void verifyProfile_IncorrectToken() {

        System.out.println(VerifyOTP.AccessToken);

        System.out.println("Control in Verify Profile");
        GetProfile GP = new GetProfile();
        GP.setAccesstoken("6361859543");
        RestAssured.baseURI = Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);


        HttpsUtils HU = new HttpsUtils();
        Response response = given().headers(HU.constantHeaders()).
                headers(HU.updateHeaders("Authorization", "Token dadassaaa"+ VerifyOTP.AccessToken)).

                        body(GP).contentType(ContentType.JSON)

                .when().get("/accounts/profile/");

        response.then();

        Assert.assertEquals(response.getStatusCode(), Constants.failurecode_unauthorized);
    }
}

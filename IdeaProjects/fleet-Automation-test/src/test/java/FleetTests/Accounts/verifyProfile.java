package FleetTests.Accounts;

import FunctionTestModels.Accounts.GetProfile;
import Utilities.Constants;
import Utilities.HttpsUtils;
import Utilities.PropertiesFile;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class verifyProfile

{
    @Test
    public static void verifyProfile() {
        //"/accounts/login/"

        GetProfile GP = new GetProfile();
        GP.setAccesstoken("6361859543");
         RestAssured.baseURI = Constants.AveeshaFleetBaseURL;
        System.out.println(RestAssured.baseURI);


        PropertiesFile prop = new PropertiesFile();
        String access_token = prop.accesstoken;
        System.out.println(access_token);

        HttpsUtils HU = new HttpsUtils();
        Response response = given().headers(HU.constantHeaders()).
                headers(HU.updateHeaders("Authorization", "Token "+ access_token)).
               // headers(HU.updateHeaders("Authorization", "Token "+ access_token)).
                body(GP).contentType(ContentType.JSON)

                .when().post("/accounts/profile/");

                response.then().log().all();

    }
}

package FleetTests.AssetTrack;

import FunctionTestModels.AssetTracking.StartAssetTrack;
import Utilities.Constants;
import Utilities.HttpsUtils;
import Utilities.PropertiesFile;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StartAssetTracking {



        @Test
        public static void AssetTracking()
    {
        //"/accounts/login/"

        StartAssetTrack AT = new StartAssetTrack();
        AT.setRegistration_number("KA-51-AD-3258");
        AT.setStation_id("111");

        RestAssured.baseURI = Constants.AveeshaFleetBaseURL;
        System.out.println(RestAssured.baseURI);

        PropertiesFile prop = new PropertiesFile();
        String access_token = prop.accesstoken;


        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization", "Token "+ access_token)).
                body(AT).contentType(ContentType.JSON)

                .when().post("/api/v1/asset/start/");

        response.then().log().all();

    }


}

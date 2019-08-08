package FleetTests.Accounts;

import FunctionTestModels.Accounts.CreateLogin;
import Utilities.Constants;
import Utilities.HttpsUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class VerifyLogin {


        //@Test
        public static void verifylogin()
        {
            //"/accounts/login/"

            CreateLogin CL = new CreateLogin();
            CL.setMobile("6361859543");
            RestAssured.baseURI= Constants.AveeshaFleetBaseURL;
            System.out.println(RestAssured.baseURI);

            Response response = given().header("X-App-Version", "29").header("ContentType", "application/json").

                    body(CL).contentType(ContentType.JSON)

                    .when().post("/accounts/login/");
            response.then().log().all();





        }
//*******************************************************************************

    @DataProvider(name = "dataForLogin")
    public Object[][] dataForLogin(){
            return new Object[][]{
                    {"6361859543"},
                    {"7019639205"}
            };
    }

    @Test(dataProvider = "dataForLogin")
    public static void verify_login(String number)
    {
        //"/accounts/login/"

        System.out.println("Control in Login");

        CreateLogin CL = new CreateLogin();
        CL.setMobile(number);
        RestAssured.baseURI= Constants.AveeshaFleetBaseURL;
        System.out.println(RestAssured.baseURI);

        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).

                body(CL).contentType(ContentType.JSON)

                .when().post("/accounts/login/");
        response.then().log().all();





    }






}



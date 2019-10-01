package FleetTests.Accounts;

import FunctionTestModels.Accounts.CreateLogin;
import Utilities.Constants;
import Utilities.HttpsUtils;
import Utilities.TestHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class VerifyLogin {


    @DataProvider(name = "dataForLogin")
    public Object[][] dataForLoginmethod()
    {
        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/verfiycopy.csv",CreateLogin.class);
    }

    @Test(dataProvider = "dataForLogin")
    public static void verify_login(String loginRequestBody)
    {

        System.out.println("Control in Login");
        RestAssured.baseURI= Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        System.out.println(loginRequestBody);


        Response response = given().
                headers(new HttpsUtils().constantHeaders()).body(loginRequestBody).
                when().post("/accounts/login/");
        response.then();
        int actual_status_code=response.getStatusCode();
        Assert.assertEquals(actual_status_code, Constants.successcode);
       // Assert.assertEquals(response.toString(), "OTP sent");





    }






}



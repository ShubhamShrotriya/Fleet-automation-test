package FleetTests.FeCheckout;

import FunctionTestModels.ConsumerAPIs.ConsumerLogin;
import FunctionTestModels.ConsumerAPIs.ConsumerOTP;
import Utilities.Constants;
import Utilities.HttpsUtils;
import Utilities.TestHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class consumerLogin {



    public static String ConsumerAccessToken;

        @DataProvider(name = "dataForLogin")
        public Object[][] dataForLoginmethod()
        {
            return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/consumerLogin.csv",ConsumerLogin.class);
        }

        @Test(dataProvider = "dataForLogin")
        public static void verify_login(String loginRequestBody)
        {

            System.out.println("Control in Login");
            RestAssured.baseURI= Constants.stageConsumerBaseURL;
            System.out.println(RestAssured.baseURI);
            System.out.println(loginRequestBody);


            Response response = given().
                    headers(new HttpsUtils().constantHeadersConsumer()).body(loginRequestBody).
                    when().post("/accounts/login/");
            response.then();
            int actual_status_code=response.getStatusCode();
            Assert.assertEquals(actual_status_code, Constants.successcode);





        }



    //accounts/users/verify/


    @DataProvider(name = "dataForzconsumerLogin")
    public Object[][] dataForVerifyConsumerLogin()
    {
        return TestHelper.getDataForDataProvider("/Users/vogo/IdeaProjects/fleet-Automation-test/src/main/resources/TestData/verifyconsumerOTP.csv", ConsumerOTP.class);
    }

    @Test(dataProvider = "dataForzconsumerLogin")
    public static void verifyConsumerOTP(String VerifyConsumerOTPBody)
    {

        System.out.println("Control in verifyOTP");
        RestAssured.baseURI= Constants.stageConsumerBaseURL;
        System.out.println(RestAssured.baseURI);
        System.out.println(VerifyConsumerOTPBody);


        Response response = given().
                headers(new HttpsUtils().updateHeaders("Content-Type", "application/json")).body(VerifyConsumerOTPBody).
                when().post("/accounts/users/verify/");
        response.then().log().all();
        int actual_status_code=response.getStatusCode();


        String responseBody = response.asString();
        //ConsumerAccessToken= HttpsUtils.ParseJSON(responseBody,"access_token");
        System.out.println(ConsumerAccessToken);

        Assert.assertEquals(actual_status_code, Constants.successcode);

    }
    }





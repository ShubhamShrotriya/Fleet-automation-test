package Utilities;

//import com.vodrive.functionalTestModels.inAppHelp.FuelAutoRefund
//import com.vodrive.unitTestModels.booking.*


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;

import java.io.FileReader;
import java.util.HashMap;

public class HttpsUtils
{
        public static FileReader reader;
        //public static HashMap<String, String> headers = new HashMap<>();
      //  public static HashMap<String, String> fleetHeaders = new HashMap<>();
        private static String jsonString;
        private static Response response;

//        public static FileReader reader;
     public  HashMap<String, String> headers = new HashMap<>();
      public  HashMap<String, String> fleetHeaders = new HashMap<>();
//        private static String jsonString;
//        private static Response response;
//
//        private HttpUtils() {
//        }

 String access_token ;


public HashMap<String, String> updateHeaders(String key, String value) {

    PropertiesFile prop = new PropertiesFile();
    access_token=prop.accesstoken;
    headers.put(key, value);
    //headers.put("Authorization", "40516d19401336f8efd574405fe8953629d6f3fd");
return headers;

                      // headers.put(key, value);
        }


       public HashMap<String, String> constantHeaders() {

           headers.put("X-App-Version", "29");
           headers.put("Content-Type", "application/json");

           return headers;

       }


       public static String ParseJSON(String response, String AttributeName)

           {
         //  static String json = "...";

               JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

              // String pageName = jsonObject.getAsJsonObject("Attributename").get("Attributename").getAsString();
               String Value = jsonObject.get(AttributeName).getAsString();
               System.out.println(Value);

//               JsonArray arr = jsonObject.getAsJsonArray("posts");
//               for (int i = 0; i < arr.size(); i++) {
//                   String post_id = arr.get(i).getAsJsonObject().get("post_id").getAsString();
//                   System.out.println(post_id);
               return Value;
           }

//            public static Response callGetListOfVehicles(String BaseURL, long stationId) {
//       RestAssured.baseURI = BaseURL;
//       response = given().headers(fleetHeaders).when().get(Constants.stations + stationId + "/" + Constants.vehicles);
//       return response;
//   }
//
//
//    //public static void updateFleetHeaders(String key, String value) {
//        fleetHeaders.put(key, value);
//    }


//
//    public static void updateHeadersForFleet() {
//        HttpUtils.updateFleetHeaders("X-App-x", Constants.fleetAndroid);
//        HttpUtils.updateFleetHeaders("X-App-Version", Constants.fleetVersion);
//        HttpUtils.updateFleetHeaders("Content-Type", Constants.contentType);
//        HttpUtils.updateFleetHeaders("Authorization", "Token " + Constants.fleetStageAccessToken);
//        System.out.println(fleetHeaders);
//    }
           }


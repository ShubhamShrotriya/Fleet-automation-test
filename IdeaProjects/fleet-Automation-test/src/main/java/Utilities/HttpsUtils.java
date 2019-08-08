package Utilities;

//import com.vodrive.functionalTestModels.inAppHelp.FuelAutoRefund
//import com.vodrive.unitTestModels.booking.*


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;

public class HttpsUtils
   {
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

return headers;
              // headers.put("Authorization", "55dc6737f5913a587675f7942c7ba793e83670de"
                      // headers.put(key, value);
        }


       public HashMap<String, String> constantHeaders() {

//           PropertiesFile prop = new PropertiesFile();
//           access_token=prop.accesstoken;
           headers.put("X-App-Version", "29");
           headers.put("ContentType", "application/json");

           return headers;

       }


       public void  ParseJSON(String response, String AttributeName )

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
               }
           }


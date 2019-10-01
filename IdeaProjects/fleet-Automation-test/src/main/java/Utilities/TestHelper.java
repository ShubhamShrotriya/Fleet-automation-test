package Utilities;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Utilities.FileUtils.FilePathCSV;
import static io.restassured.RestAssured.given;

public class TestHelper {

    private static String AssetTrackId;

    //CSV READER METHOD
    //***************************************************************************************************************

    public static void main(String args[])
    {
        getHashListForDataPath(FilePathCSV);
    }


    public static List<HashMap<String, Object>> getHashListForDataPath(String FilePathCSV) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(FilePathCSV), ',');
            String[] line;
            int i = 1;
            String[] keys = {};
            List<HashMap<String, Object>> hashList = new ArrayList<>();
            while ((line = reader.readNext()) != null) {
                if (i == 1) {
                    keys = new String[line.length];
                    for (int l = 0; l < line.length; l++) {
                        keys[l] = line[l];
                    }
                    i++;
                } else {
                    HashMap<String, Object> map = new HashMap<>();
                    for (int l = 0; l < line.length; l++) {
                        map.put(keys[l], line[l]);
                    }
                    hashList.add(map);
                    System.out.println(hashList.toString());
                }
            }
            return hashList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // MAKING DATA PROVIDER METHOD
    //***************************************************************************************************************

    public static Object[][] getDataForDataProvider(String path, Class className) {
        List<HashMap<String, Object>> hashList = ParseUtils.getHashListForDataPath(path);
        List<Object> ob = ParseUtils.getRequestBodyFromData(hashList, className);
        final Object[][] dataProvider = new Object[ob.size()][1];
       int i = 0;
       for (Object k : ob) {
           Gson gson = new Gson();
           dataProvider[i][0] = gson.toJson(k);
           i++;
          System.out.println(gson.toJson(k));
       }
       return dataProvider;


    }


    //*********************************************************************************************************************
    //Method For Asset TrackingId

    public static void trackingid(String AssetTrackBody) throws Exception {
        //"/accounts/login/"
       // System.out.println(AssetTrackForId.trackingid());


        System.out.println("Control in AssetTrackForId");
        RestAssured.baseURI= Constants.stageFleetBaseURL;
        System.out.println(RestAssured.baseURI);
        //System.out.println("AssetTrackBody"+AssetTrackBody);
        HttpsUtils HU = new HttpsUtils();

        Response response = given().
                headers(HU.constantHeaders()).headers(HU.updateHeaders("Authorization","Token 40516d19401336f8efd574405fe8953629d6f3fd")).
                body(AssetTrackBody).contentType(ContentType.JSON).

                when().post("/asset/");
        response.then().log().all();

        System.out.println("Headers is "+HU.headers);
        int actual_status_code=response.getStatusCode();
        System.out.println(actual_status_code +" " + " " +  Constants.successcode);
      //  Assert.assertEquals(actual_status_code, Constants.successcode);

        String responseBody = response.asString();
        System.out.println(responseBody);

        AssetTrackId= HttpsUtils.ParseJSON(responseBody,"id");
        System.setProperty("AssetTrackId",AssetTrackId);
        System.out.println(AssetTrackId);





    }

/*
    public static void writeDataLineByLine(String filePath)
    {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

           // "latitude","longitude","qr_identifier"
            //"12.911965232333293","77.65163523430478","Z28YRJZ"

            // adding header to csv
            String[] header = { "latitude","longitude","qr_identifier" };
            writer.writeNext(header);

            //ABC ab = new ABC();

            // add data to csv
            String[] data1 = { "12.911965232333293","77.65163523430478", ABC.qr_identifier };
            writer.writeNext(data1);
           // String[] data2 = { "Suraj", "10", "630" };
            //writer.writeNext(data2);

            // closing writer connection
            writer.close();
            System.out.println("file is written you can check");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
*/

}

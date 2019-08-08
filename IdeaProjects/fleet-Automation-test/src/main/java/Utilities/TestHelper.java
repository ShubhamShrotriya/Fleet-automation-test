package Utilities;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Utilities.FileUtils.FilePathCSV;

public class TestHelper {

    //CSV READER METHOD
    //***************************************************************************************************************

    public static void main(Strings args[]) {
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
}

package FleetTests.Accounts;/*
package FleetTests.Accounts;


import sun.plugin2.os.windows.Windows;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritePropertiesFile {
    {
        public static void main(String[] args)
            {
        try {
            Properties properties = new Properties();

            properties.setProperty("AccessToken", "");
            //properties.setProperty("favoriteContinent", "Antarctica");
            //properties.setProperty("favoritePerson", "Nicole");

            File file = new File("test2.properties");
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.store(fileOut, "Favorite Things");
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
    }
}
*/


import java.io.*;
import java.util.Properties;

public class WritePropertiesFile {

    public String accesstoken;

    public static void main(String args[])
    {
        //getproperties();
        // setproperties();
    }

    /*
        public static void getproperties()
        {
            try {
                Properties prop = new Properties();
                String ProjectPath = System.getProperty("user.dir");
                System.out.println(ProjectPath);
                InputStream Input = new FileInputStream(ProjectPath + "/ConfigProperty/PropertyFile");
                prop.load(Input);
                String accesstoken=prop.getProperty("access_token");
                System.out.println( "access_token=" + accesstoken);
            }

            catch (IOException e)
            {
                e.printStackTrace();
                e.getMessage();
            }
    //Users/vogo/IdeaProjects/fleet-Automation-test/ConfigProperty/PropertyFile
        }
    */
    public static void setproperties()
    {
        try {
            Properties prop = new Properties();
            String ProjectPath = System.getProperty("user.dir");
            System.out.println(ProjectPath);
            OutputStream  Output = new FileOutputStream(ProjectPath + "/ConfigProperty/PropertyFile");
            VerifyOTP VToken = new VerifyOTP();
           // String Vaccesstoken=VToken.Access_token;
            //prop.setProperty("access_token",Vaccesstoken);
            String key;
            String Value=prop.getProperty("Key");

            System.out.println( "access_token=" + Value);





            Properties properties = new Properties();
            properties.setProperty("favoriteAnimal", "marmot");
            //properties.setProperty("favoriteContinent", "Antarctica");
            //properties.setProperty("favoritePerson", "Nicole");

            File file = new File("test2.properties");
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.store(fileOut, "Favorite Things");
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }











        catch (Exception e)
        {
            e.printStackTrace();
            e.getMessage();
        }
//Users/vogo/IdeaProjects/fleet-Automation-test/ConfigProperty/PropertyFile
    }


}

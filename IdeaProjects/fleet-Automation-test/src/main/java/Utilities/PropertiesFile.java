package Utilities;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    public String accesstoken;

    public static void main(String args[])
    {
        getproperties();
        setproperties();
    }


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

    public static void setproperties()
    {
        try {
           Properties prop = new Properties();
            String ProjectPath = System.getProperty("user.dir");
            System.out.println(ProjectPath);
            OutputStream  Output = new FileOutputStream(ProjectPath + "/ConfigProperty/PropertyFile");
            prop.setProperty("Key", "Value");
            String key;
            String Value=prop.getProperty("Key");

            System.out.println( "access_token=" + Value);
        }

        catch (IOException e)
        {
            e.printStackTrace();
            e.getMessage();
        }
//Users/vogo/IdeaProjects/fleet-Automation-test/ConfigProperty/PropertyFile
    }



}

package FleetTests.AssetTrack;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ACSVwriting {


    public static void writeDataLineByLineForStartingAT(String filePath, String qr_identifier) throws Exception
    {
        // first create file object for file placed at location
        // specified by filepath
      //  VehicleRegNumber.GetInventoryAtStation();
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // "latitude","longitude","qr_identifier"
            //"12.911965232333293","77.65163523430478","Z28YRJZ"

            // adding header to csv
            String[] header = {"latitude", "longitude", "qr_identifier"};
            writer.writeNext(header);

            //VehicleRegNumber ab = new VehicleRegNumber();

            // add data to csv
            String[] data1 = {"12.911965232333293", "77.65163523430478", qr_identifier};
            writer.writeNext(data1);
            // String[] data2 = { "Suraj", "10", "630" };
            //writer.writeNext(data2);

            // closing writer connection
            writer.close();
            System.out.println("file for start asset track is writtne you can check");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



   // 3VDBJQN
    public static void writeDataLineByLineForNonATVehicles(String filePath, String qr_identifier) throws Exception
    {
        // first create file object for file placed at location
        // specified by filepath
        //  VehicleRegNumber.GetInventoryAtStation();
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // "latitude","longitude","qr_identifier"
            //"12.911965232333293","77.65163523430478","Z28YRJZ"

            // adding header to csv
            String[] header = {"latitude", "longitude", "qr_identifier"};
            writer.writeNext(header);

            //VehicleRegNumber ab = new VehicleRegNumber();

            // add data to csv
           // String[] data1 = {"12.911965232333293", "77.65163523430478", qr_identifier};
            String[] data1 = {"12.911965232333293", "77.65163523430478", "3VDBJQN"};
           // 3VDBJQN
            writer.writeNext(data1);

           // String[] data2 = {"12.911965232333293", "77.65163523430478", "KA4612"};
            //writer.writeNext(data2);

            // String[] data2 = { "Suraj", "10", "630" };
            //writer.writeNext(data2);

            // closing writer connection
            writer.close();
            System.out.println("file for start asset track is writtne you can check");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }








    //writeDataLineByLineForInCompletingAT

    public static void writeDataLineByLineForCompletingAT(String filePath, String Km_reading) throws Exception {

        //VehicleRegNumber.GetInventoryAtStation();

        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // "latitude","longitude","qr_identifier"
            //"12.911965232333293","77.65163523430478","Z28YRJZ"

            // adding header to csv
            String[] header = {"latitude", "longitude", "current_km_reading", "image_url", "is_iot_box_working", "is_otp_working", "helmet_count", "is_document_available", "fuel_level", "is_vehicle_damaged",};
            writer.writeNext(header);

            //VehicleRegNumber ab = new VehicleRegNumber();

            // add data to csv
            String[] data1 = {"12.911965232333293", "77.65163523430478", VehicleRegNumber.km_reading, "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "6", "false"};
            writer.writeNext(data1);

            String[] data2 = {"12.911965232333293", "77.65163523430478", VehicleRegNumber.km_reading, "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "0", "false"};
            writer.writeNext(data2);

            String[] data3 = {"12.911965232333293", "77.65163523430478", VehicleRegNumber.km_reading, "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "0", "false"};
            writer.writeNext(data3);

            // closing writer connection
            writer.close();
            System.out.println("file is written you can check");
        }

        catch(Exception e){
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    public static void writeDataLineByLineForInCompletingAT(String filePath, String Km_reading) throws Exception {

        //VehicleRegNumber.GetInventoryAtStation();

        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // "latitude","longitude","qr_identifier"
            //"12.911965232333293","77.65163523430478","Z28YRJZ"

            // adding header to csv
            String[] header = {"latitude", "longitude", "current_km_reading", "image_url", "is_iot_box_working", "is_otp_working", "helmet_count", "is_document_available", "fuel_level", "is_vehicle_damaged",};
            writer.writeNext(header);

            //VehicleRegNumber ab = new VehicleRegNumber();

            // add data to csv
            String[] data1 = {"12.911965232333293", "77.65163523430478", "47832434234", "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "6", "false"};
            writer.writeNext(data1);

            String[] data2 = {"12.911965232333293", "77.65163523430478", "", "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "6", "false"};
            writer.writeNext(data2);
            // String[] data2 = {"12.911965232333293", "77.65163523430478", VehicleRegNumber.km_reading, "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "0", "false"};
            // writer.writeNext(data2);

            // closing writer connection
            writer.close();
            System.out.println("file is written you can check");
        }

        catch(Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void AddOvertimeChangeHourApprove(String filePath, String addovertimeid) throws Exception {

        //VehicleRegNumber.GetInventoryAtStation();

        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // "latitude","longitude","qr_identifier"
            //"12.911965232333293","77.65163523430478","Z28YRJZ"

            // adding header to csv
            String[] header = {"latitude","longitude","overtime_id","overtime_minutes","status"};
            writer.writeNext(header);

            //VehicleRegNumber ab = new VehicleRegNumber();

            // add data to csv
            String[] data1 = {"12.911965232333293","77.65163523430478", addovertimeid,"120","approved"};
            writer.writeNext(data1);

            //String[] data2 = {"12.911965232333293", "77.65163523430478", "", "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "6", "false"};
            //writer.writeNext(data2);
            // String[] data2 = {"12.911965232333293", "77.65163523430478", VehicleRegNumber.km_reading, "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "0", "false"};
            // writer.writeNext(data2);

            // closing writer connection
            writer.close();
            System.out.println("file is written you can check");
        }

        catch(Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void AddOvertimeDataReject(String filePath, String addovertimeid) throws Exception {

        //VehicleRegNumber.GetInventoryAtStation();

        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // "latitude","longitude","qr_identifier"
            //"12.911965232333293","77.65163523430478","Z28YRJZ"

            // adding header to csv
            String[] header = {"latitude","longitude","overtime_id","overtime_minutes","status"};
            writer.writeNext(header);

            //VehicleRegNumber ab = new VehicleRegNumber();

            // add data to csv
            String[] data1 = {"12.911965232333293","77.65163523430478",addovertimeid,"120","rejected"};
            writer.writeNext(data1);

            //String[] data2 = {"12.911965232333293", "77.65163523430478", "", "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "6", "false"};
            //writer.writeNext(data2);
            // String[] data2 = {"12.911965232333293", "77.65163523430478", VehicleRegNumber.km_reading, "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "0", "false"};
            // writer.writeNext(data2);

            // closing writer connection
            writer.close();
            System.out.println("file is written you can check");
        }

        catch(Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void AddOvertimeApprove(String filePath, String addovertimeid) throws Exception {

        //VehicleRegNumber.GetInventoryAtStation();

        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // "latitude","longitude","qr_identifier"
            //"12.911965232333293","77.65163523430478","Z28YRJZ"

            // adding header to csv
            String[] header = {"latitude","longitude","overtime_id","overtime_minutes","status"};
            writer.writeNext(header);

            //VehicleRegNumber ab = new VehicleRegNumber();

            // add data to csv
            String[] data1 = {"12.911965232333293","77.65163523430478", addovertimeid,"60","approved"};
            writer.writeNext(data1);

            //String[] data2 = {"12.911965232333293", "77.65163523430478", "", "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "6", "false"};
            //writer.writeNext(data2);
            // String[] data2 = {"12.911965232333293", "77.65163523430478", VehicleRegNumber.km_reading, "https://s3.ap-south-1.amazonaws.com/test.consumer.vogo.tech/fleet/refueling/images/8224ee18-711d-4aab-8bbb-f09b9f104ad7.jpeg", "true", "true", "1", "true", "0", "false"};
            // writer.writeNext(data2);

            // closing writer connection
            writer.close();
            System.out.println("file is written you can check");
        }

        catch(Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
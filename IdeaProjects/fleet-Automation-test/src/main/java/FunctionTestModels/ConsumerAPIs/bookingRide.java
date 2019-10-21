package FunctionTestModels.ConsumerAPIs;
import com.google.gson.annotations.SerializedName;

//{
//        "preferred_payment_mode": 1,
//        "destination_address": "HSR WRKS, Bengaluru, Karnataka, India",
//        "destination_latitude": 12.9126907,
//        "destination_longitude": 77.6366391,
//        "drop_station_id": "1021",
//        "pickup_station_id": "1021",
//        "registration_number": "KA-07-KS-7777",
//        "source_location": "12.9126907,77.6366391",
//        "start_ride_location": "12.9126907,77.6366391"
//        }


public class bookingRide {


        @SerializedName("preferred_payment_mode")
        public String preferred_payment_mode;


        public String getpreferred_payment_mode()
        {
            return preferred_payment_mode;
        }


        public void setpreferred_payment_mode(String preferred_payment_mode)
        {
            this.preferred_payment_mode = preferred_payment_mode;
        }




    @SerializedName("destination_address")
    public String destination_address;




        public String getdestination_address()
        {

            return destination_address;
        }


        public void setdestination_address(String destination_address)
        {
            this.destination_address = destination_address;
        }


    @SerializedName("destination_latitude")
    public String destination_latitude;




    public String getdestination_latitude()
    {

        return destination_latitude;
    }


    public void setdestination_latitude(String destination_latitude)
    {
        this.destination_latitude = destination_latitude;
    }


    @SerializedName("destination_longitude")
    public String destination_longitude;




    public String getdestination_longitude()
    {

        return destination_longitude;
    }


    public void setdestination_longitude(String destination_longitude)
    {
        this.destination_longitude = destination_longitude;
    }



    @SerializedName("drop_station_id")
    public String drop_station_id;




    public String getdrop_station_id()
    {

        return drop_station_id;
    }


    public void setdrop_station_id(String drop_station_id)
    {
        this.drop_station_id = drop_station_id;
    }


    @SerializedName("pickup_station_id")
    public String pickup_station_id;




    public String getpickup_station_id()
    {

        return pickup_station_id;
    }


    public void setpickup_station_id(String pickup_station_id)
    {
        this.pickup_station_id = pickup_station_id;
    }


    @SerializedName("registration_number")
    public String registration_number;




    public String getregistration_number()
    {

        return registration_number;
    }


    public void setregistration_number(String registration_number)
    {
        this.registration_number = registration_number;
    }


    @SerializedName("source_location")
    public String source_location;




    public String getsource_location()
    {

        return source_location;
    }


    public void setsource_location(String source_location)
    {
        this.source_location = source_location;
    }


    @SerializedName("start_ride_location")
    public String start_ride_location;




    public String getstart_ride_location()
    {

        return start_ride_location;
    }


    public void setstart_ride_location(String start_ride_location)
    {
        this.start_ride_location = start_ride_location;
    }



}



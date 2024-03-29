package Utilities;

public class Constants {


    public static int  successcode =200;


    public static int  failurecode =400;
    public static int failurecode_unsupported_media=415;
    public static int  failurecode_appCheck =500;
    public static int  Failure_unauthorizedUser =401;
    public static int failurecode_IncorrectEndPoint=404;
    //Failure_unauthorizedUser
   // failurecode_appCheck

    public static String helmet_count="2";

    public static final String stageFleetBaseURL = "https://stage-fleet-api.vogo.tech/api/v1";

    public static final String stageConsumerBaseURL = "https://stage-consumer-api.vogo.tech/api/v1";

    public static final String AveeshaFleetBaseURL = "https://aveesha-fleet-api.vogo.tech/api/v1";

    public static final String stations = "stations/";
    public static final String vehicles = "vehicles/";



    public static String mobilenumber="9582323910";

    public static String station_id="1021";


    public static String FleetAccessToken="40516d19401336f8efd574405fe8953629d6f3fd";

    //40516d19401336f8efd574405fe8953629d6f3fd



    //AVAILABLE_FOR_BOOKING
   // public static final String AVAILABLE_FOR_BOOKING = "UNDER_BOOKING";
    public static final String AVAILABLE_FOR_BOOKING = "AVAILABLE_FOR_BOOKING";
    public static final String UNDER_REFUELING = "UNDER_REFUELING";
    public static final String UNDER_MAINTENANCE = "UNDER_MAINTENANCE";
    public static final String UNDER_SERVICING = "UNDER_SERVICING";
    public static final String UNDER_BOOKING = "UNDER_BOOKING";

    public static final String UnderBooking_vehicle_reg_number = "KA-50-AC-7502";

    public static final String UnderServicing_vehicle_reg_number = "KA-05-AJ-6313";
    public static int failurecode_unauthorized=401;
    //UnderMaintenance_vehicle_reg_number


    //public static final String fleetAndroid;

    //these are the credentials -
    //https://aveesha-consumer-api.vogo.tech/15B1A8AD3CC9F/vogo-admin/
    //https://aveesha-fleet-api.vogo.tech
    //stageFleetBaseURL
}

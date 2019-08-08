package FunctionTestModels.AssetTracking;

public class StartAssetTrack {



    //@SerializedName("otp")
    public String registration_number;

    //@SerializedName("mobile")
    public String station_id;

    public String getStation_id() {
        return station_id;
    }

    public String getRegistration_number()
    {
        return registration_number;
    }

    public void setRegistration_number(String RegistrationNumber)
    {
        this.registration_number = RegistrationNumber;
    }

    public void setStation_id(String StationId)
    {
        this.station_id = StationId;
    }
}



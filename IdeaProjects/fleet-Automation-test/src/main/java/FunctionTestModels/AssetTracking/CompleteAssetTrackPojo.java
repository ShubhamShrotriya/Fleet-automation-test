package FunctionTestModels.AssetTracking;

import Utilities.Constants;
import com.google.gson.annotations.SerializedName;

public class CompleteAssetTrackPojo {
//"latitude","longitude","current_km_reading","image_url","is_iot_box_working","is_otp_working","helmet_count","is_document_available","fuel_level","is_vehicle_damaged",

    @SerializedName("latitude")
    public String latitude;

    @SerializedName("longitude")
    public String longitude;

    @SerializedName("current_km_reading")
    public String current_km_reading;

    @SerializedName("image_url")
    public String image_url;

    @SerializedName("is_iot_box_working")
    public String is_iot_box_working;

    @SerializedName("is_otp_working")
    public String is_otp_working;

    @SerializedName("helmet_count")
    public String helmet_count;

    @SerializedName("is_document_available")
    public String is_document_available;

    @SerializedName("fuel_level")
    public String fuel_level;


    @SerializedName("is_vehicle_damaged")
    public String is_vehicle_damaged;




//
//    public void setLatitude(String latitude) {
//        this.latitude = latitude;
//    }
//
//
//
//    public void setLongitude(String longitude) {
//        this.longitude = longitude;
//    }



    public void setCurrent_km_reading(String current_km_reading) {
        this.current_km_reading = current_km_reading;
    }


    public void setIs_iot_box_working(String is_iot_box_working) {
        this.is_iot_box_working = is_iot_box_working;
    }


    public void setHelmet_count(String helmet_count) {
        this.helmet_count = Constants.helmet_count;
    }


public void setvalues()
{
    CompleteAssetTrackPojo Asset_track_pojo = new CompleteAssetTrackPojo();

   // Asset_track_pojo.setCurrent_km_reading( );
   // Asset_track_pojo.setHelmet_count();
   // Asset_track_pojo.setIs_iot_box_working();
}


}


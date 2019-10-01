package FunctionTestModels.AssetTracking;

import com.google.gson.annotations.SerializedName;

public class AssetTrackForIdUnderBookingPojo {

    @SerializedName("latitude")
    public String latitude;

    @SerializedName("longitude")
    public String longitude;

    @SerializedName("qr_identifier")
   public String qr_identifier;

    public String getQr_identifier() {
        return qr_identifier;
    }

    public void setQr_identifier(String qr_identifier) {
        this.qr_identifier = qr_identifier;
    }
}


package FunctionTestModels.Attendance;

import com.google.gson.annotations.SerializedName;

public class ApproveAddOvertimePojo {


    @SerializedName("latitude")
    public String latitude;

    @SerializedName("longitude")
    public String longitude;

    @SerializedName("overtime_id")
    public String overtime_id;

    @SerializedName("overtime_minutes")
    public String overtime_minutes;

    @SerializedName("status")
    public String status;

}

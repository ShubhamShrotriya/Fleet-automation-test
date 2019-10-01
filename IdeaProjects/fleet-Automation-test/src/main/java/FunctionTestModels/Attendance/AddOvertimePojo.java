package FunctionTestModels.Attendance;

import com.google.gson.annotations.SerializedName;

public class AddOvertimePojo {


    @SerializedName("latitude")
    public String latitude;

    @SerializedName("longitude")
    public String longitude;

    @SerializedName("overtime_minutes")
    public String overtime_minutes;
}

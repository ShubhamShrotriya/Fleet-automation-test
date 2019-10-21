package FunctionTestModels.ConsumerAPIs;

import com.google.gson.annotations.SerializedName;

public class ConsumerOTP {


    @SerializedName("latitude")
    public String latitude;


    public String getlatitude()
    {
        return latitude;
    }


    public void setlatitude(String latitude)
    {
        this.latitude = latitude;
    }


    @SerializedName("longitude")
    public String longitude;


    public String getlongitude()
    {
        return longitude;
    }


    public void setlongitude(String longitude)
    {
        this.longitude = longitude;
    }



    @SerializedName("mobile")
    public String mobile;


    public String getMobile()
    {
        return mobile;
    }


    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }




    @SerializedName("otp")
    public String otp;




    public String getOTP()
    {

        return otp;
    }


    public void setotp(String otp)
    {
        this.otp = otp;
    }



}


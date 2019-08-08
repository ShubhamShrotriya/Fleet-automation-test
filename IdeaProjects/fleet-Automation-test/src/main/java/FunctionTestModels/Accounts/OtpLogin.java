package FunctionTestModels.Accounts;

import com.google.gson.annotations.SerializedName;

public class OtpLogin {

  //  private String mobile;
    //        private String Otp;


    @SerializedName("otp")
    public String Otp;

    @SerializedName("mobile")
    public String mobile;

    public String getMobile() {
        return mobile;
    }

    public String getOtp() {
        return Otp;
    }

    public void setOtp(String otp) {
        Otp = otp;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

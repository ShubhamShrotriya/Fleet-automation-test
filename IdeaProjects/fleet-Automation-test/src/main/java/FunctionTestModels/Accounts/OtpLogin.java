package FunctionTestModels.Accounts;

import com.google.gson.annotations.SerializedName;

public class OtpLogin {

  //  private String mobile;
    //        private String Otp;


    @SerializedName("otp")
    public String otp;

    @SerializedName("mobile")
    public String mobile;

    public String getMobile() {
        return mobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

package FunctionTestModels.Accounts;

import com.google.gson.annotations.SerializedName;

public class CreateLogin {



    @SerializedName("mobile")
    public String mobile;


    public String getMobile() {
            return mobile;
        }


        public void setMobile(String mobile) {
            this.mobile = mobile;
        }


    }


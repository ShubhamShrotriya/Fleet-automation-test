package FunctionTestModels.ConsumerAPIs;
import com.google.gson.annotations.SerializedName;

public class ConsumerLogin {


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




    @SerializedName("retry_count")
    public String retry_count;




        public String getRetry_count()
        {

            return retry_count;
        }


        public void setretry_count(String retry_count)
        {
            this.retry_count = retry_count;
        }



    }



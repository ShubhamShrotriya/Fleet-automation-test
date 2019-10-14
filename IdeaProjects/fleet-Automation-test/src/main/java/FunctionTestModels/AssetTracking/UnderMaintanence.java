package FunctionTestModels.AssetTracking;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UnderMaintanence implements Serializable {


	@SerializedName("latitude")
	private double latitude;

	@SerializedName("longitude")
	private double longitude;


	@SerializedName("current_km_reading")
	private String currentKmReading;


	@SerializedName("image_url")
	private String imageUrl;


	@SerializedName("is_iot_box_working")
	private boolean isIotBoxWorking;


	@SerializedName("is_otp_working")
	private boolean isOtpWorking;




	@SerializedName("helmet_count")
	private int helmetCount;


	@SerializedName("is_document_available")
	private boolean isDocumentAvailable;


	@SerializedName("fuel_level")
	private String fuelLevel;

	@SerializedName("is_vehicle_damaged")
	private boolean isVehicleDamaged;


	@SerializedName("damage_reason_list")
	private List<DamageReasonListItem> damageReasonList;

	public boolean isIsOtpWorking(){
		return isOtpWorking;
	}

	public boolean isIsVehicleDamaged(){
		return isVehicleDamaged;
	}

	public String getFuelLevel(){
		return fuelLevel;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public double getLatitude(){
		return latitude;
	}

	public List<DamageReasonListItem> getDamageReasonList(){
		return damageReasonList;
	}

	public String getCurrentKmReading(){
		return currentKmReading;
	}

	public int getHelmetCount(){
		return helmetCount;
	}

	public boolean isIsIotBoxWorking(){
		return isIotBoxWorking;
	}

	public boolean isIsDocumentAvailable(){
		return isDocumentAvailable;
	}

	public double getLongitude(){
		return longitude;
	}



	@Override
 	public String toString(){
		return 
//			"UnderMaintanence{" +
//			"is_otp_working = '" + isOtpWorking + '\'' +
//			",is_vehicle_damaged = '" + isVehicleDamaged + '\'' +
//			",fuel_level = '" + fuelLevel + '\'' +
//			",image_url = '" + imageUrl + '\'' +
//			",latitude = '" + latitude + '\'' +
//			",damage_reason_list = '" + damageReasonList + '\'' +
//			",current_km_reading = '" + currentKmReading + '\'' +
//			",helmet_count = '" + helmetCount + '\'' +
//			",is_iot_box_working = '" + isIotBoxWorking + '\'' +
//			",is_document_available = '" + isDocumentAvailable + '\'' +
//			",longitude = '" + longitude + '\'' +
//			"}";


		//*********************************************************************************************


        "UnderMaintanence{" +      ",latitude = '" + latitude + '\'' +
                ",longitude = '" + longitude + '\'' +
                ",current_km_reading = '" + currentKmReading + '\'' +
                ",image_url = '" + imageUrl + '\'' +
                ",is_iot_box_working = '" + isIotBoxWorking + '\'' +
                "is_otp_working = '" + isOtpWorking + '\'' +
                ",helmet_count = '" + helmetCount + '\'' +
                ",is_document_available = '" + isDocumentAvailable + '\'' +
                ",fuel_level = '" + fuelLevel + '\'' +
                ",is_vehicle_damaged = '" + isVehicleDamaged + '\'' +
                ",damage_reason_list = '" + damageReasonList + '\'' +
                "}";



		}
}
package FunctionTestModels.AssetTracking;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UnderMaintanence implements Serializable {

	@SerializedName("is_otp_working")
	private boolean isOtpWorking;

	@SerializedName("is_vehicle_damaged")
	private boolean isVehicleDamaged;

	@SerializedName("fuel_level")
	private String fuelLevel;

	@SerializedName("image_url")
	private String imageUrl;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("damage_reason_list")
	private List<DamageReasonListItem> damageReasonList;

	@SerializedName("current_km_reading")
	private String currentKmReading;

	@SerializedName("helmet_count")
	private int helmetCount;

	@SerializedName("is_iot_box_working")
	private boolean isIotBoxWorking;

	@SerializedName("is_document_available")
	private boolean isDocumentAvailable;

	@SerializedName("longitude")
	private double longitude;

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
			"UnderMaintanence{" + 
			"is_otp_working = '" + isOtpWorking + '\'' + 
			",is_vehicle_damaged = '" + isVehicleDamaged + '\'' + 
			",fuel_level = '" + fuelLevel + '\'' + 
			",image_url = '" + imageUrl + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",damage_reason_list = '" + damageReasonList + '\'' + 
			",current_km_reading = '" + currentKmReading + '\'' + 
			",helmet_count = '" + helmetCount + '\'' + 
			",is_iot_box_working = '" + isIotBoxWorking + '\'' + 
			",is_document_available = '" + isDocumentAvailable + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}
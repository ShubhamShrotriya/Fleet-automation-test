package FunctionTestModels.AssetTracking;

import com.google.gson.annotations.SerializedName;

public class DamageReasonListItem{

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("isSelected")
	private boolean isSelected;

	@SerializedName("name")
	private String name;

	@SerializedName("fine_amount")
	private int fineAmount;

	@SerializedName("id")
	private int id;

	public String getImageUrl(){
		return imageUrl;
	}

	public boolean isIsSelected(){
		return isSelected;
	}

	public String getName(){
		return name;
	}

	public int getFineAmount(){
		return fineAmount;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"DamageReasonListItem{" + 
			"imageUrl = '" + imageUrl + '\'' + 
			",isSelected = '" + isSelected + '\'' + 
			",name = '" + name + '\'' + 
			",fine_amount = '" + fineAmount + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
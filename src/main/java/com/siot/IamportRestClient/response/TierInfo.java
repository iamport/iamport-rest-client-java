package com.siot.IamportRestClient.response;

import com.google.gson.annotations.SerializedName;

public class TierInfo {

	@SerializedName("tier_code")
	String tier_code;

	@SerializedName("tier_name")
	String tier_name;

	public String getTierCode() {
		return tier_code;
	}

	public String getTierName() {
		return tier_name;
	}
}

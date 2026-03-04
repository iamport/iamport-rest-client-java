package com.siot.IamportRestClient.response;

import com.google.gson.annotations.SerializedName;

public class StandardCode {

	@SerializedName("code")
	String code;

	@SerializedName("name")
	String name;

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}

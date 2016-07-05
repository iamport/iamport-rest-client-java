package com.siot.IamportRestClient.response;

import com.google.gson.annotations.SerializedName;

public class IamportResponse<T> {

	@SerializedName("code")
	int code;
	
	@SerializedName("message")
	String message;
	
	@SerializedName("response")
	T response;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getResponse() {
		return response;
	}
	
}

package com.siot.IamportRestClient.response.payco;

import com.google.gson.annotations.SerializedName;

public class OrderStatus {

	@SerializedName("status")
	private String status;

	public String getStatus() {
		return status;
	}
	
}

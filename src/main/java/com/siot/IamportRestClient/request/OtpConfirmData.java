package com.siot.IamportRestClient.request;

import com.google.gson.annotations.SerializedName;

public class OtpConfirmData {

	@SerializedName("otp")
	private String otp;

	public OtpConfirmData() {
	}

	public OtpConfirmData(String otp) {
		this.otp = otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
}

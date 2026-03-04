package com.siot.IamportRestClient.request;

import com.google.gson.annotations.SerializedName;

public class OtpRequestData {

	@SerializedName("name")
	private String name;

	@SerializedName("phone")
	private String phone;

	@SerializedName("birth")
	private String birth;

	@SerializedName("gender_digit")
	private String gender_digit;

	@SerializedName("carrier")
	private String carrier;

	@SerializedName("is_mvno")
	private Boolean is_mvno;

	@SerializedName("company")
	private String company;

	@SerializedName("merchant_uid")
	private String merchant_uid;

	@SerializedName("pg")
	private String pg;

	@SerializedName("channel_key")
	private String channel_key;

	@SerializedName("verification_method")
	private String verification_method;

	@SerializedName("bypass")
	private String bypass;

	public OtpRequestData(String name, String phone, String birth, String gender_digit, String carrier, String channel_key) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.gender_digit = gender_digit;
		this.carrier = carrier;
		this.channel_key = channel_key;
	}

	public void setIs_mvno(Boolean is_mvno) {
		this.is_mvno = is_mvno;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}

	public void setPg(String pg) {
		this.pg = pg;
	}

	public void setVerification_method(String verification_method) {
		this.verification_method = verification_method;
	}

	public void setBypass(String bypass) {
		this.bypass = bypass;
	}
}

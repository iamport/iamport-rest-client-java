package com.siot.IamportRestClient.request;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class BenepiaPaymentData {

	@SerializedName("benepia_user")
	private String benepia_user;

	@SerializedName("benepia_password")
	private String benepia_password;

	@SerializedName("benepia_member_code")
	private String benepia_member_code;

	@SerializedName("merchant_uid")
	private String merchant_uid;

	@SerializedName("amount")
	private BigDecimal amount;

	@SerializedName("name")
	private String name;

	@SerializedName("buyer_name")
	private String buyer_name;

	@SerializedName("buyer_email")
	private String buyer_email;

	@SerializedName("buyer_tel")
	private String buyer_tel;

	@SerializedName("buyer_addr")
	private String buyer_addr;

	@SerializedName("buyer_postcode")
	private String buyer_postcode;

	@SerializedName("channel_key")
	private String channel_key;

	@SerializedName("notice_url")
	private String[] notice_url;

	@SerializedName("custom_data")
	private String custom_data;

	public BenepiaPaymentData(String benepia_user, String benepia_password, String merchant_uid, BigDecimal amount, String name, String channel_key) {
		this.benepia_user = benepia_user;
		this.benepia_password = benepia_password;
		this.merchant_uid = merchant_uid;
		this.amount = amount;
		this.name = name;
		this.channel_key = channel_key;
	}

	public void setBenepia_member_code(String benepia_member_code) {
		this.benepia_member_code = benepia_member_code;
	}

	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	public void setBuyer_tel(String buyer_tel) {
		this.buyer_tel = buyer_tel;
	}

	public void setBuyer_addr(String buyer_addr) {
		this.buyer_addr = buyer_addr;
	}

	public void setBuyer_postcode(String buyer_postcode) {
		this.buyer_postcode = buyer_postcode;
	}

	public void setNotice_url(String[] notice_url) {
		this.notice_url = notice_url;
	}

	public void setCustom_data(String custom_data) {
		this.custom_data = custom_data;
	}
}

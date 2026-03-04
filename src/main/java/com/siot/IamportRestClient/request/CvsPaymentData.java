package com.siot.IamportRestClient.request;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class CvsPaymentData {

	@SerializedName("channel_key")
	private String channel_key;

	@SerializedName("merchant_uid")
	private String merchant_uid;

	@SerializedName("amount")
	private BigDecimal amount;

	@SerializedName("barcode")
	private String barcode;

	@SerializedName("expired_at")
	private Integer expired_at;

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

	@SerializedName("confirm_url")
	private String confirm_url;

	@SerializedName("notice_url")
	private String[] notice_url;

	@SerializedName("custom_data")
	private String custom_data;

	public CvsPaymentData(String channel_key, String merchant_uid, BigDecimal amount) {
		this.channel_key = channel_key;
		this.merchant_uid = merchant_uid;
		this.amount = amount;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setExpired_at(Integer expired_at) {
		this.expired_at = expired_at;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setConfirm_url(String confirm_url) {
		this.confirm_url = confirm_url;
	}

	public void setNotice_url(String[] notice_url) {
		this.notice_url = notice_url;
	}

	public void setCustom_data(String custom_data) {
		this.custom_data = custom_data;
	}
}

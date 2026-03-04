package com.siot.IamportRestClient.request;

import com.google.gson.annotations.SerializedName;

public class KcpQuickPaymentData {

	@SerializedName("member_id")
	private String member_id;

	@SerializedName("channel_key")
	private String channel_key;

	@SerializedName("merchant_uid")
	private String merchant_uid;

	@SerializedName("name")
	private String name;

	@SerializedName("amount")
	private int amount;

	@SerializedName("notice_url")
	private String notice_url;

	public KcpQuickPaymentData(String member_id, String channel_key, String merchant_uid, String name, int amount) {
		this.member_id = member_id;
		this.channel_key = channel_key;
		this.merchant_uid = merchant_uid;
		this.name = name;
		this.amount = amount;
	}

	public void setNotice_url(String notice_url) {
		this.notice_url = notice_url;
	}
}

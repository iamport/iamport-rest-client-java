package com.siot.IamportRestClient.request;

import com.google.gson.annotations.SerializedName;

public class BenepiaPointData {

	@SerializedName("benepia_user")
	private String benepia_user;

	@SerializedName("benepia_password")
	private String benepia_password;

	@SerializedName("channel_key")
	private String channel_key;

	public BenepiaPointData(String benepia_user, String benepia_password, String channel_key) {
		this.benepia_user = benepia_user;
		this.benepia_password = benepia_password;
		this.channel_key = channel_key;
	}

	public String getBenepia_user() {
		return benepia_user;
	}

	public String getBenepia_password() {
		return benepia_password;
	}

	public String getChannel_key() {
		return channel_key;
	}
}

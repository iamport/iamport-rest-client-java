package com.siot.IamportRestClient.response;

import com.google.gson.annotations.SerializedName;

public class PgInfo {

	@SerializedName("pg_provider")
	String pg_provider;

	@SerializedName("pg_id")
	String pg_id;

	@SerializedName("sandbox")
	boolean sandbox;

	@SerializedName("type")
	String type;

	@SerializedName("channel_name")
	String channel_name;

	@SerializedName("channel_key")
	String channel_key;

	public String getPgProvider() {
		return pg_provider;
	}

	public String getPgId() {
		return pg_id;
	}

	public boolean isSandbox() {
		return sandbox;
	}

	public String getType() {
		return type;
	}

	public String getChannelName() {
		return channel_name;
	}

	public String getChannelKey() {
		return channel_key;
	}
}

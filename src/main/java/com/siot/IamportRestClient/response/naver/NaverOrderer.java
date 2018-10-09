package com.siot.IamportRestClient.response.naver;

import com.google.gson.annotations.SerializedName;

public class NaverOrderer {

	@SerializedName("name")
	private String name;
	
	@SerializedName("id")
	private String id;
	
	@SerializedName("tel")
	private String tel;

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getTel() {
		return tel;
	}
	
}

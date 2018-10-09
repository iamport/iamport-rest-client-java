package com.siot.IamportRestClient.response.naver;

import com.google.gson.annotations.SerializedName;

public class NaverShippingAddress {

	@SerializedName("base")
	private String base;
	
	@SerializedName("detail")
	private String detail;
	
	@SerializedName("postcode")
	private String postcode;
	
	@SerializedName("tel1")
	private String tel1;
	
	@SerializedName("tel2")
	private String tel2;
	
	@SerializedName("name")
	private String name;

	public String getBase() {
		return base;
	}

	public String getDetail() {
		return detail;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getTel1() {
		return tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public String getName() {
		return name;
	}
	
}

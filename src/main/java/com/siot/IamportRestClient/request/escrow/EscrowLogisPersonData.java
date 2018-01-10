package com.siot.IamportRestClient.request.escrow;

import com.google.gson.annotations.SerializedName;

public class EscrowLogisPersonData {

	@SerializedName("name")
	private String name;
	
	@SerializedName("tel")
	private String tel;
	
	@SerializedName("addr")
	private String addr;
	
	@SerializedName("postcode")
	private String postcode;

	public EscrowLogisPersonData(String name, String tel, String addr, String postcode) {
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.postcode = postcode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}

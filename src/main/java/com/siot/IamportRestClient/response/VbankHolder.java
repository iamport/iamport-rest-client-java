package com.siot.IamportRestClient.response;

import com.google.gson.annotations.SerializedName;

public class VbankHolder {

	@SerializedName("bank_holder")
	String bank_holder;

	public String getBankHolder() {
		return bank_holder;
	}
}

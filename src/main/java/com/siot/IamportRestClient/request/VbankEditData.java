package com.siot.IamportRestClient.request;

import com.google.gson.annotations.SerializedName;

public class VbankEditData {

	@SerializedName("amount")
	private Integer amount;

	@SerializedName("vbank_due")
	private Integer vbank_due;

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setVbank_due(Integer vbank_due) {
		this.vbank_due = vbank_due;
	}
}

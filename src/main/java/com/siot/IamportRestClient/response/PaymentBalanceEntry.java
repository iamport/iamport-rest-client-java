package com.siot.IamportRestClient.response;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class PaymentBalanceEntry {

	@SerializedName("cash_receipt")
	Balance cash_receipt;
	
	@SerializedName("primary")
	Balance primary;
	
	@SerializedName("secondary")
	Balance secondary;
	
	@SerializedName("discount")
	Balance discount;
	
	@SerializedName("created")
	Date created;
	
	public PaymentBalanceEntry(Balance cash_receipt, Balance primary, Balance secondary, Balance discount,
			Date created) {
		super();
		this.cash_receipt = cash_receipt;
		this.primary = primary;
		this.secondary = secondary;
		this.discount = discount;
		this.created = created;
	}

	public Balance getCashReceipt() {
		return cash_receipt;
	}

	public Balance getPrimary() {
		return primary;
	}

	public Balance getSecondary() {
		return secondary;
	}

	public Balance getDiscount() {
		return discount;
	}
	
	public Date getCreated() {
		return created;
	}
	
}

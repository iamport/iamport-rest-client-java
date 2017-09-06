package com.siot.IamportRestClient.response;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class Balance {

	@SerializedName("tax_free")
	BigDecimal tax_free;
	
	@SerializedName("supply")
	BigDecimal supply;
	
	@SerializedName("vat")
	BigDecimal vat;
	
	@SerializedName("service")
	BigDecimal service;

	public BigDecimal getTaxFreeAmt() {
		return tax_free;
	}

	public BigDecimal getSupplyAmt() {
		return supply;
	}

	public BigDecimal getVatAmt() {
		return vat;
	}

	public BigDecimal getServiceAmt() {
		return service;
	}
	
	
	
}

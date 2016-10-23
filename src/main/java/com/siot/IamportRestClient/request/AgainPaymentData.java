package com.siot.IamportRestClient.request;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class AgainPaymentData {

	@SerializedName("customer_uid")
	private String customer_uid;
	
	@SerializedName("merchant_uid")
	private String merchant_uid;
	
	@SerializedName("amount")
	private BigDecimal amount;
	
	@SerializedName("vat")
	private BigDecimal vat;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("buyer_name")
	private String buyer_name;
	
	@SerializedName("buyer_email")
	private String buyer_email;
	
	@SerializedName("buyer_tel")
	private String buyer_tel;
	
	@SerializedName("buyer_addr")
	private String buyer_addr;
	
	@SerializedName("buyer_postcode")
	private String buyer_postcode;
	
	@SerializedName("card_quota")
	private int card_quota;

	public AgainPaymentData(String customer_uid, String merchant_uid, BigDecimal amount) {
		this.customer_uid = customer_uid;
		this.merchant_uid = merchant_uid;
		this.amount = amount;
	}
	
}

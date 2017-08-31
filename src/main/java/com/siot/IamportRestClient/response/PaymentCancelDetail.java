package com.siot.IamportRestClient.response;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class PaymentCancelDetail {

	@SerializedName("pg_tid")
	String pg_tid;
	
	@SerializedName("amount")
	BigDecimal amount;
	
	@SerializedName("cancelled_at")
	long cancelled_at;
	
	@SerializedName("reason")
	String reason;
	
	@SerializedName("receipt_url")
	String receipt_url;

	public String getPgTid() {
		return pg_tid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public long getCancelledAt() {
		return cancelled_at;
	}

	public String getReason() {
		return reason;
	}

	public String getReceiptUrl() {
		return receipt_url;
	}
	
}

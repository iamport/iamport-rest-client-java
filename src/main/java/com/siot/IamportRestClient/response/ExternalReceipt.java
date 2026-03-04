package com.siot.IamportRestClient.response;

import com.google.gson.annotations.SerializedName;

public class ExternalReceipt {

	@SerializedName("merchant_uid")
	String merchant_uid;

	@SerializedName("receipt_tid")
	String receipt_tid;

	@SerializedName("apply_num")
	String apply_num;

	@SerializedName("type")
	String type;

	@SerializedName("amount")
	int amount;

	@SerializedName("vat")
	int vat;

	@SerializedName("receipt_url")
	String receipt_url;

	@SerializedName("applied_at")
	long applied_at;

	@SerializedName("cancelled_at")
	long cancelled_at;

	public String getMerchantUid() {
		return merchant_uid;
	}

	public String getReceiptTid() {
		return receipt_tid;
	}

	public String getApplyNum() {
		return apply_num;
	}

	public String getType() {
		return type;
	}

	public int getAmount() {
		return amount;
	}

	public int getVat() {
		return vat;
	}

	public String getReceiptUrl() {
		return receipt_url;
	}

	public long getAppliedAt() {
		return applied_at;
	}

	public long getCancelledAt() {
		return cancelled_at;
	}
}

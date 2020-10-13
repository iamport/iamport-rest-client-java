package com.siot.IamportRestClient.request;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class CancelData {

	@SerializedName("imp_uid")
	private String imp_uid;
	
	@SerializedName("merchant_uid")
	private String merchant_uid;
	
	@SerializedName("amount")
	private BigDecimal amount;

	@SerializedName("tax_free")
	private BigDecimal tax_free;

	@SerializedName("checksum")
	private BigDecimal checksum;
	
	@SerializedName("reason")
	private String reason;
	
	@SerializedName("refund_holder")
	private String refund_holder;
	
	@SerializedName("refund_bank")
	private String refund_bank;
	
	@SerializedName("refund_account")
	private String refund_account;
	
	@SerializedName("escrow_confirmed")
	private boolean escrow_confirmed;

	@SerializedName("extra")
	private ExtraRequesterEntry extra;
	
	public CancelData(String uid, boolean imp_uid_or_not) {
		if ( imp_uid_or_not ) {
			this.imp_uid = uid;
		} else {
			this.merchant_uid = uid;
		}
	}
	
	public CancelData(String uid, boolean imp_uid_or_not, BigDecimal amount) {
		this(uid, imp_uid_or_not);
		this.amount = amount;
	}

	public void setTax_free(BigDecimal tax_free) {
		this.tax_free = tax_free;
	}

	public void setChecksum(BigDecimal checksum) {
		this.checksum = checksum;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setRefund_holder(String refund_holder) {
		this.refund_holder = refund_holder;
	}

	public void setRefund_bank(String refund_bank) {
		this.refund_bank = refund_bank;
	}

	public void setRefund_account(String refund_account) {
		this.refund_account = refund_account;
	}

	public void setEscrowConfirmed(boolean escrow_confirmed) {
		this.escrow_confirmed = escrow_confirmed;
	}

	public ExtraRequesterEntry getExtra() {
		return extra;
	}

	public void setExtra(ExtraRequesterEntry extra) {
		this.extra = extra;
	}
}

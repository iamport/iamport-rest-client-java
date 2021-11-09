package com.siot.IamportRestClient.response;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Payment {

	@SerializedName("imp_uid")
	String imp_uid;

	@SerializedName("merchant_uid")
	String merchant_uid;

	@SerializedName("pay_method")
	String pay_method;

	@SerializedName("channel")
	String channel;

	@SerializedName("pg_provider")
	String pg_provider;

	@SerializedName("emb_pg_provider")
	String emb_pg_provider;

	@SerializedName("pg_tid")
	String pg_tid;

	@SerializedName("escrow")
	boolean escrow;

	@SerializedName("apply_num")
	String apply_num;

	@SerializedName("bank_code")
	String bank_code;

	@SerializedName("bank_name")
	String bank_name;

	@SerializedName("card_code")
	String card_code;

	@SerializedName("card_name")
	String card_name;

	@SerializedName("card_number")
	String card_number;

	@SerializedName("card_quota")
	int card_quota;

	@SerializedName("card_type")
	int card_type;

	@SerializedName("vbank_code")
	String vbank_code;

	@SerializedName("vbank_name")
	String vbank_name;

	@SerializedName("vbank_num")
	String vbank_num;

	@SerializedName("vbank_holder")
	String vbank_holder;

	@SerializedName("vbank_date")
	long vbank_date;

	@SerializedName("vbank_issued_at")
	long vbank_issued_at;

	@SerializedName("name")
	String name;

	@SerializedName("amount")
	BigDecimal amount;

	@SerializedName("cancel_amount")
	BigDecimal cancel_amount;

	@SerializedName("currency")
	String currency;

	@SerializedName("buyer_name")
	String buyer_name;

	@SerializedName("buyer_email")
	String buyer_email;

	@SerializedName("buyer_tel")
	String buyer_tel;

	@SerializedName("buyer_addr")
	String buyer_addr;

	@SerializedName("buyer_postcode")
	String buyer_postcode;

	@SerializedName("custom_data")
	String custom_data;

	@SerializedName("status")
	String status;

	@SerializedName("started_at")
	long started_at;

	@SerializedName("paid_at")
	long paid_at;

	@SerializedName("failed_at")
	long failed_at;

	@SerializedName("cancelled_at")
	long cancelled_at;

	@SerializedName("fail_reason")
	String fail_reason;

	@SerializedName("cancel_reason")
	String cancel_reason;

	@SerializedName("receipt_url")
	String receipt_url;

	@SerializedName("cancel_history")
	PaymentCancelDetail[] cancel_history;

	@SerializedName("cash_receipt_issued")
	boolean cash_receipt_issued;

	@SerializedName("customer_uid")
	String customer_uid;

	@SerializedName("customer_uid_usage")
	String customer_uid_usage;

	public String getImpUid() {
		return imp_uid;
	}

	public String getMerchantUid() {
		return merchant_uid;
	}

	public String getPayMethod() {
		return pay_method;
	}

	public String getChannel() {
		return channel;
	}

	public String getPgProvider() {
		return pg_provider;
	}

	public String getEmbPgProvider() {
        return emb_pg_provider;
    }

	public String getPgTid() {
		return pg_tid;
	}

	public boolean isEscrow() {
		return escrow;
	}

	public String getApplyNum() {
		return apply_num;
	}

	public String getBankCode() {
		return bank_code;
	}

	public String getBankName() {
		return bank_name;
	}

	public String getCardCode() {
		return card_code;
	}

	public String getCardName() {
		return card_name;
	}

	public String getCardNumber() {
		return card_number;
	}

	public int getCardQuota() {
		return card_quota;
	}

	public int getCardType() {
		return card_type;
	}

	public String getVbankCode() {
		return vbank_code;
	}

	public String getVbankName() {
		return vbank_name;
	}

	public String getVbankNum() {
		return vbank_num;
	}

	public String getVbankHolder() {
		return vbank_holder;
	}

	public Date getVbankDate() {
		return new Date( vbank_date * 1000L );
	}

	public long getVbankIssuedAt() {
		return vbank_issued_at;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getCancelAmount() {
		return cancel_amount;
	}

	public String getCurrency() {
		return currency;
	}

	public String getBuyerName() {
		return buyer_name;
	}

	public String getBuyerEmail() {
		return buyer_email;
	}

	public String getBuyerTel() {
		return buyer_tel;
	}

	public String getBuyerAddr() {
		return buyer_addr;
	}

	public String getBuyerPostcode() {
		return buyer_postcode;
	}

	public String getCustomData() {
		return custom_data;
	}

	public String getStatus() {
		return status;
	}
	public long getStartedAt() {
		return started_at;
	}

	public Date getPaidAt() {
		return new Date( paid_at * 1000L );
	}

	public Date getFailedAt() {
		return new Date( failed_at * 1000L );
	}

	public Date getCancelledAt() {
		return new Date( cancelled_at * 1000L );
	}

	public String getFailReason() {
		return fail_reason;
	}

	public String getCancelReason() {
		return cancel_reason;
	}

	public String getReceiptUrl() {
		return receipt_url;
	}

	public PaymentCancelDetail[] getCancelHistory() {
		return cancel_history;
	}

	public boolean isCashReceiptIssued() {
		return cash_receipt_issued;
	}

	public String getCustomerUid() {
		return customer_uid;
	}

	public String getCustomerUidUsage() {
		return customer_uid_usage;
	}
}

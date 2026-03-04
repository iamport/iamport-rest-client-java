package com.siot.IamportRestClient.request;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class VbankData {

	@SerializedName("channel_key")
	private String channel_key;

	@SerializedName("merchant_uid")
	private String merchant_uid;

	@SerializedName("amount")
	private BigDecimal amount;

	@SerializedName("vbank_code")
	private String vbank_code;

	@SerializedName("vbank_due")
	private long vbank_due;

	@SerializedName("vbank_holder")
	private String vbank_holder;

	@SerializedName("vbank_num")
	private String vbank_num;

	@SerializedName("vbank_key")
	private String vbank_key;

	@SerializedName("product_type")
	private String product_type;

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

	@SerializedName("notice_url")
	private String[] notice_url;

	@SerializedName("custom_data")
	private String custom_data;

	@SerializedName("tax_free")
	private Integer tax_free;

	@SerializedName("vat_amount")
	private BigDecimal vat_amount;

	@SerializedName("business_registration_number")
	private String business_registration_number;

	@SerializedName("product_count")
	private Integer product_count;

	@SerializedName("escrow_password")
	private String escrow_password;

	@SerializedName("fixed_unlimited_vbank")
	private Boolean fixed_unlimited_vbank;

	public VbankData(String channel_key, String merchant_uid, BigDecimal amount, String vbank_code, long vbank_due) {
		this.channel_key = channel_key;
		this.merchant_uid = merchant_uid;
		this.amount = amount;
		this.vbank_code = vbank_code;
		this.vbank_due = vbank_due;
	}

	public void setVbank_holder(String vbank_holder) {
		this.vbank_holder = vbank_holder;
	}

	public void setVbank_num(String vbank_num) {
		this.vbank_num = vbank_num;
	}

	public void setVbank_key(String vbank_key) {
		this.vbank_key = vbank_key;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	public void setBuyer_tel(String buyer_tel) {
		this.buyer_tel = buyer_tel;
	}

	public void setBuyer_addr(String buyer_addr) {
		this.buyer_addr = buyer_addr;
	}

	public void setBuyer_postcode(String buyer_postcode) {
		this.buyer_postcode = buyer_postcode;
	}

	public void setNotice_url(String[] notice_url) {
		this.notice_url = notice_url;
	}

	public void setCustom_data(String custom_data) {
		this.custom_data = custom_data;
	}

	public void setTax_free(Integer tax_free) {
		this.tax_free = tax_free;
	}

	public void setVat_amount(BigDecimal vat_amount) {
		this.vat_amount = vat_amount;
	}

	public void setBusiness_registration_number(String business_registration_number) {
		this.business_registration_number = business_registration_number;
	}

	public void setProduct_count(Integer product_count) {
		this.product_count = product_count;
	}

	public void setEscrow_password(String escrow_password) {
		this.escrow_password = escrow_password;
	}

	public void setFixed_unlimited_vbank(Boolean fixed_unlimited_vbank) {
		this.fixed_unlimited_vbank = fixed_unlimited_vbank;
	}
}

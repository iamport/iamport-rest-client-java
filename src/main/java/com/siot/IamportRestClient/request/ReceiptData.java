package com.siot.IamportRestClient.request;

import com.google.gson.annotations.SerializedName;

public class ReceiptData {

	@SerializedName("identifier")
	private String identifier;

	@SerializedName("identifier_type")
	private String identifier_type;

	@SerializedName("type")
	private String type;

	@SerializedName("buyer_name")
	private String buyer_name;

	@SerializedName("buyer_email")
	private String buyer_email;

	@SerializedName("buyer_tel")
	private String buyer_tel;

	@SerializedName("tax_free")
	private Integer tax_free;

	@SerializedName("vat_amount")
	private Integer vat_amount;

	@SerializedName("product_type")
	private String product_type;

	@SerializedName("company_tel")
	private String company_tel;

	@SerializedName("company_name")
	private String company_name;

	@SerializedName("corp_reg_no")
	private String corp_reg_no;

	public ReceiptData(String identifier) {
		this.identifier = identifier;
	}

	public void setIdentifier_type(String identifier_type) {
		this.identifier_type = identifier_type;
	}

	public void setType(String type) {
		this.type = type;
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

	public void setTax_free(Integer tax_free) {
		this.tax_free = tax_free;
	}

	public void setVat_amount(Integer vat_amount) {
		this.vat_amount = vat_amount;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public void setCompany_tel(String company_tel) {
		this.company_tel = company_tel;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public void setCorp_reg_no(String corp_reg_no) {
		this.corp_reg_no = corp_reg_no;
	}
}

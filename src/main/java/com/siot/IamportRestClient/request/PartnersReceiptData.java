package com.siot.IamportRestClient.request;

import java.math.BigDecimal;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PartnersReceiptData {

	@SerializedName("data")
	private List<PartnerEntry> data;

	public PartnersReceiptData(List<PartnerEntry> data) {
		this.data = data;
	}

	public List<PartnerEntry> getData() {
		return data;
	}

	public static class PartnerEntry {

		@SerializedName("business_registration_number")
		private String business_registration_number;

		@SerializedName("company_name")
		private String company_name;

		@SerializedName("amount")
		private BigDecimal amount;

		@SerializedName("tax_free")
		private BigDecimal tax_free;

		@SerializedName("vat_amount")
		private BigDecimal vat_amount;

		public PartnerEntry(String business_registration_number, String company_name, BigDecimal amount) {
			this.business_registration_number = business_registration_number;
			this.company_name = company_name;
			this.amount = amount;
		}

		public void setTax_free(BigDecimal tax_free) {
			this.tax_free = tax_free;
		}

		public void setVat_amount(BigDecimal vat_amount) {
			this.vat_amount = vat_amount;
		}
	}
}

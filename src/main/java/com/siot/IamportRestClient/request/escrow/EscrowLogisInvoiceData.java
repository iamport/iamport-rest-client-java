package com.siot.IamportRestClient.request.escrow;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class EscrowLogisInvoiceData {

	@SerializedName("company")
	private String company;
	
	@SerializedName("invoice")
	private String invoice;
	
	@SerializedName("sent_at")
	private Date sent_at;

	public EscrowLogisInvoiceData(String company, String invoice, Date sent_at) {
		this.company = company;
		this.invoice = invoice;
		this.sent_at = sent_at;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public void setSentAt(Date sent_at) {
		this.sent_at = sent_at;
	}

	public String getCompany() {
		return company;
	}

	public String getInvoice() {
		return invoice;
	}

	public Date getSentAt() {
		return sent_at;
	}
	
}

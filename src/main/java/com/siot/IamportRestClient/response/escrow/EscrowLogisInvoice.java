package com.siot.IamportRestClient.response.escrow;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class EscrowLogisInvoice {

	@SerializedName("company")
	private String company;
	
	@SerializedName("invoice")
	private String invoice;
	
	@SerializedName("sent_at")
	private Date sent_at;
	
	@SerializedName("applied_at")
	private Date applied_at;

	public EscrowLogisInvoice(String company, String invoice, Date sent_at, Date applied_at) {
		this.company = company;
		this.invoice = invoice;
		this.sent_at = sent_at;
		this.applied_at = applied_at;
	}
	
}

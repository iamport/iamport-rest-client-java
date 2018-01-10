package com.siot.IamportRestClient.request.escrow;

import com.google.gson.annotations.SerializedName;

public class EscrowLogisData {
	
	@SerializedName("sender")
	private EscrowLogisPersonData sender;
	
	@SerializedName("receiver")
	private EscrowLogisPersonData receiver;
	
	@SerializedName("logis")
	private EscrowLogisInvoiceData logis;
	
	public EscrowLogisData() {}

	public EscrowLogisData(EscrowLogisInvoiceData logis, EscrowLogisPersonData receiver) {
		this.receiver = receiver;
		this.logis = logis;
	}

	public EscrowLogisData(EscrowLogisInvoiceData logis, EscrowLogisPersonData receiver, EscrowLogisPersonData sender) {
		this.sender = sender;
		this.receiver = receiver;
		this.logis = logis;
	}

	public void setSender(EscrowLogisPersonData sender) {
		this.sender = sender;
	}

	public void setReceiver(EscrowLogisPersonData receiver) {
		this.receiver = receiver;
	}

	public void setLogis(EscrowLogisInvoiceData logis) {
		this.logis = logis;
	}

}

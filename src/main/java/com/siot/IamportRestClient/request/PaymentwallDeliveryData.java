package com.siot.IamportRestClient.request;

import com.google.gson.annotations.SerializedName;

public class PaymentwallDeliveryData {

	@SerializedName("imp_uid")
	private String imp_uid;

	@SerializedName("merchant_uid")
	private String merchant_uid;

	@SerializedName("type")
	private String type;

	@SerializedName("status")
	private String status;

	@SerializedName("carrier_tracking_id")
	private String carrier_tracking_id;

	@SerializedName("carrier_type")
	private String carrier_type;

	@SerializedName("estimated_delivery_datetime")
	private long estimated_delivery_datetime;

	@SerializedName("estimated_update_datetime")
	private long estimated_update_datetime;

	@SerializedName("reason")
	private String reason;

	@SerializedName("refundable")
	private String refundable;

	@SerializedName("details")
	private String details;

	@SerializedName("shipping_address_email")
	private String shipping_address_email;

	@SerializedName("shipping_address_country")
	private String shipping_address_country;

	@SerializedName("shipping_address_city")
	private String shipping_address_city;

	@SerializedName("shipping_address_zip")
	private String shipping_address_zip;

	@SerializedName("shipping_address_state")
	private String shipping_address_state;

	@SerializedName("shipping_address_street")
	private String shipping_address_street;

	@SerializedName("shipping_address_phone")
	private String shipping_address_phone;

	@SerializedName("shipping_address_firstname")
	private String shipping_address_firstname;

	@SerializedName("shipping_address_lastname")
	private String shipping_address_lastname;

	public PaymentwallDeliveryData(String imp_uid, String merchant_uid, String type, String status,
								   long estimated_delivery_datetime, long estimated_update_datetime,
								   String refundable, String shipping_address_email) {
		this.imp_uid = imp_uid;
		this.merchant_uid = merchant_uid;
		this.type = type;
		this.status = status;
		this.estimated_delivery_datetime = estimated_delivery_datetime;
		this.estimated_update_datetime = estimated_update_datetime;
		this.refundable = refundable;
		this.shipping_address_email = shipping_address_email;
	}

	public void setCarrier_tracking_id(String carrier_tracking_id) {
		this.carrier_tracking_id = carrier_tracking_id;
	}

	public void setCarrier_type(String carrier_type) {
		this.carrier_type = carrier_type;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setShipping_address_country(String shipping_address_country) {
		this.shipping_address_country = shipping_address_country;
	}

	public void setShipping_address_city(String shipping_address_city) {
		this.shipping_address_city = shipping_address_city;
	}

	public void setShipping_address_zip(String shipping_address_zip) {
		this.shipping_address_zip = shipping_address_zip;
	}

	public void setShipping_address_state(String shipping_address_state) {
		this.shipping_address_state = shipping_address_state;
	}

	public void setShipping_address_street(String shipping_address_street) {
		this.shipping_address_street = shipping_address_street;
	}

	public void setShipping_address_phone(String shipping_address_phone) {
		this.shipping_address_phone = shipping_address_phone;
	}

	public void setShipping_address_firstname(String shipping_address_firstname) {
		this.shipping_address_firstname = shipping_address_firstname;
	}

	public void setShipping_address_lastname(String shipping_address_lastname) {
		this.shipping_address_lastname = shipping_address_lastname;
	}
}

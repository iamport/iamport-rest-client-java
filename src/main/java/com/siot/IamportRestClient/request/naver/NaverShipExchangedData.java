package com.siot.IamportRestClient.request.naver;

import com.google.gson.annotations.SerializedName;

public class NaverShipExchangedData {

	public static final String METHOD_DELIVERY        = "DELIVERY";
	public static final String METHOD_GDFW_ISSUE_SVC  = "GDFW_ISSUE_SVC";
	public static final String METHOD_VISIT_RECEIPT   = "VISIT_RECEIPT";
	public static final String METHOD_DIRECT_DELIVERY = "DIRECT_DELIVERY";
	public static final String METHOD_QUICK_SVC       = "QUICK_SVC";
	public static final String METHOD_NOTHING         = "NOTHING";

	@SerializedName("product_order_id")
	private String[] product_order_id;

	@SerializedName("delivery_method")
	private String delivery_method;

	@SerializedName("delivery_company")
	private String delivery_company;

	@SerializedName("tracking_number")
	private String tracking_number;

	public NaverShipExchangedData(String delivery_method) {
		if ( !isValidMethod(delivery_method) )	delivery_method = METHOD_NOTHING;

		this.delivery_method = delivery_method;
	}

	public void setProductOrderId(String[] product_order_id) {
		this.product_order_id = product_order_id;
	}

	public void setDeliveryCompany(String company) {
		this.delivery_company = company;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.tracking_number = trackingNumber;
	}

	private static boolean isValidMethod(String method) {
		return	METHOD_DELIVERY.equals(method) ||
				METHOD_GDFW_ISSUE_SVC.equals(method) ||
				METHOD_VISIT_RECEIPT.equals(method) ||
				METHOD_DIRECT_DELIVERY.equals(method) ||
				METHOD_QUICK_SVC.equals(method) ||
				METHOD_NOTHING.equals(method);
	}

}

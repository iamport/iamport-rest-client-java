package com.siot.IamportRestClient.request.naver;

import com.google.gson.annotations.SerializedName;

public class NaverCancelData {

	public static final String REASON_PRODUCT_UNSATISFIED = "PRODUCT_UNSATISFIED";
	public static final String REASON_DELAYED_DELIVERY    = "DELAYED_DELIVERY";
	public static final String REASON_SOLD_OUT            = "SOLD_OUT";
	
	@SerializedName("product_order_id")
	private String[] product_order_id;
	
	@SerializedName("reason")
	private String reason;

	public NaverCancelData(String reason) {
		if ( !isValidReason(reason) )	reason = REASON_PRODUCT_UNSATISFIED;
		
		this.reason = reason;
	}
	
	public void setProductOrderId(String[] product_order_id) {
		this.product_order_id = product_order_id;
	}
	
	private boolean isValidReason(String reason) {
		return	REASON_PRODUCT_UNSATISFIED.equals(reason) ||
				REASON_DELAYED_DELIVERY.equals(reason)    ||
				REASON_SOLD_OUT.equals(reason);
	}
	
}

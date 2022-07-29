package com.siot.IamportRestClient.request.naver;

import com.google.gson.annotations.SerializedName;

public class NaverCancelData {

	public static final String REASON_SOLD_OUT            = "SOLD_OUT";
	public static final String REASON_DELAYED_DELIVERY    = "DELAYED_DELIVERY";
	public static final String REASON_PRODUCT_UNSATISFIED = "PRODUCT_UNSATISFIED";
	public static final String REASON_INTENT_CHANGED      = "INTENT_CHANGED";
	public static final String REASON_COLOR_AND_SIZE      = "COLOR_AND_SIZE";
	public static final String REASON_WRONG_ORDER         = "WRONG_ORDER";
	public static final String REASON_INCORRECT_INFO      = "INCORRECT_INFO";
	
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
		return	REASON_SOLD_OUT.equals(reason)            ||
				REASON_DELAYED_DELIVERY.equals(reason)    ||
				REASON_PRODUCT_UNSATISFIED.equals(reason) ||
				REASON_INTENT_CHANGED.equals(reason)      ||
				REASON_COLOR_AND_SIZE.equals(reason)      ||
				REASON_WRONG_ORDER.equals(reason)         ||
				REASON_INCORRECT_INFO.equals(reason);
	}
	
}

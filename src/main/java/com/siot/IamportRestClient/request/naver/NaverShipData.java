package com.siot.IamportRestClient.request.naver;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class NaverShipData {
	
	public static final String METHOD_DELIVERY        = "DELIVERY";
	public static final String METHOD_GDFW_ISSUE_SVC  = "GDFW_ISSUE_SVC";
	public static final String METHOD_VISIT_RECEIPT   = "VISIT_RECEIPT";
	public static final String METHOD_DIRECT_DELIVERY = "DIRECT_DELIVERY";
	public static final String METHOD_QUICK_SVC       = "QUICK_SVC";
	public static final String METHOD_NOTHING         = "NOTHING";
	
	public static final String COMPANY_CJGLS          = "CJGLS";
	public static final String COMPANY_KGB            = "KGB";
	public static final String COMPANY_DONGBU         = "DONGBU";
	public static final String COMPANY_EPOST          = "EPOST";
	public static final String COMPANY_REGISTPOST     = "REGISTPOST";
	public static final String COMPANY_HANJIN         = "HANJIN";
	public static final String COMPANY_HYUNDAI        = "HYUNDAI";
	public static final String COMPANY_KGBLS          = "KGBLS";
	public static final String COMPANY_INNOGIS        = "INNOGIS";
	public static final String COMPANY_DAESIN         = "DAESIN";
	public static final String COMPANY_ILYANG         = "ILYANG";
	public static final String COMPANY_KDEXP          = "KDEXP";
	public static final String COMPANY_CHUNIL         = "CHUNIL";
	public static final String COMPANY_CH1            = "CH1";
	public static final String COMPANY_HDEXP          = "HDEXP";
	public static final String COMPANY_CVSNET         = "CVSNET";

	@SerializedName("product_order_id")
	private String[] product_order_id;
	
	@SerializedName("delivery_method")
	private String delivery_method;
	
	@SerializedName("dispatched_at")
	private long dispatched_at;
	
	@SerializedName("delivery_company")
	private String delivery_company;
	
	@SerializedName("tracking_number")
	private String tracking_number;
	
	public NaverShipData(String delivery_method, Date dispatched_at) {
		if ( !isValidMethod(delivery_method) )	delivery_method = METHOD_NOTHING;
		
		this.delivery_method = delivery_method;
		this.dispatched_at = dispatched_at.getTime() / 1000L;
	}
	
	public void setProductOrderId(String[] product_order_id) {
		this.product_order_id = product_order_id;
	}
	
	public void setDeliveryCompany(String company) {
		if ( !isValidCompany(company) )	throw new RuntimeException("지원되지 않는 택배사입니다.");
		
		this.delivery_company = company;
	}
	
	public void setTrackingNumber(String trackingNumber) {
		this.tracking_number = trackingNumber;
	}
	
	private boolean isValidMethod(String method) {
		return	METHOD_DELIVERY.equals(method) ||
				METHOD_GDFW_ISSUE_SVC.equals(method) ||
				METHOD_VISIT_RECEIPT.equals(method) ||
				METHOD_DIRECT_DELIVERY.equals(method) ||
				METHOD_QUICK_SVC.equals(method) ||
				METHOD_NOTHING.equals(method);
	}
	
	private boolean isValidCompany(String company) {
		return	COMPANY_CJGLS.equals(company) ||
				COMPANY_KGB.equals(company) ||
				COMPANY_DONGBU.equals(company) ||
				COMPANY_EPOST.equals(company) ||
				COMPANY_REGISTPOST.equals(company) ||
				COMPANY_HANJIN.equals(company) ||
				COMPANY_HYUNDAI.equals(company) ||
				COMPANY_KGBLS.equals(company) ||
				COMPANY_INNOGIS.equals(company) ||
				COMPANY_DAESIN.equals(company) ||
				COMPANY_ILYANG.equals(company) ||
				COMPANY_KDEXP.equals(company) ||
				COMPANY_CHUNIL.equals(company) ||
				COMPANY_CH1.equals(company) ||
				COMPANY_HDEXP.equals(company) ||
				COMPANY_CVSNET.equals(company);
	}
	
}

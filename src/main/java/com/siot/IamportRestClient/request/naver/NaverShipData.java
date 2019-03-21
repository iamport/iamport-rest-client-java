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
	
	public static final String COMPANY_CJGLS          = "CJGLS"; //CJ 대한통운
	public static final String COMPANY_KGB            = "KGB"; //로젠택배
	public static final String COMPANY_DONGBU         = "DONGBU"; //KG 로지스
	public static final String COMPANY_EPOST          = "EPOST"; //우체국택배
	public static final String COMPANY_REGISTPOST     = "REGISTPOST"; //우편등기
	public static final String COMPANY_HANJIN         = "HANJIN"; //한진택배
	public static final String COMPANY_HYUNDAI        = "HYUNDAI"; //현대택배
	public static final String COMPANY_KGBLS          = "KGBLS"; //KGB 택배
	public static final String COMPANY_INNOGIS        = "INNOGIS"; //GTX 로지스
	public static final String COMPANY_DAESIN         = "DAESIN"; //대신택배
	public static final String COMPANY_ILYANG         = "ILYANG"; //일양로지스
	public static final String COMPANY_KDEXP          = "KDEXP"; //경동택배
	public static final String COMPANY_CHUNIL         = "CHUNIL"; //천일택배
	public static final String COMPANY_CH1            = "CH1"; //기타 택배
	public static final String COMPANY_HDEXP          = "HDEXP"; //합동택배
	public static final String COMPANY_CVSNET         = "CVSNET"; //편의점택배
	public static final String COMPANY_DHL            = "DHL"; //DHL
	public static final String COMPANY_FEDEX          = "FEDEX"; //FEDEX
	public static final String COMPANY_GSMNTON        = "GSMNTON"; //GSMNTON
	public static final String COMPANY_WARPEX         = "WARPEX"; //WarpEx
	public static final String COMPANY_WIZWA          = "WIZWA"; //WIZWA
	public static final String COMPANY_EMS            = "EMS"; //EMS
	public static final String COMPANY_DHLDE          = "DHLDE"; //DHL(독일)
	public static final String COMPANY_ACIEXPRESS     = "ACIEXPRESS"; //ACI
	public static final String COMPANY_EZUSA          = "EZUSA"; //EZUSA
	public static final String COMPANY_PANTOS         = "PANTOS"; //범한판토스
	public static final String COMPANY_UPS            = "UPS"; //UPS
	public static final String COMPANY_HLCGLOBAL      = "HLCGLOBAL"; //현대택배(국제택배)
	public static final String COMPANY_KOREXG         = "KOREXG"; //CJ 대한통운(국제택배)
	public static final String COMPANY_TNT            = "TNT"; //TNT
	public static final String COMPANY_SWGEXP         = "SWGEXP"; //성원글로벌
	public static final String COMPANY_DAEWOON        = "DAEWOON"; //대운글로벌
	public static final String COMPANY_USPS           = "USPS"; //USPS
	public static final String COMPANY_IPARCEL        = "IPARCEL"; //i-parcel
	public static final String COMPANY_KUNYOUNG       = "KUNYOUNG"; //건영택배
	public static final String COMPANY_HPL            = "HPL"; //한의사랑택배
	public static final String COMPANY_DADREAM        = "DADREAM"; //다드림
	public static final String COMPANY_SLX            = "SLX"; //SLX 택배
	public static final String COMPANY_SFEXPRESS      = "SFEXPRESS"; //순풍택배
	public static final String COMPANY_HONAM          = "HONAM"; //호남택배

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

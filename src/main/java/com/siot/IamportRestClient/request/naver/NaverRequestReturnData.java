package com.siot.IamportRestClient.request.naver;

import com.google.gson.annotations.SerializedName;

public class NaverRequestReturnData {

    public static final String REASON_INTENT_CHANGED = "INTENT_CHANGED"; // 구매 의사 취소
    public static final String REASON_COLOR_AND_SIZE = "COLOR_AND_SIZE"; // 색상 및 사이즈 변경
    public static final String REASON_WRONG_ORDER = "WRONG_ORDER"; // 다른 상품 잘못 주문
    public static final String REASON_PRODUCT_UNSATISFIED = "PRODUCT_UNSATISFIED"; // 서비스 및 상품 불만족
    public static final String REASON_DELAYED_DELIVERY = "DELAYED_DELIVERY"; // 배송 지연
    public static final String REASON_SOLD_OUT = "SOLD_OUT"; // 상품 품절
    public static final String REASON_DROPPED_DELIVERY = "DROPPED_DELIVERY"; // 배송 누락
    public static final String REASON_BROKEN = "BROKEN"; // 상품 파손
    public static final String REASON_INCORRECT_INFO = "INCORRECT_INFO"; // 상품정보상이
    public static final String REASON_WRONG_DELIVERY = "WRONG_DELIVERY"; // 오배송
    public static final String REASON_WRONG_OPTION = "WRONG_OPTION"; // 색상 등이 다른 상품을 잘못 배송


    public static final String DELIVERY_METHOD_RETURN_DESIGNATED = "RETURN_DESIGNATED"; // 지정 반품 택배(판매자 측에서 택배접수는 미리 해준 경우)
    public static final String DELIVERY_METHOD_RETURN_DELIVERY = "RETURN_DELIVERY"; // 일반 반품 택배
    public static final String DELIVERY_METHOD_RETURN_INDIVIDUAL = "RETURN_INDIVIDUAL"; // 직접 반송


    public static final String DELIVERY_COMPANY_CJGLS = "CJGLS"; // CJ 대한통운
    public static final String DELIVERY_COMPANY_KGB = "KGB"; // 로젠택배
    public static final String DELIVERY_COMPANY_DONGBU = "DONGBU"; // KG 로지스
    public static final String DELIVERY_COMPANY_EPOST = "EPOST"; // 우체국택배
    public static final String DELIVERY_COMPANY_REGISTPOST = "REGISTPOST"; // 우편등기
    public static final String DELIVERY_COMPANY_HANJIN = "HANJIN"; // 한진택배
    public static final String DELIVERY_COMPANY_HYUNDAI = "HYUNDAI"; // 현대택배
    public static final String DELIVERY_COMPANY_KGBLS = "KGBLS"; // KGB 택배
    public static final String DELIVERY_COMPANY_INNOGIS = "INNOGIS"; // GTX 로지스
    public static final String DELIVERY_COMPANY_DAESIN = "DAESIN"; // 대신택배
    public static final String DELIVERY_COMPANY_ILYANG = "ILYANG"; // 일양로지스
    public static final String DELIVERY_COMPANY_KDEXP = "KDEXP"; // 경동택배
    public static final String DELIVERY_COMPANY_CHUNIL = "CHUNIL"; // 천일택배
    public static final String DELIVERY_COMPANY_CH1 = "CH1"; // 기타 택배
    public static final String DELIVERY_COMPANY_HDEXP = "HDEXP"; // 합동택배
    public static final String DELIVERY_COMPANY_CVSNET = "CVSNET"; // 편의점택배
    public static final String DELIVERY_COMPANY_DHL = "DHL"; // DHL
    public static final String DELIVERY_COMPANY_FEDEX = "FEDEX"; // FEDEX
    public static final String DELIVERY_COMPANY_GSMNTON = "GSMNTON"; // GSMNTON
    public static final String DELIVERY_COMPANY_WARPEX = "WARPEX"; // WarpEx
    public static final String DELIVERY_COMPANY_WIZWA = "WIZWA"; // WIZWA
    public static final String DELIVERY_COMPANY_EMS = "EMS"; // EMS
    public static final String DELIVERY_COMPANY_DHLDE = "DHLDE"; // DHL(독일)
    public static final String DELIVERY_COMPANY_ACIEXPRESS = "ACIEXPRESS"; // ACI
    public static final String DELIVERY_COMPANY_EZUSA = "EZUSA"; // EZUSA
    public static final String DELIVERY_COMPANY_PANTOS = "PANTOS"; // 범한판토스
    public static final String DELIVERY_COMPANY_UPS = "UPS"; // UPS
    public static final String DELIVERY_COMPANY_HLCGLOBAL = "HLCGLOBAL"; // 현대택배(국제택배)
    public static final String DELIVERY_COMPANY_KOREXG = "KOREXG"; // CJ 대한통운(국제택배)
    public static final String DELIVERY_COMPANY_TNT = "TNT"; // TNT
    public static final String DELIVERY_COMPANY_SWGEXP = "SWGEXP"; // 성원글로벌
    public static final String DELIVERY_COMPANY_DAEWOON = "DAEWOON"; // 대운글로벌
    public static final String DELIVERY_COMPANY_USPS = "USPS"; // USPS
    public static final String DELIVERY_COMPANY_IPARCEL = "IPARCEL"; // i-parcel
    public static final String DELIVERY_COMPANY_KUNYOUNG = "KUNYOUNG"; // 건영택배
    public static final String DELIVERY_COMPANY_HPL = "HPL"; // 한의사랑택배
    public static final String DELIVERY_COMPANY_DADREAM = "DADREAM"; // 다드림
    public static final String DELIVERY_COMPANY_SLX = "SLX"; // SLX 택배
    public static final String DELIVERY_COMPANY_SFEXPRESS = "SFEXPRESS"; // 순풍택배
    public static final String DELIVERY_COMPANY_HONAM = "HONAM"; // 호남택배

    @SerializedName("product_order_id")
    private String[] product_order_id;

    @SerializedName("reason")
    private String reason;

    @SerializedName("delivery_method")
    private String delivery_method;

    @SerializedName("delivery_company")
    private String delivery_company;

    @SerializedName("tracking_number")
    private String tracking_number;

    public NaverRequestReturnData(String delivery_method) {
        this(NaverRequestReturnData.REASON_INTENT_CHANGED, delivery_method);
    }

    public NaverRequestReturnData(String reason, String delivery_method) {
        this.reason = reason;
        this.delivery_method = delivery_method;
    }

    public void setProductOrderId(String[] product_order_id) {
        this.product_order_id = product_order_id;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDeliveryMethod(String delivery_method) {
        this.delivery_method = delivery_method;
    }

    public void setDeliveryCompany(String delivery_company) {
        this.delivery_company = delivery_company;
    }

    public void setTrackingNumber(String tracking_number) {
        this.tracking_number = tracking_number;
    }
}

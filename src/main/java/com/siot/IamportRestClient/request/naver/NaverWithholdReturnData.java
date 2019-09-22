package com.siot.IamportRestClient.request.naver;

import com.google.gson.annotations.SerializedName;

public class NaverWithholdReturnData {

    public static final String REASON_RETURN_DELIVERYFEE = "RETURN_DELIVERYFEE"; // 반품 배송비 청구
    public static final String REASON_EXTRAFEEE = "EXTRAFEEE"; // 기타 반품 비용 청구
    public static final String REASON_RETURN_DELIVERYFEE_AND_EXTRAFEEE = "RETURN_DELIVERYFEE_AND_EXTRAFEEE"; // 반품 배송비 및 기타 반품 비용 청구
    public static final String REASON_RETURN_PRODUCT_NOT_DELIVERED = "RETURN_PRODUCT_NOT_DELIVERED"; // 반품 상품 미입고
    public static final String REASON_ETC = "ETC"; // 기타 사유

    @SerializedName("product_order_id")
    private String[] product_order_id;

    @SerializedName("reason")
    private String reason;

    @SerializedName("memo")
    private String memo;

    @SerializedName("extra_charge")
    private int extra_charge;

    public NaverWithholdReturnData(String memo) {
        this.memo = memo;
    }

    public void setProductOrderId(String[] product_order_id) {
        this.product_order_id = product_order_id;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setExtraCharge(int extra_charge) {
        this.extra_charge = extra_charge;
    }
}

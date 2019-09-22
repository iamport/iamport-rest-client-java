package com.siot.IamportRestClient.request.naver;

import com.google.gson.annotations.SerializedName;

public class NaverApproveReturnData {

    @SerializedName("product_order_id")
    private String[] product_order_id;

    @SerializedName("extra_charge")
    private int extra_charge;

    @SerializedName("memo")
    private String memo;

    public void setProductOrderId(String[] product_order_id) {
        this.product_order_id = product_order_id;
    }

    public void setExtraCharge(int extra_charge) {
        this.extra_charge = extra_charge;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}

package com.siot.IamportRestClient.request.naver;

import com.google.gson.annotations.SerializedName;

public class NaverRejectReturnData {

    @SerializedName("product_order_id")
    private String[] product_order_id;

    @SerializedName("memo")
    private String memo;

    public NaverRejectReturnData(String memo) {
        this.memo = memo;
    }

    public void setProductOrderId(String[] product_order_id) {
        this.product_order_id = product_order_id;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}

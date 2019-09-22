package com.siot.IamportRestClient.request.naver;

import com.google.gson.annotations.SerializedName;

public class NaverResolveReturnData {

    @SerializedName("product_order_id")
    private String[] product_order_id;

    public void setProductOrderId(String[] product_order_id) {
        this.product_order_id = product_order_id;
    }

}

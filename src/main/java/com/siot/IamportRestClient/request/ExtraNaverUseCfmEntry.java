package com.siot.IamportRestClient.request;

import com.google.gson.annotations.SerializedName;

public class ExtraNaverUseCfmEntry {

    @SerializedName("naverUseCfm")
    private String naverUseCfm;

    public ExtraNaverUseCfmEntry(String naverUseCfm) {
        this.naverUseCfm = naverUseCfm;
    }

    public String getNaverUseCfm() {
        return naverUseCfm;
    }
}

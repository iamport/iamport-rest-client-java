package com.siot.IamportRestClient.request;

import java.math.BigDecimal;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AgainPaymentData {

    @SerializedName("customer_uid")
    private String customer_uid;

    @SerializedName("merchant_uid")
    private String merchant_uid;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("vat")
    private BigDecimal vat;

    @SerializedName("currency")
    private String currency;

    @SerializedName("name")
    private String name;

    @SerializedName("buyer_name")
    private String buyer_name;

    @SerializedName("buyer_email")
    private String buyer_email;

    @SerializedName("buyer_tel")
    private String buyer_tel;

    @SerializedName("buyer_addr")
    private String buyer_addr;

    @SerializedName("buyer_postcode")
    private String buyer_postcode;

    @SerializedName("browser_ip")
    private String browser_ip;

    @SerializedName("card_quota")
    private int card_quota;

    @SerializedName("extra")
    private ExtraNaverUseCfmEntry extra;

    public AgainPaymentData(String customer_uid, String merchant_uid, BigDecimal amount) {
        this.customer_uid = customer_uid;
        this.merchant_uid = merchant_uid;
        this.amount = amount;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuyerName() {
        return buyer_name;
    }

    public void setBuyerName(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String getBuyerEmail() {
        return buyer_email;
    }

    public void setBuyerEmail(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public String getBuyerTel() {
        return buyer_tel;
    }

    public void setBuyerTel(String buyer_tel) {
        this.buyer_tel = buyer_tel;
    }

    public String getBuyerAddr() {
        return buyer_addr;
    }

    public void setBuyerAddr(String buyer_addr) {
        this.buyer_addr = buyer_addr;
    }

    public String getBuyerPostcode() {
        return buyer_postcode;
    }

    public void setBuyerPostcode(String buyer_postcode) {
        this.buyer_postcode = buyer_postcode;
    }

    public int getCardQuota() {
        return card_quota;
    }

    public void setCardQuota(int card_quota) {
        this.card_quota = card_quota;
    }

    public ExtraNaverUseCfmEntry getExtra() {
        return extra;
    }

    public void setExtra(ExtraNaverUseCfmEntry extra) {
        this.extra = extra;
    }

    public void setBrowser_ip(String browser_ip) {
        this.browser_ip = browser_ip;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

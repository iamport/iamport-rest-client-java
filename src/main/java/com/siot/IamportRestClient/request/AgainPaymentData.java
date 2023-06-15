package com.siot.IamportRestClient.request;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class AgainPaymentData {

    @SerializedName("customer_uid")
    private String customer_uid;

    @SerializedName("merchant_uid")
    private String merchant_uid;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("tax_free")
    private BigDecimal tax_free;

    @SerializedName("vat")
    private BigDecimal vat;

    @SerializedName("vat_amount")
    private BigDecimal vat_amount;

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

    @SerializedName("interest_free_by_merchant")
    private boolean interest_free_by_merchant;

    @SerializedName("use_card_point")
    private boolean use_card_point;

    @SerializedName("custom_data")
    private String custom_data;

    @SerializedName("notice_url")
    private String notice_url;

    @SerializedName("product_type")
    private String product_type;

    @SerializedName("product_count")
    private int product_count;

    @SerializedName("bypass")
    private String bypass;

    public AgainPaymentData(String customer_uid, String merchant_uid, BigDecimal amount) {
        this.customer_uid = customer_uid;
        this.merchant_uid = merchant_uid;
        this.amount = amount;
    }

    public BigDecimal getTaxFree() {
        return tax_free;
    }

    public void setTaxFree(BigDecimal tax_free) {
        this.tax_free = tax_free;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getVatAmount() {
        return vat_amount;
    }

    public void setVatAmount(BigDecimal vat_amount) {
        this.vat_amount = vat_amount;
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

    public String getBrowser_ip() {
        return browser_ip;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setInterestFreeByMerchant(boolean interest_free_by_merchant) {
        this.interest_free_by_merchant = interest_free_by_merchant;
    }

    public boolean getInterestFreeByMerchant() {
        return interest_free_by_merchant;
    }

    public void setUseCardPoint(boolean use_card_point) {
        this.use_card_point = use_card_point;
    }

    public boolean getUseCardPoint() {
        return use_card_point;
    }

    public void setCustomData(String custom_data) {
        this.custom_data = custom_data;
    }

    public String getCustomData() {
        return custom_data;
    }

    public void setNoticeUrl(String notice_url) {
        this.notice_url = notice_url;
    }

    public String getNoticeUrl() {
        return notice_url;
    }

    public void setProductType(String product_type) {
        this.product_type = product_type;
    }

    public String getProductType() {
        return product_type;
    }

    public void setProductCount(int product_count) {
        this.product_count = product_count;
    }

    public int getProductCount() {
        return product_count;
    }

    public void setBypass(String bypass) {
        this.bypass = bypass;
    }

    public String getBypass() {
        return bypass;
    }
}

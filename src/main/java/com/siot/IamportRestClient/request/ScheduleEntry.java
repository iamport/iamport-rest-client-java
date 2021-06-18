package com.siot.IamportRestClient.request;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class ScheduleEntry {

    @SerializedName("merchant_uid")
    private String merchant_uid;

    @SerializedName("schedule_at")
    private Date schedule_at;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("tax_free")
    private BigDecimal tax_free;

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

    @SerializedName("custom_data")
    private String custom_data;

    @SerializedName("notice_url")
    private String notice_url;

    public ScheduleEntry(String merchant_uid, Date schedule_at, BigDecimal amount) {
        this.merchant_uid = merchant_uid;
        this.schedule_at = schedule_at;
        this.amount = amount;
    }

    public void setMerchantUid(String merchant_uid) {
        this.merchant_uid = merchant_uid;
    }

    public void setScheduleAt(Date schedule_at) {
        this.schedule_at = schedule_at;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTaxFree(BigDecimal tax_free) {
        this.tax_free = tax_free;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuyerName(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public void setBuyerEmail(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public void setBuyerTel(String buyer_tel) {
        this.buyer_tel = buyer_tel;
    }

    public void setBuyerAddr(String buyer_addr) {
        this.buyer_addr = buyer_addr;
    }

    public void setBuyerPostcode(String buyer_postcode) {
        this.buyer_postcode = buyer_postcode;
    }

    public void setCustomData(String custom_data) {
        this.custom_data = custom_data;
    }

    public void setNoticeUrl(String notice_url) {
        this.notice_url = notice_url;
    }

    public String getMerchantUid() {
        return merchant_uid;
    }

    public Date getScheduleAt() {
        return schedule_at;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getTaxFree() {
        return tax_free;
    }

    public String getName() {
        return name;
    }

    public String getBuyerName() {
        return buyer_name;
    }

    public String getBuyerEmail() {
        return buyer_email;
    }

    public String getBuyerTel() {
        return buyer_tel;
    }

    public String getBuyerAddr() {
        return buyer_addr;
    }

    public String getBuyerPostcode() {
        return buyer_postcode;
    }

    public String getCustomData() {
        return custom_data;
    }

    public String getNoticeUrl() {
        return notice_url;
    }
}

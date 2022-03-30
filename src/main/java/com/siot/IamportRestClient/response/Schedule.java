package com.siot.IamportRestClient.response;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Schedule {

    @SerializedName("customer_uid")
    private String customer_uid;

    @SerializedName("merchant_uid")
    private String merchant_uid;

    @SerializedName("imp_uid")
    private String imp_uid;

    @SerializedName("schedule_at")
    private Date schedule_at;

    @SerializedName("executed_at")
    private Date executed_at;

    @SerializedName("revoked_at")
    private Date revoked_at;

    @SerializedName("amount")
    private BigDecimal amount;

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
    @SerializedName("schedule_status")
    private String schedule_status;
    @SerializedName("payment_status")
    private String payment_status;
    @SerializedName("fail_reason")
    private String fail_reason;

    public Schedule(String customer_uid, String merchant_uid, String imp_uid, Date schedule_at, Date executed_at, Date revoked_at, BigDecimal amount, String name, String buyer_name, String buyer_email, String buyer_tel, String buyer_addr, String buyer_postcode, String custom_data, String schedule_status, String payment_status, String fail_reason) {
        this.customer_uid = customer_uid;
        this.merchant_uid = merchant_uid;
        this.imp_uid = imp_uid;
        this.schedule_at = schedule_at;
        this.executed_at = executed_at;
        this.revoked_at = revoked_at;
        this.amount = amount;
        this.name = name;
        this.buyer_name = buyer_name;
        this.buyer_email = buyer_email;
        this.buyer_tel = buyer_tel;
        this.buyer_addr = buyer_addr;
        this.buyer_postcode = buyer_postcode;
        this.custom_data = custom_data;
        this.schedule_status = schedule_status;
        this.payment_status = payment_status;
        this.fail_reason = fail_reason;
    }

    public Schedule(String customer_uid, String merchant_uid, Date schedule_at, BigDecimal amount) {
        this.customer_uid = customer_uid;
        this.merchant_uid = merchant_uid;
        this.schedule_at = schedule_at;
        this.amount = amount;
    }

    public String getCustomerUid() {
        return customer_uid;
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

    public String getCustomer_uid() {
        return customer_uid;
    }

    public void setCustomer_uid(String customer_uid) {
        this.customer_uid = customer_uid;
    }

    public String getMerchant_uid() {
        return merchant_uid;
    }

    public void setMerchant_uid(String merchant_uid) {
        this.merchant_uid = merchant_uid;
    }

    public String getImp_uid() {
        return imp_uid;
    }

    public void setImp_uid(String imp_uid) {
        this.imp_uid = imp_uid;
    }

    public Date getSchedule_at() {
        return schedule_at;
    }

    public void setSchedule_at(Date schedule_at) {
        this.schedule_at = schedule_at;
    }

    public Date getExecuted_at() {
        return executed_at;
    }

    public void setExecuted_at(Date executed_at) {
        this.executed_at = executed_at;
    }

    public Date getRevoked_at() {
        return revoked_at;
    }

    public void setRevoked_at(Date revoked_at) {
        this.revoked_at = revoked_at;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String getBuyer_email() {
        return buyer_email;
    }

    public void setBuyer_email(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public String getBuyer_tel() {
        return buyer_tel;
    }

    public void setBuyer_tel(String buyer_tel) {
        this.buyer_tel = buyer_tel;
    }

    public String getBuyer_addr() {
        return buyer_addr;
    }

    public void setBuyer_addr(String buyer_addr) {
        this.buyer_addr = buyer_addr;
    }

    public String getBuyer_postcode() {
        return buyer_postcode;
    }

    public void setBuyer_postcode(String buyer_postcode) {
        this.buyer_postcode = buyer_postcode;
    }

    public String getCustom_data() {
        return custom_data;
    }

    public void setCustom_data(String custom_data) {
        this.custom_data = custom_data;
    }

    public String getSchedule_status() {
        return schedule_status;
    }

    public void setSchedule_status(String schedule_status) {
        this.schedule_status = schedule_status;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getFail_reason() {
        return fail_reason;
    }

    public void setFail_reason(String fail_reason) {
        this.fail_reason = fail_reason;
    }
}

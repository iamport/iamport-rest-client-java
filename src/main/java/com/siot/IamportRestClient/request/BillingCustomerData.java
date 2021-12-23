package com.siot.IamportRestClient.request;

import com.google.gson.annotations.SerializedName;

public class BillingCustomerData {

    @SerializedName("pg")
    private String pg;

    @SerializedName("card_number")
    private String card_number;

    @SerializedName("expiry")
    private String expiry;

    @SerializedName("birth")
    private String birth;

    @SerializedName("pwd_2digit")
    private String pwd_2digit;

    @SerializedName("cvc")
    private String cvc;

    @SerializedName("customer_name")
    private String customer_name;

    @SerializedName("customer_tel")
    private String customer_tel;

    @SerializedName("customer_email")
    private String customer_email;

    @SerializedName("customer_addr")
    private String customer_addr;

    @SerializedName("customer_postcode")
    private String customer_postcode;

    public BillingCustomerData(String customer_uid, String card_number, String expiry, String birth) {
        this.card_number = card_number;
        this.expiry = expiry;
        this.birth = birth;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public void setCardNumber(String card_number) {
        this.card_number = card_number;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setPwd2Digit(String pwd_2digit) {
        this.pwd_2digit = pwd_2digit;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public void setCustomerName(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomerTel(String customer_tel) {
        this.customer_tel = customer_tel;
    }

    public void setCustomerEmail(String customer_email) {
        this.customer_email = customer_email;
    }

    public void setCustomerAddr(String customer_addr) {
        this.customer_addr = customer_addr;
    }

    public void setCustomerPostcode(String customer_postcode) {
        this.customer_postcode = customer_postcode;
    }

    public String getPg() {
        return pg;
    }

    public String getCardNumber() {
        return card_number;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getBirth() {
        return birth;
    }

    public String getPwd2Digit() {
        return pwd_2digit;
    }

    public String getCvc() {
        return cvc;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public String getCustomerTel() {
        return customer_tel;
    }

    public String getCustomerEmail() {
        return customer_email;
    }

    public String getCustomerAddr() {
        return customer_addr;
    }

    public String getCustomerPostcode() {
        return customer_postcode;
    }
}

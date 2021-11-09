package com.siot.IamportRestClient.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class BillingCustomer {

    @SerializedName("customer_uid")
    String customer_uid;

    @SerializedName("pg_provider")
    String pg_provider;

    @SerializedName("pg_id")
    String pg_id;

    @SerializedName("card_name")
    String card_name;

    @SerializedName("card_code")
    String card_code;

    @SerializedName("card_number")
    String card_number;

    @SerializedName("card_type")
    String card_type;

    @SerializedName("customer_name")
    String customer_name;

    @SerializedName("customer_tel")
    String customer_tel;

    @SerializedName("customer_email")
    String customer_email;

    @SerializedName("customer_addr")
    String customer_addr;

    @SerializedName("customer_postcode")
    String customer_postcode;

    @SerializedName("inserted")
    long inserted;

    @SerializedName("updated")
    long updated;

    public String getCustomerUid() {
        return customer_uid;
    }

    public String getPgProvider() {
        return pg_provider;
    }

    public String getPgId() {
        return pg_id;
    }

    public String getCardName() {
        return card_name;
    }

    public String getCardCode() {
        return card_code;
    }

    public String getCardNumber() {
        return card_number;
    }

    public String getCardType() {
        return card_type;
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

    public Date getInserted() {
        return new Date( inserted * 1000L );
    }

    public Date getUpdated() {
        return new Date( updated * 1000L );
    }
}

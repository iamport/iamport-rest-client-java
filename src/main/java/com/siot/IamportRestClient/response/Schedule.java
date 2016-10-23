package com.siot.IamportRestClient.response;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Schedule {

	@SerializedName("customer_uid")
	private String customer_uid;
	
	@SerializedName("merchant_uid")
	private String merchant_uid;
	
	@SerializedName("schedule_at")
	private Date schedule_at;
	
	@SerializedName("amount")
	private BigDecimal amount;

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
	
}

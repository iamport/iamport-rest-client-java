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

	public ScheduleEntry(String merchant_uid, Date schedule_at, BigDecimal amount) {
		this.merchant_uid = merchant_uid;
		this.schedule_at = schedule_at;
		this.amount = amount;
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

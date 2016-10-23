package com.siot.IamportRestClient.request;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class UnscheduleData {

	@SerializedName("customer_uid")
	private String customer_uid;
	
	@SerializedName("merchant_uid")
	private List<String> merchant_uids;
	
	public UnscheduleData(String customer_uid) {
		this.customer_uid = customer_uid;
		this.merchant_uids = new ArrayList<String>();
	}
	
	public void addMerchantUid(String merchant_uid) {
		this.merchant_uids.add(merchant_uid);
	}
	
	public List<String> getMerchantUidList() {
		return this.merchant_uids;
	}
	
}

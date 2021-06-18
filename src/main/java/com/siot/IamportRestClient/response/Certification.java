package com.siot.IamportRestClient.response;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Certification {

	@SerializedName("imp_uid")
	String imp_uid;
	
	@SerializedName("merchant_uid")
	String merchant_uid;
	
	@SerializedName("pg_tid")
	String pg_tid;
	
	@SerializedName("pg_provider")
	String pg_provider;
	
	@SerializedName("name")
	String name;
	
	@SerializedName("gender")
	String gender;
	
	@SerializedName("birth")
	int birth;

	@SerializedName("phone")
	String phone;

	@SerializedName("carrier")
	String carrier;
	
	@SerializedName("certified")
	boolean certified;
	
	@SerializedName("certified_at")
	long certified_at;
	
	@SerializedName("unique_key")
	String unique_key;
	
	@SerializedName("unique_in_site")
	String unique_in_site;

	@SerializedName("origin")
	String origin;

	public String getImpUid() {
		return imp_uid;
	}

	public String getMerchantUid() {
		return merchant_uid;
	}

	public String getPgTid() {
		return pg_tid;
	}

	public String getPgProvider() {
		return pg_provider;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public Date getBirth() {
		return new Date( birth * 1000L );
	}

	public String getPhone() { return phone; }

	public String getCarrier() { return carrier; }

	public boolean isCertified() {
		return certified;
	}

	public Date getCertifiedAt() {
		return new Date( certified_at * 1000L );
	}

	public String getUniqueKey() {
		return unique_key;
	}

	public String getUniqueInSite() {
		return unique_in_site;
	}

	public String getOrigin() {
		return origin;
	}
}

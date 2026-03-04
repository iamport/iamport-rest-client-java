package com.siot.IamportRestClient.response.naver;

import com.google.gson.annotations.SerializedName;

public class NaverCashAmount {

	@SerializedName("amount_total")
	int amount_total;

	@SerializedName("amount_by_npoint")
	int amount_by_npoint;

	@SerializedName("amount_by_primary")
	int amount_by_primary;

	@SerializedName("amount_supply")
	int amount_supply;

	@SerializedName("amount_vat")
	int amount_vat;

	public int getAmountTotal() {
		return amount_total;
	}

	public int getAmountByNpoint() {
		return amount_by_npoint;
	}

	public int getAmountByPrimary() {
		return amount_by_primary;
	}

	public int getAmountSupply() {
		return amount_supply;
	}

	public int getAmountVat() {
		return amount_vat;
	}
}

package com.siot.IamportRestClient.request;

public final class CardInfo {

	String card_number;
	String expiry;
	String birth;
	String pwd_2digit;
	String cvc;

	public CardInfo(String card_number, String expiry, String birth, String pwd_2digit) {
		this.card_number = card_number;
		this.expiry = expiry;
		this.birth = birth;
		this.pwd_2digit = pwd_2digit;
	}

	public CardInfo(String card_number, String expiry, String birth, String pwd_2digit, String cvc) {
		this.card_number = card_number;
		this.expiry = expiry;
		this.birth = birth;
		this.pwd_2digit = pwd_2digit;
		this.cvc = cvc;
	}
}

package com.siot.IamportRestClient;

import java.io.IOException;

import com.siot.IamportRestClient.request.AuthData;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.Payment;
import com.siot.IamportRestClient.response.IamportResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IamportClient {

	private static final String API_URL = "https://api.iamport.kr";
//	private static final String API_URL = "http://localhost";
	private String api_key = null;
	private String api_secret = null;
	private Iamport iamport = null;
	
	public IamportClient(String api_key, String api_secret) {
		this.api_key = api_key;
		this.api_secret = api_secret;
		this.iamport = this.create();
	}
	
	public IamportResponse<AccessToken> getAuth() {
		Call<IamportResponse<AccessToken>> call = this.iamport.token( new AuthData(this.api_key, this.api_secret) );
		try {
			Response<IamportResponse<AccessToken>> response = call.execute();
			if ( response.isSuccessful() ) {
				return response.body();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public IamportResponse<Payment> paymentByImpUid(String imp_uid) {
		AccessToken auth = getAuth().getResponse();
		if ( auth != null ) {
			Call<IamportResponse<Payment>> call = this.iamport.payment_by_imp_uid(auth.getToken(), imp_uid);
			
			try {
				Response<IamportResponse<Payment>> response = call.execute();
				if ( response.isSuccessful() ) {
					return response.body();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public IamportResponse<Payment> cancelPaymentByImpUid(CancelData cancel_data) {
		AccessToken auth = getAuth().getResponse();
		if ( auth != null ) {
			Call<IamportResponse<Payment>> call = this.iamport.cancel_payment(auth.getToken(), cancel_data);
			
			try {
				Response<IamportResponse<Payment>> response = call.execute();
				if ( response.isSuccessful() ) {
					return response.body();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	private Iamport create() {
		Retrofit retrofit = new Retrofit.Builder()
								.baseUrl(API_URL)
								.addConverterFactory(GsonConverterFactory.create())
								.build();
		
		return retrofit.create(Iamport.class);
	}
	
}

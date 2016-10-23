package com.siot.IamportRestClient;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.siot.IamportRestClient.request.AgainPaymentData;
import com.siot.IamportRestClient.request.AuthData;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.request.OnetimePaymentData;
import com.siot.IamportRestClient.request.ScheduleData;
import com.siot.IamportRestClient.request.ScheduleEntry;
import com.siot.IamportRestClient.request.UnscheduleData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.siot.IamportRestClient.response.Schedule;
import com.siot.IamportRestClient.serializer.ScheduleEntrySerializer;

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
	
	public IamportResponse<Payment> onetimePayment(OnetimePaymentData onetime_data) {
		AccessToken auth = getAuth().getResponse();
		if ( auth != null ) {
			Call<IamportResponse<Payment>> call = this.iamport.onetime_payment(auth.getToken(), onetime_data);
			
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
	
	public IamportResponse<Payment> againPayment(AgainPaymentData again_data) {
		AccessToken auth = getAuth().getResponse();
		if ( auth != null ) {
			Call<IamportResponse<Payment>> call = this.iamport.again_payment(auth.getToken(), again_data);
			
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
	
	public IamportResponse<List<Schedule>> subscribeSchedule(ScheduleData schedule_data) {
		AccessToken auth = getAuth().getResponse();
		if ( auth != null ) {
			Call<IamportResponse<List<Schedule>>> call = this.iamport.schedule_subscription(auth.getToken(), schedule_data);
			
			try {
				Response<IamportResponse<List<Schedule>>> response = call.execute();
				if ( response.isSuccessful() ) {
					return response.body();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public IamportResponse<List<Schedule>> unsubscribeSchedule(UnscheduleData unschedule_data) {
		AccessToken auth = getAuth().getResponse();
		if ( auth != null ) {
			Call<IamportResponse<List<Schedule>>> call = this.iamport.unschedule_subscription(auth.getToken(), unschedule_data);
			
			try {
				Response<IamportResponse<List<Schedule>>> response = call.execute();
				if ( response.isSuccessful() ) {
					return response.body();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	protected Iamport create() {
		Retrofit retrofit = new Retrofit.Builder()
								.baseUrl(API_URL)
								.addConverterFactory(buildGsonConverter())
								.build();
		
		return retrofit.create(Iamport.class);
	}
	
	protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Adding custom deserializers
        gsonBuilder.registerTypeAdapter(ScheduleEntry.class, new ScheduleEntrySerializer());
        gsonBuilder.registerTypeAdapter(Schedule.class, new ScheduleEntrySerializer());
        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }
	
}

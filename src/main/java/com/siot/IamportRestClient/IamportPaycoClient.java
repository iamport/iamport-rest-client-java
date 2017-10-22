package com.siot.IamportRestClient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.siot.IamportRestClient.request.payco.OrderStatusData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.payco.OrderStatus;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IamportPaycoClient extends IamportClient {

	private PaycoImpl paycoImpl;
	
	public IamportPaycoClient(String api_key, String api_secret) {
		super(api_key, api_secret);
		this.paycoImpl = this.createImpl();
	}
	
	private PaycoImpl createImpl() {
		OkHttpClient client = new OkHttpClient.Builder()
									.readTimeout(30, TimeUnit.SECONDS)
									.connectTimeout(10, TimeUnit.SECONDS)
									.build();
		
		Retrofit retrofit = new Retrofit.Builder()
								.baseUrl(API_URL)
								.addConverterFactory(GsonConverterFactory.create())
								.client(client)
								.build();
		
		return retrofit.create(PaycoImpl.class);
	}
	
	public IamportResponse<OrderStatus> updateOrderStatus(String impUid, String status) {
		AccessToken auth = getAuth().getResponse();
		if ( auth != null ) {
			
			Call<IamportResponse<OrderStatus>> call = this.paycoImpl.updateStatus(auth.getToken(), impUid, new OrderStatusData(status));
			
			try {
				Response<IamportResponse<OrderStatus>> response = call.execute();
				if ( response.isSuccessful() ) {
					return response.body();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}

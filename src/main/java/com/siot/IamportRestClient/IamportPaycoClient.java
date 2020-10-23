package com.siot.IamportRestClient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.payco.OrderStatusData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.payco.OrderStatus;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IamportPaycoClient extends IamportClient {

	private PaycoImpl paycoImpl;

	public IamportPaycoClient(String api_key, String api_secret) {
		super(api_key, api_secret);
		this.paycoImpl = this.createImpl(false);
	}

	public IamportPaycoClient(String api_key, String api_secret, boolean useStaticIP) {
		super(api_key, api_secret, useStaticIP);
		this.paycoImpl = this.createImpl(useStaticIP);
	}

	private PaycoImpl createImpl(boolean useStaticIP) {
		OkHttpClient client = new OkHttpClient.Builder()
									.readTimeout(30, TimeUnit.SECONDS)
									.connectTimeout(10, TimeUnit.SECONDS)
									.build();

		Retrofit retrofit = new Retrofit.Builder()
								.baseUrl(useStaticIP ? STATIC_API_URL:API_URL)
								.addConverterFactory(GsonConverterFactory.create())
								.client(client)
								.build();

		return retrofit.create(PaycoImpl.class);
	}

	public IamportResponse<OrderStatus> updateOrderStatus(String impUid, String status) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<OrderStatus>> call = this.paycoImpl.updateStatus(auth.getToken(), impUid, new OrderStatusData(status));

		Response<IamportResponse<OrderStatus>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

}

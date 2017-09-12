package com.siot.IamportRestClient;

import com.siot.IamportRestClient.request.payco.OrderStatusData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.payco.OrderStatus;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PaycoImpl {

	@POST("/payco/orders/status/{imp_uid}")
	Call<IamportResponse<OrderStatus>> updateStatus(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body OrderStatusData statusData
	);
	
}

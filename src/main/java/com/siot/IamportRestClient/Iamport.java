package com.siot.IamportRestClient;

import java.util.List;

import com.siot.IamportRestClient.request.AgainPaymentData;
import com.siot.IamportRestClient.request.AuthData;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.request.OnetimePaymentData;
import com.siot.IamportRestClient.request.ScheduleData;
import com.siot.IamportRestClient.request.UnscheduleData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.Payment;
import com.siot.IamportRestClient.response.Schedule;
import com.siot.IamportRestClient.response.IamportResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Iamport {

	@POST("/users/getToken")
	Call<IamportResponse<AccessToken>> token(
		@Body AuthData auth);
	
	@GET("/payments/{imp_uid}")
    Call<IamportResponse<Payment>> payment_by_imp_uid(
    	@Header("Authorization") String token,
        @Path("imp_uid") String imp_uid
    );
	
	@POST("/payments/cancel")
	Call<IamportResponse<Payment>> cancel_payment(
		@Header("Authorization") String token,
		@Body CancelData cancel_data
	);
	
	@POST("/subscribe/payments/onetime")
	Call<IamportResponse<Payment>> onetime_payment(
		@Header("Authorization") String token,
		@Body OnetimePaymentData onetime_data
	);
	
	@POST("/subscribe/payments/again")
	Call<IamportResponse<Payment>> again_payment(
		@Header("Authorization") String token,
		@Body AgainPaymentData again_data
	);
	
	@POST("/subscribe/payments/schedule")
	Call<IamportResponse<List<Schedule>>> schedule_subscription(
		@Header("Authorization") String token,
		@Body ScheduleData schedule_data
	);
	
	@POST("/subscribe/payments/unschedule")
	Call<IamportResponse<List<Schedule>>> unschedule_subscription(
		@Header("Authorization") String token,
		@Body UnscheduleData unschedule_data
	);
}

package com.siot.IamportRestClient;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.AgainPaymentData;
import com.siot.IamportRestClient.request.AuthData;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.request.OnetimePaymentData;
import com.siot.IamportRestClient.request.ScheduleData;
import com.siot.IamportRestClient.request.ScheduleEntry;
import com.siot.IamportRestClient.request.UnscheduleData;
import com.siot.IamportRestClient.request.escrow.EscrowLogisData;
import com.siot.IamportRestClient.request.escrow.EscrowLogisInvoiceData;
import com.siot.IamportRestClient.request.naver.*;
import com.siot.IamportRestClient.response.*;
import com.siot.IamportRestClient.response.escrow.EscrowLogisInvoice;
import com.siot.IamportRestClient.response.naver.NaverProductOrder;
import com.siot.IamportRestClient.response.naver.NaverReview;
import com.siot.IamportRestClient.serializer.BalanceEntrySerializer;
import com.siot.IamportRestClient.serializer.EscrowInvoiceEntrySerializer;
import com.siot.IamportRestClient.serializer.ScheduleEntrySerializer;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IamportClient {

	public static final String API_URL = "https://api.iamport.kr";
	protected String api_key = null;
	protected String api_secret = null;
	protected String tier_code = null;
	protected Iamport iamport = null;

	public IamportClient(String api_key, String api_secret) {
		this.api_key = api_key;
		this.api_secret = api_secret;
		this.iamport = this.create();
	}

	public IamportClient(String api_key, String api_secret, String tier_code) {
		this(api_key, api_secret);
		this.tier_code = tier_code;
	}

	public void setTierCode(String tier_code) {
		this.tier_code = tier_code;
	}

	public IamportResponse<AccessToken> getAuth() throws IamportResponseException, IOException {
		Call<IamportResponse<AccessToken>> call = this.iamport.token( new AuthData(this.api_key, this.api_secret) );
		Response<IamportResponse<AccessToken>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<PaymentBalance> paymentBalanceByImpUid(String imp_uid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<PaymentBalance>> call = this.iamport.balance_by_imp_uid(auth.getToken(), imp_uid);

		Response<IamportResponse<PaymentBalance>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> paymentByImpUid(String imp_uid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.payment_by_imp_uid(auth.getToken(), imp_uid);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<PagedDataList<Payment>> paymentsByStatus(String status) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<PagedDataList<Payment>>> call = this.iamport.payments_by_status(auth.getToken(), status);

		Response<IamportResponse<PagedDataList<Payment>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> cancelPaymentByImpUid(CancelData cancel_data) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.cancel_payment(auth.getToken(), cancel_data);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> onetimePayment(OnetimePaymentData onetime_data) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.onetime_payment(auth.getToken(), onetime_data);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> againPayment(AgainPaymentData again_data) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.again_payment(auth.getToken(), again_data);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<Schedule>> subscribeSchedule(ScheduleData schedule_data) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<Schedule>>> call = this.iamport.schedule_subscription(auth.getToken(), schedule_data);

		Response<IamportResponse<List<Schedule>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<Schedule>> unsubscribeSchedule(UnscheduleData unschedule_data) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<Schedule>>> call = this.iamport.unschedule_subscription(auth.getToken(), unschedule_data);

		Response<IamportResponse<List<Schedule>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* 본인인증 */
	public IamportResponse<Certification> certificationByImpUid(String imp_uid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Certification>> call = this.iamport.certification_by_imp_uid(auth.getToken(), imp_uid);

		Response<IamportResponse<Certification>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* 에스크로 배송처리 */
	public IamportResponse<EscrowLogisInvoice> postEscrowLogis(String imp_uid, EscrowLogisData logis_data) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<EscrowLogisInvoice>> call = this.iamport.post_escrow_logis(auth.getToken(), imp_uid, logis_data);

		Response<IamportResponse<EscrowLogisInvoice>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<BillingCustomer> getBillingCustomer(String customerUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<BillingCustomer>> call = this.iamport.get_billing_customer(auth.getToken(), customerUid);

		Response<IamportResponse<BillingCustomer>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* 네이버페이 관련 API */
	public IamportResponse<List<NaverProductOrder>> naverProductOrders(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = this.iamport.naver_product_orders(auth.getToken(), impUid);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<NaverProductOrder> naverProductOrderSingle(String productOrderId) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<NaverProductOrder>> call = this.iamport.naver_single_product_order(auth.getToken(), productOrderId);

		Response<IamportResponse<NaverProductOrder>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverReview>> naverReviews() throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverReview>>> call = this.iamport.naver_reviews(auth.getToken());

		Response<IamportResponse<List<NaverReview>>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverProductOrder>> naverCancelOrders(String impUid, NaverCancelData cancelData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = iamport.naver_cancel(auth.getToken(), impUid, cancelData);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverProductOrder>> naverShippingOrders(String impUid, NaverShipData shippingData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = iamport.naver_ship(auth.getToken(), impUid, shippingData);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverProductOrder>> naverPlaceOrders(String impUid, NaverPlaceData placeData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = iamport.naver_place(auth.getToken(), impUid, placeData);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverProductOrder>> naverRequestReturnOrders(String impUid, NaverRequestReturnData requestReturnData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = iamport.naver_request_return(auth.getToken(), impUid, requestReturnData);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverProductOrder>> naverApproveReturnOrders(String impUid, NaverApproveReturnData approveReturnData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = iamport.naver_approve_return(auth.getToken(), impUid, approveReturnData);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverProductOrder>> naverRejectReturnOrders(String impUid, NaverRejectReturnData rejectReturnData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = iamport.naver_reject_return(auth.getToken(), impUid, rejectReturnData);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverProductOrder>> naverWithholdReturnOrders(String impUid, NaverWithholdReturnData withholdReturnData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = iamport.naver_withhold_return(auth.getToken(), impUid, withholdReturnData);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverProductOrder>> naverResolveReturnOrders(String impUid, NaverResolveReturnData resolveReturnData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = iamport.naver_resolve_return(auth.getToken(), impUid, resolveReturnData);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	protected Iamport create() {
		OkHttpClient client = new OkHttpClient.Builder()
				.readTimeout(30, TimeUnit.SECONDS)
				.connectTimeout(10, TimeUnit.SECONDS)
				.addInterceptor(new Interceptor() { //Tier Header
					public okhttp3.Response intercept(Chain chain) throws IOException {
						Request request = chain.request();

						if (IamportClient.this.tier_code != null) {
							request = request.newBuilder().addHeader("Tier", IamportClient.this.tier_code).build();
						}

						return chain.proceed(request);
					}
				})
				.build();

		Retrofit retrofit = new Retrofit.Builder()
								.baseUrl(API_URL)
								.addConverterFactory(buildGsonConverter())
								.client(client)
								.build();

		return retrofit.create(Iamport.class);
	}

	protected GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Adding custom deserializers
        Object escrowInvoiceStrategy = new EscrowInvoiceEntrySerializer();

        gsonBuilder.registerTypeAdapter(ScheduleEntry.class, new ScheduleEntrySerializer());
        gsonBuilder.registerTypeAdapter(Schedule.class, new ScheduleEntrySerializer());
        gsonBuilder.registerTypeAdapter(PaymentBalanceEntry.class, new BalanceEntrySerializer());
        gsonBuilder.registerTypeAdapter(EscrowLogisInvoiceData.class, escrowInvoiceStrategy);
        gsonBuilder.registerTypeAdapter(EscrowLogisInvoice.class, escrowInvoiceStrategy);

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }

	protected String getExceptionMessage(Response<?> response) {
		String error = null;
		try {
			JsonElement element = new JsonParser().parse(response.errorBody().string());
			error = element.getAsJsonObject().get("message").getAsString();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if ( error == null )	error = response.message();

		return error;
	}

}

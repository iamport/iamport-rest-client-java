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
import com.siot.IamportRestClient.request.*;
import com.siot.IamportRestClient.request.escrow.EscrowLogisData;
import com.siot.IamportRestClient.request.escrow.EscrowLogisInvoiceData;
import com.siot.IamportRestClient.request.naver.*;
import com.siot.IamportRestClient.response.*;
import com.siot.IamportRestClient.response.escrow.EscrowLogisInvoice;
import com.siot.IamportRestClient.response.naver.NaverCashAmount;
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
	public static final String STATIC_API_URL = "https://static-api.iamport.kr";
	protected String apiKey;
	protected String apiSecret;
	protected String tierCode = null;
	protected Iamport iamport = null;

	public IamportClient(String apiKey, String apiSecret) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.iamport = this.create(false);
	}

	public IamportClient(String apiKey, String apiSecret, boolean useStaticIP) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.iamport = this.create(useStaticIP);
	}

	public IamportClient(String apiKey, String apiSecret, String tierCode) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.tierCode = tierCode;
		this.iamport = this.create(false);
	}

	public IamportClient(String apiKey, String apiSecret, String tierCode, boolean useStaticIP) {
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.tierCode = tierCode;
		this.iamport = this.create(useStaticIP);
	}

	public void setTierCode(String tier_code) {
		this.tierCode = tier_code;
	}

	public IamportResponse<AccessToken> getAuth() throws IamportResponseException, IOException {
		Call<IamportResponse<AccessToken>> call = this.iamport.token( new AuthData(this.apiKey, this.apiSecret) );
		Response<IamportResponse<AccessToken>> response = call.execute();

		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<PaymentBalance> paymentBalanceByImpUid(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<PaymentBalance>> call = this.iamport.balance_by_imp_uid(auth.getToken(), impUid);

		Response<IamportResponse<PaymentBalance>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> paymentByImpUid(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.payment_by_imp_uid(auth.getToken(), impUid, false);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> paymentByImpUid(String impUid, boolean includeSandbox) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.payment_by_imp_uid(auth.getToken(), impUid, includeSandbox);

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

	public IamportResponse<Payment> cancelPaymentByImpUid(CancelData cancelData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.cancel_payment(auth.getToken(), cancelData);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Prepare> postPrepare(PrepareData prepareData) throws IOException, IamportResponseException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Prepare>> call = this.iamport.post_prepare(auth.getToken(), prepareData);

		Response<IamportResponse<Prepare>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Prepare> getPrepare(String merchantUid) throws IOException, IamportResponseException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Prepare>> call = this.iamport.get_prepare(auth.getToken(), merchantUid);

		Response<IamportResponse<Prepare>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<BillingCustomer> deleteBillingCustomer(String customerUid, String reason, String extra) throws IOException, IamportResponseException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<BillingCustomer>> call = this.iamport.delete_billing_customer(auth.getToken(), customerUid, reason, extra);

		Response<IamportResponse<BillingCustomer>> response = call.execute();
		if( !response.isSuccessful() ) throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<BillingCustomer> postBillingCustomer(String customerUid, BillingCustomerData billingData) throws IOException, IamportResponseException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<BillingCustomer>> call = this.iamport.post_billing_customer(auth.getToken(), customerUid, billingData);

		Response<IamportResponse<BillingCustomer>> response = call.execute();
		if( !response.isSuccessful() ) throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> onetimePayment(OnetimePaymentData onetimeData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.onetime_payment(auth.getToken(), onetimeData);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> againPayment(AgainPaymentData againData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.again_payment(auth.getToken(), againData);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<ScheduleList> getPaymentSchedule(GetScheduleData getScheduleData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<ScheduleList>> call = this.iamport.get_payment_schedule(auth.getToken(),
				getScheduleData.getSchedule_from(),
				getScheduleData.getSchedule_to(),
				getScheduleData.getSchedule_status(),
				getScheduleData.getPage(),
				getScheduleData.getLimit()
		);

		Response<IamportResponse<ScheduleList>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<Schedule>> subscribeSchedule(ScheduleData scheduleData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<Schedule>>> call = this.iamport.schedule_subscription(auth.getToken(), scheduleData);

		Response<IamportResponse<List<Schedule>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<Schedule>> unsubscribeSchedule(UnscheduleData unscheduleData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<Schedule>>> call = this.iamport.unschedule_subscription(auth.getToken(), unscheduleData);

		Response<IamportResponse<List<Schedule>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* 본인인증 */
	public IamportResponse<Certification> certificationByImpUid(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Certification>> call = this.iamport.certification_by_imp_uid(auth.getToken(), impUid);

		Response<IamportResponse<Certification>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* 에스크로 배송처리 */
	public IamportResponse<EscrowLogisInvoice> postEscrowLogis(String impUid, EscrowLogisData logisData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<EscrowLogisInvoice>> call = this.iamport.post_escrow_logis(auth.getToken(), impUid, logisData);

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

	public IamportResponse<EmptyResponse> naverConfirmOrders(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<EmptyResponse>> call = iamport.naver_confirm(auth.getToken(), impUid);

		Response<IamportResponse<EmptyResponse>> response = call.execute();

		if( !response.isSuccessful() ) throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

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

	public IamportResponse<EmptyResponse> naverPoint(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<EmptyResponse>> call = iamport.naver_point(auth.getToken(), impUid);

		Response<IamportResponse<EmptyResponse>> response = call.execute();

		if( !response.isSuccessful() ) throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* PAYMENTS (additional) */
	public IamportResponse<List<Payment>> paymentsByImpUid(List<String> impUids) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<Payment>>> call = this.iamport.payments_by_imp_uid(auth.getToken(), impUids);

		Response<IamportResponse<List<Payment>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> paymentByMerchantUid(String merchantUid, String paymentStatus) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.payment_by_merchant_uid(auth.getToken(), merchantUid, paymentStatus);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<PagedDataList<Payment>> paymentsByMerchantUid(String merchantUid, String paymentStatus) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<PagedDataList<Payment>>> call = this.iamport.payments_by_merchant_uid(auth.getToken(), merchantUid, paymentStatus);

		Response<IamportResponse<PagedDataList<Payment>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Prepare> putPrepare(PrepareData prepareData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Prepare>> call = this.iamport.put_prepare(auth.getToken(), prepareData);

		Response<IamportResponse<Prepare>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* CERTIFICATIONS (additional) */
	public IamportResponse<Certification> deleteCertification(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Certification>> call = this.iamport.delete_certification(auth.getToken(), impUid);

		Response<IamportResponse<Certification>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Certification> otpRequest(OtpRequestData otpData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Certification>> call = this.iamport.otp_request(auth.getToken(), otpData);

		Response<IamportResponse<Certification>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Certification> otpConfirm(String impUid, OtpConfirmData otpData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Certification>> call = this.iamport.otp_confirm(auth.getToken(), impUid, otpData);

		Response<IamportResponse<Certification>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* CODES */
	public IamportResponse<List<StandardCode>> allBankCodes() throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<StandardCode>>> call = this.iamport.all_bank_codes(auth.getToken());

		Response<IamportResponse<List<StandardCode>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<StandardCode> bankCode(String code) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<StandardCode>> call = this.iamport.bank_code(auth.getToken(), code);

		Response<IamportResponse<StandardCode>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<StandardCode>> allCardCodes() throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<StandardCode>>> call = this.iamport.all_card_codes(auth.getToken());

		Response<IamportResponse<List<StandardCode>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<StandardCode> cardCode(String code) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<StandardCode>> call = this.iamport.card_code(auth.getToken(), code);

		Response<IamportResponse<StandardCode>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* ESCROW (additional) */
	public IamportResponse<EscrowLogisInvoice> getEscrowLogis(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<EscrowLogisInvoice>> call = this.iamport.get_escrow_logis(auth.getToken(), impUid);

		Response<IamportResponse<EscrowLogisInvoice>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<EscrowLogisInvoice> putEscrowLogis(String impUid, EscrowLogisData logisData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<EscrowLogisInvoice>> call = this.iamport.put_escrow_logis(auth.getToken(), impUid, logisData);

		Response<IamportResponse<EscrowLogisInvoice>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* SUBSCRIBE (additional) */
	public IamportResponse<Schedule> getScheduleByMerchantUid(String merchantUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Schedule>> call = this.iamport.get_schedule_by_merchant_uid(auth.getToken(), merchantUid);

		Response<IamportResponse<Schedule>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Schedule> putScheduleByMerchantUid(String merchantUid, ScheduleUpdateData updateData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Schedule>> call = this.iamport.put_schedule_by_merchant_uid(auth.getToken(), merchantUid, updateData);

		Response<IamportResponse<Schedule>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> retrySchedule(String merchantUid, ScheduleRetryData retryData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.retry_schedule(auth.getToken(), merchantUid, retryData);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Schedule> rescheduleSchedule(String merchantUid, ScheduleRescheduleData rescheduleData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Schedule>> call = this.iamport.reschedule_schedule(auth.getToken(), merchantUid, rescheduleData);

		Response<IamportResponse<Schedule>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<ScheduleList> getScheduleByCustomerUid(String customerUid, int page, int scheduleFrom, int scheduleTo, String scheduleStatus) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<ScheduleList>> call = this.iamport.get_schedule_by_customer_uid(auth.getToken(), customerUid, page, scheduleFrom, scheduleTo, scheduleStatus);

		Response<IamportResponse<ScheduleList>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* SUBSCRIBE.CUSTOMER (additional) */
	public IamportResponse<List<BillingCustomer>> getBillingCustomers(List<String> customerUids) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<BillingCustomer>>> call = this.iamport.get_billing_customers(auth.getToken(), customerUids);

		Response<IamportResponse<List<BillingCustomer>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<PagedDataList<Payment>> getCustomerPayments(String customerUid, int page) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<PagedDataList<Payment>>> call = this.iamport.get_customer_payments(auth.getToken(), customerUid, page);

		Response<IamportResponse<PagedDataList<Payment>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<ScheduleList> getCustomerSchedules(String customerUid, int page, int scheduleFrom, int scheduleTo, String scheduleStatus) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<ScheduleList>> call = this.iamport.get_customer_schedules(auth.getToken(), customerUid, page, scheduleFrom, scheduleTo, scheduleStatus);

		Response<IamportResponse<ScheduleList>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* BENEPIA */
	public IamportResponse<BenepiaPoint> benepiaPoint(BenepiaPointData pointData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<BenepiaPoint>> call = this.iamport.benepia_point(auth.getToken(), pointData);

		Response<IamportResponse<BenepiaPoint>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> benepiaPayment(BenepiaPaymentData paymentData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.benepia_payment(auth.getToken(), paymentData);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* CVS */
	public IamportResponse<Payment> issueCvsPayment(CvsPaymentData cvsData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.issue_cvs_payment(auth.getToken(), cvsData);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> revokeCvsPayment(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.revoke_cvs_payment(auth.getToken(), impUid);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* KCPQUICK */
	public IamportResponse<EmptyResponse> deleteKcpQuickMember(String memberId) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<EmptyResponse>> call = this.iamport.delete_kcpquick_member(auth.getToken(), memberId);

		Response<IamportResponse<EmptyResponse>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> payKcpQuickMoney(KcpQuickPaymentData paymentData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.pay_kcpquick_money(auth.getToken(), paymentData);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* NAVER (additional) */
	public IamportResponse<NaverCashAmount> naverCashAmount(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<NaverCashAmount>> call = this.iamport.naver_cash_amount(auth.getToken(), impUid);

		Response<IamportResponse<NaverCashAmount>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverProductOrder>> naverApproveCancel(String impUid, NaverApproveCancelData data) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = this.iamport.naver_approve_cancel(auth.getToken(), impUid, data);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverProductOrder>> naverCollectExchanged(String impUid, NaverCollectExchangedData data) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = this.iamport.naver_collect_exchanged(auth.getToken(), impUid, data);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<List<NaverProductOrder>> naverShipExchanged(String impUid, NaverShipExchangedData data) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<NaverProductOrder>>> call = this.iamport.naver_ship_exchanged(auth.getToken(), impUid, data);

		Response<IamportResponse<List<NaverProductOrder>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* PARTNERS */
	public IamportResponse<EmptyResponse> partnerReceipt(String impUid, PartnersReceiptData receiptData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<EmptyResponse>> call = this.iamport.partner_receipt(auth.getToken(), impUid, receiptData);

		Response<IamportResponse<EmptyResponse>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* PAYMENTWALL */
	public IamportResponse<EmptyResponse> paymentwallDelivery(PaymentwallDeliveryData deliveryData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<EmptyResponse>> call = this.iamport.paymentwall_delivery(auth.getToken(), deliveryData);

		Response<IamportResponse<EmptyResponse>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* RECEIPTS */
	public IamportResponse<Receipt> getReceipt(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Receipt>> call = this.iamport.get_receipt(auth.getToken(), impUid);

		Response<IamportResponse<Receipt>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Receipt> issueReceipt(String impUid, ReceiptData receiptData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Receipt>> call = this.iamport.issue_receipt(auth.getToken(), impUid, receiptData);

		Response<IamportResponse<Receipt>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Receipt> revokeReceipt(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Receipt>> call = this.iamport.revoke_receipt(auth.getToken(), impUid);

		Response<IamportResponse<Receipt>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<ExternalReceipt> getExternalReceipt(String merchantUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<ExternalReceipt>> call = this.iamport.get_external_receipt(auth.getToken(), merchantUid);

		Response<IamportResponse<ExternalReceipt>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<ExternalReceipt> issueExternalReceipt(String merchantUid, ExternalReceiptData receiptData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<ExternalReceipt>> call = this.iamport.issue_external_receipt(auth.getToken(), merchantUid, receiptData);

		Response<IamportResponse<ExternalReceipt>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<ExternalReceipt> revokeExternalReceipt(String merchantUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<ExternalReceipt>> call = this.iamport.revoke_external_receipt(auth.getToken(), merchantUid);

		Response<IamportResponse<ExternalReceipt>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* TIERS */
	public IamportResponse<TierInfo> getTier(String tierCode) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<TierInfo>> call = this.iamport.get_tier(auth.getToken(), tierCode);

		Response<IamportResponse<TierInfo>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* USERS */
	public IamportResponse<List<PgInfo>> getPgSettings() throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<List<PgInfo>>> call = this.iamport.get_pg_settings(auth.getToken());

		Response<IamportResponse<List<PgInfo>>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	/* VBANKS */
	public IamportResponse<Payment> createVbank(VbankData vbankData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.create_vbank(auth.getToken(), vbankData);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<VbankHolder> getVbankHolder(String bankCode, String bankNum) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<VbankHolder>> call = this.iamport.get_vbank_holder(auth.getToken(), bankCode, bankNum);

		Response<IamportResponse<VbankHolder>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> modifyVbank(String impUid, VbankEditData vbankData) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.modify_vbank(auth.getToken(), impUid, vbankData);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	public IamportResponse<Payment> revokeVbank(String impUid) throws IamportResponseException, IOException {
		AccessToken auth = getAuth().getResponse();
		Call<IamportResponse<Payment>> call = this.iamport.revoke_vbank(auth.getToken(), impUid);

		Response<IamportResponse<Payment>> response = call.execute();
		if ( !response.isSuccessful() )	throw new IamportResponseException( getExceptionMessage(response), new HttpException(response) );

		return response.body();
	}

	protected Iamport create(boolean useStaticIP) {
		OkHttpClient client = new OkHttpClient.Builder()
				.readTimeout(30, TimeUnit.SECONDS)
				.connectTimeout(10, TimeUnit.SECONDS)
				.addInterceptor(new Interceptor() { //Tier Header
					public okhttp3.Response intercept(Chain chain) throws IOException {
						Request request = chain.request();

						if (IamportClient.this.tierCode != null) {
							request = request.newBuilder().addHeader("Tier", IamportClient.this.tierCode).build();
						}

						return chain.proceed(request);
					}
				})
				.build();

		Retrofit retrofit = new Retrofit.Builder()
								.baseUrl(useStaticIP ? STATIC_API_URL:API_URL)
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
		} catch (JsonSyntaxException | IOException e) {
			e.printStackTrace();
		}

        if ( error == null )	error = response.message();

		return error;
	}

}

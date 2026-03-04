package com.siot.IamportRestClient;

import java.util.List;

import com.siot.IamportRestClient.request.*;
import com.siot.IamportRestClient.request.escrow.EscrowLogisData;
import com.siot.IamportRestClient.request.naver.*;
import com.siot.IamportRestClient.response.*;
import com.siot.IamportRestClient.response.escrow.EscrowLogisInvoice;
import com.siot.IamportRestClient.response.naver.NaverCashAmount;
import com.siot.IamportRestClient.response.naver.NaverProductOrder;
import com.siot.IamportRestClient.response.naver.NaverReview;

import retrofit2.Call;
import retrofit2.http.*;

public interface Iamport {

	@POST("/users/getToken")
	Call<IamportResponse<AccessToken>> token(
		@Body AuthData auth);

	@GET("/payments/{imp_uid}/balance")
    Call<IamportResponse<PaymentBalance>> balance_by_imp_uid(
    	@Header("Authorization") String token,
        @Path("imp_uid") String imp_uid
    );

	@GET("/payments/{imp_uid}")
    Call<IamportResponse<Payment>> payment_by_imp_uid(
    	@Header("Authorization") String token,
        @Path("imp_uid") String imp_uid,
		@Query("include_sandbox") boolean include_sandbox
    );

	@GET("/payments/status/{payment_status}")
    Call<IamportResponse<PagedDataList<Payment>>> payments_by_status(
    	@Header("Authorization") String token,
        @Path("payment_status") String payment_status
    );

	@POST("/payments/cancel")
	Call<IamportResponse<Payment>> cancel_payment(
		@Header("Authorization") String token,
		@Body CancelData cancel_data
	);

	@POST("/payments/prepare")
	Call<IamportResponse<Prepare>> post_prepare(
		@Header("Authorization") String token,
		@Body PrepareData prepare_data
	);

	@GET("/payments/prepare/{merchant_uid}")
	Call<IamportResponse<Prepare>> get_prepare(
		@Header("Authorization") String token,
		@Path("merchant_uid") String merchant_uid
	);

	@DELETE("/subscribe/customers/{customer_uid}")
	Call<IamportResponse<BillingCustomer>> delete_billing_customer(
		@Header("Authorization") String token,
		@Path("customer_uid") String customer_uid,
		@Query("reason") String reason,
		@Query("extra[requester]") String extra
	);

	@POST("/subscribe/customers/{customer_uid}")
	Call<IamportResponse<BillingCustomer>> post_billing_customer(
		@Header("Authorization") String token,
		@Path("customer_uid") String customer_uid,
		@Body BillingCustomerData billing_data
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

	@GET("/subscribe/payments/schedule")
	Call<IamportResponse<ScheduleList>> get_payment_schedule(
		@Header("Authorization") String token,
//		@Query("_token") String token,
		@Query("schedule_from") int schedule_from,
        @Query("schedule_to") int schedule_to,
        @Query("schedule_status") String schedule_status,
        @Query("page") int page,
        @Query("limit") int limit
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

	@GET("/subscribe/customers/{customer_uid}")
	Call<IamportResponse<BillingCustomer>> get_billing_customer(
			@Header("Authorization") String token,
			@Path("customer_uid") String customer_uid
	);

	/* 본인인증 결과 (certification result) */
	@GET("/certifications/{imp_uid}")
    Call<IamportResponse<Certification>> certification_by_imp_uid(
    	@Header("Authorization") String token,
        @Path("imp_uid") String imp_uid
    );

	@POST("/escrows/logis/{imp_uid}")
	Call<IamportResponse<EscrowLogisInvoice>> post_escrow_logis(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body EscrowLogisData logis_data
	);

	@GET("/payments/{imp_uid}/naver/product-orders")
	Call<IamportResponse<List<NaverProductOrder>>> naver_product_orders(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid
	);

	@GET("/naver/product-orders/{product_order_id}")
	Call<IamportResponse<NaverProductOrder>> naver_single_product_order(
		@Header("Authorization") String token,
		@Path("product_order_id") String product_order_id
	);

	@GET("/naver/reviews")
	Call<IamportResponse<List<NaverReview>>> naver_reviews(
		@Header("Authorization") String token
	);

	@POST("/payments/{imp_uid}/naver/cancel")
	Call<IamportResponse<List<NaverProductOrder>>> naver_cancel(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body NaverCancelData naver_cancel_data
	);

	@POST("/payments/{imp_uid}/naver/ship")
	Call<IamportResponse<List<NaverProductOrder>>> naver_ship(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body NaverShipData naver_ship_data
	);

	@POST("/payments/{imp_uid}/naver/place")
	Call<IamportResponse<List<NaverProductOrder>>> naver_place(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body NaverPlaceData naver_place_data
	);

	@POST("/payments/{imp_uid}/naver/confirm")
	Call<IamportResponse<EmptyResponse>> naver_confirm(
			@Header("Authorization") String token,
			@Path("imp_uid") String imp_uid
	);

	@POST("/payments/{imp_uid}/naver/request-return")
	Call<IamportResponse<List<NaverProductOrder>>> naver_request_return(
			@Header("Authorization") String token,
			@Path("imp_uid") String imp_uid,
			@Body NaverRequestReturnData naver_request_return_data
	);

	@POST("/payments/{imp_uid}/naver/approve-return")
	Call<IamportResponse<List<NaverProductOrder>>> naver_approve_return(
			@Header("Authorization") String token,
			@Path("imp_uid") String imp_uid,
			@Body NaverApproveReturnData naver_approve_return_data
	);

	@POST("/payments/{imp_uid}/naver/reject-return")
	Call<IamportResponse<List<NaverProductOrder>>> naver_reject_return(
			@Header("Authorization") String token,
			@Path("imp_uid") String imp_uid,
			@Body NaverRejectReturnData naver_reject_return_data
	);

	@POST("/payments/{imp_uid}/naver/withhold-return")
	Call<IamportResponse<List<NaverProductOrder>>> naver_withhold_return(
			@Header("Authorization") String token,
			@Path("imp_uid") String imp_uid,
			@Body NaverWithholdReturnData naver_withhold_return_data
	);

	@POST("/payments/{imp_uid}/naver/resolve-return")
	Call<IamportResponse<List<NaverProductOrder>>> naver_resolve_return(
			@Header("Authorization") String token,
			@Path("imp_uid") String imp_uid,
			@Body NaverResolveReturnData naver_resolve_return_data
	);

	@POST("/payments/{imp_uid}/naver/point")
	Call<IamportResponse<EmptyResponse>> naver_point(
			@Header("Authorization") String token,
			@Path("imp_uid") String imp_uid
	);

	/* PAYMENTS (additional) */
	@GET("/payments")
	Call<IamportResponse<List<Payment>>> payments_by_imp_uid(
		@Header("Authorization") String token,
		@Query("imp_uid[]") List<String> imp_uid
	);

	@GET("/payments/find/{merchant_uid}/{payment_status}")
	Call<IamportResponse<Payment>> payment_by_merchant_uid(
		@Header("Authorization") String token,
		@Path("merchant_uid") String merchant_uid,
		@Path("payment_status") String payment_status
	);

	@GET("/payments/findAll/{merchant_uid}/{payment_status}")
	Call<IamportResponse<PagedDataList<Payment>>> payments_by_merchant_uid(
		@Header("Authorization") String token,
		@Path("merchant_uid") String merchant_uid,
		@Path("payment_status") String payment_status
	);

	@PUT("/payments/prepare")
	Call<IamportResponse<Prepare>> put_prepare(
		@Header("Authorization") String token,
		@Body PrepareData prepare_data
	);

	/* CERTIFICATIONS (additional) */
	@DELETE("/certifications/{imp_uid}")
	Call<IamportResponse<Certification>> delete_certification(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid
	);

	@POST("/certifications/otp/request")
	Call<IamportResponse<Certification>> otp_request(
		@Header("Authorization") String token,
		@Body OtpRequestData otp_data
	);

	@POST("/certifications/otp/confirm/{imp_uid}")
	Call<IamportResponse<Certification>> otp_confirm(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body OtpConfirmData otp_data
	);

	/* CODES */
	@GET("/banks")
	Call<IamportResponse<List<StandardCode>>> all_bank_codes(
		@Header("Authorization") String token
	);

	@GET("/banks/{bank_standard_code}")
	Call<IamportResponse<StandardCode>> bank_code(
		@Header("Authorization") String token,
		@Path("bank_standard_code") String code
	);

	@GET("/cards")
	Call<IamportResponse<List<StandardCode>>> all_card_codes(
		@Header("Authorization") String token
	);

	@GET("/cards/{card_standard_code}")
	Call<IamportResponse<StandardCode>> card_code(
		@Header("Authorization") String token,
		@Path("card_standard_code") String code
	);

	/* ESCROW (additional) */
	@GET("/escrows/logis/{imp_uid}")
	Call<IamportResponse<EscrowLogisInvoice>> get_escrow_logis(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid
	);

	@PUT("/escrows/logis/{imp_uid}")
	Call<IamportResponse<EscrowLogisInvoice>> put_escrow_logis(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body EscrowLogisData logis_data
	);

	/* SUBSCRIBE (additional) */
	@GET("/subscribe/payments/schedule/{merchant_uid}")
	Call<IamportResponse<Schedule>> get_schedule_by_merchant_uid(
		@Header("Authorization") String token,
		@Path("merchant_uid") String merchant_uid
	);

	@PUT("/subscribe/payments/schedule/{merchant_uid}")
	Call<IamportResponse<Schedule>> put_schedule_by_merchant_uid(
		@Header("Authorization") String token,
		@Path("merchant_uid") String merchant_uid,
		@Body ScheduleUpdateData update_data
	);

	@POST("/subscribe/payments/schedule/{merchant_uid}/retry")
	Call<IamportResponse<Payment>> retry_schedule(
		@Header("Authorization") String token,
		@Path("merchant_uid") String merchant_uid,
		@Body ScheduleRetryData retry_data
	);

	@POST("/subscribe/payments/schedule/{merchant_uid}/reschedule")
	Call<IamportResponse<Schedule>> reschedule_schedule(
		@Header("Authorization") String token,
		@Path("merchant_uid") String merchant_uid,
		@Body ScheduleRescheduleData reschedule_data
	);

	@GET("/subscribe/payments/schedule/customers/{customer_uid}")
	Call<IamportResponse<ScheduleList>> get_schedule_by_customer_uid(
		@Header("Authorization") String token,
		@Path("customer_uid") String customer_uid,
		@Query("page") int page,
		@Query("schedule_from") int schedule_from,
		@Query("schedule_to") int schedule_to,
		@Query("schedule_status") String schedule_status
	);

	/* SUBSCRIBE.CUSTOMER (additional) */
	@GET("/subscribe/customers")
	Call<IamportResponse<List<BillingCustomer>>> get_billing_customers(
		@Header("Authorization") String token,
		@Query("customer_uid[]") List<String> customer_uid
	);

	@GET("/subscribe/customers/{customer_uid}/payments")
	Call<IamportResponse<PagedDataList<Payment>>> get_customer_payments(
		@Header("Authorization") String token,
		@Path("customer_uid") String customer_uid,
		@Query("page") int page
	);

	@GET("/subscribe/customers/{customer_uid}/schedules")
	Call<IamportResponse<ScheduleList>> get_customer_schedules(
		@Header("Authorization") String token,
		@Path("customer_uid") String customer_uid,
		@Query("page") int page,
		@Query("schedule_from") int schedule_from,
		@Query("schedule_to") int schedule_to,
		@Query("schedule_status") String schedule_status
	);

	/* BENEPIA */
	@POST("/benepia/point")
	Call<IamportResponse<BenepiaPoint>> benepia_point(
		@Header("Authorization") String token,
		@Body BenepiaPointData point_data
	);

	@POST("/benepia/payment")
	Call<IamportResponse<Payment>> benepia_payment(
		@Header("Authorization") String token,
		@Body BenepiaPaymentData payment_data
	);

	/* CVS */
	@POST("/cvs")
	Call<IamportResponse<Payment>> issue_cvs_payment(
		@Header("Authorization") String token,
		@Body CvsPaymentData cvs_data
	);

	@DELETE("/cvs/{imp_uid}")
	Call<IamportResponse<Payment>> revoke_cvs_payment(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid
	);

	/* KCPQUICK */
	@DELETE("/kcpquick/members/{member_id}")
	Call<IamportResponse<EmptyResponse>> delete_kcpquick_member(
		@Header("Authorization") String token,
		@Path("member_id") String member_id
	);

	@POST("/kcpquick/payment/money")
	Call<IamportResponse<Payment>> pay_kcpquick_money(
		@Header("Authorization") String token,
		@Body KcpQuickPaymentData payment_data
	);

	/* NAVER (additional) */
	@GET("/payments/{imp_uid}/naver/cash-amount")
	Call<IamportResponse<NaverCashAmount>> naver_cash_amount(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid
	);

	@POST("/payments/{imp_uid}/naver/approve-cancel")
	Call<IamportResponse<List<NaverProductOrder>>> naver_approve_cancel(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body NaverApproveCancelData data
	);

	@POST("/payments/{imp_uid}/naver/collect-exchanged")
	Call<IamportResponse<List<NaverProductOrder>>> naver_collect_exchanged(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body NaverCollectExchangedData data
	);

	@POST("/payments/{imp_uid}/naver/ship-exchanged")
	Call<IamportResponse<List<NaverProductOrder>>> naver_ship_exchanged(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body NaverShipExchangedData data
	);

	/* PARTNERS */
	@POST("/partners/receipts/{imp_uid}")
	Call<IamportResponse<EmptyResponse>> partner_receipt(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body PartnersReceiptData receipt_data
	);

	/* PAYMENTWALL */
	@POST("/paymentwall/delivery")
	Call<IamportResponse<EmptyResponse>> paymentwall_delivery(
		@Header("Authorization") String token,
		@Body PaymentwallDeliveryData delivery_data
	);

	/* RECEIPTS */
	@GET("/receipts/{imp_uid}")
	Call<IamportResponse<Receipt>> get_receipt(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid
	);

	@POST("/receipts/{imp_uid}")
	Call<IamportResponse<Receipt>> issue_receipt(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body ReceiptData receipt_data
	);

	@DELETE("/receipts/{imp_uid}")
	Call<IamportResponse<Receipt>> revoke_receipt(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid
	);

	@GET("/receipts/external/{merchant_uid}")
	Call<IamportResponse<ExternalReceipt>> get_external_receipt(
		@Header("Authorization") String token,
		@Path("merchant_uid") String merchant_uid
	);

	@POST("/receipts/external/{merchant_uid}")
	Call<IamportResponse<ExternalReceipt>> issue_external_receipt(
		@Header("Authorization") String token,
		@Path("merchant_uid") String merchant_uid,
		@Body ExternalReceiptData receipt_data
	);

	@DELETE("/receipts/external/{merchant_uid}")
	Call<IamportResponse<ExternalReceipt>> revoke_external_receipt(
		@Header("Authorization") String token,
		@Path("merchant_uid") String merchant_uid
	);

	/* TIERS */
	@GET("/tiers/{tier_code}")
	Call<IamportResponse<TierInfo>> get_tier(
		@Header("Authorization") String token,
		@Path("tier_code") String tier_code
	);

	/* USERS */
	@GET("/users/pg")
	Call<IamportResponse<List<PgInfo>>> get_pg_settings(
		@Header("Authorization") String token
	);

	/* VBANKS */
	@POST("/vbanks")
	Call<IamportResponse<Payment>> create_vbank(
		@Header("Authorization") String token,
		@Body VbankData vbank_data
	);

	@GET("/vbanks/holder")
	Call<IamportResponse<VbankHolder>> get_vbank_holder(
		@Header("Authorization") String token,
		@Query("bank_code") String bank_code,
		@Query("bank_num") String bank_num
	);

	@PUT("/vbanks/{imp_uid}")
	Call<IamportResponse<Payment>> modify_vbank(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid,
		@Body VbankEditData vbank_data
	);

	@DELETE("/vbanks/{imp_uid}")
	Call<IamportResponse<Payment>> revoke_vbank(
		@Header("Authorization") String token,
		@Path("imp_uid") String imp_uid
	);
}

package com.siot.IamportRestClient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

/**
 * Unit test for simple App.
 */
public class IamportRestTest {
	
	IamportClient client;
	
	@Before
	public void setup() {
		String test_api_key = "imp_apikey";
		String test_api_secret = "ekKoeW8RyKuT0zgaZsUtXXTLQ4AhPFW3ZGseDA6bkA5lamv9OqDMnxyeB9wqOsuO9W3Mx9YSJ4dTqJ3f";
		client = new IamportClient(test_api_key, test_api_secret);
	}
	
	@Test
	public void testGetToken() {
		IamportResponse<AccessToken> auth_response = client.getAuth();
		assertNotNull(auth_response.getResponse());
		assertNotNull(auth_response.getResponse().getToken());
	}
	
	@Test
	public void testPaymentByImpUid() {
		String test_imp_uid = "imp_448280090638";
		IamportResponse<Payment> payment_response = client.paymentByImpUid(test_imp_uid);
		assertNotNull(payment_response.getResponse());
		assertEquals(test_imp_uid, payment_response.getResponse().getImpUid());
	}
	
	@Test
	public void testCancelPaymentAlreadyCancelledImpUid() {
		String test_already_cancelled_imp_uid = "imp_448280090638";
		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true); //imp_uid를 통한 전액취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
	}
	
	@Test
	public void testCancelPaymentAlreadyCancelledMerchantUid() {
		String test_already_cancelled_merchant_uid = "merchant_1448280088556";
		CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false); //merchant_uid를 통한 전액취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}
	
	@Test
	public void testPartialCancelPaymentAlreadyCancelledImpUid() {
		String test_already_cancelled_imp_uid = "imp_448280090638";
		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true, BigDecimal.valueOf(500)); //imp_uid를 통한 500원 부분취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}
	
	@Test
	public void testPartialCancelPaymentAlreadyCancelledMerchantUid() {
		String test_already_cancelled_merchant_uid = "merchant_1448280088556";
		CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false, BigDecimal.valueOf(500)); //merchant_uid를 통한 500원 부분취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}
	
	@Test
	public void testCancelVbankPaymentAlreadyCancelledImpUid() {
		String test_already_cancelled_imp_uid = "imp_1416557733458";
		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true, BigDecimal.valueOf(500)); //imp_uid를 통한 500원 부분취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}
	
	@Test
	public void testPartialCancelVbankPaymentAlreadyCancelledMerchantUid() {
		String test_already_cancelled_merchant_uid = "merchant_1416557727868";
		CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false, BigDecimal.valueOf(500)); //merchant_uid를 통한 500원 부분취소
		IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
		
		assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
		System.out.println(payment_response.getMessage());
	}
	
}

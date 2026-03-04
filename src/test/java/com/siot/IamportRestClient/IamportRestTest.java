package com.siot.IamportRestClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.siot.IamportRestClient.constant.CardConstant;
import com.siot.IamportRestClient.request.*;
import com.siot.IamportRestClient.request.naver.*;
import com.siot.IamportRestClient.response.*;
import com.siot.IamportRestClient.response.escrow.EscrowLogisInvoice;
import com.siot.IamportRestClient.response.naver.NaverCashAmount;
import com.siot.IamportRestClient.response.naver.NaverProductOrder;
import com.siot.IamportRestClient.response.payco.OrderStatus;
import org.junit.Before;
import org.junit.Test;

import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.escrow.EscrowLogisData;
import com.siot.IamportRestClient.request.escrow.EscrowLogisInvoiceData;
import com.siot.IamportRestClient.request.escrow.EscrowLogisPersonData;

import static org.junit.Assert.*;

public class IamportRestTest {

    IamportClient client;

    private IamportClient getNaverTestClient() {
        String test_api_key = "5978210787555892";
        String test_api_secret = "9e75ulp4f9Wwj0i8MSHlKFA9PCTcuMYE15Kvr9AHixeCxwKkpsFa7fkWSd9m0711dLxEV7leEAQc6Bxv";

        return new IamportClient(test_api_key, test_api_secret);
    }

    private IamportClient getBillingTestClient() {
        String test_api_key = "7544324362787472";
        String test_api_secret = "9frnPjLAQe3evvAaJl3xLOODfO3yBk7LAy9pRV0H93VEzwPjRSQDHFhWtku5EBRea1E1WEJ6IEKhbAA3";

        return new IamportClient(test_api_key, test_api_secret);
    }

    @Before
    public void setup() {
        String test_api_key = "imp_apikey";
        String test_api_secret = "ekKoeW8RyKuT0zgaZsUtXXTLQ4AhPFW3ZGseDA6bkA5lamv9OqDMnxyeB9wqOsuO9W3Mx9YSJ4dTqJ3f";
        client = new IamportClient(test_api_key, test_api_secret);
    }

    @Test
    public void testGetToken() {
        try {
            IamportResponse<AccessToken> auth_response = client.getAuth();

            assertNotNull(auth_response.getResponse());
            assertNotNull(auth_response.getResponse().getToken());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            //서버 연결 실패
            e.printStackTrace();
        }
    }

    @Test
    public void testPaymentBalanceByImpUid() {
        String test_imp_uid = "imp_011115679124";
        try {
            IamportResponse<PaymentBalance> payment_response = client.paymentBalanceByImpUid(test_imp_uid);

            assertNotNull(payment_response.getResponse());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testPaymentByImpUid() {
        String test_imp_uid = "imp_448280090638";
        try {
            IamportResponse<Payment> payment_response = client.paymentByImpUid(test_imp_uid);

            assertNotNull(payment_response.getResponse());
            assertEquals(test_imp_uid, payment_response.getResponse().getImpUid());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String test_imp_uid_cancelled = "imp_138841716839";
        try {
            IamportResponse<Payment> cancelled_response = client.paymentByImpUid(test_imp_uid_cancelled);

            Payment cancelled = cancelled_response.getResponse();
            PaymentCancelDetail[] cancelDetail = cancelled.getCancelHistory();

            assertEquals(cancelDetail.length, 1);
            assertNotNull(cancelDetail[0].getPgTid());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testPaymentsByStatusAll() {
        try {
            IamportResponse<PagedDataList<Payment>> r_response = client.paymentsByStatus("ready");
            IamportResponse<PagedDataList<Payment>> p_response = client.paymentsByStatus("paid");
            IamportResponse<PagedDataList<Payment>> f_response = client.paymentsByStatus("failed");
            IamportResponse<PagedDataList<Payment>> c_response = client.paymentsByStatus("cancelled");
            IamportResponse<PagedDataList<Payment>> all_response = client.paymentsByStatus("all");

            assertNotNull(all_response.getResponse());
            assertNotNull(r_response.getResponse());
            assertNotNull(p_response.getResponse());
            assertNotNull(f_response.getResponse());
            assertNotNull(c_response.getResponse());

            assertEquals(all_response.getResponse().getTotal(), r_response.getResponse().getTotal() + p_response.getResponse().getTotal() + f_response.getResponse().getTotal() + c_response.getResponse().getTotal());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testCancelPaymentAlreadyCancelledImpUid() {
        String test_already_cancelled_imp_uid = "imp_448280090638";
        CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true); //imp_uid를 통한 전액취소

        try {
            IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);

            assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testCancelPaymentChecksumByImpUid() {
        String test_already_cancelled_imp_uid = "imp_448280090638";
        CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true); //imp_uid를 통한 전액취소
        cancel_data.setChecksum(BigDecimal.valueOf(500)); // checksum 으로 검증 추가

        try {
            IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);

            assertNull(payment_response.getResponse());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testCancelPaymentAlreadyCancelledMerchantUid() {
        String test_already_cancelled_merchant_uid = "merchant_1448280088556";
        CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false); //merchant_uid를 통한 전액취소
        cancel_data.setEscrowConfirmed(true); //에스크로 구매확정 후 취소인 경우 true설정

        try {
            IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);

            assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
            System.out.println(payment_response.getMessage());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testPartialCancelPaymentAlreadyCancelledImpUid() {
        String test_already_cancelled_imp_uid = "imp_448280090638";
        CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true, BigDecimal.valueOf(500)); //imp_uid를 통한 500원 부분취소

        try {
            IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);

            assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
            System.out.println(payment_response.getMessage());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testPartialCancelPaymentAlreadyCancelledMerchantUid() {
        String test_already_cancelled_merchant_uid = "merchant_1448280088556";
        CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false, BigDecimal.valueOf(500)); //merchant_uid를 통한 500원 부분취소

        try {
            IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);

            assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
            System.out.println(payment_response.getMessage());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testCancelVbankPaymentAlreadyCancelledImpUid() {
        String test_already_cancelled_imp_uid = "imp_1416557733458";
        CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true, BigDecimal.valueOf(500)); //imp_uid를 통한 500원 부분취소

        try {
            IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);

            assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
            System.out.println(payment_response.getMessage());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testPartialCancelVbankPaymentAlreadyCancelledMerchantUid() {
        String test_already_cancelled_merchant_uid = "merchant_1416557727868";
        CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false, BigDecimal.valueOf(500)); //merchant_uid를 통한 500원 부분취소

        try {
            IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);

            assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
            System.out.println(payment_response.getMessage());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testPaycoUpdateOrderStatus() {
        String test_api_key = "2966106337421865";
        String test_api_secret = "rZfEkQvBL6hRaWexFEQQwrrylIHTnSzORPscFYNq54hf1wNHaDyH4ZfqHXj5PTTHJmTokHPpM6FNDsvN";
        IamportPaycoClient payco = new IamportPaycoClient(test_api_key, test_api_secret);

        //유효하지 않은 status
        try {
            IamportResponse<OrderStatus> payment_response = payco.updateOrderStatus("imp_436389624339", "asdf");
            assertNull(payment_response);

            payment_response = payco.updateOrderStatus("imp_436389624339", "CANCELED");
            assertEquals("CANCELED", payment_response.getResponse().getStatus());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testCertificationByImpUid() {
//		String test_imp_uid = "imp_339323965143";
        // origin 검증을 위해 is not null인 imp_uid로 변경
        String test_imp_uid = "imp_992536806181";

        try {
            IamportResponse<Certification> certification_response = client.certificationByImpUid(test_imp_uid);

            assertNotNull(certification_response.getResponse());
            assertEquals(test_imp_uid, certification_response.getResponse().getImpUid());
            assertEquals("http://kicc.iamport.kr/pages/certi", certification_response.getResponse().getOrigin());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testPostEscrowLogis() {
        String imp_uid = "imp_205852873956";

        EscrowLogisPersonData sender = new EscrowLogisPersonData("가맹점", "02-1234-1234", "서울 용산구", "12345");
        EscrowLogisPersonData receiver = new EscrowLogisPersonData("홍길동", "010-1234-5678", "서울 강남구 삼성동", "98765");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 3);

        EscrowLogisInvoiceData invoice = new EscrowLogisInvoiceData("LOGEN", "123456789", cal.getTime()); //택배사 코드표 : https://github.com/iamport/iamport-manual/blob/master/RESTAPI/logis.md

        try {
            IamportResponse<EscrowLogisInvoice> response = client.postEscrowLogis(imp_uid, new EscrowLogisData(invoice, receiver, sender));
            assertNotNull(response.getResponse());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBillingCustomer() {
        IamportClient billingClient = getBillingTestClient();
        String testCustomerUid = "customer_1234";

        try {
            IamportResponse<BillingCustomer> billingCustomerResponse = billingClient.getBillingCustomer(testCustomerUid);

            BillingCustomer billingCustomer = billingCustomerResponse.getResponse();

            assertEquals(CardConstant.CODE_SHINHAN, billingCustomer.getCardCode());
            assertEquals("nice", billingCustomer.getPgProvider());
            assertNotNull(billingCustomer.getCardNumber());
            assertNotNull(billingCustomer.getCardName());

        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO : API credential 이 잘못된 경우
                    break;
                case 404:
                    //TODO : customer_uid 에 해당되는 빌링등록정보가 존재하지 않는 경우
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testNaverProductOrders() {
        IamportClient naverClient = getNaverTestClient();

        String impUid = "imp_630554823245";

        try {
            IamportResponse<List<NaverProductOrder>> r = naverClient.naverProductOrders(impUid);
            List<NaverProductOrder> productOrders = r.getResponse();

            assertNotNull(productOrders);
            assertFalse(productOrders.isEmpty());

            String productOrderId = productOrders.get(0).getProductOrderId();
            IamportResponse<NaverProductOrder> rr = naverClient.naverProductOrderSingle(productOrderId);
            NaverProductOrder firstOrder = rr.getResponse();

            assertEquals(firstOrder.getProductOrderId(), productOrderId);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testNaverCancelOrders() {
        String impUid = "imp_964732188684";
        NaverCancelData cancelData = new NaverCancelData(NaverCancelData.REASON_SOLD_OUT);

        IamportClient naverClient = getNaverTestClient();
        try {
            IamportResponse<List<NaverProductOrder>> r = naverClient.naverCancelOrders(impUid, cancelData);
            List<NaverProductOrder> productOrders = r.getResponse();

            for (NaverProductOrder naverProductOrder : productOrders) {
                assertEquals("CANCELED", naverProductOrder.getProductOrderStatus());
            }
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testNaverShippingOrders() {
        Calendar cal = Calendar.getInstance();
        cal.set(2018, Calendar.NOVEMBER, 9, 12, 0, 0);

        String impUid = "imp_964732188684";
        NaverShipData shippingData = new NaverShipData(NaverShipData.METHOD_DELIVERY, cal.getTime());

        IamportClient naverClient = getNaverTestClient();
        try {
            IamportResponse<List<NaverProductOrder>> r = naverClient.naverShippingOrders(impUid, shippingData);
            List<NaverProductOrder> productOrders = r.getResponse();

        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testNaverRequestReturnOrders() {
        String impUid = "imp_964732188684";
        NaverRequestReturnData requestReturnData = new NaverRequestReturnData(NaverRequestReturnData.DELIVERY_METHOD_RETURN_INDIVIDUAL);
        requestReturnData.setDeliveryCompany(NaverRequestReturnData.DELIVERY_COMPANY_CH1); //기타 택배
        requestReturnData.setTrackingNumber("1234123412341234");

        IamportClient naverClient = getNaverTestClient();
        try {
            IamportResponse<List<NaverProductOrder>> r = naverClient.naverRequestReturnOrders(impUid, requestReturnData);
            List<NaverProductOrder> productOrders = r.getResponse();

        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testNaverApproveReturnOrders() {
        String impUid = "imp_964732188684";
        NaverApproveReturnData approveReturnData = new NaverApproveReturnData();

        IamportClient naverClient = getNaverTestClient();
        try {
            IamportResponse<List<NaverProductOrder>> r = naverClient.naverApproveReturnOrders(impUid, approveReturnData);
            List<NaverProductOrder> productOrders = r.getResponse();

        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testNaverRejectReturnOrders() {
        String impUid = "imp_964732188684";
        NaverRejectReturnData rejectReturnData = new NaverRejectReturnData("죄송합니다만, 주문제작 상품이라 반품이 불가능합니다.");

        IamportClient naverClient = getNaverTestClient();
        try {
            IamportResponse<List<NaverProductOrder>> r = naverClient.naverRejectReturnOrders(impUid, rejectReturnData);
            List<NaverProductOrder> productOrders = r.getResponse();

        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testNaverWithholdReturnOrders() {
        String impUid = "imp_964732188684";
        NaverWithholdReturnData withholdReturnData = new NaverWithholdReturnData("내부 확인 중에 있으니 곧 안내드리겠습니다.");

        IamportClient naverClient = getNaverTestClient();
        try {
            IamportResponse<List<NaverProductOrder>> r = naverClient.naverWithholdReturnOrders(impUid, withholdReturnData);
            List<NaverProductOrder> productOrders = r.getResponse();

        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testNaverResolveReturnOrders() {
        String impUid = "imp_964732188684";
        NaverResolveReturnData resolveReturnData = new NaverResolveReturnData();

        IamportClient naverClient = getNaverTestClient();
        try {
            IamportResponse<List<NaverProductOrder>> r = naverClient.naverResolveReturnOrders(impUid, resolveReturnData);
            List<NaverProductOrder> productOrders = r.getResponse();

        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());

            switch (e.getHttpStatusCode()) {
                case 401:
                    //TODO
                    break;
                case 500:
                    //TODO
                    break;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //	@Test
//	public void testOnetimePayment() {
//		CardInfo card = new CardInfo("1234123412341234", "201901", "801231", "00");
//		OnetimePaymentData onetime_data = new OnetimePaymentData(getRandomMerchantUid(), BigDecimal.valueOf(1004), card);
//		onetime_data.setName("ActiveX없는결제테스트");
//		onetime_data.setBuyerName("구매자");
//		onetime_data.setBuyerEmail("iamport@siot.do");
//		onetime_data.setBuyerTel("16705176");
//
//		IamportResponse<Payment> payment_response = client.onetimePayment(onetime_data);
//		assertEquals(payment_response.getResponse().getStatus(), "paid");
//	}
//
//	@Test
//	public void testAgainPayment() throws IOException, IamportResponseException {
//		String test_customer_uid = "customer_123456";
//		CardInfo card = new CardInfo("1234123412341234", "201901", "801231", "00");
//		OnetimePaymentData onetime_data = new OnetimePaymentData(getRandomMerchantUid(), BigDecimal.valueOf(1004), card);
//		onetime_data.setName("최초결제테스트");
//		onetime_data.setBuyerName("구매자");
//		onetime_data.setBuyerEmail("iamport@siot.do");
//		onetime_data.setBuyerTel("16705176");
//		onetime_data.setCustomer_uid(test_customer_uid); //결제 성공 후 customer_123456 라는 customer_uid로 빌링키 등록
//
//		IamportResponse<Payment> payment_response = client.onetimePayment(onetime_data);
//		assertEquals(payment_response.getResponse().getStatus(), "paid");
//
//		try {
//			//3초 후 customer_uid로 재결제
//			Thread.sleep(3000);
//
//			AgainPaymentData again_data = new AgainPaymentData(test_customer_uid, getRandomMerchantUid(), BigDecimal.valueOf(1005));
//			payment_response = client.againPayment(again_data);
//			assertEquals(payment_response.getResponse().getStatus(), "paid");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
    @Test
    public void testAgainPayment() throws IOException, IamportResponseException {
        String test_customer_uid = "customer_123456";
        CardInfo card = new CardInfo("1234123412341234", "201901", "801231", "00");

        AgainPaymentData again_data = new AgainPaymentData(test_customer_uid, getRandomMerchantUid(), BigDecimal.valueOf(1005));
        again_data.setExtra(new ExtraNaverUseCfmEntry("20200101"));
        ExtraNaverUseCfmEntry extra = again_data.getExtra();
        IamportResponse<Payment> payment_response = client.againPayment(again_data);
        assertEquals("paid", payment_response.getResponse().getStatus());
    }

    @Test
    public void testGetPaymentSchedule() throws IOException, IamportResponseException {

        GetScheduleData getScheduleData = new GetScheduleData(1643497892, 1648595492, null, 1, 20);

        IamportResponse<ScheduleList> schedule_response = client.getPaymentSchedule(getScheduleData);
        System.out.println(schedule_response.getResponse().getList().get(0).getCustomerUid());
    }
//
//	@Test
//	public void testSubscribeScheduleAndUnschedule() {
//		String test_customer_uid = "customer_123456";
//		ScheduleData schedule_data = new ScheduleData(test_customer_uid);
//
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.OCTOBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d1 = cal.getTime();
//
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.NOVEMBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d2 = cal.getTime();
//
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.DECEMBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d3 = cal.getTime();
//
//		schedule_data.addSchedule(new ScheduleEntry(getRandomMerchantUid(), d1, BigDecimal.valueOf(1004)));
//		schedule_data.addSchedule(new ScheduleEntry(getRandomMerchantUid(), d2, BigDecimal.valueOf(1005)));
//		schedule_data.addSchedule(new ScheduleEntry(getRandomMerchantUid(), d3, BigDecimal.valueOf(1006)));
//
//		System.out.println("예약 요청");
//		IamportResponse<List<Schedule>> schedule_response = client.subscribeSchedule(schedule_data);
//
//		List<Schedule> schedules = schedule_response.getResponse();
//		List<ScheduleEntry> req_schedules = schedule_data.getSchedules();
//
//		for (int i = 0; i < 3; i++) {
//			assertEquals(schedules.get(i).getCustomerUid(), test_customer_uid);
//			assertEquals(schedules.get(i).getMerchantUid(), req_schedules.get(i).getMerchantUid());
//			assertDateEquals(schedules.get(i).getScheduleAt(), req_schedules.get(i).getScheduleAt());
//			assertEquals(schedules.get(i).getAmount(), req_schedules.get(i).getAmount());
//		}
//
//		try {
//			//1초 후 등록된 예약 unschedule by multiple merchant_uid
//			Thread.sleep(1000);
//			System.out.println("복수 merchant_uid 예약 취소 요청");
//			UnscheduleData unschedule_data = new UnscheduleData(test_customer_uid);
//			unschedule_data.addMerchantUid( req_schedules.get(0).getMerchantUid() );
//			unschedule_data.addMerchantUid( req_schedules.get(2).getMerchantUid() );
//
//			IamportResponse<List<Schedule>> unschedule_response = client.unsubscribeSchedule(unschedule_data);
//			List<Schedule> cancelled_schedule = unschedule_response.getResponse();
//
//			assertNotNull(cancelled_schedule);
//			assertEquals(cancelled_schedule.get(0).getMerchantUid(), req_schedules.get(0).getMerchantUid());
//			assertEquals(cancelled_schedule.get(1).getMerchantUid(), req_schedules.get(2).getMerchantUid());
//
//			//1초 후 등록된 예약 unschedule by single multiple_uid
//			Thread.sleep(1000);
//			System.out.println("단일 merchant_uid 예약 취소 요청");
//			unschedule_data = new UnscheduleData(test_customer_uid);
//			unschedule_data.addMerchantUid( req_schedules.get(1).getMerchantUid());
//
//			unschedule_response = client.unsubscribeSchedule(unschedule_data);
//			cancelled_schedule = unschedule_response.getResponse();
//
//			assertNotNull(cancelled_schedule);
//			assertEquals(cancelled_schedule.get(0).getMerchantUid(), req_schedules.get(1).getMerchantUid());
//
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testSubscribeDuplicatedSchedule() {
//		String test_customer_uid = "iamportjangbora";
//		ScheduleData schedule_data = new ScheduleData(test_customer_uid);
//
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.OCTOBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d1 = cal.getTime();
//
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.NOVEMBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d2 = cal.getTime();
//
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.DECEMBER);
//		cal.set(Calendar.DAY_OF_MONTH, 25);
//		Date d3 = cal.getTime();
//
//		schedule_data.addSchedule(new ScheduleEntry("scheduled_merchant_1$$$", d1, BigDecimal.valueOf(1004)));
//		schedule_data.addSchedule(new ScheduleEntry("scheduled_merchant_2$$$", d2, BigDecimal.valueOf(1005)));
//		schedule_data.addSchedule(new ScheduleEntry("scheduled_merchant_3$$$", d3, BigDecimal.valueOf(1006)));
//
//		IamportResponse<List<Schedule>> schedule_response = client.subscribeSchedule(schedule_data);
//
//		assertEquals(1, schedule_response.getCode()); //중복된 merchant_uid이므로 schedule에 실패함
//	}

    /* ============================================
     * PAYMENTS (additional) tests
     * ============================================ */

    @Test
    public void testPaymentsByImpUid() {
        try {
            List<String> impUids = Arrays.asList("imp_448280090638", "imp_138841716839");
            IamportResponse<List<Payment>> response = client.paymentsByImpUid(impUids);

            assertNotNull(response.getResponse());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPaymentByMerchantUid() {
        String testMerchantUid = "merchant_1448280088556";
        try {
            IamportResponse<Payment> response = client.paymentByMerchantUid(testMerchantUid, "all");

            assertNotNull(response.getResponse());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPaymentsByMerchantUid() {
        String testMerchantUid = "merchant_1448280088556";
        try {
            IamportResponse<PagedDataList<Payment>> response = client.paymentsByMerchantUid(testMerchantUid, "all");

            assertNotNull(response.getResponse());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPutPrepare() {
        try {
            PrepareData prepareData = new PrepareData(getRandomMerchantUid(), BigDecimal.valueOf(1000));
            IamportResponse<Prepare> response = client.putPrepare(prepareData);

            assertNotNull(response.getResponse());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * CERTIFICATIONS (additional) tests
     * ============================================ */

    @Test
    public void testDeleteCertification() {
        String testImpUid = "imp_test_certification_uid";
        try {
            IamportResponse<Certification> response = client.deleteCertification(testImpUid);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOtpRequest() {
        try {
            OtpRequestData otpData = new OtpRequestData("홍길동", "01012345678", "19900101", "1", "SKT", "channel_key_test");
            IamportResponse<Certification> response = client.otpRequest(otpData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOtpConfirm() {
        String testImpUid = "imp_test_otp_uid";
        try {
            OtpConfirmData otpData = new OtpConfirmData("123456");
            IamportResponse<Certification> response = client.otpConfirm(testImpUid, otpData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * CODES tests
     * ============================================ */

    @Test
    public void testAllBankCodes() {
        try {
            IamportResponse<List<StandardCode>> response = client.allBankCodes();

            assertNotNull(response.getResponse());
            assertFalse(response.getResponse().isEmpty());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBankCode() {
        try {
            IamportResponse<StandardCode> response = client.bankCode("004");

            assertNotNull(response.getResponse());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAllCardCodes() {
        try {
            IamportResponse<List<StandardCode>> response = client.allCardCodes();

            assertNotNull(response.getResponse());
            assertFalse(response.getResponse().isEmpty());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCardCode() {
        try {
            IamportResponse<StandardCode> response = client.cardCode("361");

            assertNotNull(response.getResponse());
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * ESCROW (additional) tests
     * ============================================ */

    @Test
    public void testGetEscrowLogis() {
        String testImpUid = "imp_205852873956";
        try {
            IamportResponse<EscrowLogisInvoice> response = client.getEscrowLogis(testImpUid);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPutEscrowLogis() {
        String testImpUid = "imp_205852873956";

        EscrowLogisPersonData sender = new EscrowLogisPersonData("가맹점", "02-1234-1234", "서울 용산구", "12345");
        EscrowLogisPersonData receiver = new EscrowLogisPersonData("홍길동", "010-1234-5678", "서울 강남구 삼성동", "98765");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 3);

        EscrowLogisInvoiceData invoice = new EscrowLogisInvoiceData("LOGEN", "123456789", cal.getTime());

        try {
            IamportResponse<EscrowLogisInvoice> response = client.putEscrowLogis(testImpUid, new EscrowLogisData(invoice, receiver, sender));
            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * SUBSCRIBE (additional) tests
     * ============================================ */

    @Test
    public void testGetScheduleByMerchantUid() {
        String testMerchantUid = "scheduled_merchant_test";
        try {
            IamportResponse<Schedule> response = client.getScheduleByMerchantUid(testMerchantUid);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPutScheduleByMerchantUid() {
        String testMerchantUid = "scheduled_merchant_test";
        long newScheduleAt = System.currentTimeMillis() / 1000L + 86400;
        ScheduleUpdateData updateData = new ScheduleUpdateData(newScheduleAt);
        try {
            IamportResponse<Schedule> response = client.putScheduleByMerchantUid(testMerchantUid, updateData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRetrySchedule() {
        String testMerchantUid = "scheduled_merchant_test";
        ScheduleRetryData retryData = new ScheduleRetryData();
        try {
            IamportResponse<Payment> response = client.retrySchedule(testMerchantUid, retryData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRescheduleSchedule() {
        String testMerchantUid = "scheduled_merchant_test";
        long newScheduleAt = System.currentTimeMillis() / 1000L + 172800;
        ScheduleRescheduleData rescheduleData = new ScheduleRescheduleData(newScheduleAt);
        try {
            IamportResponse<Schedule> response = client.rescheduleSchedule(testMerchantUid, rescheduleData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetScheduleByCustomerUid() {
        String testCustomerUid = "customer_123456";
        try {
            IamportResponse<ScheduleList> response = client.getScheduleByCustomerUid(testCustomerUid, 1, 1643497892, 1948595492, null);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * SUBSCRIBE.CUSTOMER (additional) tests
     * ============================================ */

    @Test
    public void testGetBillingCustomers() {
        try {
            List<String> customerUids = Arrays.asList("customer_1234", "customer_5678");
            IamportResponse<List<BillingCustomer>> response = client.getBillingCustomers(customerUids);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCustomerPayments() {
        String testCustomerUid = "customer_123456";
        try {
            IamportResponse<PagedDataList<Payment>> response = client.getCustomerPayments(testCustomerUid, 1);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCustomerSchedules() {
        String testCustomerUid = "customer_123456";
        try {
            IamportResponse<ScheduleList> response = client.getCustomerSchedules(testCustomerUid, 1, 1643497892, 1948595492, null);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * BENEPIA tests
     * ============================================ */

    @Test
    public void testBenepiaPoint() {
        try {
            BenepiaPointData pointData = new BenepiaPointData("test_user", "test_password", "channel_key_test");
            IamportResponse<BenepiaPoint> response = client.benepiaPoint(pointData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBenepiaPayment() {
        try {
            BenepiaPaymentData paymentData = new BenepiaPaymentData("test_user", "test_password", getRandomMerchantUid(), BigDecimal.valueOf(1000), "테스트상품", "channel_key_test");
            IamportResponse<Payment> response = client.benepiaPayment(paymentData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * CVS tests
     * ============================================ */

    @Test
    public void testIssueCvsPayment() {
        try {
            CvsPaymentData cvsData = new CvsPaymentData("channel_key_test", getRandomMerchantUid(), BigDecimal.valueOf(1000));
            cvsData.setName("테스트상품");
            IamportResponse<Payment> response = client.issueCvsPayment(cvsData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRevokeCvsPayment() {
        String testImpUid = "imp_test_cvs_uid";
        try {
            IamportResponse<Payment> response = client.revokeCvsPayment(testImpUid);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * KCPQUICK tests
     * ============================================ */

    @Test
    public void testDeleteKcpQuickMember() {
        String testMemberId = "test_member_id";
        try {
            IamportResponse<EmptyResponse> response = client.deleteKcpQuickMember(testMemberId);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPayKcpQuickMoney() {
        try {
            KcpQuickPaymentData paymentData = new KcpQuickPaymentData("test_member_id", "channel_key_test", getRandomMerchantUid(), "테스트상품", 1000);
            IamportResponse<Payment> response = client.payKcpQuickMoney(paymentData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * NAVER (additional) tests
     * ============================================ */

    @Test
    public void testNaverCashAmount() {
        IamportClient naverClient = getNaverTestClient();
        String testImpUid = "imp_630554823245";

        try {
            IamportResponse<NaverCashAmount> response = naverClient.naverCashAmount(testImpUid);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNaverApproveCancel() {
        IamportClient naverClient = getNaverTestClient();
        String testImpUid = "imp_630554823245";

        NaverApproveCancelData data = new NaverApproveCancelData();
        data.setProductOrderId(new String[]{"test_product_order_id"});

        try {
            IamportResponse<List<NaverProductOrder>> response = naverClient.naverApproveCancel(testImpUid, data);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNaverCollectExchanged() {
        IamportClient naverClient = getNaverTestClient();
        String testImpUid = "imp_630554823245";

        NaverCollectExchangedData data = new NaverCollectExchangedData();
        data.setProductOrderId(new String[]{"test_product_order_id"});

        try {
            IamportResponse<List<NaverProductOrder>> response = naverClient.naverCollectExchanged(testImpUid, data);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNaverShipExchanged() {
        IamportClient naverClient = getNaverTestClient();
        String testImpUid = "imp_630554823245";

        NaverShipExchangedData data = new NaverShipExchangedData(NaverShipExchangedData.METHOD_DELIVERY);
        data.setProductOrderId(new String[]{"test_product_order_id"});

        try {
            IamportResponse<List<NaverProductOrder>> response = naverClient.naverShipExchanged(testImpUid, data);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * PARTNERS tests
     * ============================================ */

    @Test
    public void testPartnerReceipt() {
        String testImpUid = "imp_test_partner_uid";
        List<PartnersReceiptData.PartnerEntry> entries = new ArrayList<>();
        entries.add(new PartnersReceiptData.PartnerEntry("1234567890", "테스트회사", BigDecimal.valueOf(1000)));
        PartnersReceiptData receiptData = new PartnersReceiptData(entries);

        try {
            IamportResponse<EmptyResponse> response = client.partnerReceipt(testImpUid, receiptData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * PAYMENTWALL tests
     * ============================================ */

    @Test
    public void testPaymentwallDelivery() {
        long now = System.currentTimeMillis() / 1000L;
        PaymentwallDeliveryData deliveryData = new PaymentwallDeliveryData(
            "imp_test_uid", "merchant_test_uid", "physical", "order_shipped",
            now + 259200, now, "yes", "test@example.com"
        );

        try {
            IamportResponse<EmptyResponse> response = client.paymentwallDelivery(deliveryData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * RECEIPTS tests
     * ============================================ */

    @Test
    public void testGetReceipt() {
        String testImpUid = "imp_448280090638";
        try {
            IamportResponse<Receipt> response = client.getReceipt(testImpUid);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIssueReceipt() {
        String testImpUid = "imp_448280090638";
        ReceiptData receiptData = new ReceiptData("0101234567");
        receiptData.setType("person");

        try {
            IamportResponse<Receipt> response = client.issueReceipt(testImpUid, receiptData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRevokeReceipt() {
        String testImpUid = "imp_448280090638";
        try {
            IamportResponse<Receipt> response = client.revokeReceipt(testImpUid);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetExternalReceipt() {
        String testMerchantUid = "merchant_test_external";
        try {
            IamportResponse<ExternalReceipt> response = client.getExternalReceipt(testMerchantUid);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIssueExternalReceipt() {
        String testMerchantUid = getRandomMerchantUid();
        ExternalReceiptData receiptData = new ExternalReceiptData("channel_key_test", "테스트상품", 1000, "0101234567");

        try {
            IamportResponse<ExternalReceipt> response = client.issueExternalReceipt(testMerchantUid, receiptData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRevokeExternalReceipt() {
        String testMerchantUid = "merchant_test_external";
        try {
            IamportResponse<ExternalReceipt> response = client.revokeExternalReceipt(testMerchantUid);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * TIERS tests
     * ============================================ */

    @Test
    public void testGetTier() {
        String testTierCode = "test_tier_code";
        try {
            IamportResponse<TierInfo> response = client.getTier(testTierCode);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * USERS tests
     * ============================================ */

    @Test
    public void testGetPgSettings() {
        try {
            IamportResponse<List<PgInfo>> response = client.getPgSettings();

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ============================================
     * VBANKS tests
     * ============================================ */

    @Test
    public void testCreateVbank() {
        long dueTimestamp = System.currentTimeMillis() / 1000L + 86400;
        VbankData vbankData = new VbankData("channel_key_test", getRandomMerchantUid(), BigDecimal.valueOf(1000), "004", dueTimestamp);
        vbankData.setVbank_holder("홍길동");
        vbankData.setName("테스트 가상계좌");

        try {
            IamportResponse<Payment> response = client.createVbank(vbankData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetVbankHolder() {
        try {
            IamportResponse<VbankHolder> response = client.getVbankHolder("004", "12345678901234");

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testModifyVbank() {
        String testImpUid = "imp_test_vbank_uid";
        VbankEditData vbankData = new VbankEditData();
        vbankData.setAmount(2000);

        try {
            IamportResponse<Payment> response = client.modifyVbank(testImpUid, vbankData);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRevokeVbank() {
        String testImpUid = "imp_test_vbank_uid";
        try {
            IamportResponse<Payment> response = client.revokeVbank(testImpUid);

            assertNotNull(response);
        } catch (IamportResponseException e) {
            System.out.println(e.getMessage());
            switch (e.getHttpStatusCode()) {
                case 401:
                    break;
                case 404:
                    break;
                case 500:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getRandomMerchantUid() {
        DateFormat df = new SimpleDateFormat("$$hhmmssSS");
        int n = (int) (Math.random() * 100) + 1;

        return df.format(new Date()) + "_" + n;
    }

    private void assertDateEquals(Date d1, Date d2) {
        assertEquals(d1.getTime() / 1000L, d2.getTime() / 1000L);
    }
}

# iamport REST Client for JAVA

> **⚠️ DEPRECATED**: 이 레포지토리는 2026년 3월 4일부로 deprecated 되었으며, 공식 지원이 되지 않습니다.
> 본 클라이언트는 함께 포함된 [openapi.json](./openapi.json) Swagger spec 기준으로 동작합니다.
> 추가/수정이 필요한 경우 본 레포지토리를 fork하여 수정하거나,
> [PortOne V1 REST API 문서](https://developers.portone.io/api/rest-v1?v=v1)를 참고하여 REST client를 직접 구현해주세요.

JAVA 사용자를 위한 아임포트 REST API 연동 모듈입니다.

- [com.squareup.retrofit2](https://github.com/square/retrofit) 모듈을 기반으로 만들어진 버전
- maven plugin 형태로 제공


## 요구사항
JAVA 1.7이상의 버전을 요구합니다.  
(dependency관계에 있는 [com.squareup.retrofit2](https://github.com/square/retrofit) 이 JAVA 1.7이상의 버전을 요구합니다)


## 설치
    
[JitPack](https://jitpack.io/#iamport/iamport-rest-client-java) 을 통해 maven설정을 하실 수 있습니다.  

pom.xml에 아래의 내용을 추가해주세요. 

```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```

```xml
<dependencies>
	<dependency>
	    <groupId>com.github.iamport</groupId>
	    <artifactId>iamport-rest-client-java</artifactId>
	    <version>0.3.0</version>
	</dependency>
</dependencies>
```
 


## 구현된 API

### 인증 API

- POST /users/getToken

### 결제관련 기본 API

- GET /payments (결제내역 복수조회)
- GET /payments/{imp_uid}
- GET /payments/{imp_uid}/balance
- GET /payments/find/{merchant_uid}/{payment_status}
- GET /payments/findAll/{merchant_uid}/{payment_status}
- GET /payments/status/{payment_status}
- POST /payments/cancel

### 결제 사전검증 API

- POST /payments/prepare
- PUT /payments/prepare
- GET /payments/prepare/{merchant_uid}

### 본인인증 API

- GET /certifications/{imp_uid}
- DELETE /certifications/{imp_uid}
- POST /certifications/otp/request
- POST /certifications/otp/confirm/{imp_uid}

### 에스크로 API

- GET /escrows/logis/{imp_uid}
- POST /escrows/logis/{imp_uid}
- PUT /escrows/logis/{imp_uid}

### 비인증 결제 API

- POST /subscribe/payments/onetime
- POST /subscribe/payments/again

### 정기결제 예약 API

- POST /subscribe/payments/schedule
- POST /subscribe/payments/unschedule
- GET /subscribe/payments/schedule
- GET /subscribe/payments/schedule/{merchant_uid}
- PUT /subscribe/payments/schedule/{merchant_uid}
- POST /subscribe/payments/schedule/{merchant_uid}/retry
- POST /subscribe/payments/schedule/{merchant_uid}/reschedule
- GET /subscribe/payments/schedule/customers/{customer_uid}

### 빌링키 고객정보 API

- GET /subscribe/customers
- GET /subscribe/customers/{customer_uid}
- POST /subscribe/customers/{customer_uid}
- DELETE /subscribe/customers/{customer_uid}
- GET /subscribe/customers/{customer_uid}/payments
- GET /subscribe/customers/{customer_uid}/schedules

### 은행/카드 코드 API

- GET /banks
- GET /banks/{bank_standard_code}
- GET /cards
- GET /cards/{card_standard_code}

### 베네피아 API

- POST /benepia/point
- POST /benepia/payment

### 편의점 결제 API

- POST /cvs
- DELETE /cvs/{imp_uid}

### KCP 퀵페이 API

- DELETE /kcpquick/members/{member_id}
- POST /kcpquick/payment/money

### 현금영수증 API

- GET /receipts/{imp_uid}
- POST /receipts/{imp_uid}
- DELETE /receipts/{imp_uid}
- GET /receipts/external/{merchant_uid}
- POST /receipts/external/{merchant_uid}
- DELETE /receipts/external/{merchant_uid}

### 가상계좌 API

- POST /vbanks
- GET /vbanks/holder
- PUT /vbanks/{imp_uid}
- DELETE /vbanks/{imp_uid}

### 네이버페이 주문처리 관련 API

- GET /naver/product-orders/{product_order_id}
- GET /naver/reviews
- GET /payments/{imp_uid}/naver/cash-amount
- GET /payments/{imp_uid}/naver/product-orders
- POST /payments/{imp_uid}/naver/approve-cancel
- POST /payments/{imp_uid}/naver/cancel
- POST /payments/{imp_uid}/naver/collect-exchanged
- POST /payments/{imp_uid}/naver/ship
- POST /payments/{imp_uid}/naver/ship-exchanged
- POST /payments/{imp_uid}/naver/place
- POST /payments/{imp_uid}/naver/confirm
- POST /payments/{imp_uid}/naver/point

### 네이버페이 반품처리 관련 API

- POST /payments/{imp_uid}/naver/request-return
- POST /payments/{imp_uid}/naver/approve-return
- POST /payments/{imp_uid}/naver/reject-return
- POST /payments/{imp_uid}/naver/withhold-return
- POST /payments/{imp_uid}/naver/resolve-return

### 기타 API

- POST /payco/orders/status/{imp_uid}
- POST /partners/receipts/{imp_uid}
- POST /paymentwall/delivery
- GET /tiers/{tier_code}
- GET /users/pg

## API Client 생성  

### 일반 사용자

```java
IamportClient client = new IamportClient("{가입한 아임포트 계정의 API key}", "{가입한 아임포트 계정의 API secret}");
```

### Agency 사용자 (하위가맹점 관리용 계정)
```java
IamportClient client = new IamportClient("{가입한 아임포트 계정의 API key}", "{가입한 아임포트 계정의 API secret}", "{하위가맹점 Tier Code}");
```

또는,

```java
IamportClient client = new IamportClient("{가입한 아임포트 계정의 API key}", "{가입한 아임포트 계정의 API secret}");
client.setTierCode("{하위가맹점 Tier Code}");
```

## API Client 생성(방화벽 내 사용 환경)  
사내 보안정책에 의해, 아임포트 REST API 서버 접속을 위해 outbound IP 사전 등록이 필요한 환경에서는 아래 2개의 IP에 대해 방화벽 등록 후 API Client 생성시 useStaticIP(기본값 false) 인자를 true로 지정합니다.  
(해당 기능은 0.2.12버전부터 제공됩니다.)

- 13.248.182.65
- 76.223.41.209

```java
IamportClient client = new IamportClient("{가입한 아임포트 계정의 API key}", "{가입한 아임포트 계정의 API secret}", true);
```


## 0.2.x 마이그레이션  
API 응답 오류 상황에 대해 명시적으로 Exception 을 발생시킴으로써 에러 핸들링이 가능하도록 수정하였습니다. 
예를 들어, 기존에는 500응답이 내려오는 경우 오류 message를 확인할 수 없는 단점이 있었는데 `IamportResponseException` 을 throw 함으로써 정확한 오류 원인을 파악하실 수 있습니다.  

또한, 서버와의 네트워크 장애 상황에서는 `IOException` 을 throw 하여 구분이 가능합니다. 

```java
try {
	IamportResponse<Payment> paymentResponse = client.paymentByImpUid("imp_123412341234");
	
	//TODO : 처리 로직
} catch (IamportResponseException e) {
	System.out.println(e.getMessage());
	
	switch(e.getHttpStatusCode()) {
	case 401 :
		//TODO : 401 Unauthorized 
		break;
	case 404 :
		//TODO : imp_123412341234 에 해당되는 거래내역이 존재하지 않음
	 	break;
	case 500 :
		//TODO : 서버 응답 오류
		break;
	}
} catch (IOException e) {
	//서버 연결 실패
	e.printStackTrace();
}
```

## 예제
src/test/java 의 IamportRestTest.java를 참조해주세요

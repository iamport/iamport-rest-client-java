# iamport REST Client for JAVA
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
	    <version>0.2.0</version>
	</dependency>
</dependencies>
```

## 구현된 API

### 인증 API  

- POST /users/getToken

### 결제관련 기본 API  

- GET /payments/{imp_uid}
- GET /payments/status/{payment_status}
- POST /payments/cancel
- POST /subscribe/payments/onetime
- POST /subscribe/payments/again
- POST /subscribe/payments/schedule
- POST /subscribe/payments/unschedule

### 본인인증 API  

- GET /certifications/{imp_uid}

### 에스크로 API   

- POST /escrows/logis/{imp_uid}

### 네이버페이 주문처리 관련 API  

- GET /naver/product-orders/{product_order_id}
- GET /naver/reviews
- GET /payments/{imp_uid}/naver/product-orders
- POST /payments/{imp_uid}/naver/cancel
- POST /payments/{imp_uid}/naver/ship
- POST /payments/{imp_uid}/naver/place

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

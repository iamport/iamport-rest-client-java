# iamport REST Client for JAVA
JAVA 사용자를 위한 아임포트 REST API 연동 모듈입니다.

- [com.squareup.retrofit2](https://github.com/square/retrofit) 모듈을 기반으로 만들어진 버전
- maven plugin 형태로 제공


## 요구사항
JAVA 1.7이상의 버전을 요구합니다.  
(dependency관계에 있는 [com.squareup.retrofit2](https://github.com/square/retrofit) 이 JAVA 1.7이상의 버전을 요구합니다)


## 설치
maven plugin을 다음과 같이 추가하시거나, build된 [jar](build/iamport-rest-client-0.1.1-SNAPSHOT.jar) 파일을 다운로드하세요.

```xml
<dependency>
	<groupId>com.siot.iamport</groupId>
	<artifactId>iamport-rest-client</artifactId>
	<version>0.1.1-SNAPSHOT</version>
</dependency>
```

## 구현된 API
- /users/getToken
- /payments/{imp_uid}
- /payments/cancel

## 예제
src/test/java 의 IamportRestTest.java를 참조해주세요
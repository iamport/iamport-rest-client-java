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
	    <version>0.1.10</version>
	</dependency>
</dependencies>
```

## 구현된 API
- /users/getToken
- /payments/{imp_uid}
- /payments/cancel

## 예제
src/test/java 의 IamportRestTest.java를 참조해주세요

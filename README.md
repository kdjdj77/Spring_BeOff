# BeOff
# JPA Repository / Spring Security (BcryptPasswordEncoder) / Kakao,Naver,Google 로그인 / 전화번호 인증 / 결제

팀명 : 떠나자

팀장 : 김대진

팀원 : 김재윤, 노진수, 안일찬, 진하륜

주제 : 패키지 여행

프로젝트 발표 url : https://www.youtube.com/playlist?list=PLedGoSru794_QVz2l6M3jL4Kjc5yJ8N8J

<p align="">
<img width="500" alt="erd8" src="https://user-images.githubusercontent.com/112387307/224238495-a9c011b0-d17a-46ba-9db7-474046386001.png">

### 📌 프로젝트 기술스택
- 에디터 : Eclipse
- 개발 툴 : SpringBoot 2.7.5
- 자바 : JAVA 11
- 빌드 : Maven 3.0
- 서버 : localhost
- 데이터베이스 : MySql
- 필수 라이브러리 : SpringBoot Web, MySQL, Spring Data JPA, Lombok, Spring Security, jstl

## 구현 완료
**Function** | **완료** | 
:------------ | :-------------|  
**회원가입 / 로그인 구현** | :heavy_check_mark: | 
**Validator** | :heavy_check_mark: | 
**문자인증** | :heavy_check_mark: |  
**Spring Security** | :heavy_check_mark: |  
**BcryptPasswordEncoder 비밀번호 암호화** | :heavy_check_mark: |  
**커뮤니티 구현 (댓글)** | :heavy_check_mark: |  
**항공/숙소/렌트카 관리(추가, 삭제, 수정, 리스트)** | :heavy_check_mark: |  
**결제 시스템** | :heavy_check_mark: | 
**목록 페이징** | :heavy_check_mark: | 
**Header, Footer(홈, 항공/숙소/렌트카 페이지, 결제내역, 관리(관리자), 마이페이지)** | :heavy_check_mark: | 
**마이페이지 구현** | :heavy_check_mark: | 
**항공/숙소/렌트카 페이지 구현(날짜, 위치로 검색가능, 결제)** | :heavy_check_mark: | 
**관리자 페이지(항공/숙소/렌트카 관리)** | :heavy_check_mark: |
**화면 UI 개발 (헤더, 풋터, 회원가입, 로그인, home, 항공/숙소/렌트카 예약/구매/내역, 마이페이지)** | :heavy_check_mark: | 
**google, kakao, naver API 로그인 구현** | :heavy_check_mark: |  
**웹 서버** | :heavy_check_mark: |  
**비동기(ajax)** | :heavy_check_mark: |  



# ERD 다이어그램
<p align="center">
<img width="700" alt="erd8" src="https://user-images.githubusercontent.com/51112376/227470099-d0f6d81b-bf94-40a0-96e2-f323af3e8046.png">


## 🔽 RestAPI EndPoint

| METHOD | URI                                | 기능                       |   | METHOD | URI                                | 기능                       |
| ------ | ---------------------------------- |--------------------------- |---| ------ | ---------------------------------- |--------------------------- |
| REQUEST |  |  ||  |  |  |
| GET | /hotel/admin/list |  ||  |  |  |
| GET | /hotel/admin/roomList |  ||  |  |  |
| GET | /hotel/admin/hotelWrite |  ||  |  |  |
| GET | /hotel/admin/roomWrite |  ||  |  |  |
| POST | /hotel/admin/hotelWriteOk |  ||  |  |  |
| POST | /hotel/admin/roomWriteOk |  ||  |  |  |
| GET | /hotel/admin/update |  ||  |  |  |
| POST | /hotel/admin/hotelUpdateOk |  ||  |  |  |
| POST | /hotel/admin/roomUpdateOk |  ||  |  |  |
| GET | /hotel/admin/delete |  ||  |  |  |
| GET | /hotel/admin/roomDelete |  ||  |  |  |
| G | /rental/admin/list |  ||  |  |  |
| G | /rental/admin/rentalWrite |  ||  |  |  |
| P | /rental/admin/rentalWriteOk |  ||  |  |  |
| G | /rental/admin/rentalUpdate |  ||  |  |  |
| P | /rental/admin/rentalUpdateOk |  ||  |  |  |
| G | /rental/admin/rentalDeleteOk |  ||  |  |  |
| G | /rental/admin/cars/list |  ||  |  |  |
| G | /rental/admin/cars/carWrite |  ||  |  |  |
| P | /rental/admin/cars/carWriteOk |  ||  |  |  |
| G | /rental/admin/cars/carUpdate |  ||  |  |  |
| P | /rental/admin/cars/carUpdateOk |  ||  |  |  |
| G | /rental/admin/cars/carDeleteOk |  ||  |  |  |
|  |  |  ||  |  |  |
|  |  |  ||  |  |  |
|  |  |  ||  |  |  |
|  |  |  ||  |  |  |
|  |  |  ||  |  |  |
|  |  |  ||  |  |  |
|  |  |  ||  |  |  |
|  |  |  ||  |  |  |
|  |  |  ||  |  |  |
|  |  |  ||  |  |  |
|  |  |  ||  |  |  |
|  |  |  ||  |  |  |



# BeOff
# JPA Repository / Spring Security (BcryptPasswordEncoder) / SpringBoot / Kakao,Naver,Google 로그인 / 전화번호 인증 / 결제

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
| GET | /hotel/list | 숙소 목록 || GET | /air/basic | 비행 페이지 |
| POST | /hotel/list | 숙소 검색목록 || POST | /air/settime | 비행 시간대 설정 |
| GET | /hotel/detail | 숙소상세 || POST | /air/onewayReserv | 편도비행 좌석선택 페이지 |
| GET | /hotel/reserve | 숙소 예약 페이지 || POST | /air/roundReserv | 왕복비행 좌석선택 페이지 |
| POST | /hotel/reservOk | 숙소 예약 확인 || POST | /air/onewayReservOk | 편도비행 좌석선택 확인 |
| GET | /hotel/tickets | 숙소 결제내역 || POST | /air/roundReservOk | 왕복비행 좌석선택 확인 |
| POST | /hotel/pageRows | 숙소 페이징 열수변경 || GET | /air/tickets | 비행 결제내역 |
| POST | /hotel | 숙소예약 홈 || POST | /air/delticket | 비행 결제내역 삭제 |
| GET | /hotel/admin/list | 숙소 목록(관리자) || GET | /air/admin/list | 비행 목록(관리자) |
| GET | /hotel/admin/roomList | 방 목록 || POST | /air/admin/addregion | 국가 추가 |
| GET | /hotel/admin/hotelWrite | 숙소 등록 페이지 || POST | /air/admin/addtime | 시간대 추가 |
| GET | /hotel/admin/roomWrite | 방 등록 페이지 || POST | /air/admin/addname | 항공사 추가 |
| POST | /hotel/admin/hotelWriteOk | 숙소 등록 확인 || POST | /air/admin/delregion | 국가 삭제 |
| POST | /hotel/admin/roomWriteOk | 방 등록 확인 || POST | /air/admin/deltime | 시간대 삭제 |
| GET | /hotel/admin/update | 숙소정보 변경 페이지 || POST | /air/admin/delname | 항공사 삭제 |
| POST | /hotel/admin/hotelUpdateOk | 숙소정보 변경 확인 || POST | /air/admin/updateregion | 국가 수정 |
| POST | /hotel/admin/roomUpdateOk | 방정보 변경 확인  || POST | /air/admin/updatetime | 시간대 수정 |
| GET | /hotel/admin/delete | 숙소 삭제 || POST | /air/admin/updatename | 항공사 수정 |
| GET | /hotel/admin/roomDelete | 방 삭제 || GET | /air/admin/aircrud | 항공기 추가 페이지 |
| REQUEST | /hotel/admin/download | 호텔 이미지 다운로드 || POST | /air/admin/aircrudtime | 항공기 시간대 추가 |
| GET | /rental/list | 렌트카 업체 목록 || POST | /air/admin/airplaneupdateOk | 항공기정보 수정 확인 |
| POST | /rental/list | 렌트카 업체 검색목록 || POST | /air/airplane/list | 항공기 목록 |
| POST | /rental/cars/list | 차 목록 || GET | /board/list | QnA목록 |
| GET | /rental/cars/detail | 차 상세 || POST | /board/list | QnA 검색목록 |
| POST | /rental/cars/reserv | 차 예약 페이지 || POST | /board/write | QnA작성 |
| POST | /rental/cars/reservate | 차 예약 || GET | /board/detail | QnA상세 페이지 |
| GET | /rental/tickets | 렌트카 결제내역 || POST | /board/update | QnA 수정 |
| GET | /rental/admin/list | 렌트카 업체목록(관리자) || POST | /board/delete | QnA 삭제 |
| GET | /rental/admin/rentalWrite | 렌트카 업체등록 페이지 || POST | /board/pageRows | QnA 페이징 열수 변경 |
| POST | /rental/admin/rentalWriteOk | 렌트카 업체등록 확인 || REQUEST | /board/download | QnA 이미지 다운로드 |
| GET | /rental/admin/rentalUpdate | 렌트카 업체수정 페이지 || POST | /user/login | 로그인 |
| POST | /rental/admin/rentalUpdateOk | 렌트카 업체수정 확인 || POST | /user/register | 회원가입 |
| GET | /rental/admin/rentalDeleteOk | 렌트카 업체삭제 || GET | /user/userinfo | 회원정보 |
| GET | /rental/admin/cars/list | 차 목록 || REQUEST | /user/rejectAuth | 권한부족 리다이렉트 |
| GET | /rental/admin/cars/carWrite | 차 등록 페이지 || POST | /user/adminreq | 권한요청 |
| POST | /rental/admin/cars/carWriteOk | 차 등록 확인 || POST | /user/apiLogin | API로그인 |
| GET | /rental/admin/cars/carUpdate | 차 수정 페이지 || GET | /user/naverOK | 네이버로그인 확인 |
| POST | /rental/admin/cars/carUpdateOk | 차 수정 확인 || REQUEST | /user/phoneCheck | 인증번호 확인 |
| GET | /rental/admin/cars/carDeleteOk | 차 삭제 || GET | /user/update | 회원정보 수정 페이지 |
| GET | /hcomment/list | 숙소댓글 목록 || POST | /user/updateOk | 회원정보 수정 확인 |
| POST | /hcomment/write | 숙소댓글 작성 || GET | /user/deleteOk | 회원 탈퇴 |
| POST | /hcomment/delete | 숙소댓글 삭제 || GET | /user/admin/authcheck | 권한 부여 페이지(관리자) |
| GET | /comment/list | QnA댓글 목록 || POST | /user/admin/authaccept | 권한 요청 수락 |
| POST | /comment/write | QnA댓글 작성 || POST | /user/admin/authrefuse | 권한 요청 파기 |
| POST | /comment/delete | QnA댓글 삭제 || REQUEST | /auth | 로그인한 유저의 권한 |
| REQUEST | /home | 홈 페이지 ||  |  |  |

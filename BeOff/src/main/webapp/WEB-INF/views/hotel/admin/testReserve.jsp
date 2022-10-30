<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form>
	<h1>여긴 예약페이지</h1>
	호텔이름 <span id="hotelname">${r.hotel.hotelname }</span> <br>
	룸이름 <span id="roomname">${r.roomname }</span> <br>
	가격 <span id="price">${r.price }</span> <br>
	선택한 룸 이미지 
	<span id="roomImg">
		<img class="card-img-top" src="${pageContext.request.contextPath }/upload/${r.files[0].file}" alt="..." />
	</span>
	<br>
	확인ㅇㅋ
	<p>       
		<button id="reserve" type="button" onclick="requestPay('${r.hotel.hotelname}', '${r.price}')">결제하러 간다?</button>
	</p>
</form>
</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script src="${pageContext.request.contextPath }/js/test.js"></script>
</html>
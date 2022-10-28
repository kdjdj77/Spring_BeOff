<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<p>Name</p>
		<input value="${user.name }" readonly>
	
		<p>Phone</p>
		<input value="${user.phonenum }" readonly>
	
		<p>Email</p>
		<input value="${user.email }" readonly>
	
		<p>Hotel</p>
		<input value="${hotel.hotelname }" readonly>
		
		<p>Room</p>
		<input value="${room.roomname }" readonly>
		
		<p>가격</p>
		<input value="${room.price }원" readonly>
		
		<button>결제하기</button>
</body>
</html>
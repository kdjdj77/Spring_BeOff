<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%-- 로그인한 사용자 정보 Authentication 객체의 필요한 property 들을 변수에 담아 사용 가능  --%>
<sec:authentication property="name" var="username" />
<sec:authentication property="authorities" var="authorities" />
<sec:authentication property="principal" var="userdetails" />


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	const conPath = "${pageContext.request.contextPath }";
	const logged_id = ${userdetails.user.id};
</script>
<script src="${pageContext.request.contextPath }/js/comment.js"></script>
<title>detail</title>
</head>

<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<%
			String region = request.getParameter("region");
			String checkin = request.getParameter("inn");
			String checkout = request.getParameter("out");
		%>

	<hr style="height:2px; background-color: #e52813;">
		<div class="justify-content-center text-center">호텔 정보</div>
	<hr style="height:2px; background-color: #e52813;">
	<div class="w-75  container" style="border-top:1px solid gray; border-bottom:1px solid gray;">
		<div style="float: left;">
			<img style="height: 210px; width:410px" src="${pageContext.request.contextPath }/upload/${hotel.rooms[0].files[0].file}"  alt="...">
		</div>
		<div style="margin-left:430px; ">
			
			<div><h3>${hotel.hotelname }</h3></div>
			<br>
			<div><%=region %> / ${hotel.content }</div>
			<br>
			<div>
				<span>별점 : </span>
					<span style="color:#FFB400;">
						<label><span id="star_cnt"></span>★</label>
					</span>
			</div>
			<br>
			<br>
			<div>
			<span>여행날짜 : </span>
			<span><%=checkin %> ~ <%=checkout %> </span>
			</div>
		</div>
	</div>
	<hr style="height:2px; background-color: #e52813;">
		<div class="justify-content-center text-center">객실 목록</div>
	<hr style="height:2px; background-color: #e52813;">
		<br>
	<c:forEach var="i" items="${roomList }">
		<div class="w-50  container" >
		<div style="border:2px solid gray;">
		<div>
			<img style="height: 210px; width:300px; float: left;" src="${pageContext.request.contextPath }/upload/${i.files[0].file}"  class="mt-1 ms-1" alt="..." />
		</div>
		<div  style="margin-left:315px; ">
			<p style="margin-top:10px; " class="text-center">${i.roomname}</p>
			
	<hr style="height:2px; background-color: #e52813;">
			<div class="text-center">
				<span>가격 : </span>
				<span>${i.price }원</span>
				<br>
				<br>
				<span>침대 갯수 : </span>
				<span>${i.bed }개</span>
			</div><br>
			<div style="margin-top:20px; margin-bottom:5px;">
				<button class="hover1" type="button" onclick="location.href='../hotel/reserve?id=${i.id}&checkin=<%=checkin %>&checkout=<%=checkout %>&price=${i.price}'">예약</button>
			</div></div></div></div><br>
	</c:forEach>
    	<hr style="height:2px; background-color: #e52813;">
		<div class="justify-content-center text-center">후기 목록</div>
	<hr style="height:2px; background-color: #e52813;">
	


	<input type="hidden" name="inn" id="inn" value="${checkin }">
	<input type="hidden" name="out" id="out" value="${checkout }">
	<input type="hidden" name="id" value="${hotel.id }">

	<jsp:include page="hcomment.jsp" />


</body>
<style>
.hover1{
	border-radius : 5px;
	width:410px;
	border:1px solid black;
	background-color:#f70260;
	color:white;
    }
.hover1:hover{
	background-color:#141414;
}

 
</style>
</html>
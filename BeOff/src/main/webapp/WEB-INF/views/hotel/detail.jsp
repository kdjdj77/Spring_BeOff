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
			String checkin = request.getParameter("checkin");
			String checkout = request.getParameter("checkout");
		%>
		
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>지역</th>
				<th>체크인</th>
				<th>체크아웃</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=region %></td>
				<td><%=checkin %></td>
				<td><%=checkout %></td>
			</tr>
		</tbody>
	</table>	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>#</th>
				<th>호텔 이름</th>
				<th>호텔 정보</th>
				<th>별점 평균</th>
			</tr>
		</thead>
		<tbody>

			<tr>
				<td>${hotel.id }</td>
				<td>${hotel.hotelname }</td>
				<td>${hotel.content }</td>
				<td><label><span id="star_cnt"></span> 점</label></td>
			</tr>
		</tbody>
	</table>
	
    
	<table class="table table-bordered" id="table">
		<thead>
			<tr>
				<th>#</th>
				<th>방 이름</th>
				<th>방 가격</th>
				<th>침대 갯수</th>
				<th>방 사진</th>
				<th>예약</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${hotel.rooms }">
				<tr>
					<td>${i.id }</td>
					<td>${i.roomname }</td>
					<td>${i.price }</td>
					<td>${i.bed }</td>
					<td><img style="width: 300px; height: 300px;"
						src="${pageContext.request.contextPath }/upload/${i.files[0].file}"
						alt="..." /></td>
					<td><button
							onclick="location.href='../hotel/reserve?id=${i.id}&checkin=<%=checkin %>&checkout=<%=checkout %>&price=${i.price}'">예약하기</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<input type="hidden" name="inn" id="inn" value="${checkin }">
	<input type="hidden" name="out" id="out" value="${checkout }">
	<input type="hidden" name="id" value="${hotel.id }">

	<jsp:include page="hcomment.jsp" />


</body>
</html>

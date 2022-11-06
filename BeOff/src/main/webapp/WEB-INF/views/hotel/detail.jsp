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
		<!--  
		<div>목적지 >> <%=region %></div>
		<div>
		<div>체크인 ~ 체크아웃 >> <%=checkin %> ~ <%=checkout %></div>
		<div>검색 결과입니다.</div>
		</div>
	<div class="container  text-white  mb-5" style="border: 1px solid #333333; background-color:#0c75ed;">
		<div class="row">
				<div class="col-sm-4">목적지</div>
				<div class="col-sm-4">체크인 날짜</div>
				<div class="col-sm-4">체크아웃 날짜</div>
		</div>
		<hr>
		<div class="row"> 
				<div class="col-sm-4">
				</div>
				<div class="col-sm-4">
				</div>
				<div class="col-sm-4">
				</div>
		</div>
	</div>
	-->
	<hr style="height:2px; background-color: black;">
	<div class="w-75  container " >
		<div style="float: left;">
			<img style="height: 210px; width:400px" src="${pageContext.request.contextPath }/upload/${hotel.rooms[0].files[0].file}" class="card-img-top" alt="...">
		</div>
		<div style="margin-left:430px; ">
			
			<div><h3>${hotel.hotelname }</h3></div>
			<br>
			<div><%=region %> / ${hotel.content }</div>
			<br>
			<div>
				<span>별점 평균 : </span>
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
		<!--  
		<c:forEach var="i" items="${roomList }">
	<div class="w-75  container">
		<br>
		<div>${i.roomname}</div>
		<div>
			<span>가격 : </span>
			<span>${i.price }원</span>
		</div>
		<div>
			<button onclick="location.href='../hotel/reserve?id=${i.id}&checkin=<%=checkin %>&checkout=<%=checkout %>&price=${i.price}'">예약하기</button>
		</div>
		<div>
			<img style="width: 200px; height: 150px;" src="${pageContext.request.contextPath }/upload/${i.files[0].file}" alt="..." />
		</div>
	</div>
	<br>
	<br>
		</c:forEach>
	-->
	<c:forEach var="i" items="${roomList }">
		<div class="w-75  container " >
		<div>
			<div>${i.roomname}</div>
			<div>
				<span>가격 : </span>
				<span>${i.price }원</span>
			</div>
			<div>
				<button onclick="location.href='../hotel/reserve?id=${i.id}&checkin=<%=checkin %>&checkout=<%=checkout %>&price=${i.price}'">예약하기</button>
			</div>
		</div>
		<br><br><br><br>
		<div style="float: right;">
			<img style="height: 200px; width:200px" src="${pageContext.request.contextPath }/upload/${i.files[0].file}" alt="..." />
		</div>
	</div>
	</c:forEach>
    
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
			<c:forEach var="i" items="${roomList }">
				<tr>
					<td>${i.id }</td>
					<td>${i.roomname }</td>
					<td>${i.price }원</td>
					<td>${i.bed }</td>
					<td><img style="width: 300px; height: 300px;"
						src="${pageContext.request.contextPath }/upload/${i.files[0].file}"
						alt="..." /></td>
					<td><button onclick="location.href='../hotel/reserve?id=${i.id}&checkin=<%=checkin %>&checkout=<%=checkout %>&price=${i.price}'">예약하기</button></td>
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
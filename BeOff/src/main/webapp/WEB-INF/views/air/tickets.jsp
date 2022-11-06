<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%-- 로그인한 사용자 정보 Authentication 객체의 필요한 property 들을 변수에 담아 사용 가능  --%>
<sec:authentication property="name" var="username"/>  
<sec:authentication property="authorities" var="authorities"/> 
<sec:authentication property="principal" var="userdetails"/>    
    
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

	<script src="https://kit.fontawesome.com/51772bd9bd.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	
	<title>비행기 예매목록</title>
</head>

<body style="margin-bottom: 200px">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="container mt-3">
		<h2 style="margin-left:200px;">${username}(${userdetails.user.name}) 님의 비행기 예매</h2>
		<c:forEach var="i" items="${list}" begin="1">
			<table style="width:60%; height:200px; margin:auto;">
				<tr style="height:20px;"></tr>
				<tr style="height:10px;">
					<td>${i.regDateTime}</td><td></td><td></td>
				</tr>
				<tr style="background-color:#87CEFA;">
					<td style="width:30%; text-align:center; font-size:1.5rem;">
						${i.airplane.depart.region} → ${i.airplane.arrive.region}
						<br>
					</td>
					<td style="width:30%; text-align:center; font-size:1.5rem;">
						${i.airplane.name.name}
						<br>
					</td>
					<td style="width:30%; text-align:center; font-size:1.5rem;">
						${i.seat}
						<br>
					</td>
					<td rowspan="2" style="width:10%; text-align:center;">
						<form action="#" method="post" style="width:100%; height:100%;">
							<input type="hidden" name="ticketIds" value="${i.id}">
							<input type="hidden" name="ids" value="${i.ids}">
							<button type="button" class="btn btn-danger" style="width:100%; height:100%;">취소</button>
						</form>
					</td>
				</tr>
				<tr style="background-color:#87CEFA;">
					<td style="width:30%; text-align:center; font-size:1.5rem;">
						${i.date.toString().substring(0, 4)}.${i.date.toString().substring(4, 6)}.${i.date.toString().substring(6, 8)}
					</td>
					<td style="width:30%; text-align:center; font-size:1.5rem;">
						${i.airplane.time.time}KST
					</td>
					<td style="width:30%; text-align:center; font-size:1.5rem;">
						${i.price}￦
					</td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>

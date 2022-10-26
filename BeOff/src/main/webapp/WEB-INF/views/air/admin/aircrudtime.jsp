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
	
	<title>비행기 예매</title>
	<style>
		input[type="number"]::-webkit-outer-spin-button,
		input[type="number"]::-webkit-inner-spin-button {-webkit-appearance: none; margin: 0;}
		td {padding-top:0.5rem;padding-bottom:0.5rem;}
		select {height:32px; width:95%;}
		input[type=checkbox] {width:20px; height:20px;}
	</style>
</head>

<body style="margin-bottom: 200px">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<div class="container mt-3">
		<h2>
			항공기 타임테이블
			<a class="btn btn-outline-dark" href="list">목록</a>
		</h2>
		<hr>
		<span class="fs-4">항공사 : ${airname.name }</span><br>
		<span class="fs-4">경로&nbsp;&nbsp;&nbsp; : ${departregion.region } → ${arriveregion.region }</span>
		<p></p>
		<hr>
		<form action="airplaneupdateOk" method="post">
			<input type="hidden" name="departregion" value="${departregion.id}">
			<input type="hidden" name="arriveregion" value="${arriveregion.id}">
			<input type="hidden" name="airname" value="${airname.id}">
			<span class="fs-4">
				타임테이블 
				<button class="btn btn-outline-dark">등록</button>
			</span><br><br>
			<div class="d-flex">
				<c:forEach var="t" items="${timeList}">
					<div class="border mx-4 p-2">
						<label for="${t.id}" class="fs-5">${t.time}</label>
						<c:choose>
							<c:when test="${existList.contains(t)}">
								<input class="mt-1" type="checkbox" name="etimelist" id="${t.id}" value="${t.time}" checked>
							</c:when>
							<c:otherwise>
								<input class="mt-1" type="checkbox" name="etimelist" id="${t.id}" value="${t.time}">
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
			</div>
		</form>
	</div>
</body>	
</html>

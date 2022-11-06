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
		select {height:50px; width:95%;}
	</style>
</head>

<body style="margin-bottom: 200px;">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<div class="container mt-3" style="font-size:1.5rem;">
		<h2>
			항공기 관리
			<a class="btn btn-outline-dark" href="list">목록</a>
		</h2>
		<p><br><br></p>
		<form action="aircrudtime" method="post">
			<table width="100%">
				<thead>
					<tr>
						<th width="25%">출발지</td>
						<th width="25%">목적지</td>
						<th width="25%">항공사</td>
						<th width="25%"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<select name="departregion" id="in1">
								<option value="null" selected>선택</option>
								<c:forEach var="region" items="${regionList}">
									<option value = "${region.id}">${region.region}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<select name="arriveregion" id="in2">
								<option value="null" selected>선택</option>
								<c:forEach var="region" items="${regionList}">
									<option value="${region.id}">${region.region}</option>
								</c:forEach>
							</select>
						</td> 
						<td>
							<select name="aircomp" id="in3">
								<option value="null" selected>선택</option>
								<c:forEach var="name" items="${airnameList}">
									<option value="${name.id}">${name.name}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<button class="btn btn-outline-dark" style="width:150px; height:50px; font-size:1.5rem;">검색</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		
	</div>
</body>	
</html>

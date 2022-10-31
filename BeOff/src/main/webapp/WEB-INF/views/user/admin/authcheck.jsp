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
	
	<title>권한 수락</title>

</head>

<body style="margin-bottom: 200px">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<div class="container mt-3">
		<h2>권한 수락</h2>
		<table style="width:100%; text-align:start; border-bottom:1px solid black;">
			<tr style="border-bottom:1px solid black;">
				<td style="border-right:1px solid black;" width="10%">유저</td>
				<td style="border-right:1px solid black;" width="15%">권한</td>
				<td style="border-right:1px solid black;" width="50%">내용</td>
				<td width="10%">&nbsp;</td>
			</tr>
		<c:forEach var="i" items="${list}">
			<tr style="border-bottom:1px solid black;">
				<td style="border-right:1px solid black;">${i.user.name}</td>
				<td style="border-right:1px solid black;">${i.authority.name}</td>
				<td style="border-right:1px solid black;"><pre style="font-size:1.2rem; font-family:sans-serif; word-wrap: break-word;white-space: pre-wrap;white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap;word-break:break-all;">${i.content}</pre></td>
				<td class="d-flex justify-content-around mt-3">
					<form action="authaccept" method="post">
						<input type="hidden" name="authreqId" value="${i.id}">
						<input type="hidden" name="userId" value="${i.user.id}">
						<input type="hidden" name="authId" value="${i.authority.id}">
						<button class="btn btn-success">수락</button>
					</form>
					<form action="authrefuse" method="post">
						<input type="hidden" name="authreqId" value="${i.id}">
						<button class="btn btn-danger">거절</button>
					</form>
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>	
</html>

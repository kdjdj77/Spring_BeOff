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
</head>

<body style="margin-bottom: 200px">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<div class="container mt-3">
		<h2>국가/비행기시간/항공사 관리</h2>
		<hr>
		<table>
			<thead>
				<tr>
                    <th width="40%">국가</th>
                    <th width="40%">출국시간</th>
                    <th width="40%">항공사</th>
                </tr>
			</thead>
			<tbody>
				<tr>
					<td valign="top" >
						<table>
							<input type="text" name="addregion">
							<button type="button">추가</button>
							<c:forEach var="region" items="${regionList}">
								<tr><td>${region}</td></tr>
							</c:forEach>
						</table>
					</td>
					<td valign="top">
						<table>
							<input type="text" name="addtime">
							<button type="button">추가</button>
							<c:forEach var="time" items="${timeList}">
								<tr><td>${time}</td></tr>
							</c:forEach>
						</table>
					</td>
					<td valign="top">
						<table>
							<input type="text" name="addname">
							<button type="button">추가</button>
							<c:forEach var="name" items="${nameList}">
								<tr><td>${name}</td></tr>
							</c:forEach>
						</table>
					</td>							
				</tr>
			</tbody>
		</table>
	</div>
</body>	
</html>

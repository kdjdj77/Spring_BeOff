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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <title>목록</title>
</head>

<body style="margin-bottom: 200px">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<div class="container mt-3">
		<h2>비행기 표 예매하기</h2>
		<hr>
		<form name="frm" action="chkround" method="post">
			<table width="100%">
				<thead>
					<tr>
	                    <th>출발지</th>
	                    <th>목적지</th>
	                    <th>가는날</th>
	                    <th>오는날</th>
	                    <th>편도/왕복</th>
	                    <th>인원</th>
	                </tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<select name="depart">
								<c:forEach var="region" items="${regionList}">
									<option value = "${region}">${region}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<select name="arrive">
								<c:forEach var="region" items="${regionList}">
									<option value="${region}">${region}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							달력
						</td>
						<td>
							달력
						</td>
						<td>
							<select name="round_oneway">
								<option value="round">왕복</option>
								<option value="oneway">편도</option>
							</select>
						</td>
						<td>
							<button type="button" class="minus">-</button>
							<span id="num">1</span>
							<input type="hidden" name="num_person" id="num_person" value="1"></input>
							<button type="button" class="plus">+</button>
						</td>
					</tr>
				</tbody>
			</table>
			<button onclick="submit()">비행기 예매 시작</button>
		</form>
	</div>
</body>
<script>
	let num = document.querySelector("#num");
	let plus = document.querySelector(".plus");
	let minus = document.querySelector(".minus");
	let np = document.querySelector("#num_person")
	let frm = document.querySelector("#frm");
	
	let cnt = 1;
	
	plus.addEventListener("click", function () {
		cnt++; 
		num.textContent = cnt;
		np.value = cnt;
	})
	minus.addEventListener("click", function () {
		if (cnt > 1) {
			cnt--;
			num.textContent = cnt;
			np.value = cnt;
		}
	})
</script>
</html>

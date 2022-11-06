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
	
	<title>비행기 예매</title>
	<style>
		body {
			overflow-x: hidden;
		}
		input[type=radio]{
		    display: none;
		}
		input[type=radio]+label{
		    display: inline-block;
		    cursor: pointer;
		    height: 40px;
		    width: 70px;
		    border: 1px solid #333;
		    border-radius:3px;
		    line-height: 38px;
		    text-align: center;
		}
		input[type=radio]+label{
		    background-color: #fff;
		    color: #333;
		}
		input[type=radio]:checked+label{
		    background-color: #36f;
		    color: #fff;
		}
		input[type=radio]+label:hover{
		    background-color: #cff;
		    color: #333;
		}
	</style>
</head>

<body style="margin-bottom: 200px">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<div class="container mt-3">
		<h2>편도 비행기 시간 설정</h2>
		<hr>
		<div class="d-flex justify-content-center" style="width:100%">
			<div style="width:40vw;">
			<div style="font-size:1.3rem;">
				<span>출발일자 : ${departdate}</span>
				<span class="ms-5">${departregion} → ${arriveregion}</span>
				<span class="ms-5">인원 : ${num_person}</span><br>
			</div>
			<div style="font-size:1.3rem; padding-left:200px;">
				<br>출발시각 : 
				<select name="time_sel">
					<c:forEach var="t" items="${timeList}">
						<option value = "${t}">${t}</option>
					</c:forEach>
				</select>
			</div>
			<div style="width:100vw">
				<label><br>개수: <span id="air_cnt"></span> 개</label>
				<form id="frm" action="onewayReserv" method="post">
					<table id="air_list" width="40%">
						<!-- 비행기 리스트(input airplane_id 포함) -->
					</table>
					<input type="hidden" name="departdate" value="${departdate}">
					<input type="hidden" name="num_person" value="${num_person}">
					<p><br></p>
					<button type="button" style="margin-left:15%; width:150px; height:70px; font-size:1.5rem;" class="btn btn-outline-dark" onclick="frmsubmit()">다음</button>

				</form>
			</div>
			</div>
		</div>
	</div>
	<div id="notSend">
		<input type="hidden" name="departregion" value="${departregion}">
		<input type="hidden" name="arriveregion" value="${arriveregion}">
	</div>
</body>

<script>
	const conPath = "${pageContext.request.contextPath }";
	function frmsubmit() {
		const frm = document.getElementById("frm");	
		const NodeList = document.getElementsByName('air_id');
		let check = false;
		  
		NodeList.forEach(function(node) {
			if(node.checked) check = true;
		}) 
		if (check) frm.submit();
		else alert("비행편을 선택해주세요");
	}
</script>
<script src="${pageContext.request.contextPath }/js/airlist.js"></script>

</html>

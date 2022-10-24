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
</head>

<body style="margin-bottom: 200px">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<div class="container mt-3">
		<h2>왕복 비행기 시간 설정</h2>
		<hr>
		<form id="frm" action="roundReserv" method="post">
		<table width="100%">
			<tr>
				<td>
					<span>출발일자 : ${departdate}</span>
					<span>${departregion} → ${arriveregion}</span>
					<div>
						<span>인원 : ${num_person}</span>
						출발시각
						<select name="time_sel">
							<c:forEach var="t" items="${timeList}">
								<option value = "${t}">${t}</option>
							</c:forEach>
						</select>
					</div>
				</td>
				<td>
					<span>출발일자 : ${departdate2}</span>
					<span>${departregion2} → ${arriveregion2}</span>
					<div>
						<span>인원 : ${num_person2}</span>
						출발시각
						<select name="time_sel2">
							<c:forEach var="t" items="${timeList}">
								<option value = "${t}">${t}</option>
							</c:forEach>
						</select>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div>
						<label>개수: <span id="air_cnt"></span> 개</label>
						
						<table id="air_list" width="60%">
							<!-- 비행기 리스트(input airplane_id 포함) -->
						</table>
						<input type="hidden" name="departdate" value="${departdate}">
						<input type="hidden" name="num_person" value="${num_person}">
						
					</div>
				</td>
				<td>
					<div>
						<label>개수: <span id="air_cnt2"></span> 개</label>
					
						<table id="air_list2" width="60%">
							<!-- 비행기 리스트(input airplane_id 포함) -->
						</table>
						<input type="hidden" name="departdate2" value="${departdate2}">
						<input type="hidden" name="num_person2" value="${num_person2}">
						
					</div>
				</td>
			</tr>
		</table>
		</form>
		<div class="container mt-3"style="width:100%;">
	        <button type="button" onclick="frmsubmit()" style="position:absolute; left:35%; height:50px; width:100px;" class="btn btn-outline-dark mx-3">다음</button>
	    </div>
	</div>
	<div id="notSend">
		<input type="hidden" name="departregion" value="${departregion}">
		<input type="hidden" name="arriveregion" value="${arriveregion}">
		<input type="hidden" name="departregion2" value="${departregion2}">
		<input type="hidden" name="arriveregion2" value="${arriveregion2}">
	</div>
</body>

<script>
	const conPath = "${pageContext.request.contextPath }";
	function frmsubmit() {
		let frm = document.getElementById("frm");
		frm.submit();
	}
</script>
<script src="${pageContext.request.contextPath }/js/airlist.js"></script>
<script src="${pageContext.request.contextPath }/js/airlist2.js"></script>

</html>

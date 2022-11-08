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
	
	<title>BeOff</title>
	<style>
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
		    width: 40px;
		    border:3px solid black;
		    border-radius:3px;
		    line-height: 38px;
		    text-align: center;
		    background-color: #fff;
		    color: #fff;
		}
		input[type=radio]:checked+label{
		    color: #000;
		}
		input[type=radio]+label:hover{
		    border:3px solid gray;
		}
	</style>
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
				<td style="font-size:1.3rem;">
					<span>출발일자 : ${departdate}</span>
					<span class="ms-5">${departregion} → ${arriveregion}</span>
					<span class="ms-5">인원 : ${num_person}</span>
					<div style="margin-left:25%;">
						<br>출발시각
						<select name="time_sel">
							<c:forEach var="t" items="${timeList}">
								<option value = "${t}">${t}</option>
							</c:forEach>
						</select>
						<p></p>
					</div>
				</td>
				<td style="font-size:1.3rem;">
					<span>출발일자 : ${departdate2}</span>
					<span class="ms-5">${departregion2} → ${arriveregion2}</span>
					<span class="ms-5">인원 : ${num_person2}</span>
					<div style="margin-left:25%;">
						<br>출발시각
						<select name="time_sel2">
							<c:forEach var="t" items="${timeList}">
								<option value = "${t}">${t}</option>
							</c:forEach>
						</select>
						<p></p>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div>
						<label>개수: <span id="air_cnt"></span> 개</label>
						
						<div id="air_list" width="80%">
							<!-- 비행기 리스트(input airplane_id 포함) -->
						</div>
						<input type="hidden" name="departdate" value="${departdate}">
						<input type="hidden" name="num_person" value="${num_person}">
						
					</div>
				</td>
				<td>
					<div>
						<label>개수: <span id="air_cnt2"></span> 개</label>
					
						<div id="air_list2" width="80%">
							<!-- 비행기 리스트(input airplane_id 포함) -->
						</div>
						<input type="hidden" name="departdate2" value="${departdate2}">
						<input type="hidden" name="num_person2" value="${num_person2}">
						
					</div>
				</td>
			</tr>
		</table>
		</form>
		<div class="container mt-3"style="width:100%;">
	        <button type="button" onclick="frmsubmit()" style="position:absolute; left:41%; height:60px; width:130px; font-size:1.5rem;" class="btn btn-outline-dark mx-3">다음</button>
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
		const frm = document.getElementById("frm");
		const NodeList = document.getElementsByName('air_id');
		const NodeList2 = document.getElementsByName('air_id2');
		let check1 = false;
		let check2 = false
		  
		NodeList.forEach(function(node) {if(node.checked) check1 = true;}) 
		NodeList2.forEach(function(node) {if(node.checked) check2 = true;})
		
		if (check1 && check2) frm.submit();
		else alert("비행편을 선택해주세요");
	}
</script>
<script src="${pageContext.request.contextPath }/js/airlist.js"></script>
<script src="${pageContext.request.contextPath }/js/airlist2.js"></script>

</html>

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
		select {height:32px; width:95%;}
		input[type=button] {height:32px;width:70%;}
		img {cursor:pointer;}
	</style>
</head>

<body style="margin-bottom: 200px">
	<%-- 인증 헤더 --%>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<div class="container mt-3">
		<h2>
			비행기 표 예매하기
			<sec:authorize access="hasAnyRole('ADMIN_AIR')">
            	<a class="btn btn-outline-dark" href="admin/list">관리</a>
            </sec:authorize>
		</h2>
		<hr>
		<p><br><br><br><br><br></p>
		<form name="frm" id="frm" action="settime" method="post">
			<table width="100%">
				<thead>
					<tr>
	                    <th width="17%">출발지</th>
	                    <th width="17%">목적지</th>
	                    <th width="17%">가는날</th>
	                    <th width="17%">오는날</th>
	                    <th width="17%">편도/왕복</th>
	                    <th width="17%">&nbsp;&nbsp;인원</th>
	                </tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<select name="departregion" id="in1">
								<option value="null" selected>선택</option>
								<c:forEach var="region" items="${regionList}">
									<option value = "${region}">${region}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<select name="arriveregion" id="in2">
								<option value="null" selected>선택</option>
								<c:forEach var="region" items="${regionList}">
									<option value="${region}">${region}</option>
								</c:forEach>
							</select>
						</td> 
						<td>
							<input name="dd" type="button" id="in3">
							<input name="departdate" type="hidden" id="in3h">
						</td>
						<td id="arrivebox">
							<input name="ad" type="button" id="in4">
							<input name="arrivedate" type="hidden" id="in4h">
						</td>
						<td>
							<select name="round_oneway" id="in5">
								<option value="round" selected>왕복</option>
								<option value="oneway">편도</option>
							</select>
						</td>
						
						<td>
							&nbsp;&nbsp;
							<button type="button" class="minus btn btn-sm btn-outline-dark">-</button>
							<span id="num">1</span>
							<input type="hidden" name="num_person" id="in6" value="1"></input>
							<button type="button" class="plus btn btn-sm btn-outline-dark">+</button>
						</td>
					</tr>
				</tbody>
			</table>
			<p><br></p>
			<div class="px-5 d-flex justify-content-center">
				<button type="button" class="btn btn-outline-dark" style="width:200px; height:50px;" onclick="mysubmit()">비행기 예매 시작</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</form>
	</div>
</body>
<script>
	$( function() {
		$( "#in3, #in4" ).datepicker({
			showMonthAfterYear:true,
			showOn:"button",           
			buttonImage:"${pageContext.request.contextPath }/img/aircalender.png",            
			buttonImageOnly:true,
			dateFormat:'yy-mm-dd', 
			minDate: 0,          
			nextText:'다음 달',            
			prevText:'이전 달',            
			dayNamesMin:['일','월','화','수','목','금','토'],            
			monthNames:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
			
		});
		$("#in3").datepicker('setDate', 'today');
		$("#in4").datepicker('setDate', 'today');
		
		$('#in5').change(function() {
			if ($('#in5').val() == "oneway") {
				$('#arrivebox').css("visibility", "hidden");
			} else {
				$('#arrivebox').css("visibility", "visible");
			}
		});
	});
</script>
<script>
	let num = document.querySelector("#num");
	let plus = document.querySelector(".plus");
	let minus = document.querySelector(".minus");
	
	let frm = document.querySelector("#frm");
	let in1 = document.querySelector("#in1");
	let in2 = document.querySelector("#in2");
	let in5 = document.querySelector("#in5");
	let in6 = document.querySelector("#in6");
	
	let in3 = document.querySelector("#in3");
	let in4 = document.querySelector("#in4");
	let in3h = document.querySelector("#in3h");
	let in4h = document.querySelector("#in4h");
	
	
	let cnt = 1;
	
	plus.addEventListener("click", function () {
		cnt++; 
		num.textContent = cnt;
		in6.value = cnt;
	})
	minus.addEventListener("click", function () {
		if (cnt > 1) {
			cnt--;
			num.textContent = cnt;
			in6.value = cnt;
		}
	})
	function mysubmit() {
		if (in1.value == "null") {alert('출발지를 선택해주세요'); return;}
		if (in2.value == "null") {alert('목적지를 선택해주세요'); return;}
		if (in1.value == in2.value) {alert('출발지와 목적지는 달라야 합니다'); return;}
		if (in5.value == "round" && in3.value > in4.value) {
			alert('오는날은 가는날 이전이어야 합니다'); 
			return;
		}
		in3h.value = in3.value.toString();
		in4h.value = in4.value.toString();
		frm.submit();
	}
</script>
</html>

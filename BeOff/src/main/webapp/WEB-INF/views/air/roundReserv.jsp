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

	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>    
    <title>BeOff</title>
    <style>
    	.seat {width:44px; height:30px;}
    	.none {background-color:dimgray;}
    	.clicked {background-color:red; color:white;}
    	.clicked2 {background-color:red; color:white;}
    	.inv {opacity:0;}
    </style>
</head>
<c:set var="air_id" value="${id}"/>
<body>
    <%-- 인증 헤더 --%>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <br><br><br>
    <div class="container"><h3>좌석예매 - 왕복</h3></div>
    <div class="container mt-3"style="display:flex; justify-content:center;">
        <table width="100%">
	        <tr>
		        <td>
		        <div class="seat-wrapper">
					<div style="width:485px; height:50px; text-align:center; background-color:white" class="mb-5 border">
						<table width="100%">
							<tr>
								<td>
									<span>${airplane.name.name}</span><br>
									<span>출발시각 : ${airplane.time.time}</span>
								</td>
								<td>
									<span>${date}</span><br>
									<span>가격 ${airplane.name.price * num}￦</span>
								</td>
								<td>
									<span>${airplane.depart.region} → ${airplane.arrive.region}</span><br>
									<span>인원 ${num}</span>
								</td>
							</tr>
						</table>
					</div>
		        </div>
		        </td>
		        <td>
		        <div class="seat-wrapper2">
					<div style="width:485px; height:50px; text-align:center; background-color:white" class="mb-5 border">
						<table width="100%">
							<tr>
								<td>
									<span>${airplane2.name.name}</span><br>
									<span>출발시각 : ${airplane2.time.time}</span>
								</td>
								<td>
									<span>${date2}</span><br>
									<span>가격 ${airplane2.name.price * num2}￦</span>
								</td>
								<td>
									<span>${airplane2.depart.region} → ${airplane2.arrive.region}</span><br>
									<span>인원 ${num2}</span>
								</td>
							</tr>
						</table>
					</div>
		        </div>
		        </td>
        	</tr>
        </table>
    </div>
    <div class="container mt-3"style="display:flex; justify-content:center;">
        <button style="height:60px; width:100px;" class="btn btn-outline-dark mx-3" onClick="iamport()">카드결제</button>
        <button style="height:60px; width:100px;" class="btn btn-outline-dark mx-3" onClick="frmSubmit(0)">바로결제(테스트)</button>
    </div>
    <p><br><br></p>
	<input type="hidden" id="id" value="${airplane.id}">
	<input type="hidden" id="date" value="${date}">
	<input type="hidden" id="num" value="${num}">
	
	<input type="hidden" id="id2" value="${airplane2.id}">
	<input type="hidden" id="date2" value="${date2}">
	<input type="hidden" id="num2" value="${num2}">
</body>
<script>
	let reserved = [];
	let reserved2 = [];
</script>
<c:forEach var="item" items="${reserved}">
	<script>reserved.push("${item}");</script>
</c:forEach>
<c:forEach var="item" items="${reserved2}">
	<script>reserved2.push("${item}");</script>
</c:forEach>

<script src="${pageContext.request.contextPath }/js/reservAir.js"></script>
<script src="${pageContext.request.contextPath }/js/reservAir2.js"></script>
<script>
	function frmSubmit(flag) {
		let air_id = document.getElementById("id").value;
		let dDate = document.getElementById("date").value;
		let numInt = document.getElementById("num").value;
		
		let air_id2 = document.getElementById("id2").value;
		let dDate2 = document.getElementById("date2").value;
		let numInt2 = document.getElementById("num2").value;
		
		let newForm = document.createElement('form');
		newForm.name = 'newForm';
		newForm.method = 'post';
		newForm.action = 'roundReservOk';
	
		for (let i = 0; i < selectedSeats.length; i++) {
			let input1 = document.createElement("input");
	
			input1.type = "hidden";
			input1.name = "seats";
			input1.value = selectedSeats[i];
	
			newForm.append(input1);
		}
		
		const input2 = document.createElement('input');
		input2.type = "hidden";
		input2.name = "id";
		input2.value = air_id;
		newForm.append(input2);
		
		const input3 = document.createElement('input');
		input3.type = "hidden";
		input3.name = "departDate";
		input3.value = dDate;
		newForm.append(input3);	
		
		for (let i = 0; i < selectedSeats2.length; i++) {
			let input3 = document.createElement("input");
	
			input3.type = "hidden";
			input3.name = "seats2";
			input3.value = selectedSeats2[i];
	
			newForm.append(input3);
		}
		
		const input4 = document.createElement('input');
		input4.type = "hidden";
		input4.name = "id2";
		input4.value = air_id2;
		newForm.append(input4);
		
		const input5 = document.createElement('input');
		input5.type = "hidden";
		input5.name = "departDate2";
		input5.value = dDate2;
		newForm.append(input5);	
		
		document.body.appendChild(newForm);
		
		if (selectedSeats.length != numInt) {alert("가는편 좌석수와 인원 수가 다릅니다");return;}
		if (selectedSeats2.length != numInt2) {alert("오는편 좌석수와 인원 수가 다릅니다");return;}
		
		if (flag == 0) {
			if (confirm("예매하시겠습니까?")) newForm.submit();
			else return;
		} else {
			newForm.submit();
		}
	}
	
	function iamport(){
		//가맹점 식별코드

		let numInt = document.getElementById("num").value;
		let numInt2 = document.getElementById("num2").value;
		if (selectedSeats.length != numInt) {alert("가는편 좌석수와 인원 수가 다릅니다");return;}
		if (selectedSeats2.length != numInt2) {alert("오는편 좌석수와 인원 수가 다릅니다");return;}
		
		IMP.init('imp72720756');
		IMP.request_pay({
		    pg : 'kcp',
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : '항공편' , //결제창에서 보여질 이름
		    amount : ${airplane.name.price * num} + ${airplane2.name.price * num2}, 
		    buyer_email : '${userdetails.user.email}',
		    buyer_name : '${userdetails.user.name}',
		    buyer_tel : '${userdetails.user.phonenum}',
		    buyer_addr : '-',
		    buyer_postcode : '-'
		}, function(rsp) {
			console.log(rsp);
		    if ( rsp.success ) {
		    	var msg = '결제가 완료되었습니다.';
		        msg += '고유ID : ' + rsp.imp_uid;
		        msg += '상점 거래ID : ' + rsp.merchant_uid;
		        msg += '결제 금액 : ' + rsp.paid_amount;
		        msg += '카드 승인번호 : ' + rsp.apply_num;
		    } else {
		    	 var msg = '결제에 실패하였습니다.';
		         msg += '에러내용 : ' + rsp.error_msg;
		         return;
		    }
		    alert(msg);
		    frmSubmit(1);
		});
	}
</script>
</html>
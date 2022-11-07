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
    <title>비행기 예매</title>
    <style>
    	.seat {width:44px; height:30px;}
    	.none {background-color:dimgray;}
    	.clicked {background-color:red; color:white;}
    	.inv {opacity:0;}
    </style>
</head>
<c:set var="air_id" value="${id}"/>
<body>
    <%-- 인증 헤더 --%>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div class="container"><h3>좌석예매 - 편도</h3></div>
    <div class="container mt-3 d-flex justify-content-center">
        <div class="seat-wrapper">
			<div style="width:485px; height:50px; text-align:center; background-color:white" class="mb-5 border">
				<table width="100%">
					<tr>
						<td>
							<span>${airplane.name.name}</span><br>
							<span>출발시각 : ${airplane.time.time}</span>
						</td>
						<td>
							<span id="api_price">${date}</span><br>
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
    </div>
    <div class="container mt-3"style="display:flex; justify-content:center;">
        <button style="height:60px; width:100px;" class="btn btn-outline-dark mx-3" onClick="iamport()">카드결제</button>
        <button style="height:60px; width:100px;" class="btn btn-outline-dark mx-3" onClick="frmSubmit(0)">바로결제(테스트)</button>
    </div>
    <p><br><br></p>
<input type="hidden" id="id" value="${airplane.id}">
<input type="hidden" id="date" value="${date}">
<input type="hidden" id="num" value="${num}">
</body>
<script>
	let reserved = [];
</script>
<c:forEach var="item" items="${reserved}">
	<script>reserved.push("${item}");</script>
</c:forEach>

<script src="${pageContext.request.contextPath }/js/reservAir.js"></script>
<script>
	function frmSubmit(flag) {
		let air_id = document.getElementById("id").value;
		let dDate = document.getElementById("date").value;
		let numInt = document.getElementById("num").value;
		
		if (selectedSeats.length != numInt) {alert("좌석수와 인원 수가 다릅니다"); return;}
		
		let newForm = document.createElement('form');
		newForm.name = 'newForm';
		newForm.method = 'post';
		newForm.action = 'onewayReservOk';
	
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
		
		document.body.appendChild(newForm);
		
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
		if (selectedSeats.length != numInt) {alert("좌석수와 인원 수가 다릅니다"); return;}
		
		IMP.init('imp72720756');
		IMP.request_pay({
		    pg : 'kcp',
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : '항공편' , //결제창에서 보여질 이름
		    //amount : ${airplane.name.price * num}, 
		    amount : 1234, //실제 결제되는 가격
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
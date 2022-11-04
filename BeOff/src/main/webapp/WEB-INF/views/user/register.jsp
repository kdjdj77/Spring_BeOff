<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>회원가입</title>
    <style>
    	input[type="number"]::-webkit-outer-spin-button,
		input[type="number"]::-webkit-inner-spin-button {
		    -webkit-appearance: none;
		    margin: 0;
		}
    </style>
</head>

<body style="margin-bottom: 200px">
    <div class="container mt-3">
        <div class="row mt-5">
            <div class="col-12 text-center">
                <h1>회원가입</h1>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-12 text-danger">
                ${error }
            </div>
        </div>
        <div class="row">
            <form id="frm" method="POST" action="${pageContext.request.contextPath}/user/register">
                <div class="form-group mt-3">
                    <label for="username">사용자 아이디</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="사용자아이디" value="${username }" required>
                </div>
                <div class="form-group mt-3">
                    <label for="name">사용자 이름</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="사용자 이름" value="${name }" required>
                </div>
                <div class="form-group mt-3">
                    <label for="password">비밀번호</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호" required>
                </div>
                <div class="form-group mt-3">
                    <label for="re-password">비밀번호 확인</label>   <%-- binding 을 위해 hyphen 사용 자제 --%>
                    <input type="password" class="form-control" id="re_password" name="re_password" placeholder="비밀번호 확인" required>
                </div>
                <div class="form-group mt-3">
                    <label for="email">이메일</label>
                	<input type="email" id="email" name="email" class="form-control" pattern="[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}" placeholder="예) id@domain.com" value="${email }" required/>
                </div>
                <div class="form-group mt-3">
                    <label for="phonenum">휴대폰번호</label><br>
                	<input type="number" id="phonenum" name="phonenum" class="form-control w-50 d-inline-flex p-2" pattern="^(010|011|016|017|018|019)[0-9]{3,4}[0-9]{4}$" placeholder="예) 01012341234" value="${phonenum }" required/>
                	<span id="phoneChk" class="btn btn-outline-dark doubleChk ">인증번호 전송</span><br><br>
                	<label for="">휴대폰 인증번호 입력</label><br>
                	<input id="phone2" type="text" name="phone2" title="인증번호 입력" disabled required/>
					<span id="phoneChk2" class="btn btn-outline-dark doubleChk">본인인증</span><br>
					<span class="point successPhoneChk"><b>휴대폰 번호 입력후 인증번호 전송을 눌러주세요</b></span>
					<input type="hidden" id="phoneDoubleChk"/>
                </div>
                <button type="button" onclick="frmsubmit()" class="w-100 btn btn-lg btn-primary mt-3">등록</button>
            </form>
        </div>
	</div>
</body>
<script>
//휴대폰 번호 인증
let code2 = "";
let checkNum = false;
$("#phoneChk").click(function(){
	
	if(($("#phonenum").val() == "")){
		alert("휴대폰 번호가 올바르지 않습니다.")
		$(".successPhoneChk").text("유효한 번호를 입력해주세요.");
		$(".successPhoneChk").css("color","red");
	}else if(!($("#phonenum").val() == "") && $("#phonenum").val().length == 11){
		alert("인증번호 발송이 완료되었습니다.\n휴대폰에서 인증번호 확인을 해주십시오.");
		var phone = $("#phonenum").val();
		$.ajax({
	        type:"GET",
	        url:"phoneCheck?phone=" + phone,
	        cache : false,
	        success:function(data){
	        	if(data == "error"){
	        		alert("휴대폰 번호가 올바르지 않습니다.")
					$(".successPhoneChk").text("유효한 번호를 입력해주세요.");
					$(".successPhoneChk").css("color","red");
					$("#phonenum").attr("autofocus",true);
	        	}else{	        		
	        		$("#phone2").attr("disabled",false);
	        		$("#phoneChk2").css("display","inline-block");
	        		$(".successPhoneChk").text("인증번호를 입력한 뒤 본인인증을 눌러주십시오.");
	        		$(".successPhoneChk").css("color","green");
	        		$("#phonenum").attr("readonly",true);
	        		code2 = data;
	        	}
	        }
	    });
	}else{
		alert("휴대폰 번호가 올바르지 않습니다.")
		$(".successPhoneChk").text("유효한 번호를 입력해주세요");
		$(".successPhoneChk").css("color","red")
	}
	
});

//휴대폰 인증번호 대조
$("#phoneChk2").click(function(){
	console.log(phoneChk2);
	
	if(code2.length <= 0 ){
		$("#phone2").attr("disabled",false);
		$("#phoneChk2").css("display","inline-block");
		$(".successPhoneChk").text("인증번호를 입력한 뒤 본인인증을 눌러주십시오.");
		$(".successPhoneChk").css("color","green");
	}
	else if(
		$("#phone2").val() == code2){
		$(".successPhoneChk").text("인증번호가 일치합니다.");
		$(".successPhoneChk").css("color","green");
		$("#phoneDoubleChk").val("true");
		$("#phone2").attr("disabled",true);
		checkNum = true;
	}else{
		$(".successPhoneChk").text("인증번호가 일치하지 않습니다. 확인해주시기 바랍니다.");
		$(".successPhoneChk").css("color","red");
		$("#phoneDoubleChk").val("false");
		$(this).attr("autofocus",true);
		return;
	}
});

</script>
<script>
	let frm = document.getElementById("frm");
	function frmsubmit() {
		if (checkNum == true) frm.submit();
		else alert("인증번호를 확인해 주세요");
	}
</script>
</html>
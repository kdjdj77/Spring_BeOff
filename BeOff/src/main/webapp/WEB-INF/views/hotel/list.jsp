<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/resources/css/style.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css" />
<script type="text/javascript" src="/resources/js/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="UTF-8">
<title>list</title>
</head>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<body>
<div>
	<form action="${pageContext.request.contextPath}/hotel/list" name="frm" id="frm">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>목적지</th>
					<th>체크인 날짜</th>
					<th>체크아웃 날짜</th>
					<th>인원</th>
				</tr>
				<tr>
					<td>
						<select name="hotelregion" id="region">
							<c:forEach var="region" items="${regionList}">    
								<option value="${region }">${region }</option>
							</c:forEach>
						</select>
					</td>
					<td><input type="text" id="start" name="in"></td>
					<td><input type="text" id="end" name="out"></td>
					<td>
						<input type='button' onclick='count("minus")' value='-' />
							<span id='result'>0</span>
							<input type="hidden" name="bed" id="${number}">
						<input type='button' onclick='count("plus")' value='+' />
					</td>
					<td>
						<button type="submit" onclick="onsubmit()">숙소 검색</button>
					</td>
				</tr>
			</thead>
		</table>
	</form>
</div>
<div>

		

</div>
<div>
	<c:forEach name="hotelname" items="${hotelList }">
		<div>${hotelname}</div>
		<div>${hotelcontent}</div>
	</c:forEach>
</div>
</body>


<script>
	$(function() {
		//input을 datepicker로 선언
		$("#start,#end")
				.datepicker(
						{
							dateFormat : 'yy-mm-dd' //달력 날짜 형태
							,
							showOtherMonths : true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
							,
							showMonthAfterYear : true // 월- 년 순서가아닌 년도 - 월 순서
							,
							changeYear : true //option값 년 선택 가능
							,
							changeMonth : true //option값  월 선택 가능                
							,
							showOn : "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
							,
							buttonImage : "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
							,
							buttonImageOnly : true //버튼 이미지만 깔끔하게 보이게함
							,
							buttonText : "선택" //버튼 호버 텍스트              
							,
							yearSuffix : "년" //달력의 년도 부분 뒤 텍스트
							,
							monthNamesShort : [ '1월', '2월', '3월', '4월', '5월',
									'6월', '7월', '8월', '9월', '10월', '11월', '12월' ] //달력의 월 부분 텍스트
							,
							monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월',
									'7월', '8월', '9월', '10월', '11월', '12월' ] //달력의 월 부분 Tooltip
							,
							dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ] //달력의 요일 텍스트
							,
							dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일',
									'금요일', '토요일' ] //달력의 요일 Tooltip
							,
							minDate : 0 //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
							,
							maxDate : "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
						});

		//초기값을 오늘
		$('#datepicker').datepicker('setDate', 'today');

	});
</script>
<script>
	function count(type) {
		let resultElement = document.getElementById('result');
		let number = resultElement.innerText;
		if (type === 'plus') {
			number = parseInt(number) + 1;
		} else if (type === 'minus') {
			number = parseInt(number) - 1;
			if (number < 0) {
				return false;
			}
		}
		resultElement.innerText = number;
	}
	function onsubmit(){
		let start = document.querySeletor("#start");
		let end = document.querySeletor("#end");
		if(start.value == "null"){alert('체크인 날짜를 선택해주세요'); return;}
		if(end.value == "null"){console.log('체크아웃 날짜를 선택해주세요'); return;}
		if(start.value > end.value){alert('체크아웃 날짜는 체크인 날짜 이후로 선택해주세요'); return;}
		frm.submit();
	}
</script>

</html>
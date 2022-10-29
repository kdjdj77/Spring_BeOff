<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%-- 로그인한 사용자 정보 Authentication 객체의 필요한 property 들을 변수에 담아 사용 가능  --%>
<sec:authentication property="name" var="username" />
<sec:authentication property="authorities" var="authorities" />
<sec:authentication property="principal" var="userdetails" />



		<c:set var="dto" value="${list[0]}" />
		<!DOCTYPE html>
		<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	const conPath = "${pageContext.request.contextPath }";
	const logged_id = $
	{
		userdetails.user.id
	};
</script>
<script src="${pageContext.request.contextPath }/js/comment.js"></script>
<title>조회 - ${dto.subject}</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="UTF-8">
<title>detail</title>
</head>
<jsp:include page="/WEB-INF/views/common/header.jsp" />

<body>
	<div>
		<form action="${pageContext.request.contextPath}/hotel/list"
			name="frm" id="frm" method="post">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>목적지</th>
						<th>체크인 날짜</th>
						<th>체크아웃 날짜</th>
						<th>인원</th>
					</tr>
					<tr>
						<td><select name="hotelregion" id="region">
								<c:forEach var="region" items="${regionList}">    
								<option value="${region }">${region }</option>
								</c:forEach>
						</select></td>
						<td><input type="text" id="start" name="in1"></td>
						<td><input type="text" id="end" name="out1"></td>
						<td><input type='button' onclick='count("minus")' value='-' />
							<span id='result'>0</span> <input type='button'
							onclick='count("plus")' value='+' /></td>
						<td>
							<button type="button" onclick="hsubmit()">숙소 검색</button>
						</td>
					</tr>
				</thead>
			</table>
			<input type="hidden" name="inn" id="inn"> <input
				type="hidden" name="out" id="out">
		</form>
	</div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>#</th>
				<th>호텔 이름</th>
				<th>호텔 정보</th>
				<th>별점 평균</th>
			</tr>
		</thead>
		<tbody>

			<tr>
				<td>${hotel.id }</td>
				<td>${hotel.hotelname }</td>
				<td>${hotel.content }</td>
				<td>${hotel.avgstar }</td>
			</tr>
		</tbody>
	</table>
	<table class="table table-bordered" id="table">
		<thead>
			<tr>
				<th>#</th>
				<th>방 이름</th>
				<th>방 가격</th>
				<th>침대 갯수</th>
				<th>방 사진</th>
				<th>예약</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" items="${hotel.rooms }">
				<tr>
					<td>${i.id }</td>
					<td>${i.roomname }</td>
					<td>${i.price }</td>
					<td>${i.bed }</td>
					<td><img style="width: 300px; height: 300px;"
						src="${pageContext.request.contextPath }/upload/${i.files[0].file}"
						alt="..." /></td>
					<td><button
							onclick="location.href='../hotel/reserv?hotelid=${hotel.id}&&roomid=${i.id}'">예약하기</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th>작성자</th>
				<th>작성일</th>
				<th>내용</th>
				<th>별점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="co" items="${hotel.hcomments }">
				<tr>
					<td>${co.user.username }</td>
					<td>${co.regDateTime }</td>
					<td>${co.content }</td>
					<td>${co.star }</td>
					<td>
						<button>수정</button>
						<button>삭제</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<jsp:include page="hcomment.jsp"></jsp:include>


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
	let inn = document.querySelector("#inn");
	let out = document.querySelector("#out");
	let in1 = document.querySelector("#start");
	let out1 = document.querySelector("#end");

	let btn = document.getElementById("#sub");

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
	function hsubmit() {

		if (in1.value === "") {
			alert('체크인 날짜를 선택해주세요');
			return;
		}
		if (out1.value === "") {
			alert('체크아웃 날짜를 선택해주세요');
			return;
		}
		if (in1.value > out1.value) {
			alert('체크인 날짜는 체크아웃 날짜 이전이어야 합니다')
		}
		inn.value = in1.value.toString();
		out.value = out1.value.toString();

		frm.submit();
	}
</script>

		</html>

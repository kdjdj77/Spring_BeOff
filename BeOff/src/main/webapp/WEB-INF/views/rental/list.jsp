<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
   rel="stylesheet">
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
   href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css" />
<link rel="stylesheet"
   href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="UTF-8">
<title>rental list</title>
</head>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<body>
	<header> </header>
	<main>
		<div class="container">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-6"></div>
				<sec:authorize access="hasAnyRole('ADMIN_RENTAL')">
				<div class="col-lg-2">
            		<a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/rental/admin/list">관리자모드</a>
				</div>
            </sec:authorize>
				<div class="col-lg-2"></div>
			</div>
		</div>
		<br>

		<div class="container">
			<div class="row">
				<div class="col-lg-1"></div>
				<div class="col-lg-10">
					<form action="${pageContext.request.contextPath}/rental/list"
						name="frm" id="frm" method="post">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>목적지</th>
									<th>대여 날짜</th>
									<th>반납 날짜</th>
									<th></th>
								</tr>

								<tr>
									<td><select name="rentalregion" id="region">
											<c:forEach var="region" items="${regionList}">    
                        						<option value="${region }">${region }</option>
											</c:forEach>
									</select></td>
									<td><input type="text" class=""
										id="start" name="in1" value="${sDate}" ></td>
									<td><input type="text" class=""
										id="end" name="out1" value="${eDate}"  ></td>
									<td><button type="button"
											class="btn btn-outline-secondary" id="sub" name ="sub" onclick="hsubmit()">검색</button></td>
								</tr>
							</thead>
						</table>
					</form>

				</div>
				<div class="col-lg-1"></div>
			</div>
		</div><br>


		<%-- 	<form action="cars/list" method="POST">
		<input type="hidden" name="rentalId" value="${dto.id }">
		<input type="hidden" name="sDate" value="${sDate }">
		<input type="hidden" name="eDate" value="${eDate }">
		<input type="hidden" name="sizeOption" value="all">
		<div class="row d-flex justify-content-start "
			style="margin-left: 150px;">
			<c:forEach var="dto" items="${rentalList }" varStatus="status">
				<div class="card col-sm-3 ms-2 me-2 my-3"
					style="width: 20rem; border: 1px solid #333333;">
					<img style="height: 200px; width: 300px"
						src="../upload/g80.jpg"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">${dto.region.region }/ ${dto.rentalname }</h5>
						<p class="card-text">${dto.content }</p>
					</div>
					<div class="text-end">
						<button class="btn btn-outline-secondary">자세히 알아보기</button>
					</div>
				</div>
			</c:forEach>
		</div>
				</form> --%>

	<div style="width:100vw; height:auto;">
		<c:forEach var="dto" items="${rentalList }" varStatus="status">
		<form action="cars/list" method="POST">
		<input type="hidden" name="rentalId" value="${dto.id }">
		<input type="hidden" name="sDate" value="${sDate }">
		<input type="hidden" name="eDate" value="${eDate }">
		<input type="hidden" name="sizeOption" value="all">
		<div class="container" style="float:left; width:370px; height:500px;">
			<div class="row">
				<div class="col-lg-1"></div>
				<div class="col-lg-10">
					<div class="card-columns">
						<img style="width:320px; height:200px; object-fit:fill; float: left;" class="card-img-top"
							src="${pageContext.request.contextPath }/upload/${dto.cars[0].files[0].file}"
							alt="..." />
						<div class="card-body">
							<h6>서비스지역</h6>
							<h4>${dto.region.region }</h4>
							<h5 class="card-title">${dto.rentalname }</h5>
							<p class="card-text">${dto.content }</p>
							<c:choose>
								<c:when test="${method == 1 }">
									<button class="btn btn-outline-secondary">자세히 알아보기</button>
								
								</c:when>
								<c:otherwise>
								<div></div>
								</c:otherwise>
							
							</c:choose>
						</div>
					</div>
				</div>
				<div class="col-lg-1"></div>
			</div>
		</div>
		</form>
		</c:forEach>
		</div>
	</main>

	<footer> </footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
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
      $("#start").datepicker('setDate', 'today');
		$("#end").datepicker('setDate', 'today');
   });
</script>
<script>

	let btn = document.getElementById("sub");
/* 	let inn = document.querySelector("#inn");
	let out = document.querySelector("#out"); */
	let in1 = document.querySelector("#start");
	let out1 = document.querySelector("#end");

	function hsubmit() {

		if (in1.value === "") {
			alert('대여날짜를 선택해주세요');
			return;
		}
		if (out1.value === "") {
			alert('반납 날짜를 선택해주세요');
			return;
		}
		if (in1.value > out1.value) {
			alert('대여날짜는 반납날짜 이전이어야 합니다')
		}
		in1.value = in1.value.toString();
		out1.value = out1.value.toString();
		console.log("sdffs")
		frm.submit();
	}
</script>
</html>